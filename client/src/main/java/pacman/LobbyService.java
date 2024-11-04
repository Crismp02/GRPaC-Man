// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: pacman.proto
// Protobuf Java Version: 4.28.2

package pacman;

/**
 * Protobuf service {@code pacman.LobbyService}
 */
public  abstract class LobbyService
    implements com.google.protobuf.Service {
  protected LobbyService() {}

  public interface Interface {
    /**
     * <code>rpc JoinLobby(.pacman.JoinRequest) returns (.pacman.JoinResponse);</code>
     */
    public abstract void joinLobby(
        com.google.protobuf.RpcController controller,
        pacman.JoinRequest request,
        com.google.protobuf.RpcCallback<pacman.JoinResponse> done);

    /**
     * <code>rpc LeaveLobby(.pacman.LeaveRequest) returns (.pacman.LeaveResponse);</code>
     */
    public abstract void leaveLobby(
        com.google.protobuf.RpcController controller,
        pacman.LeaveRequest request,
        com.google.protobuf.RpcCallback<pacman.LeaveResponse> done);

    /**
     * <code>rpc StreamLobby(stream .pacman.LobbyUpdate) returns (stream .pacman.PlayerStatus);</code>
     */
    public abstract void streamLobby(
        com.google.protobuf.RpcController controller,
        pacman.LobbyUpdate request,
        com.google.protobuf.RpcCallback<pacman.PlayerStatus> done);

    /**
     * <code>rpc StreamScores(stream .pacman.ScoreUpdate) returns (stream .pacman.ScoreUpdate);</code>
     */
    public abstract void streamScores(
        com.google.protobuf.RpcController controller,
        pacman.ScoreUpdate request,
        com.google.protobuf.RpcCallback<pacman.ScoreUpdate> done);

    /**
     * <code>rpc StartGame(.pacman.StartGameRequest) returns (.pacman.StartGameResponse);</code>
     */
    public abstract void startGame(
        com.google.protobuf.RpcController controller,
        pacman.StartGameRequest request,
        com.google.protobuf.RpcCallback<pacman.StartGameResponse> done);

    /**
     * <code>rpc StreamGameStart(stream .pacman.GameStartUpdate) returns (stream .pacman.GameStartNotification);</code>
     */
    public abstract void streamGameStart(
        com.google.protobuf.RpcController controller,
        pacman.GameStartUpdate request,
        com.google.protobuf.RpcCallback<pacman.GameStartNotification> done);

    /**
     * <code>rpc GetTopScores(.pacman.TopScoresRequest) returns (.pacman.TopScoresResponse);</code>
     */
    public abstract void getTopScores(
        com.google.protobuf.RpcController controller,
        pacman.TopScoresRequest request,
        com.google.protobuf.RpcCallback<pacman.TopScoresResponse> done);

  }

  public static com.google.protobuf.Service newReflectiveService(
      final Interface impl) {
    return new LobbyService() {
      @java.lang.Override
      public  void joinLobby(
          com.google.protobuf.RpcController controller,
          pacman.JoinRequest request,
          com.google.protobuf.RpcCallback<pacman.JoinResponse> done) {
        impl.joinLobby(controller, request, done);
      }

      @java.lang.Override
      public  void leaveLobby(
          com.google.protobuf.RpcController controller,
          pacman.LeaveRequest request,
          com.google.protobuf.RpcCallback<pacman.LeaveResponse> done) {
        impl.leaveLobby(controller, request, done);
      }

      @java.lang.Override
      public  void streamLobby(
          com.google.protobuf.RpcController controller,
          pacman.LobbyUpdate request,
          com.google.protobuf.RpcCallback<pacman.PlayerStatus> done) {
        impl.streamLobby(controller, request, done);
      }

      @java.lang.Override
      public  void streamScores(
          com.google.protobuf.RpcController controller,
          pacman.ScoreUpdate request,
          com.google.protobuf.RpcCallback<pacman.ScoreUpdate> done) {
        impl.streamScores(controller, request, done);
      }

      @java.lang.Override
      public  void startGame(
          com.google.protobuf.RpcController controller,
          pacman.StartGameRequest request,
          com.google.protobuf.RpcCallback<pacman.StartGameResponse> done) {
        impl.startGame(controller, request, done);
      }

      @java.lang.Override
      public  void streamGameStart(
          com.google.protobuf.RpcController controller,
          pacman.GameStartUpdate request,
          com.google.protobuf.RpcCallback<pacman.GameStartNotification> done) {
        impl.streamGameStart(controller, request, done);
      }

      @java.lang.Override
      public  void getTopScores(
          com.google.protobuf.RpcController controller,
          pacman.TopScoresRequest request,
          com.google.protobuf.RpcCallback<pacman.TopScoresResponse> done) {
        impl.getTopScores(controller, request, done);
      }

    };
  }

  public static com.google.protobuf.BlockingService
      newReflectiveBlockingService(final BlockingInterface impl) {
    return new com.google.protobuf.BlockingService() {
      public final com.google.protobuf.Descriptors.ServiceDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }

      public final com.google.protobuf.Message callBlockingMethod(
          com.google.protobuf.Descriptors.MethodDescriptor method,
          com.google.protobuf.RpcController controller,
          com.google.protobuf.Message request)
          throws com.google.protobuf.ServiceException {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.callBlockingMethod() given method descriptor for " +
            "wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return impl.joinLobby(controller, (pacman.JoinRequest)request);
          case 1:
            return impl.leaveLobby(controller, (pacman.LeaveRequest)request);
          case 2:
            return impl.streamLobby(controller, (pacman.LobbyUpdate)request);
          case 3:
            return impl.streamScores(controller, (pacman.ScoreUpdate)request);
          case 4:
            return impl.startGame(controller, (pacman.StartGameRequest)request);
          case 5:
            return impl.streamGameStart(controller, (pacman.GameStartUpdate)request);
          case 6:
            return impl.getTopScores(controller, (pacman.TopScoresRequest)request);
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

      public final com.google.protobuf.Message
          getRequestPrototype(
          com.google.protobuf.Descriptors.MethodDescriptor method) {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.getRequestPrototype() given method " +
            "descriptor for wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return pacman.JoinRequest.getDefaultInstance();
          case 1:
            return pacman.LeaveRequest.getDefaultInstance();
          case 2:
            return pacman.LobbyUpdate.getDefaultInstance();
          case 3:
            return pacman.ScoreUpdate.getDefaultInstance();
          case 4:
            return pacman.StartGameRequest.getDefaultInstance();
          case 5:
            return pacman.GameStartUpdate.getDefaultInstance();
          case 6:
            return pacman.TopScoresRequest.getDefaultInstance();
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

      public final com.google.protobuf.Message
          getResponsePrototype(
          com.google.protobuf.Descriptors.MethodDescriptor method) {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.getResponsePrototype() given method " +
            "descriptor for wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return pacman.JoinResponse.getDefaultInstance();
          case 1:
            return pacman.LeaveResponse.getDefaultInstance();
          case 2:
            return pacman.PlayerStatus.getDefaultInstance();
          case 3:
            return pacman.ScoreUpdate.getDefaultInstance();
          case 4:
            return pacman.StartGameResponse.getDefaultInstance();
          case 5:
            return pacman.GameStartNotification.getDefaultInstance();
          case 6:
            return pacman.TopScoresResponse.getDefaultInstance();
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

    };
  }

  /**
   * <code>rpc JoinLobby(.pacman.JoinRequest) returns (.pacman.JoinResponse);</code>
   */
  public abstract void joinLobby(
      com.google.protobuf.RpcController controller,
      pacman.JoinRequest request,
      com.google.protobuf.RpcCallback<pacman.JoinResponse> done);

  /**
   * <code>rpc LeaveLobby(.pacman.LeaveRequest) returns (.pacman.LeaveResponse);</code>
   */
  public abstract void leaveLobby(
      com.google.protobuf.RpcController controller,
      pacman.LeaveRequest request,
      com.google.protobuf.RpcCallback<pacman.LeaveResponse> done);

  /**
   * <code>rpc StreamLobby(stream .pacman.LobbyUpdate) returns (stream .pacman.PlayerStatus);</code>
   */
  public abstract void streamLobby(
      com.google.protobuf.RpcController controller,
      pacman.LobbyUpdate request,
      com.google.protobuf.RpcCallback<pacman.PlayerStatus> done);

  /**
   * <code>rpc StreamScores(stream .pacman.ScoreUpdate) returns (stream .pacman.ScoreUpdate);</code>
   */
  public abstract void streamScores(
      com.google.protobuf.RpcController controller,
      pacman.ScoreUpdate request,
      com.google.protobuf.RpcCallback<pacman.ScoreUpdate> done);

  /**
   * <code>rpc StartGame(.pacman.StartGameRequest) returns (.pacman.StartGameResponse);</code>
   */
  public abstract void startGame(
      com.google.protobuf.RpcController controller,
      pacman.StartGameRequest request,
      com.google.protobuf.RpcCallback<pacman.StartGameResponse> done);

  /**
   * <code>rpc StreamGameStart(stream .pacman.GameStartUpdate) returns (stream .pacman.GameStartNotification);</code>
   */
  public abstract void streamGameStart(
      com.google.protobuf.RpcController controller,
      pacman.GameStartUpdate request,
      com.google.protobuf.RpcCallback<pacman.GameStartNotification> done);

  /**
   * <code>rpc GetTopScores(.pacman.TopScoresRequest) returns (.pacman.TopScoresResponse);</code>
   */
  public abstract void getTopScores(
      com.google.protobuf.RpcController controller,
      pacman.TopScoresRequest request,
      com.google.protobuf.RpcCallback<pacman.TopScoresResponse> done);

  public static final
      com.google.protobuf.Descriptors.ServiceDescriptor
      getDescriptor() {
    return pacman.Pacman.getDescriptor().getServices().get(0);
  }
  public final com.google.protobuf.Descriptors.ServiceDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }

  public final void callMethod(
      com.google.protobuf.Descriptors.MethodDescriptor method,
      com.google.protobuf.RpcController controller,
      com.google.protobuf.Message request,
      com.google.protobuf.RpcCallback<
        com.google.protobuf.Message> done) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.callMethod() given method descriptor for wrong " +
        "service type.");
    }
    switch(method.getIndex()) {
      case 0:
        this.joinLobby(controller, (pacman.JoinRequest)request,
          com.google.protobuf.RpcUtil.<pacman.JoinResponse>specializeCallback(
            done));
        return;
      case 1:
        this.leaveLobby(controller, (pacman.LeaveRequest)request,
          com.google.protobuf.RpcUtil.<pacman.LeaveResponse>specializeCallback(
            done));
        return;
      case 2:
        this.streamLobby(controller, (pacman.LobbyUpdate)request,
          com.google.protobuf.RpcUtil.<pacman.PlayerStatus>specializeCallback(
            done));
        return;
      case 3:
        this.streamScores(controller, (pacman.ScoreUpdate)request,
          com.google.protobuf.RpcUtil.<pacman.ScoreUpdate>specializeCallback(
            done));
        return;
      case 4:
        this.startGame(controller, (pacman.StartGameRequest)request,
          com.google.protobuf.RpcUtil.<pacman.StartGameResponse>specializeCallback(
            done));
        return;
      case 5:
        this.streamGameStart(controller, (pacman.GameStartUpdate)request,
          com.google.protobuf.RpcUtil.<pacman.GameStartNotification>specializeCallback(
            done));
        return;
      case 6:
        this.getTopScores(controller, (pacman.TopScoresRequest)request,
          com.google.protobuf.RpcUtil.<pacman.TopScoresResponse>specializeCallback(
            done));
        return;
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public final com.google.protobuf.Message
      getRequestPrototype(
      com.google.protobuf.Descriptors.MethodDescriptor method) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.getRequestPrototype() given method " +
        "descriptor for wrong service type.");
    }
    switch(method.getIndex()) {
      case 0:
        return pacman.JoinRequest.getDefaultInstance();
      case 1:
        return pacman.LeaveRequest.getDefaultInstance();
      case 2:
        return pacman.LobbyUpdate.getDefaultInstance();
      case 3:
        return pacman.ScoreUpdate.getDefaultInstance();
      case 4:
        return pacman.StartGameRequest.getDefaultInstance();
      case 5:
        return pacman.GameStartUpdate.getDefaultInstance();
      case 6:
        return pacman.TopScoresRequest.getDefaultInstance();
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public final com.google.protobuf.Message
      getResponsePrototype(
      com.google.protobuf.Descriptors.MethodDescriptor method) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.getResponsePrototype() given method " +
        "descriptor for wrong service type.");
    }
    switch(method.getIndex()) {
      case 0:
        return pacman.JoinResponse.getDefaultInstance();
      case 1:
        return pacman.LeaveResponse.getDefaultInstance();
      case 2:
        return pacman.PlayerStatus.getDefaultInstance();
      case 3:
        return pacman.ScoreUpdate.getDefaultInstance();
      case 4:
        return pacman.StartGameResponse.getDefaultInstance();
      case 5:
        return pacman.GameStartNotification.getDefaultInstance();
      case 6:
        return pacman.TopScoresResponse.getDefaultInstance();
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public static Stub newStub(
      com.google.protobuf.RpcChannel channel) {
    return new Stub(channel);
  }

  public static final class Stub extends pacman.LobbyService implements Interface {
    private Stub(com.google.protobuf.RpcChannel channel) {
      this.channel = channel;
    }

    private final com.google.protobuf.RpcChannel channel;

    public com.google.protobuf.RpcChannel getChannel() {
      return channel;
    }

    public  void joinLobby(
        com.google.protobuf.RpcController controller,
        pacman.JoinRequest request,
        com.google.protobuf.RpcCallback<pacman.JoinResponse> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(0),
        controller,
        request,
        pacman.JoinResponse.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          pacman.JoinResponse.class,
          pacman.JoinResponse.getDefaultInstance()));
    }

    public  void leaveLobby(
        com.google.protobuf.RpcController controller,
        pacman.LeaveRequest request,
        com.google.protobuf.RpcCallback<pacman.LeaveResponse> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(1),
        controller,
        request,
        pacman.LeaveResponse.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          pacman.LeaveResponse.class,
          pacman.LeaveResponse.getDefaultInstance()));
    }

    public  void streamLobby(
        com.google.protobuf.RpcController controller,
        pacman.LobbyUpdate request,
        com.google.protobuf.RpcCallback<pacman.PlayerStatus> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(2),
        controller,
        request,
        pacman.PlayerStatus.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          pacman.PlayerStatus.class,
          pacman.PlayerStatus.getDefaultInstance()));
    }

    public  void streamScores(
        com.google.protobuf.RpcController controller,
        pacman.ScoreUpdate request,
        com.google.protobuf.RpcCallback<pacman.ScoreUpdate> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(3),
        controller,
        request,
        pacman.ScoreUpdate.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          pacman.ScoreUpdate.class,
          pacman.ScoreUpdate.getDefaultInstance()));
    }

    public  void startGame(
        com.google.protobuf.RpcController controller,
        pacman.StartGameRequest request,
        com.google.protobuf.RpcCallback<pacman.StartGameResponse> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(4),
        controller,
        request,
        pacman.StartGameResponse.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          pacman.StartGameResponse.class,
          pacman.StartGameResponse.getDefaultInstance()));
    }

    public  void streamGameStart(
        com.google.protobuf.RpcController controller,
        pacman.GameStartUpdate request,
        com.google.protobuf.RpcCallback<pacman.GameStartNotification> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(5),
        controller,
        request,
        pacman.GameStartNotification.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          pacman.GameStartNotification.class,
          pacman.GameStartNotification.getDefaultInstance()));
    }

    public  void getTopScores(
        com.google.protobuf.RpcController controller,
        pacman.TopScoresRequest request,
        com.google.protobuf.RpcCallback<pacman.TopScoresResponse> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(6),
        controller,
        request,
        pacman.TopScoresResponse.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          pacman.TopScoresResponse.class,
          pacman.TopScoresResponse.getDefaultInstance()));
    }
  }

  public static BlockingInterface newBlockingStub(
      com.google.protobuf.BlockingRpcChannel channel) {
    return new BlockingStub(channel);
  }

  public interface BlockingInterface {
    public pacman.JoinResponse joinLobby(
        com.google.protobuf.RpcController controller,
        pacman.JoinRequest request)
        throws com.google.protobuf.ServiceException;

    public pacman.LeaveResponse leaveLobby(
        com.google.protobuf.RpcController controller,
        pacman.LeaveRequest request)
        throws com.google.protobuf.ServiceException;

    public pacman.PlayerStatus streamLobby(
        com.google.protobuf.RpcController controller,
        pacman.LobbyUpdate request)
        throws com.google.protobuf.ServiceException;

    public pacman.ScoreUpdate streamScores(
        com.google.protobuf.RpcController controller,
        pacman.ScoreUpdate request)
        throws com.google.protobuf.ServiceException;

    public pacman.StartGameResponse startGame(
        com.google.protobuf.RpcController controller,
        pacman.StartGameRequest request)
        throws com.google.protobuf.ServiceException;

    public pacman.GameStartNotification streamGameStart(
        com.google.protobuf.RpcController controller,
        pacman.GameStartUpdate request)
        throws com.google.protobuf.ServiceException;

    public pacman.TopScoresResponse getTopScores(
        com.google.protobuf.RpcController controller,
        pacman.TopScoresRequest request)
        throws com.google.protobuf.ServiceException;
  }

  private static final class BlockingStub implements BlockingInterface {
    private BlockingStub(com.google.protobuf.BlockingRpcChannel channel) {
      this.channel = channel;
    }

    private final com.google.protobuf.BlockingRpcChannel channel;

    public pacman.JoinResponse joinLobby(
        com.google.protobuf.RpcController controller,
        pacman.JoinRequest request)
        throws com.google.protobuf.ServiceException {
      return (pacman.JoinResponse) channel.callBlockingMethod(
        getDescriptor().getMethods().get(0),
        controller,
        request,
        pacman.JoinResponse.getDefaultInstance());
    }


    public pacman.LeaveResponse leaveLobby(
        com.google.protobuf.RpcController controller,
        pacman.LeaveRequest request)
        throws com.google.protobuf.ServiceException {
      return (pacman.LeaveResponse) channel.callBlockingMethod(
        getDescriptor().getMethods().get(1),
        controller,
        request,
        pacman.LeaveResponse.getDefaultInstance());
    }


    public pacman.PlayerStatus streamLobby(
        com.google.protobuf.RpcController controller,
        pacman.LobbyUpdate request)
        throws com.google.protobuf.ServiceException {
      return (pacman.PlayerStatus) channel.callBlockingMethod(
        getDescriptor().getMethods().get(2),
        controller,
        request,
        pacman.PlayerStatus.getDefaultInstance());
    }


    public pacman.ScoreUpdate streamScores(
        com.google.protobuf.RpcController controller,
        pacman.ScoreUpdate request)
        throws com.google.protobuf.ServiceException {
      return (pacman.ScoreUpdate) channel.callBlockingMethod(
        getDescriptor().getMethods().get(3),
        controller,
        request,
        pacman.ScoreUpdate.getDefaultInstance());
    }


    public pacman.StartGameResponse startGame(
        com.google.protobuf.RpcController controller,
        pacman.StartGameRequest request)
        throws com.google.protobuf.ServiceException {
      return (pacman.StartGameResponse) channel.callBlockingMethod(
        getDescriptor().getMethods().get(4),
        controller,
        request,
        pacman.StartGameResponse.getDefaultInstance());
    }


    public pacman.GameStartNotification streamGameStart(
        com.google.protobuf.RpcController controller,
        pacman.GameStartUpdate request)
        throws com.google.protobuf.ServiceException {
      return (pacman.GameStartNotification) channel.callBlockingMethod(
        getDescriptor().getMethods().get(5),
        controller,
        request,
        pacman.GameStartNotification.getDefaultInstance());
    }


    public pacman.TopScoresResponse getTopScores(
        com.google.protobuf.RpcController controller,
        pacman.TopScoresRequest request)
        throws com.google.protobuf.ServiceException {
      return (pacman.TopScoresResponse) channel.callBlockingMethod(
        getDescriptor().getMethods().get(6),
        controller,
        request,
        pacman.TopScoresResponse.getDefaultInstance());
    }

  }

  // @@protoc_insertion_point(class_scope:pacman.LobbyService)
}

