// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: pacman.proto
// Protobuf Java Version: 4.28.2

package pacman;

/**
 * Protobuf type {@code pacman.LobbyUpdate}
 */
public final class LobbyUpdate extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:pacman.LobbyUpdate)
    LobbyUpdateOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 28,
      /* patch= */ 2,
      /* suffix= */ "",
      LobbyUpdate.class.getName());
  }
  // Use LobbyUpdate.newBuilder() to construct.
  private LobbyUpdate(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private LobbyUpdate() {
    playerName_ = "";
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return pacman.Pacman.internal_static_pacman_LobbyUpdate_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return pacman.Pacman.internal_static_pacman_LobbyUpdate_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            pacman.LobbyUpdate.class, pacman.LobbyUpdate.Builder.class);
  }

  public static final int PLAYERNAME_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object playerName_ = "";
  /**
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

  public static final int ISJOINING_FIELD_NUMBER = 2;
  private boolean isJoining_ = false;
  /**
   * <pre>
   * True if joining, false if leaving
   * </pre>
   *
   * <code>bool isJoining = 2;</code>
   * @return The isJoining.
   */
  @java.lang.Override
  public boolean getIsJoining() {
    return isJoining_;
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
    if (isJoining_ != false) {
      output.writeBool(2, isJoining_);
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
    if (isJoining_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, isJoining_);
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
    if (!(obj instanceof pacman.LobbyUpdate)) {
      return super.equals(obj);
    }
    pacman.LobbyUpdate other = (pacman.LobbyUpdate) obj;

    if (!getPlayerName()
        .equals(other.getPlayerName())) return false;
    if (getIsJoining()
        != other.getIsJoining()) return false;
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
    hash = (37 * hash) + ISJOINING_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getIsJoining());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static pacman.LobbyUpdate parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pacman.LobbyUpdate parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pacman.LobbyUpdate parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pacman.LobbyUpdate parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pacman.LobbyUpdate parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pacman.LobbyUpdate parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pacman.LobbyUpdate parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static pacman.LobbyUpdate parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static pacman.LobbyUpdate parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static pacman.LobbyUpdate parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static pacman.LobbyUpdate parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static pacman.LobbyUpdate parseFrom(
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
  public static Builder newBuilder(pacman.LobbyUpdate prototype) {
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
   * Protobuf type {@code pacman.LobbyUpdate}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:pacman.LobbyUpdate)
      pacman.LobbyUpdateOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return pacman.Pacman.internal_static_pacman_LobbyUpdate_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return pacman.Pacman.internal_static_pacman_LobbyUpdate_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              pacman.LobbyUpdate.class, pacman.LobbyUpdate.Builder.class);
    }

    // Construct using pacman.LobbyUpdate.newBuilder()
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
      isJoining_ = false;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return pacman.Pacman.internal_static_pacman_LobbyUpdate_descriptor;
    }

    @java.lang.Override
    public pacman.LobbyUpdate getDefaultInstanceForType() {
      return pacman.LobbyUpdate.getDefaultInstance();
    }

    @java.lang.Override
    public pacman.LobbyUpdate build() {
      pacman.LobbyUpdate result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public pacman.LobbyUpdate buildPartial() {
      pacman.LobbyUpdate result = new pacman.LobbyUpdate(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(pacman.LobbyUpdate result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.playerName_ = playerName_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.isJoining_ = isJoining_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof pacman.LobbyUpdate) {
        return mergeFrom((pacman.LobbyUpdate)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(pacman.LobbyUpdate other) {
      if (other == pacman.LobbyUpdate.getDefaultInstance()) return this;
      if (!other.getPlayerName().isEmpty()) {
        playerName_ = other.playerName_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.getIsJoining() != false) {
        setIsJoining(other.getIsJoining());
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
              isJoining_ = input.readBool();
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

    private boolean isJoining_ ;
    /**
     * <pre>
     * True if joining, false if leaving
     * </pre>
     *
     * <code>bool isJoining = 2;</code>
     * @return The isJoining.
     */
    @java.lang.Override
    public boolean getIsJoining() {
      return isJoining_;
    }
    /**
     * <pre>
     * True if joining, false if leaving
     * </pre>
     *
     * <code>bool isJoining = 2;</code>
     * @param value The isJoining to set.
     * @return This builder for chaining.
     */
    public Builder setIsJoining(boolean value) {

      isJoining_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * True if joining, false if leaving
     * </pre>
     *
     * <code>bool isJoining = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearIsJoining() {
      bitField0_ = (bitField0_ & ~0x00000002);
      isJoining_ = false;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:pacman.LobbyUpdate)
  }

  // @@protoc_insertion_point(class_scope:pacman.LobbyUpdate)
  private static final pacman.LobbyUpdate DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new pacman.LobbyUpdate();
  }

  public static pacman.LobbyUpdate getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LobbyUpdate>
      PARSER = new com.google.protobuf.AbstractParser<LobbyUpdate>() {
    @java.lang.Override
    public LobbyUpdate parsePartialFrom(
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

  public static com.google.protobuf.Parser<LobbyUpdate> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LobbyUpdate> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public pacman.LobbyUpdate getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

