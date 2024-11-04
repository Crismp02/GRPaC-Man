// Code generated by protoc-gen-go. DO NOT EDIT.
// versions:
// 	protoc-gen-go v1.35.1
// 	protoc        v5.28.2
// source: pacman.proto

package grpc

import (
	protoreflect "google.golang.org/protobuf/reflect/protoreflect"
	protoimpl "google.golang.org/protobuf/runtime/protoimpl"
	reflect "reflect"
	sync "sync"
)

const (
	// Verify that this generated code is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(20 - protoimpl.MinVersion)
	// Verify that runtime/protoimpl is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(protoimpl.MaxVersion - 20)
)

type ScoreUpdate struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	PlayerName string `protobuf:"bytes,1,opt,name=player_name,json=playerName,proto3" json:"player_name,omitempty"`
	Score      int32  `protobuf:"varint,2,opt,name=score,proto3" json:"score,omitempty"`
}

func (x *ScoreUpdate) Reset() {
	*x = ScoreUpdate{}
	mi := &file_pacman_proto_msgTypes[0]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *ScoreUpdate) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*ScoreUpdate) ProtoMessage() {}

func (x *ScoreUpdate) ProtoReflect() protoreflect.Message {
	mi := &file_pacman_proto_msgTypes[0]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use ScoreUpdate.ProtoReflect.Descriptor instead.
func (*ScoreUpdate) Descriptor() ([]byte, []int) {
	return file_pacman_proto_rawDescGZIP(), []int{0}
}

func (x *ScoreUpdate) GetPlayerName() string {
	if x != nil {
		return x.PlayerName
	}
	return ""
}

func (x *ScoreUpdate) GetScore() int32 {
	if x != nil {
		return x.Score
	}
	return 0
}

type JoinRequest struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	PlayerName string `protobuf:"bytes,1,opt,name=playerName,proto3" json:"playerName,omitempty"`
}

func (x *JoinRequest) Reset() {
	*x = JoinRequest{}
	mi := &file_pacman_proto_msgTypes[1]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *JoinRequest) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*JoinRequest) ProtoMessage() {}

func (x *JoinRequest) ProtoReflect() protoreflect.Message {
	mi := &file_pacman_proto_msgTypes[1]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use JoinRequest.ProtoReflect.Descriptor instead.
func (*JoinRequest) Descriptor() ([]byte, []int) {
	return file_pacman_proto_rawDescGZIP(), []int{1}
}

func (x *JoinRequest) GetPlayerName() string {
	if x != nil {
		return x.PlayerName
	}
	return ""
}

type JoinResponse struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Message string   `protobuf:"bytes,1,opt,name=message,proto3" json:"message,omitempty"`
	Players []string `protobuf:"bytes,2,rep,name=players,proto3" json:"players,omitempty"` // List of current players
}

func (x *JoinResponse) Reset() {
	*x = JoinResponse{}
	mi := &file_pacman_proto_msgTypes[2]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *JoinResponse) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*JoinResponse) ProtoMessage() {}

func (x *JoinResponse) ProtoReflect() protoreflect.Message {
	mi := &file_pacman_proto_msgTypes[2]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use JoinResponse.ProtoReflect.Descriptor instead.
func (*JoinResponse) Descriptor() ([]byte, []int) {
	return file_pacman_proto_rawDescGZIP(), []int{2}
}

func (x *JoinResponse) GetMessage() string {
	if x != nil {
		return x.Message
	}
	return ""
}

func (x *JoinResponse) GetPlayers() []string {
	if x != nil {
		return x.Players
	}
	return nil
}

type LeaveRequest struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	PlayerName string `protobuf:"bytes,1,opt,name=playerName,proto3" json:"playerName,omitempty"`
}

func (x *LeaveRequest) Reset() {
	*x = LeaveRequest{}
	mi := &file_pacman_proto_msgTypes[3]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *LeaveRequest) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*LeaveRequest) ProtoMessage() {}

func (x *LeaveRequest) ProtoReflect() protoreflect.Message {
	mi := &file_pacman_proto_msgTypes[3]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use LeaveRequest.ProtoReflect.Descriptor instead.
func (*LeaveRequest) Descriptor() ([]byte, []int) {
	return file_pacman_proto_rawDescGZIP(), []int{3}
}

func (x *LeaveRequest) GetPlayerName() string {
	if x != nil {
		return x.PlayerName
	}
	return ""
}

type LeaveResponse struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Message string `protobuf:"bytes,1,opt,name=message,proto3" json:"message,omitempty"`
}

func (x *LeaveResponse) Reset() {
	*x = LeaveResponse{}
	mi := &file_pacman_proto_msgTypes[4]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *LeaveResponse) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*LeaveResponse) ProtoMessage() {}

