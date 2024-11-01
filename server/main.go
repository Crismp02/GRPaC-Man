package main

import (
	"context"
	"fmt"
	"log"
	"net"
	"sync"

	pb "server/grpc"

	"google.golang.org/grpc"
)

const (
	maxPlayers = 4
)

type server struct {
	pb.UnimplementedLobbyServiceServer
	players      []string
	mu           sync.Mutex
	playerStream map[string]pb.LobbyService_StreamLobbyServer
	scoreStream  map[string]pb.LobbyService_StreamScoresServer
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

func main() {
	lis, err := net.Listen("tcp", ":9090")
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	s := grpc.NewServer()
	pb.RegisterLobbyServiceServer(s, &server{
		players:      []string{},
		playerStream: make(map[string]pb.LobbyService_StreamLobbyServer),
		scoreStream:  make(map[string]pb.LobbyService_StreamScoresServer),
	})
	log.Println("Server is running on port :9090")
	if err := s.Serve(lis); err != nil {
		log.Fatalf("failed to serve: %v", err)
	}
}
