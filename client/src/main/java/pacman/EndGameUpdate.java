// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: pacman.proto
// Protobuf Java Version: 4.28.2

package pacman;

/**
 * Protobuf type {@code pacman.EndGameUpdate}
 */
public final class EndGameUpdate extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:pacman.EndGameUpdate)
    EndGameUpdateOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 28,
      /* patch= */ 2,
      /* suffix= */ "",
      EndGameUpdate.class.getName());
  }
  // Use EndGameUpdate.newBuilder() to construct.
  private EndGameUpdate(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private EndGameUpdate() {
    playerName_ = "";
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return pacman.Pacman.internal_static_pacman_EndGameUpdate_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return pacman.Pacman.internal_static_pacman_EndGameUpdate_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            pacman.EndGameUpdate.class, pacman.EndGameUpdate.Builder.class);
  }

  public static final int PLAYERNAME_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object playerName_ = "";
  /**
   * <pre>
   * Indicates if a player has ended the game
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
   * Indicates if a player has ended the game
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
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof pacman.EndGameUpdate)) {
      return super.equals(obj);
    }
    pacman.EndGameUpdate other = (pacman.EndGameUpdate) obj;

    if (!getPlayerName()
        .equals(other.getPlayerName())) return false;
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
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static pacman.EndGameUpdate parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pacman.EndGameUpdate parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pacman.EndGameUpdate parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pacman.EndGameUpdate parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pacman.EndGameUpdate parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pacman.EndGameUpdate parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pacman.EndGameUpdate parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static pacman.EndGameUpdate parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static pacman.EndGameUpdate parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static pacman.EndGameUpdate parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static pacman.EndGameUpdate parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static pacman.EndGameUpdate parseFrom(
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
  public static Builder newBuilder(pacman.EndGameUpdate prototype) {
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
   * Protobuf type {@code pacman.EndGameUpdate}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:pacman.EndGameUpdate)
      pacman.EndGameUpdateOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return pacman.Pacman.internal_static_pacman_EndGameUpdate_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return pacman.Pacman.internal_static_pacman_EndGameUpdate_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              pacman.EndGameUpdate.class, pacman.EndGameUpdate.Builder.class);
    }

    // Construct using pacman.EndGameUpdate.newBuilder()
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
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return pacman.Pacman.internal_static_pacman_EndGameUpdate_descriptor;
    }

    @java.lang.Override
    public pacman.EndGameUpdate getDefaultInstanceForType() {
      return pacman.EndGameUpdate.getDefaultInstance();
    }

    @java.lang.Override
    public pacman.EndGameUpdate build() {
      pacman.EndGameUpdate result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public pacman.EndGameUpdate buildPartial() {
      pacman.EndGameUpdate result = new pacman.EndGameUpdate(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(pacman.EndGameUpdate result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.playerName_ = playerName_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof pacman.EndGameUpdate) {
        return mergeFrom((pacman.EndGameUpdate)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(pacman.EndGameUpdate other) {
      if (other == pacman.EndGameUpdate.getDefaultInstance()) return this;
      if (!other.getPlayerName().isEmpty()) {
        playerName_ = other.playerName_;
        bitField0_ |= 0x00000001;
        onChanged();
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
     * Indicates if a player has ended the game
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
     * Indicates if a player has ended the game
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
     * Indicates if a player has ended the game
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
     * Indicates if a player has ended the game
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
     * Indicates if a player has ended the game
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

    // @@protoc_insertion_point(builder_scope:pacman.EndGameUpdate)
  }

  // @@protoc_insertion_point(class_scope:pacman.EndGameUpdate)
  private static final pacman.EndGameUpdate DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new pacman.EndGameUpdate();
  }

  public static pacman.EndGameUpdate getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<EndGameUpdate>
      PARSER = new com.google.protobuf.AbstractParser<EndGameUpdate>() {
    @java.lang.Override
    public EndGameUpdate parsePartialFrom(
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

  public static com.google.protobuf.Parser<EndGameUpdate> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<EndGameUpdate> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public pacman.EndGameUpdate getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
