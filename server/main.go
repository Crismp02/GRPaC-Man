package main

import (
	"context"
	"fmt"
	"log"
	"net"
	"os"
	"sync"

	pb "server/grpc"

	"github.com/jackc/pgx/v4"
	"github.com/joho/godotenv"
	"google.golang.org/grpc"
)

const (
	maxPlayers = 4
)

type ScoreHistory struct {
	PlayerName string
	Score      int32
}

type server struct {
	pb.UnimplementedLobbyServiceServer
	players               []string
	mu                    sync.Mutex
	playerStream          map[string]pb.LobbyService_StreamLobbyServer
	scoreStream           map[string]pb.LobbyService_StreamScoresServer
	gameStartNotification map[string]pb.LobbyService_StreamGameStartServer
	gameStarted           bool
	db                    *pgx.Conn // Database connection
}

// Function to connect to the PostgreSQL database
func connectToDatabase(DATABASE_URL string) (*pgx.Conn, error) {
	conn, err := pgx.Connect(context.Background(), DATABASE_URL)
	if err != nil {
		return nil, err
	}
	return conn, nil
}

// Function to get the first 5 scores from the database
func (s *server) GetTopScores(ctx context.Context, req *pb.TopScoresRequest) (*pb.TopScoresResponse, error) {
	rows, err := s.db.Query(context.Background(), "SELECT playerName, score FROM scoreHistory ORDER BY score DESC LIMIT 5")
	if err != nil {
		return nil, err
	}
	defer rows.Close()

	var scores []ScoreHistory
	for rows.Next() {
		var score ScoreHistory
		if err := rows.Scan(&score.PlayerName, &score.Score); err != nil {
			return nil, err
		}
		scores = append(scores, score)
	}

	if err := rows.Err(); err != nil {
		return nil, err
	}

	response := &pb.TopScoresResponse{
		Scores: make([]*pb.ScoreHistory, len(scores)),
	}
	for i, score := range scores {
		response.Scores[i] = &pb.ScoreHistory{
			PlayerName: score.PlayerName,
			Score:      score.Score,
		}
	}

	return response, nil
}

func (s *server) InsertScore(ctx context.Context, req *pb.InsertScoreRequest) (*pb.InsertScoreResponse, error) {
	// Extract player name and score from the request
	playerName := req.GetPlayerName()
	score := req.GetScore()

	// Insert the score into the database
	_, err := s.db.Query(context.Background(), "INSERT INTO scoreHistory (playerName, score) VALUES ($1, $2)", playerName, score)
	if err != nil {
		return &pb.InsertScoreResponse{
			Success: false,
			Message: "Failed to insert score: " + err.Error(),
		}, nil
	}

	// Return a successful response
	return &pb.InsertScoreResponse{
		Success: true,
		Message: "Score inserted successfully",
	}, nil
}

func (s *server) JoinLobby(ctx context.Context, req *pb.JoinRequest) (*pb.JoinResponse, error) {
	s.mu.Lock()
	defer s.mu.Unlock()

	if len(s.players) >= maxPlayers {
		return &pb.JoinResponse{Message: "Lobby is full!"}, nil
	}

	s.players = append(s.players, req.PlayerName)

	// Notify all players about the new player
	s.broadcastPlayerStatus(req.PlayerName)

	return &pb.JoinResponse{
		Message: "Welcome to the lobby!",
		Players: s.players,
	}, nil
}

func (s *server) LeaveLobby(ctx context.Context, req *pb.LeaveRequest) (*pb.LeaveResponse, error) {
	s.mu.Lock()
	defer s.mu.Unlock()

	for i, player := range s.players {
		if player == req.PlayerName {
			s.players = append(s.players[:i], s.players[i+1:]...)
			break
		}
	}

	// Notify all players about the player leaving
	s.broadcastPlayerStatus(req.PlayerName)

	return &pb.LeaveResponse{
		Message: "You have left the lobby.",
	}, nil
}

