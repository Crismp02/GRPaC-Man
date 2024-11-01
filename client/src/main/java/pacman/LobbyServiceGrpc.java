package pacman;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.0)",
    comments = "Source: pacman.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LobbyServiceGrpc {

  private LobbyServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "pacman.LobbyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<pacman.JoinRequest,
      pacman.JoinResponse> getJoinLobbyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JoinLobby",
      requestType = pacman.JoinRequest.class,
      responseType = pacman.JoinResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pacman.JoinRequest,
      pacman.JoinResponse> getJoinLobbyMethod() {
    io.grpc.MethodDescriptor<pacman.JoinRequest, pacman.JoinResponse> getJoinLobbyMethod;
    if ((getJoinLobbyMethod = LobbyServiceGrpc.getJoinLobbyMethod) == null) {
      synchronized (LobbyServiceGrpc.class) {
        if ((getJoinLobbyMethod = LobbyServiceGrpc.getJoinLobbyMethod) == null) {
          LobbyServiceGrpc.getJoinLobbyMethod = getJoinLobbyMethod =
              io.grpc.MethodDescriptor.<pacman.JoinRequest, pacman.JoinResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JoinLobby"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pacman.JoinRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pacman.JoinResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LobbyServiceMethodDescriptorSupplier("JoinLobby"))
              .build();
        }
      }
    }
    return getJoinLobbyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pacman.LeaveRequest,
      pacman.LeaveResponse> getLeaveLobbyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LeaveLobby",
      requestType = pacman.LeaveRequest.class,
      responseType = pacman.LeaveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pacman.LeaveRequest,
      pacman.LeaveResponse> getLeaveLobbyMethod() {
    io.grpc.MethodDescriptor<pacman.LeaveRequest, pacman.LeaveResponse> getLeaveLobbyMethod;
    if ((getLeaveLobbyMethod = LobbyServiceGrpc.getLeaveLobbyMethod) == null) {
      synchronized (LobbyServiceGrpc.class) {
        if ((getLeaveLobbyMethod = LobbyServiceGrpc.getLeaveLobbyMethod) == null) {
          LobbyServiceGrpc.getLeaveLobbyMethod = getLeaveLobbyMethod =
              io.grpc.MethodDescriptor.<pacman.LeaveRequest, pacman.LeaveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LeaveLobby"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pacman.LeaveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pacman.LeaveResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LobbyServiceMethodDescriptorSupplier("LeaveLobby"))
              .build();
        }
      }
    }
    return getLeaveLobbyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pacman.LobbyUpdate,
      pacman.PlayerStatus> getStreamLobbyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamLobby",
      requestType = pacman.LobbyUpdate.class,
      responseType = pacman.PlayerStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<pacman.LobbyUpdate,
      pacman.PlayerStatus> getStreamLobbyMethod() {
    io.grpc.MethodDescriptor<pacman.LobbyUpdate, pacman.PlayerStatus> getStreamLobbyMethod;
    if ((getStreamLobbyMethod = LobbyServiceGrpc.getStreamLobbyMethod) == null) {
      synchronized (LobbyServiceGrpc.class) {
        if ((getStreamLobbyMethod = LobbyServiceGrpc.getStreamLobbyMethod) == null) {
          LobbyServiceGrpc.getStreamLobbyMethod = getStreamLobbyMethod =
              io.grpc.MethodDescriptor.<pacman.LobbyUpdate, pacman.PlayerStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamLobby"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pacman.LobbyUpdate.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pacman.PlayerStatus.getDefaultInstance()))
              .setSchemaDescriptor(new LobbyServiceMethodDescriptorSupplier("StreamLobby"))
              .build();
        }
      }
    }
    return getStreamLobbyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pacman.ScoreUpdate,
      pacman.ScoreUpdate> getStreamScoresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamScores",
      requestType = pacman.ScoreUpdate.class,
      responseType = pacman.ScoreUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<pacman.ScoreUpdate,
      pacman.ScoreUpdate> getStreamScoresMethod() {
    io.grpc.MethodDescriptor<pacman.ScoreUpdate, pacman.ScoreUpdate> getStreamScoresMethod;
    if ((getStreamScoresMethod = LobbyServiceGrpc.getStreamScoresMethod) == null) {
      synchronized (LobbyServiceGrpc.class) {
        if ((getStreamScoresMethod = LobbyServiceGrpc.getStreamScoresMethod) == null) {
          LobbyServiceGrpc.getStreamScoresMethod = getStreamScoresMethod =
              io.grpc.MethodDescriptor.<pacman.ScoreUpdate, pacman.ScoreUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamScores"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pacman.ScoreUpdate.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pacman.ScoreUpdate.getDefaultInstance()))
              .setSchemaDescriptor(new LobbyServiceMethodDescriptorSupplier("StreamScores"))
              .build();
        }
      }
    }
    return getStreamScoresMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LobbyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LobbyServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LobbyServiceStub>() {
        @java.lang.Override
        public LobbyServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LobbyServiceStub(channel, callOptions);
        }
      };
    return LobbyServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LobbyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LobbyServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LobbyServiceBlockingStub>() {
        @java.lang.Override
        public LobbyServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LobbyServiceBlockingStub(channel, callOptions);
        }
      };
    return LobbyServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LobbyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LobbyServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LobbyServiceFutureStub>() {
        @java.lang.Override
        public LobbyServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LobbyServiceFutureStub(channel, callOptions);
        }
      };
    return LobbyServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void joinLobby(pacman.JoinRequest request,
        io.grpc.stub.StreamObserver<pacman.JoinResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJoinLobbyMethod(), responseObserver);
    }

    /**
     */
    default void leaveLobby(pacman.LeaveRequest request,
        io.grpc.stub.StreamObserver<pacman.LeaveResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLeaveLobbyMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<pacman.LobbyUpdate> streamLobby(
        io.grpc.stub.StreamObserver<pacman.PlayerStatus> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamLobbyMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<pacman.ScoreUpdate> streamScores(
        io.grpc.stub.StreamObserver<pacman.ScoreUpdate> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamScoresMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LobbyService.
   */
  public static abstract class LobbyServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LobbyServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LobbyService.
   */
  public static final class LobbyServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LobbyServiceStub> {
    private LobbyServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LobbyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LobbyServiceStub(channel, callOptions);
    }

    /**
     */
    public void joinLobby(pacman.JoinRequest request,
        io.grpc.stub.StreamObserver<pacman.JoinResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJoinLobbyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void leaveLobby(pacman.LeaveRequest request,
        io.grpc.stub.StreamObserver<pacman.LeaveResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLeaveLobbyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<pacman.LobbyUpdate> streamLobby(
        io.grpc.stub.StreamObserver<pacman.PlayerStatus> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamLobbyMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<pacman.ScoreUpdate> streamScores(
        io.grpc.stub.StreamObserver<pacman.ScoreUpdate> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamScoresMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LobbyService.
   */
  public static final class LobbyServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LobbyServiceBlockingStub> {
    private LobbyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LobbyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LobbyServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public pacman.JoinResponse joinLobby(pacman.JoinRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJoinLobbyMethod(), getCallOptions(), request);
    }

    /**
     */
    public pacman.LeaveResponse leaveLobby(pacman.LeaveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLeaveLobbyMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LobbyService.
   */
  public static final class LobbyServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LobbyServiceFutureStub> {
    private LobbyServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LobbyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LobbyServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pacman.JoinResponse> joinLobby(
        pacman.JoinRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJoinLobbyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pacman.LeaveResponse> leaveLobby(
        pacman.LeaveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLeaveLobbyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_JOIN_LOBBY = 0;
  private static final int METHODID_LEAVE_LOBBY = 1;
  private static final int METHODID_STREAM_LOBBY = 2;
  private static final int METHODID_STREAM_SCORES = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_JOIN_LOBBY:
          serviceImpl.joinLobby((pacman.JoinRequest) request,
              (io.grpc.stub.StreamObserver<pacman.JoinResponse>) responseObserver);
          break;
        case METHODID_LEAVE_LOBBY:
          serviceImpl.leaveLobby((pacman.LeaveRequest) request,
              (io.grpc.stub.StreamObserver<pacman.LeaveResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_LOBBY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamLobby(
              (io.grpc.stub.StreamObserver<pacman.PlayerStatus>) responseObserver);
        case METHODID_STREAM_SCORES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamScores(
              (io.grpc.stub.StreamObserver<pacman.ScoreUpdate>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getJoinLobbyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              pacman.JoinRequest,
              pacman.JoinResponse>(
                service, METHODID_JOIN_LOBBY)))
        .addMethod(
          getLeaveLobbyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              pacman.LeaveRequest,
              pacman.LeaveResponse>(
                service, METHODID_LEAVE_LOBBY)))
        .addMethod(
          getStreamLobbyMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              pacman.LobbyUpdate,
              pacman.PlayerStatus>(
                service, METHODID_STREAM_LOBBY)))
        .addMethod(
          getStreamScoresMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              pacman.ScoreUpdate,
              pacman.ScoreUpdate>(
                service, METHODID_STREAM_SCORES)))
        .build();
  }

  private static abstract class LobbyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LobbyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pacman.Pacman.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LobbyService");
    }
  }

  private static final class LobbyServiceFileDescriptorSupplier
      extends LobbyServiceBaseDescriptorSupplier {
    LobbyServiceFileDescriptorSupplier() {}
  }

  private static final class LobbyServiceMethodDescriptorSupplier
      extends LobbyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LobbyServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LobbyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LobbyServiceFileDescriptorSupplier())
              .addMethod(getJoinLobbyMethod())
              .addMethod(getLeaveLobbyMethod())
              .addMethod(getStreamLobbyMethod())
              .addMethod(getStreamScoresMethod())
              .build();
        }
      }
    }
    return result;
  }
}
