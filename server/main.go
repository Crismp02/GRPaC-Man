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
	db                    *pgx.Conn       // Database connection
	playersEnded          map[string]bool // Track players who have ended the game
	endPlayerStream       map[string]pb.LobbyService_StreamEndGameServer
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

	for _, player := range s.players {
		if player == req.PlayerName {
			return &pb.JoinResponse{Message: "That name is already taken!"}, nil
		}
	}

	s.players = append(s.players, req.PlayerName)
	s.playersEnded[req.PlayerName] = false // Initialize the player as not ended

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
			delete(s.playersEnded, player) // Remove player from playersEnded map
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
				s.playersEnded[update.PlayerName] = false // Initialize the player as not ended
			}
		} else {
			for i, player := range s.players {
				if player == update.PlayerName {
					s.players = append(s.players[:i], s.players[i+1:]...)
					delete(s.playersEnded, player) // Remove player from playersEnded map
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

	log.Printf("Game started by %s!", req.PlayerName)
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
	}
}

// Implement the EndGame method
func (s *server) EndGame(ctx context.Context, req *pb.EndGameRequest) (*pb.EndGameResponse, error) {
	s.mu.Lock()
	defer s.mu.Unlock()

	// Mark the player as having ended the game
	s.playersEnded[req.PlayerName] = true

	// Check if all players have ended the game
	allEnded := len(s.playersEnded) == len(s.players)

	if allEnded {
		// Reset for the next game
		s.playersEnded = make(map[string]bool)
		return &pb.EndGameResponse{AllPlayersEnded: true}, nil
	}

	return &pb.EndGameResponse{AllPlayersEnded: false}, nil
}

func (s *server) StreamEndGame(stream pb.LobbyService_StreamEndGameServer) error {
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
			s.playersEnded[playerName] = false // Initialize player as not ended
		}
		s.playersEnded[playerName] = true // Mark this player as having ended the game
		s.mu.Unlock()

		// Check if all players have ended the game
		allEnded := len(s.playersEnded) == len(s.players)

		// Create the boolean response
		response := &pb.EndGameNotification{
			AllPlayersEnded: allEnded,
		}

		// Send the boolean response to all connected clients
		s.broadcastBoolResponse(response)

		// If all players have ended the game, break out of the loop
		if allEnded {
			break
		}
	}

	return nil
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
	log.Printf("Score: %v, Player: %v", scoreUpdate.Score, scoreUpdate.PlayerName)
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

func (s *server) broadcastBoolResponse(response *pb.EndGameNotification) error {
	for _, stream := range s.endPlayerStream {
		if stream != nil {
			stream.Send(response)
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
		db:                    db,                    // Pass the database connection to the server
		playersEnded:          make(map[string]bool), // Initialize the map for players who have ended the game
		endPlayerStream:       make(map[string]pb.LobbyService_StreamEndGameServer),
	})
	log.Println("Server is running on port :9090")
	if err := s.Serve(lis); err != nil {
		log.Fatalf("failed to serve: %v", err)
	}
}
