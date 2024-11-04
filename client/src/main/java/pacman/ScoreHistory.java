// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: pacman.proto
// Protobuf Java Version: 4.28.2

package pacman;

/**
 * Protobuf type {@code pacman.ScoreHistory}
 */
public final class ScoreHistory extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:pacman.ScoreHistory)
    ScoreHistoryOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 28,
      /* patch= */ 2,
      /* suffix= */ "",
      ScoreHistory.class.getName());
  }
  // Use ScoreHistory.newBuilder() to construct.
  private ScoreHistory(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private ScoreHistory() {
    playerName_ = "";
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return pacman.Pacman.internal_static_pacman_ScoreHistory_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return pacman.Pacman.internal_static_pacman_ScoreHistory_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            pacman.ScoreHistory.class, pacman.ScoreHistory.Builder.class);
  }

  public static final int PLAYERNAME_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object playerName_ = "";
  /**
   * <pre>
   * Name of the player
   * </pre>
   *
   * <code>string playerName = 1;</code>
   * @return The playerName.
   */
  @java.lang.Override
  public java.lang.String getPlayerName() {
    java.lang.Object ref = playerName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      playerName_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Name of the player
   * </pre>
   *
   * <code>string playerName = 1;</code>
   * @return The bytes for playerName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getPlayerNameBytes() {
    java.lang.Object ref = playerName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      playerName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SCORE_FIELD_NUMBER = 2;
  private int score_ = 0;
  /**
   * <pre>
   * Player's score
   * </pre>
   *
   * <code>int32 score = 2;</code>
   * @return The score.
   */
  @java.lang.Override
  public int getScore() {
    return score_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(playerName_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, playerName_);
    }
    if (score_ != 0) {
      output.writeInt32(2, score_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(playerName_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, playerName_);
    }
    if (score_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, score_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof pacman.ScoreHistory)) {
      return super.equals(obj);
    }
    pacman.ScoreHistory other = (pacman.ScoreHistory) obj;

    if (!getPlayerName()
        .equals(other.getPlayerName())) return false;
    if (getScore()
        != other.getScore()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PLAYERNAME_FIELD_NUMBER;
    hash = (53 * hash) + getPlayerName().hashCode();
    hash = (37 * hash) + SCORE_FIELD_NUMBER;
    hash = (53 * hash) + getScore();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static pacman.ScoreHistory parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pacman.ScoreHistory parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pacman.ScoreHistory parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pacman.ScoreHistory parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pacman.ScoreHistory parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pacman.ScoreHistory parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pacman.ScoreHistory parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static pacman.ScoreHistory parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static pacman.ScoreHistory parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static pacman.ScoreHistory parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static pacman.ScoreHistory parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static pacman.ScoreHistory parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(pacman.ScoreHistory prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code pacman.ScoreHistory}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:pacman.ScoreHistory)
      pacman.ScoreHistoryOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return pacman.Pacman.internal_static_pacman_ScoreHistory_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return pacman.Pacman.internal_static_pacman_ScoreHistory_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              pacman.ScoreHistory.class, pacman.ScoreHistory.Builder.class);
    }

    // Construct using pacman.ScoreHistory.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      playerName_ = "";
      score_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return pacman.Pacman.internal_static_pacman_ScoreHistory_descriptor;
    }

    @java.lang.Override
    public pacman.ScoreHistory getDefaultInstanceForType() {
      return pacman.ScoreHistory.getDefaultInstance();
    }

    @java.lang.Override
    public pacman.ScoreHistory build() {
      pacman.ScoreHistory result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public pacman.ScoreHistory buildPartial() {
      pacman.ScoreHistory result = new pacman.ScoreHistory(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(pacman.ScoreHistory result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.playerName_ = playerName_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.score_ = score_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof pacman.ScoreHistory) {
        return mergeFrom((pacman.ScoreHistory)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(pacman.ScoreHistory other) {
      if (other == pacman.ScoreHistory.getDefaultInstance()) return this;
      if (!other.getPlayerName().isEmpty()) {
        playerName_ = other.playerName_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.getScore() != 0) {
        setScore(other.getScore());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              playerName_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              score_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object playerName_ = "";
    /**
     * <pre>
     * Name of the player
     * </pre>
     *
     * <code>string playerName = 1;</code>
     * @return The playerName.
     */
    public java.lang.String getPlayerName() {
      java.lang.Object ref = playerName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        playerName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * Name of the player
     * </pre>
     *
     * <code>string playerName = 1;</code>
     * @return The bytes for playerName.
     */
    public com.google.protobuf.ByteString
        getPlayerNameBytes() {
      java.lang.Object ref = playerName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        playerName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Name of the player
     * </pre>
     *
     * <code>string playerName = 1;</code>
     * @param value The playerName to set.
     * @return This builder for chaining.
     */
    public Builder setPlayerName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      playerName_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Name of the player
     * </pre>
     *
     * <code>string playerName = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearPlayerName() {
      playerName_ = getDefaultInstance().getPlayerName();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Name of the player
     * </pre>
     *
     * <code>string playerName = 1;</code>
     * @param value The bytes for playerName to set.
     * @return This builder for chaining.
     */
    public Builder setPlayerNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      playerName_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private int score_ ;
    /**
     * <pre>
     * Player's score
     * </pre>
     *
     * <code>int32 score = 2;</code>
     * @return The score.
     */
    @java.lang.Override
    public int getScore() {
      return score_;
    }
    /**
     * <pre>
     * Player's score
     * </pre>
     *
     * <code>int32 score = 2;</code>
     * @param value The score to set.
     * @return This builder for chaining.
     */
    public Builder setScore(int value) {

      score_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Player's score
     * </pre>
     *
     * <code>int32 score = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearScore() {
      bitField0_ = (bitField0_ & ~0x00000002);
      score_ = 0;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:pacman.ScoreHistory)
  }

  // @@protoc_insertion_point(class_scope:pacman.ScoreHistory)
  private static final pacman.ScoreHistory DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new pacman.ScoreHistory();
  }

  public static pacman.ScoreHistory getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ScoreHistory>
      PARSER = new com.google.protobuf.AbstractParser<ScoreHistory>() {
    @java.lang.Override
    public ScoreHistory parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<ScoreHistory> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ScoreHistory> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public pacman.ScoreHistory getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
