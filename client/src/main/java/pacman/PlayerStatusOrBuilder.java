// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: pacman.proto
// Protobuf Java Version: 4.28.2

package pacman;

public interface PlayerStatusOrBuilder extends
    // @@protoc_insertion_point(interface_extends:pacman.PlayerStatus)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string playerName = 1;</code>
   * @return The playerName.
   */
  java.lang.String getPlayerName();
  /**
   * <code>string playerName = 1;</code>
   * @return The bytes for playerName.
   */
  com.google.protobuf.ByteString
      getPlayerNameBytes();

  /**
   * <pre>
   * Current number of players in the lobby
   * </pre>
   *
   * <code>int32 currentPlayers = 2;</code>
   * @return The currentPlayers.
   */
  int getCurrentPlayers();
}
