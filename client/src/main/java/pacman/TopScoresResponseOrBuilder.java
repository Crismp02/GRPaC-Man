// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: pacman.proto
// Protobuf Java Version: 4.28.2

package pacman;

public interface TopScoresResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:pacman.TopScoresResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * List of top scores
   * </pre>
   *
   * <code>repeated .pacman.ScoreHistory scores = 1;</code>
   */
  java.util.List<pacman.ScoreHistory> 
      getScoresList();
  /**
   * <pre>
   * List of top scores
   * </pre>
   *
   * <code>repeated .pacman.ScoreHistory scores = 1;</code>
   */
  pacman.ScoreHistory getScores(int index);
  /**
   * <pre>
   * List of top scores
   * </pre>
   *
   * <code>repeated .pacman.ScoreHistory scores = 1;</code>
   */
  int getScoresCount();
  /**
   * <pre>
   * List of top scores
   * </pre>
   *
   * <code>repeated .pacman.ScoreHistory scores = 1;</code>
   */
  java.util.List<? extends pacman.ScoreHistoryOrBuilder> 
      getScoresOrBuilderList();
  /**
   * <pre>
   * List of top scores
   * </pre>
   *
   * <code>repeated .pacman.ScoreHistory scores = 1;</code>
   */
  pacman.ScoreHistoryOrBuilder getScoresOrBuilder(
      int index);
}