func (x *LeaveResponse) ProtoReflect() protoreflect.Message {
	mi := &file_pacman_proto_msgTypes[4]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use LeaveResponse.ProtoReflect.Descriptor instead.
func (*LeaveResponse) Descriptor() ([]byte, []int) {
	return file_pacman_proto_rawDescGZIP(), []int{4}
}

func (x *LeaveResponse) GetMessage() string {
	if x != nil {
		return x.Message
	}
	return ""
}

type LobbyUpdate struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	PlayerName string `protobuf:"bytes,1,opt,name=playerName,proto3" json:"playerName,omitempty"`
	IsJoining  bool   `protobuf:"varint,2,opt,name=isJoining,proto3" json:"isJoining,omitempty"` // True if joining, false if leaving
}

func (x *LobbyUpdate) Reset() {
	*x = LobbyUpdate{}
	mi := &file_pacman_proto_msgTypes[5]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *LobbyUpdate) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*LobbyUpdate) ProtoMessage() {}

func (x *LobbyUpdate) ProtoReflect() protoreflect.Message {
	mi := &file_pacman_proto_msgTypes[5]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use LobbyUpdate.ProtoReflect.Descriptor instead.
func (*LobbyUpdate) Descriptor() ([]byte, []int) {
	return file_pacman_proto_rawDescGZIP(), []int{5}
}

func (x *LobbyUpdate) GetPlayerName() string {
	if x != nil {
		return x.PlayerName
	}
	return ""
}

func (x *LobbyUpdate) GetIsJoining() bool {
	if x != nil {
		return x.IsJoining
	}
	return false
}

type PlayerStatus struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	PlayerName     string `protobuf:"bytes,1,opt,name=playerName,proto3" json:"playerName,omitempty"`
	CurrentPlayers int32  `protobuf:"varint,2,opt,name=currentPlayers,proto3" json:"currentPlayers,omitempty"` // Current number of players in the lobby
}

func (x *PlayerStatus) Reset() {
	*x = PlayerStatus{}
	mi := &file_pacman_proto_msgTypes[6]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *PlayerStatus) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*PlayerStatus) ProtoMessage() {}

func (x *PlayerStatus) ProtoReflect() protoreflect.Message {
	mi := &file_pacman_proto_msgTypes[6]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use PlayerStatus.ProtoReflect.Descriptor instead.
func (*PlayerStatus) Descriptor() ([]byte, []int) {
	return file_pacman_proto_rawDescGZIP(), []int{6}
}

func (x *PlayerStatus) GetPlayerName() string {
	if x != nil {
		return x.PlayerName
	}
	return ""
}

func (x *PlayerStatus) GetCurrentPlayers() int32 {
	if x != nil {
		return x.CurrentPlayers
	}
	return 0
}

type StartGameRequest struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	PlayerName string `protobuf:"bytes,1,opt,name=playerName,proto3" json:"playerName,omitempty"` // The name of the player who is starting the game
}

func (x *StartGameRequest) Reset() {
	*x = StartGameRequest{}
	mi := &file_pacman_proto_msgTypes[7]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *StartGameRequest) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*StartGameRequest) ProtoMessage() {}

func (x *StartGameRequest) ProtoReflect() protoreflect.Message {
	mi := &file_pacman_proto_msgTypes[7]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use StartGameRequest.ProtoReflect.Descriptor instead.
func (*StartGameRequest) Descriptor() ([]byte, []int) {
	return file_pacman_proto_rawDescGZIP(), []int{7}
}

func (x *StartGameRequest) GetPlayerName() string {
	if x != nil {
		return x.PlayerName
	}
	return ""
}

type StartGameResponse struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Message string `protobuf:"bytes,1,opt,name=message,proto3" json:"message,omitempty"`
}

func (x *StartGameResponse) Reset() {
	*x = StartGameResponse{}
	mi := &file_pacman_proto_msgTypes[8]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *StartGameResponse) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*StartGameResponse) ProtoMessage() {}

func (x *StartGameResponse) ProtoReflect() protoreflect.Message {
	mi := &file_pacman_proto_msgTypes[8]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use StartGameResponse.ProtoReflect.Descriptor instead.
func (*StartGameResponse) Descriptor() ([]byte, []int) {
	return file_pacman_proto_rawDescGZIP(), []int{8}
}

func (x *StartGameResponse) GetMessage() string {
	if x != nil {
		return x.Message
	}
	return ""
}

type GameStartUpdate struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	PlayerName string `protobuf:"bytes,1,opt,name=playerName,proto3" json:"playerName,omitempty"` // Indicates if the game has started
}

func (x *GameStartUpdate) Reset() {
	*x = GameStartUpdate{}
	mi := &file_pacman_proto_msgTypes[9]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *GameStartUpdate) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*GameStartUpdate) ProtoMessage() {}

func (x *GameStartUpdate) ProtoReflect() protoreflect.Message {
	mi := &file_pacman_proto_msgTypes[9]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use GameStartUpdate.ProtoReflect.Descriptor instead.
func (*GameStartUpdate) Descriptor() ([]byte, []int) {
	return file_pacman_proto_rawDescGZIP(), []int{9}
}

func (x *GameStartUpdate) GetPlayerName() string {
	if x != nil {
		return x.PlayerName
	}
	return ""
}

type GameStartNotification struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Message string `protobuf:"bytes,1,opt,name=message,proto3" json:"message,omitempty"` // Notification message
}

