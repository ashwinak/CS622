package com.proto.trafficStatistics;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: trafficStatistics/trafficStatistics.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FullInventoryListGrpc {

  private FullInventoryListGrpc() {}

  public static final String SERVICE_NAME = "trafficStatistics.FullInventoryList";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.trafficStatistics.QueryFullInventoryList,
      com.proto.trafficStatistics.FullInventoryListResponse> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribe",
      requestType = com.proto.trafficStatistics.QueryFullInventoryList.class,
      responseType = com.proto.trafficStatistics.FullInventoryListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.trafficStatistics.QueryFullInventoryList,
      com.proto.trafficStatistics.FullInventoryListResponse> getSubscribeMethod() {
    io.grpc.MethodDescriptor<com.proto.trafficStatistics.QueryFullInventoryList, com.proto.trafficStatistics.FullInventoryListResponse> getSubscribeMethod;
    if ((getSubscribeMethod = FullInventoryListGrpc.getSubscribeMethod) == null) {
      synchronized (FullInventoryListGrpc.class) {
        if ((getSubscribeMethod = FullInventoryListGrpc.getSubscribeMethod) == null) {
          FullInventoryListGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<com.proto.trafficStatistics.QueryFullInventoryList, com.proto.trafficStatistics.FullInventoryListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.trafficStatistics.QueryFullInventoryList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.trafficStatistics.FullInventoryListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FullInventoryListMethodDescriptorSupplier("subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FullInventoryListStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FullInventoryListStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FullInventoryListStub>() {
        @java.lang.Override
        public FullInventoryListStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FullInventoryListStub(channel, callOptions);
        }
      };
    return FullInventoryListStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FullInventoryListBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FullInventoryListBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FullInventoryListBlockingStub>() {
        @java.lang.Override
        public FullInventoryListBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FullInventoryListBlockingStub(channel, callOptions);
        }
      };
    return FullInventoryListBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FullInventoryListFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FullInventoryListFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FullInventoryListFutureStub>() {
        @java.lang.Override
        public FullInventoryListFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FullInventoryListFutureStub(channel, callOptions);
        }
      };
    return FullInventoryListFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void subscribe(com.proto.trafficStatistics.QueryFullInventoryList request,
        io.grpc.stub.StreamObserver<com.proto.trafficStatistics.FullInventoryListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FullInventoryList.
   */
  public static abstract class FullInventoryListImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FullInventoryListGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FullInventoryList.
   */
  public static final class FullInventoryListStub
      extends io.grpc.stub.AbstractAsyncStub<FullInventoryListStub> {
    private FullInventoryListStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FullInventoryListStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FullInventoryListStub(channel, callOptions);
    }

    /**
     */
    public void subscribe(com.proto.trafficStatistics.QueryFullInventoryList request,
        io.grpc.stub.StreamObserver<com.proto.trafficStatistics.FullInventoryListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FullInventoryList.
   */
  public static final class FullInventoryListBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FullInventoryListBlockingStub> {
    private FullInventoryListBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FullInventoryListBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FullInventoryListBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.proto.trafficStatistics.FullInventoryListResponse> subscribe(
        com.proto.trafficStatistics.QueryFullInventoryList request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FullInventoryList.
   */
  public static final class FullInventoryListFutureStub
      extends io.grpc.stub.AbstractFutureStub<FullInventoryListFutureStub> {
    private FullInventoryListFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FullInventoryListFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FullInventoryListFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SUBSCRIBE = 0;

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
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((com.proto.trafficStatistics.QueryFullInventoryList) request,
              (io.grpc.stub.StreamObserver<com.proto.trafficStatistics.FullInventoryListResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSubscribeMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.proto.trafficStatistics.QueryFullInventoryList,
              com.proto.trafficStatistics.FullInventoryListResponse>(
                service, METHODID_SUBSCRIBE)))
        .build();
  }

  private static abstract class FullInventoryListBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FullInventoryListBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.trafficStatistics.TrafficStatistics.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FullInventoryList");
    }
  }

  private static final class FullInventoryListFileDescriptorSupplier
      extends FullInventoryListBaseDescriptorSupplier {
    FullInventoryListFileDescriptorSupplier() {}
  }

  private static final class FullInventoryListMethodDescriptorSupplier
      extends FullInventoryListBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FullInventoryListMethodDescriptorSupplier(String methodName) {
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
      synchronized (FullInventoryListGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FullInventoryListFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