func (s *server) StreamLobby(stream pb.LobbyService_StreamLobbyServer) error {
	playerName := ""
	for {
		update, err := stream.Recv()
		if err != nil {
			log.Printf("Error receiving update: %v", err)
			return err
		}

		s.mu.Lock()
		if playerName == "" {
			playerName = update.PlayerName
			s.playerStream[playerName] = stream
		}

		if update.IsJoining {
			// Check if the player is already in the list
			playerExists := false
			for _, player := range s.players {
				if player == update.PlayerName {
					playerExists = true
					break
				}
			}
			if !playerExists {
				s.players = append(s.players, update.PlayerName)
			}
		} else {
			for i, player := range s.players {
				if player == update.PlayerName {
					s.players = append(s.players[:i], s.players[i+1:]...)
					break
				}
			}
		}
		s.mu.Unlock()

		// Broadcast the player status to all connected clients
		s.broadcastPlayerStatus(update.PlayerName)
	}
}

func (s *server) StreamScores(stream pb.LobbyService_StreamScoresServer) error {
	playerName := ""
	for {
		scoreUpdate, err := stream.Recv()
		fmt.Println(scoreUpdate)
		if err != nil {
			return err
		}

		s.mu.Lock()
		if playerName == "" {
			playerName = scoreUpdate.PlayerName
			s.scoreStream[playerName] = stream
		}
		s.mu.Unlock()

		s.broadcastScoreUpdate(scoreUpdate)
	}
}

func (s *server) StartGame(ctx context.Context, req *pb.StartGameRequest) (*pb.StartGameResponse, error) {
	s.mu.Lock()
	defer s.mu.Unlock()

	log.Printf("Player %s is attempting to start the game", req.PlayerName)

	if s.gameStarted {
		log.Printf("Game has already started. Player %s cannot start again", req.PlayerName)
		return &pb.StartGameResponse{Message: "Game has already started!"}, nil
	}

	log.Printf("Game started by %s!", req.PlayerName)
	s.gameStarted = true
	startMessage := fmt.Sprintf("Game started by %s!", req.PlayerName)
	s.broadcastGameStartNotification(startMessage)

	return &pb.StartGameResponse{Message: "Game is starting!"}, nil
}

func (s *server) StreamGameStart(stream pb.LobbyService_StreamGameStartServer) error {
	playerName := ""
	for {
		update, err := stream.Recv()
		if err != nil {
			log.Printf("Error receiving update: %v", err)
			return err
		}

		s.mu.Lock()
		if playerName == "" {
			playerName = update.PlayerName
			s.gameStartNotification[playerName] = stream
		}
		s.mu.Unlock()

		// No need to broadcast here; we will do it in StartGame
	}
}

func (s *server) broadcastPlayerStatus(playerName string) {

	for _, stream := range s.playerStream {
		if stream != nil {
			stream.Send(&pb.PlayerStatus{
				PlayerName:     playerName,
				CurrentPlayers: int32(len(s.players)),
			})
		}
	}
}

func (s *server) broadcastScoreUpdate(scoreUpdate *pb.ScoreUpdate) {
	for _, stream := range s.scoreStream {
		if stream != nil {
			stream.Send(scoreUpdate)
		}
	}
}

func (s *server) broadcastGameStartNotification(message string) error {
	for _, stream := range s.gameStartNotification {
		if stream != nil {
			log.Printf("Sending game start notification to stream: %v", stream)
			stream.Send(&pb.GameStartNotification{Message: message})
		}
	}
	return nil
}

func main() {
	// Load environment variables from .env file
	err := godotenv.Load()
	if err != nil {
		log.Fatal("Error loading .env file")
	}

	// Get the database URL from the environment variable
	dbURL := os.Getenv("DATABASE_URL")

	// Check if the environment variable is set
	if dbURL == "" {
		log.Fatal("DATABASE_URL environment variable is not set")
	}
	// Connect to the database
	db, err := connectToDatabase(dbURL)
	if err != nil {
		log.Fatalf("failed to connect to database: %v", err)
	}
	defer db.Close(context.Background())

	lis, err := net.Listen("tcp", ":9090")
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	s := grpc.NewServer()
	pb.RegisterLobbyServiceServer(s, &server{
		players:               []string{},
		playerStream:          make(map[string]pb.LobbyService_StreamLobbyServer),
		scoreStream:           make(map[string]pb.LobbyService_StreamScoresServer),
		gameStartNotification: make(map[string]pb.LobbyService_StreamGameStartServer),
		gameStarted:           false,
		db:                    db, // Pass the database connection to the server
	})
	log.Println("Server is running on port :9090")
	if err := s.Serve(lis); err != nil {
		log.Fatalf("failed to serve: %v", err)
	}
}