func (x *GameStartNotification) Reset() {
	*x = GameStartNotification{}
	mi := &file_pacman_proto_msgTypes[10]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *GameStartNotification) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*GameStartNotification) ProtoMessage() {}

func (x *GameStartNotification) ProtoReflect() protoreflect.Message {
	mi := &file_pacman_proto_msgTypes[10]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use GameStartNotification.ProtoReflect.Descriptor instead.
func (*GameStartNotification) Descriptor() ([]byte, []int) {
	return file_pacman_proto_rawDescGZIP(), []int{10}
}

func (x *GameStartNotification) GetMessage() string {
	if x != nil {
		return x.Message
	}
	return ""
}

type ScoreHistory struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	PlayerName string `protobuf:"bytes,1,opt,name=playerName,proto3" json:"playerName,omitempty"` // Name of the player
	Score      int32  `protobuf:"varint,2,opt,name=score,proto3" json:"score,omitempty"`          // Player's score
}

func (x *ScoreHistory) Reset() {
	*x = ScoreHistory{}
	mi := &file_pacman_proto_msgTypes[11]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *ScoreHistory) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*ScoreHistory) ProtoMessage() {}

func (x *ScoreHistory) ProtoReflect() protoreflect.Message {
	mi := &file_pacman_proto_msgTypes[11]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use ScoreHistory.ProtoReflect.Descriptor instead.
func (*ScoreHistory) Descriptor() ([]byte, []int) {
	return file_pacman_proto_rawDescGZIP(), []int{11}
}

func (x *ScoreHistory) GetPlayerName() string {
	if x != nil {
		return x.PlayerName
	}
	return ""
}

func (x *ScoreHistory) GetScore() int32 {
	if x != nil {
		return x.Score
	}
	return 0
}

// New request message for getting top scores
type TopScoresRequest struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields
}

func (x *TopScoresRequest) Reset() {
	*x = TopScoresRequest{}
	mi := &file_pacman_proto_msgTypes[12]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *TopScoresRequest) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*TopScoresRequest) ProtoMessage() {}

func (x *TopScoresRequest) ProtoReflect() protoreflect.Message {
	mi := &file_pacman_proto_msgTypes[12]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use TopScoresRequest.ProtoReflect.Descriptor instead.
func (*TopScoresRequest) Descriptor() ([]byte, []int) {
	return file_pacman_proto_rawDescGZIP(), []int{12}
}

// New response message for top scores
type TopScoresResponse struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Scores []*ScoreHistory `protobuf:"bytes,1,rep,name=scores,proto3" json:"scores,omitempty"` // List of top scores
}

func (x *TopScoresResponse) Reset() {
	*x = TopScoresResponse{}
	mi := &file_pacman_proto_msgTypes[13]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *TopScoresResponse) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*TopScoresResponse) ProtoMessage() {}

func (x *TopScoresResponse) ProtoReflect() protoreflect.Message {
	mi := &file_pacman_proto_msgTypes[13]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use TopScoresResponse.ProtoReflect.Descriptor instead.
func (*TopScoresResponse) Descriptor() ([]byte, []int) {
	return file_pacman_proto_rawDescGZIP(), []int{13}
}

func (x *TopScoresResponse) GetScores() []*ScoreHistory {
	if x != nil {
		return x.Scores
	}
	return nil
}

// The request message for inserting a score
type InsertScoreRequest struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	PlayerName string `protobuf:"bytes,1,opt,name=playerName,proto3" json:"playerName,omitempty"`
	Score      int32  `protobuf:"varint,2,opt,name=score,proto3" json:"score,omitempty"`
}

func (x *InsertScoreRequest) Reset() {
	*x = InsertScoreRequest{}
	mi := &file_pacman_proto_msgTypes[14]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *InsertScoreRequest) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*InsertScoreRequest) ProtoMessage() {}

func (x *InsertScoreRequest) ProtoReflect() protoreflect.Message {
	mi := &file_pacman_proto_msgTypes[14]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use InsertScoreRequest.ProtoReflect.Descriptor instead.
func (*InsertScoreRequest) Descriptor() ([]byte, []int) {
	return file_pacman_proto_rawDescGZIP(), []int{14}
}

func (x *InsertScoreRequest) GetPlayerName() string {
	if x != nil {
		return x.PlayerName
	}
	return ""
}

func (x *InsertScoreRequest) GetScore() int32 {
	if x != nil {
		return x.Score
	}
	return 0
}

// The response message for inserting a score
type InsertScoreResponse struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Success bool   `protobuf:"varint,1,opt,name=success,proto3" json:"success,omitempty"`
	Message string `protobuf:"bytes,2,opt,name=message,proto3" json:"message,omitempty"` // Optional message to provide feedback
}

func (x *InsertScoreResponse) Reset() {
	*x = InsertScoreResponse{}
	mi := &file_pacman_proto_msgTypes[15]
	ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
	ms.StoreMessageInfo(mi)
}

