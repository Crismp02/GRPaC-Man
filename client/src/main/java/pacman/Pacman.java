// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: pacman.proto
// Protobuf Java Version: 4.28.2

package pacman;

public final class Pacman {
  private Pacman() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 28,
      /* patch= */ 2,
      /* suffix= */ "",
      Pacman.class.getName());
  }
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pacman_ScoreUpdate_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_pacman_ScoreUpdate_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pacman_JoinRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_pacman_JoinRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pacman_JoinResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_pacman_JoinResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pacman_LeaveRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_pacman_LeaveRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pacman_LeaveResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_pacman_LeaveResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pacman_LobbyUpdate_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_pacman_LobbyUpdate_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pacman_PlayerStatus_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_pacman_PlayerStatus_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014pacman.proto\022\006pacman\"1\n\013ScoreUpdate\022\023\n" +
      "\013player_name\030\001 \001(\t\022\r\n\005score\030\002 \001(\005\"!\n\013Joi" +
      "nRequest\022\022\n\nplayerName\030\001 \001(\t\"0\n\014JoinResp" +
      "onse\022\017\n\007message\030\001 \001(\t\022\017\n\007players\030\002 \003(\t\"\"" +
      "\n\014LeaveRequest\022\022\n\nplayerName\030\001 \001(\t\" \n\rLe" +
      "aveResponse\022\017\n\007message\030\001 \001(\t\"4\n\013LobbyUpd" +
      "ate\022\022\n\nplayerName\030\001 \001(\t\022\021\n\tisJoining\030\002 \001" +
      "(\010\":\n\014PlayerStatus\022\022\n\nplayerName\030\001 \001(\t\022\026" +
      "\n\016currentPlayers\030\002 \001(\0052\375\001\n\014LobbyService\022" +
      "6\n\tJoinLobby\022\023.pacman.JoinRequest\032\024.pacm" +
      "an.JoinResponse\0229\n\nLeaveLobby\022\024.pacman.L" +
      "eaveRequest\032\025.pacman.LeaveResponse\022<\n\013St" +
      "reamLobby\022\023.pacman.LobbyUpdate\032\024.pacman." +
      "PlayerStatus(\0010\001\022<\n\014StreamScores\022\023.pacma" +
      "n.ScoreUpdate\032\023.pacman.ScoreUpdate(\0010\001B\024" +
      "P\001Z\roperator/grpc\210\001\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_pacman_ScoreUpdate_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_pacman_ScoreUpdate_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_pacman_ScoreUpdate_descriptor,
        new java.lang.String[] { "PlayerName", "Score", });
    internal_static_pacman_JoinRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_pacman_JoinRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_pacman_JoinRequest_descriptor,
        new java.lang.String[] { "PlayerName", });
    internal_static_pacman_JoinResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_pacman_JoinResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_pacman_JoinResponse_descriptor,
        new java.lang.String[] { "Message", "Players", });
    internal_static_pacman_LeaveRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_pacman_LeaveRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_pacman_LeaveRequest_descriptor,
        new java.lang.String[] { "PlayerName", });
    internal_static_pacman_LeaveResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_pacman_LeaveResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_pacman_LeaveResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_pacman_LobbyUpdate_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_pacman_LobbyUpdate_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_pacman_LobbyUpdate_descriptor,
        new java.lang.String[] { "PlayerName", "IsJoining", });
    internal_static_pacman_PlayerStatus_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_pacman_PlayerStatus_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_pacman_PlayerStatus_descriptor,
        new java.lang.String[] { "PlayerName", "CurrentPlayers", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}