func (x *InsertScoreResponse) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*InsertScoreResponse) ProtoMessage() {}

func (x *InsertScoreResponse) ProtoReflect() protoreflect.Message {
	mi := &file_pacman_proto_msgTypes[15]
	if x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use InsertScoreResponse.ProtoReflect.Descriptor instead.
func (*InsertScoreResponse) Descriptor() ([]byte, []int) {
	return file_pacman_proto_rawDescGZIP(), []int{15}
}

func (x *InsertScoreResponse) GetSuccess() bool {
	if x != nil {
		return x.Success
	}
	return false
}

func (x *InsertScoreResponse) GetMessage() string {
	if x != nil {
		return x.Message
	}
	return ""
}

var File_pacman_proto protoreflect.FileDescriptor

var file_pacman_proto_rawDesc = []byte{
	0x0a, 0x0c, 0x70, 0x61, 0x63, 0x6d, 0x61, 0x6e, 0x2e, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x12, 0x06,
	0x70, 0x61, 0x63, 0x6d, 0x61, 0x6e, 0x22, 0x44, 0x0a, 0x0b, 0x53, 0x63, 0x6f, 0x72, 0x65, 0x55,
	0x70, 0x64, 0x61, 0x74, 0x65, 0x12, 0x1f, 0x0a, 0x0b, 0x70, 0x6c, 0x61, 0x79, 0x65, 0x72, 0x5f,
	0x6e, 0x61, 0x6d, 0x65, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52, 0x0a, 0x70, 0x6c, 0x61, 0x79,
	0x65, 0x72, 0x4e, 0x61, 0x6d, 0x65, 0x12, 0x14, 0x0a, 0x05, 0x73, 0x63, 0x6f, 0x72, 0x65, 0x18,
	0x02, 0x20, 0x01, 0x28, 0x05, 0x52, 0x05, 0x73, 0x63, 0x6f, 0x72, 0x65, 0x22, 0x2d, 0x0a, 0x0b,
	0x4a, 0x6f, 0x69, 0x6e, 0x52, 0x65, 0x71, 0x75, 0x65, 0x73, 0x74, 0x12, 0x1e, 0x0a, 0x0a, 0x70,
	0x6c, 0x61, 0x79, 0x65, 0x72, 0x4e, 0x61, 0x6d, 0x65, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52,
	0x0a, 0x70, 0x6c, 0x61, 0x79, 0x65, 0x72, 0x4e, 0x61, 0x6d, 0x65, 0x22, 0x42, 0x0a, 0x0c, 0x4a,
	0x6f, 0x69, 0x6e, 0x52, 0x65, 0x73, 0x70, 0x6f, 0x6e, 0x73, 0x65, 0x12, 0x18, 0x0a, 0x07, 0x6d,
	0x65, 0x73, 0x73, 0x61, 0x67, 0x65, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52, 0x07, 0x6d, 0x65,
	0x73, 0x73, 0x61, 0x67, 0x65, 0x12, 0x18, 0x0a, 0x07, 0x70, 0x6c, 0x61, 0x79, 0x65, 0x72, 0x73,
	0x18, 0x02, 0x20, 0x03, 0x28, 0x09, 0x52, 0x07, 0x70, 0x6c, 0x61, 0x79, 0x65, 0x72, 0x73, 0x22,
	0x2e, 0x0a, 0x0c, 0x4c, 0x65, 0x61, 0x76, 0x65, 0x52, 0x65, 0x71, 0x75, 0x65, 0x73, 0x74, 0x12,
	0x1e, 0x0a, 0x0a, 0x70, 0x6c, 0x61, 0x79, 0x65, 0x72, 0x4e, 0x61, 0x6d, 0x65, 0x18, 0x01, 0x20,
	0x01, 0x28, 0x09, 0x52, 0x0a, 0x70, 0x6c, 0x61, 0x79, 0x65, 0x72, 0x4e, 0x61, 0x6d, 0x65, 0x22,
	0x29, 0x0a, 0x0d, 0x4c, 0x65, 0x61, 0x76, 0x65, 0x52, 0x65, 0x73, 0x70, 0x6f, 0x6e, 0x73, 0x65,
	0x12, 0x18, 0x0a, 0x07, 0x6d, 0x65, 0x73, 0x73, 0x61, 0x67, 0x65, 0x18, 0x01, 0x20, 0x01, 0x28,
	0x09, 0x52, 0x07, 0x6d, 0x65, 0x73, 0x73, 0x61, 0x67, 0x65, 0x22, 0x4b, 0x0a, 0x0b, 0x4c, 0x6f,
	0x62, 0x62, 0x79, 0x55, 0x70, 0x64, 0x61, 0x74, 0x65, 0x12, 0x1e, 0x0a, 0x0a, 0x70, 0x6c, 0x61,
	0x79, 0x65, 0x72, 0x4e, 0x61, 0x6d, 0x65, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52, 0x0a, 0x70,
	0x6c, 0x61, 0x79, 0x65, 0x72, 0x4e, 0x61, 0x6d, 0x65, 0x12, 0x1c, 0x0a, 0x09, 0x69, 0x73, 0x4a,
	0x6f, 0x69, 0x6e, 0x69, 0x6e, 0x67, 0x18, 0x02, 0x20, 0x01, 0x28, 0x08, 0x52, 0x09, 0x69, 0x73,
	0x4a, 0x6f, 0x69, 0x6e, 0x69, 0x6e, 0x67, 0x22, 0x56, 0x0a, 0x0c, 0x50, 0x6c, 0x61, 0x79, 0x65,
	0x72, 0x53, 0x74, 0x61, 0x74, 0x75, 0x73, 0x12, 0x1e, 0x0a, 0x0a, 0x70, 0x6c, 0x61, 0x79, 0x65,
	0x72, 0x4e, 0x61, 0x6d, 0x65, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52, 0x0a, 0x70, 0x6c, 0x61,
	0x79, 0x65, 0x72, 0x4e, 0x61, 0x6d, 0x65, 0x12, 0x26, 0x0a, 0x0e, 0x63, 0x75, 0x72, 0x72, 0x65,
	0x6e, 0x74, 0x50, 0x6c, 0x61, 0x79, 0x65, 0x72, 0x73, 0x18, 0x02, 0x20, 0x01, 0x28, 0x05, 0x52,
	0x0e, 0x63, 0x75, 0x72, 0x72, 0x65, 0x6e, 0x74, 0x50, 0x6c, 0x61, 0x79, 0x65, 0x72, 0x73, 0x22,
	0x32, 0x0a, 0x10, 0x53, 0x74, 0x61, 0x72, 0x74, 0x47, 0x61, 0x6d, 0x65, 0x52, 0x65, 0x71, 0x75,
	0x65, 0x73, 0x74, 0x12, 0x1e, 0x0a, 0x0a, 0x70, 0x6c, 0x61, 0x79, 0x65, 0x72, 0x4e, 0x61, 0x6d,
	0x65, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52, 0x0a, 0x70, 0x6c, 0x61, 0x79, 0x65, 0x72, 0x4e,
	0x61, 0x6d, 0x65, 0x22, 0x2d, 0x0a, 0x11, 0x53, 0x74, 0x61, 0x72, 0x74, 0x47, 0x61, 0x6d, 0x65,
	0x52, 0x65, 0x73, 0x70, 0x6f, 0x6e, 0x73, 0x65, 0x12, 0x18, 0x0a, 0x07, 0x6d, 0x65, 0x73, 0x73,
	0x61, 0x67, 0x65, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52, 0x07, 0x6d, 0x65, 0x73, 0x73, 0x61,
	0x67, 0x65, 0x22, 0x31, 0x0a, 0x0f, 0x47, 0x61, 0x6d, 0x65, 0x53, 0x74, 0x61, 0x72, 0x74, 0x55,
	0x70, 0x64, 0x61, 0x74, 0x65, 0x12, 0x1e, 0x0a, 0x0a, 0x70, 0x6c, 0x61, 0x79, 0x65, 0x72, 0x4e,
	0x61, 0x6d, 0x65, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52, 0x0a, 0x70, 0x6c, 0x61, 0x79, 0x65,
	0x72, 0x4e, 0x61, 0x6d, 0x65, 0x22, 0x31, 0x0a, 0x15, 0x47, 0x61, 0x6d, 0x65, 0x53, 0x74, 0x61,
	0x72, 0x74, 0x4e, 0x6f, 0x74, 0x69, 0x66, 0x69, 0x63, 0x61, 0x74, 0x69, 0x6f, 0x6e, 0x12, 0x18,
	0x0a, 0x07, 0x6d, 0x65, 0x73, 0x73, 0x61, 0x67, 0x65, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52,
	0x07, 0x6d, 0x65, 0x73, 0x73, 0x61, 0x67, 0x65, 0x22, 0x44, 0x0a, 0x0c, 0x53, 0x63, 0x6f, 0x72,
	0x65, 0x48, 0x69, 0x73, 0x74, 0x6f, 0x72, 0x79, 0x12, 0x1e, 0x0a, 0x0a, 0x70, 0x6c, 0x61, 0x79,
	0x65, 0x72, 0x4e, 0x61, 0x6d, 0x65, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52, 0x0a, 0x70, 0x6c,
	0x61, 0x79, 0x65, 0x72, 0x4e, 0x61, 0x6d, 0x65, 0x12, 0x14, 0x0a, 0x05, 0x73, 0x63, 0x6f, 0x72,
	0x65, 0x18, 0x02, 0x20, 0x01, 0x28, 0x05, 0x52, 0x05, 0x73, 0x63, 0x6f, 0x72, 0x65, 0x22, 0x12,
	0x0a, 0x10, 0x54, 0x6f, 0x70, 0x53, 0x63, 0x6f, 0x72, 0x65, 0x73, 0x52, 0x65, 0x71, 0x75, 0x65,
	0x73, 0x74, 0x22, 0x41, 0x0a, 0x11, 0x54, 0x6f, 0x70, 0x53, 0x63, 0x6f, 0x72, 0x65, 0x73, 0x52,
	0x65, 0x73, 0x70, 0x6f, 0x6e, 0x73, 0x65, 0x12, 0x2c, 0x0a, 0x06, 0x73, 0x63, 0x6f, 0x72, 0x65,
	0x73, 0x18, 0x01, 0x20, 0x03, 0x28, 0x0b, 0x32, 0x14, 0x2e, 0x70, 0x61, 0x63, 0x6d, 0x61, 0x6e,
	0x2e, 0x53, 0x63, 0x6f, 0x72, 0x65, 0x48, 0x69, 0x73, 0x74, 0x6f, 0x72, 0x79, 0x52, 0x06, 0x73,
	0x63, 0x6f, 0x72, 0x65, 0x73, 0x22, 0x4a, 0x0a, 0x12, 0x49, 0x6e, 0x73, 0x65, 0x72, 0x74, 0x53,
	0x63, 0x6f, 0x72, 0x65, 0x52, 0x65, 0x71, 0x75, 0x65, 0x73, 0x74, 0x12, 0x1e, 0x0a, 0x0a, 0x70,
	0x6c, 0x61, 0x79, 0x65, 0x72, 0x4e, 0x61, 0x6d, 0x65, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52,
	0x0a, 0x70, 0x6c, 0x61, 0x79, 0x65, 0x72, 0x4e, 0x61, 0x6d, 0x65, 0x12, 0x14, 0x0a, 0x05, 0x73,
	0x63, 0x6f, 0x72, 0x65, 0x18, 0x02, 0x20, 0x01, 0x28, 0x05, 0x52, 0x05, 0x73, 0x63, 0x6f, 0x72,
	0x65, 0x22, 0x49, 0x0a, 0x13, 0x49, 0x6e, 0x73, 0x65, 0x72, 0x74, 0x53, 0x63, 0x6f, 0x72, 0x65,
	0x52, 0x65, 0x73, 0x70, 0x6f, 0x6e, 0x73, 0x65, 0x12, 0x18, 0x0a, 0x07, 0x73, 0x75, 0x63, 0x63,
	0x65, 0x73, 0x73, 0x18, 0x01, 0x20, 0x01, 0x28, 0x08, 0x52, 0x07, 0x73, 0x75, 0x63, 0x63, 0x65,
	0x73, 0x73, 0x12, 0x18, 0x0a, 0x07, 0x6d, 0x65, 0x73, 0x73, 0x61, 0x67, 0x65, 0x18, 0x02, 0x20,
	0x01, 0x28, 0x09, 0x52, 0x07, 0x6d, 0x65, 0x73, 0x73, 0x61, 0x67, 0x65, 0x32, 0x9b, 0x04, 0x0a,
	0x0c, 0x4c, 0x6f, 0x62, 0x62, 0x79, 0x53, 0x65, 0x72, 0x76, 0x69, 0x63, 0x65, 0x12, 0x36, 0x0a,
	0x09, 0x4a, 0x6f, 0x69, 0x6e, 0x4c, 0x6f, 0x62, 0x62, 0x79, 0x12, 0x13, 0x2e, 0x70, 0x61, 0x63,
	0x6d, 0x61, 0x6e, 0x2e, 0x4a, 0x6f, 0x69, 0x6e, 0x52, 0x65, 0x71, 0x75, 0x65, 0x73, 0x74, 0x1a,
	0x14, 0x2e, 0x70, 0x61, 0x63, 0x6d, 0x61, 0x6e, 0x2e, 0x4a, 0x6f, 0x69, 0x6e, 0x52, 0x65, 0x73,
	0x70, 0x6f, 0x6e, 0x73, 0x65, 0x12, 0x39, 0x0a, 0x0a, 0x4c, 0x65, 0x61, 0x76, 0x65, 0x4c, 0x6f,
	0x62, 0x62, 0x79, 0x12, 0x14, 0x2e, 0x70, 0x61, 0x63, 0x6d, 0x61, 0x6e, 0x2e, 0x4c, 0x65, 0x61,
	0x76, 0x65, 0x52, 0x65, 0x71, 0x75, 0x65, 0x73, 0x74, 0x1a, 0x15, 0x2e, 0x70, 0x61, 0x63, 0x6d,
	0x61, 0x6e, 0x2e, 0x4c, 0x65, 0x61, 0x76, 0x65, 0x52, 0x65, 0x73, 0x70, 0x6f, 0x6e, 0x73, 0x65,
	0x12, 0x3c, 0x0a, 0x0b, 0x53, 0x74, 0x72, 0x65, 0x61, 0x6d, 0x4c, 0x6f, 0x62, 0x62, 0x79, 0x12,
	0x13, 0x2e, 0x70, 0x61, 0x63, 0x6d, 0x61, 0x6e, 0x2e, 0x4c, 0x6f, 0x62, 0x62, 0x79, 0x55, 0x70,
	0x64, 0x61, 0x74, 0x65, 0x1a, 0x14, 0x2e, 0x70, 0x61, 0x63, 0x6d, 0x61, 0x6e, 0x2e, 0x50, 0x6c,
	0x61, 0x79, 0x65, 0x72, 0x53, 0x74, 0x61, 0x74, 0x75, 0x73, 0x28, 0x01, 0x30, 0x01, 0x12, 0x3c,
	0x0a, 0x0c, 0x53, 0x74, 0x72, 0x65, 0x61, 0x6d, 0x53, 0x63, 0x6f, 0x72, 0x65, 0x73, 0x12, 0x13,
	0x2e, 0x70, 0x61, 0x63, 0x6d, 0x61, 0x6e, 0x2e, 0x53, 0x63, 0x6f, 0x72, 0x65, 0x55, 0x70, 0x64,
	0x61, 0x74, 0x65, 0x1a, 0x13, 0x2e, 0x70, 0x61, 0x63, 0x6d, 0x61, 0x6e, 0x2e, 0x53, 0x63, 0x6f,
	0x72, 0x65, 0x55, 0x70, 0x64, 0x61, 0x74, 0x65, 0x28, 0x01, 0x30, 0x01, 0x12, 0x40, 0x0a, 0x09,
	0x53, 0x74, 0x61, 0x72, 0x74, 0x47, 0x61, 0x6d, 0x65, 0x12, 0x18, 0x2e, 0x70, 0x61, 0x63, 0x6d,
	0x61, 0x6e, 0x2e, 0x53, 0x74, 0x61, 0x72, 0x74, 0x47, 0x61, 0x6d, 0x65, 0x52, 0x65, 0x71, 0x75,
	0x65, 0x73, 0x74, 0x1a, 0x19, 0x2e, 0x70, 0x61, 0x63, 0x6d, 0x61, 0x6e, 0x2e, 0x53, 0x74, 0x61,
	0x72, 0x74, 0x47, 0x61, 0x6d, 0x65, 0x52, 0x65, 0x73, 0x70, 0x6f, 0x6e, 0x73, 0x65, 0x12, 0x4d,
	0x0a, 0x0f, 0x53, 0x74, 0x72, 0x65, 0x61, 0x6d, 0x47, 0x61, 0x6d, 0x65, 0x53, 0x74, 0x61, 0x72,
	0x74, 0x12, 0x17, 0x2e, 0x70, 0x61, 0x63, 0x6d, 0x61, 0x6e, 0x2e, 0x47, 0x61, 0x6d, 0x65, 0x53,
	0x74, 0x61, 0x72, 0x74, 0x55, 0x70, 0x64, 0x61, 0x74, 0x65, 0x1a, 0x1d, 0x2e, 0x70, 0x61, 0x63,
	0x6d, 0x61, 0x6e, 0x2e, 0x47, 0x61, 0x6d, 0x65, 0x53, 0x74, 0x61, 0x72, 0x74, 0x4e, 0x6f, 0x74,
	0x69, 0x66, 0x69, 0x63, 0x61, 0x74, 0x69, 0x6f, 0x6e, 0x28, 0x01, 0x30, 0x01, 0x12, 0x43, 0x0a,
	0x0c, 0x47, 0x65, 0x74, 0x54, 0x6f, 0x70, 0x53, 0x63, 0x6f, 0x72, 0x65, 0x73, 0x12, 0x18, 0x2e,
	0x70, 0x61, 0x63, 0x6d, 0x61, 0x6e, 0x2e, 0x54, 0x6f, 0x70, 0x53, 0x63, 0x6f, 0x72, 0x65, 0x73,
	0x52, 0x65, 0x71, 0x75, 0x65, 0x73, 0x74, 0x1a, 0x19, 0x2e, 0x70, 0x61, 0x63, 0x6d, 0x61, 0x6e,
	0x2e, 0x54, 0x6f, 0x70, 0x53, 0x63, 0x6f, 0x72, 0x65, 0x73, 0x52, 0x65, 0x73, 0x70, 0x6f, 0x6e,
	0x73, 0x65, 0x12, 0x46, 0x0a, 0x0b, 0x49, 0x6e, 0x73, 0x65, 0x72, 0x74, 0x53, 0x63, 0x6f, 0x72,
	0x65, 0x12, 0x1a, 0x2e, 0x70, 0x61, 0x63, 0x6d, 0x61, 0x6e, 0x2e, 0x49, 0x6e, 0x73, 0x65, 0x72,
	0x74, 0x53, 0x63, 0x6f, 0x72, 0x65, 0x52, 0x65, 0x71, 0x75, 0x65, 0x73, 0x74, 0x1a, 0x1b, 0x2e,
	0x70, 0x61, 0x63, 0x6d, 0x61, 0x6e, 0x2e, 0x49, 0x6e, 0x73, 0x65, 0x72, 0x74, 0x53, 0x63, 0x6f,
	0x72, 0x65, 0x52, 0x65, 0x73, 0x70, 0x6f, 0x6e, 0x73, 0x65, 0x42, 0x14, 0x50, 0x01, 0x5a, 0x0d,
	0x6f, 0x70, 0x65, 0x72, 0x61, 0x74, 0x6f, 0x72, 0x2f, 0x67, 0x72, 0x70, 0x63, 0x88, 0x01, 0x01,
	0x62, 0x06, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x33,
}

var (
	file_pacman_proto_rawDescOnce sync.Once
	file_pacman_proto_rawDescData = file_pacman_proto_rawDesc
)

func file_pacman_proto_rawDescGZIP() []byte {
	file_pacman_proto_rawDescOnce.Do(func() {
		file_pacman_proto_rawDescData = protoimpl.X.CompressGZIP(file_pacman_proto_rawDescData)
	})
	return file_pacman_proto_rawDescData
}

var file_pacman_proto_msgTypes = make([]protoimpl.MessageInfo, 16)
var file_pacman_proto_goTypes = []any{
	(*ScoreUpdate)(nil),           // 0: pacman.ScoreUpdate
	(*JoinRequest)(nil),           // 1: pacman.JoinRequest
	(*JoinResponse)(nil),          // 2: pacman.JoinResponse
	(*LeaveRequest)(nil),          // 3: pacman.LeaveRequest
	(*LeaveResponse)(nil),         // 4: pacman.LeaveResponse
	(*LobbyUpdate)(nil),           // 5: pacman.LobbyUpdate
	(*PlayerStatus)(nil),          // 6: pacman.PlayerStatus
	(*StartGameRequest)(nil),      // 7: pacman.StartGameRequest
	(*StartGameResponse)(nil),     // 8: pacman.StartGameResponse
	(*GameStartUpdate)(nil),       // 9: pacman.GameStartUpdate
	(*GameStartNotification)(nil), // 10: pacman.GameStartNotification
	(*ScoreHistory)(nil),          // 11: pacman.ScoreHistory
	(*TopScoresRequest)(nil),      // 12: pacman.TopScoresRequest
	(*TopScoresResponse)(nil),     // 13: pacman.TopScoresResponse
	(*InsertScoreRequest)(nil),    // 14: pacman.InsertScoreRequest
	(*InsertScoreResponse)(nil),   // 15: pacman.InsertScoreResponse
}
var file_pacman_proto_depIdxs = []int32{
	11, // 0: pacman.TopScoresResponse.scores:type_name -> pacman.ScoreHistory
	1,  // 1: pacman.LobbyService.JoinLobby:input_type -> pacman.JoinRequest
	3,  // 2: pacman.LobbyService.LeaveLobby:input_type -> pacman.LeaveRequest
	5,  // 3: pacman.LobbyService.StreamLobby:input_type -> pacman.LobbyUpdate
	0,  // 4: pacman.LobbyService.StreamScores:input_type -> pacman.ScoreUpdate
	7,  // 5: pacman.LobbyService.StartGame:input_type -> pacman.StartGameRequest
	9,  // 6: pacman.LobbyService.StreamGameStart:input_type -> pacman.GameStartUpdate
	12, // 7: pacman.LobbyService.GetTopScores:input_type -> pacman.TopScoresRequest
	14, // 8: pacman.LobbyService.InsertScore:input_type -> pacman.InsertScoreRequest
	2,  // 9: pacman.LobbyService.JoinLobby:output_type -> pacman.JoinResponse
	4,  // 10: pacman.LobbyService.LeaveLobby:output_type -> pacman.LeaveResponse
	6,  // 11: pacman.LobbyService.StreamLobby:output_type -> pacman.PlayerStatus
	0,  // 12: pacman.LobbyService.StreamScores:output_type -> pacman.ScoreUpdate
	8,  // 13: pacman.LobbyService.StartGame:output_type -> pacman.StartGameResponse
	10, // 14: pacman.LobbyService.StreamGameStart:output_type -> pacman.GameStartNotification
	13, // 15: pacman.LobbyService.GetTopScores:output_type -> pacman.TopScoresResponse
	15, // 16: pacman.LobbyService.InsertScore:output_type -> pacman.InsertScoreResponse
	9,  // [9:17] is the sub-list for method output_type
	1,  // [1:9] is the sub-list for method input_type
	1,  // [1:1] is the sub-list for extension type_name
	1,  // [1:1] is the sub-list for extension extendee
	0,  // [0:1] is the sub-list for field type_name
}

func init() { file_pacman_proto_init() }
func file_pacman_proto_init() {
	if File_pacman_proto != nil {
		return
	}
	type x struct{}
	out := protoimpl.TypeBuilder{
		File: protoimpl.DescBuilder{
			GoPackagePath: reflect.TypeOf(x{}).PkgPath(),
			RawDescriptor: file_pacman_proto_rawDesc,
			NumEnums:      0,
			NumMessages:   16,
			NumExtensions: 0,
			NumServices:   1,
		},
		GoTypes:           file_pacman_proto_goTypes,
		DependencyIndexes: file_pacman_proto_depIdxs,
		MessageInfos:      file_pacman_proto_msgTypes,
	}.Build()
	File_pacman_proto = out.File
	file_pacman_proto_rawDesc = nil
	file_pacman_proto_goTypes = nil
	file_pacman_proto_depIdxs = nil
}
