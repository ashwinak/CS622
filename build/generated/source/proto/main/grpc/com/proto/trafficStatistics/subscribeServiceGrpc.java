package com.proto.trafficStatistics;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: trafficStatistics/trafficStatistics.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class subscribeServiceGrpc {

  private subscribeServiceGrpc() {}

  public static final String SERVICE_NAME = "trafficStatistics.subscribeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.trafficStatistics.StatsRequest,
      com.proto.trafficStatistics.StatsResponse> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribe",
      requestType = com.proto.trafficStatistics.StatsRequest.class,
      responseType = com.proto.trafficStatistics.StatsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.trafficStatistics.StatsRequest,
      com.proto.trafficStatistics.StatsResponse> getSubscribeMethod() {
    io.grpc.MethodDescriptor<com.proto.trafficStatistics.StatsRequest, com.proto.trafficStatistics.StatsResponse> getSubscribeMethod;
    if ((getSubscribeMethod = subscribeServiceGrpc.getSubscribeMethod) == null) {
      synchronized (subscribeServiceGrpc.class) {
        if ((getSubscribeMethod = subscribeServiceGrpc.getSubscribeMethod) == null) {
          subscribeServiceGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<com.proto.trafficStatistics.StatsRequest, com.proto.trafficStatistics.StatsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.trafficStatistics.StatsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.trafficStatistics.StatsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new subscribeServiceMethodDescriptorSupplier("subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static subscribeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<subscribeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<subscribeServiceStub>() {
        @java.lang.Override
        public subscribeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new subscribeServiceStub(channel, callOptions);
        }
      };
    return subscribeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static subscribeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<subscribeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<subscribeServiceBlockingStub>() {
        @java.lang.Override
        public subscribeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new subscribeServiceBlockingStub(channel, callOptions);
        }
      };
    return subscribeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static subscribeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<subscribeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<subscribeServiceFutureStub>() {
        @java.lang.Override
        public subscribeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new subscribeServiceFutureStub(channel, callOptions);
        }
      };
    return subscribeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void subscribe(com.proto.trafficStatistics.StatsRequest request,
        io.grpc.stub.StreamObserver<com.proto.trafficStatistics.StatsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service subscribeService.
   */
  public static abstract class subscribeServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return subscribeServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service subscribeService.
   */
  public static final class subscribeServiceStub
      extends io.grpc.stub.AbstractAsyncStub<subscribeServiceStub> {
    private subscribeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected subscribeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new subscribeServiceStub(channel, callOptions);
    }

    /**
     */
    public void subscribe(com.proto.trafficStatistics.StatsRequest request,
        io.grpc.stub.StreamObserver<com.proto.trafficStatistics.StatsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service subscribeService.
   */
  public static final class subscribeServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<subscribeServiceBlockingStub> {
    private subscribeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected subscribeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new subscribeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.proto.trafficStatistics.StatsResponse> subscribe(
        com.proto.trafficStatistics.StatsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service subscribeService.
   */
  public static final class subscribeServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<subscribeServiceFutureStub> {
    private subscribeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected subscribeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new subscribeServiceFutureStub(channel, callOptions);
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
          serviceImpl.subscribe((com.proto.trafficStatistics.StatsRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.trafficStatistics.StatsResponse>) responseObserver);
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
              com.proto.trafficStatistics.StatsRequest,
              com.proto.trafficStatistics.StatsResponse>(
                service, METHODID_SUBSCRIBE)))
        .build();
  }

  private static abstract class subscribeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    subscribeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.trafficStatistics.TrafficStatistics.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("subscribeService");
    }
  }

  private static final class subscribeServiceFileDescriptorSupplier
      extends subscribeServiceBaseDescriptorSupplier {
    subscribeServiceFileDescriptorSupplier() {}
  }

  private static final class subscribeServiceMethodDescriptorSupplier
      extends subscribeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    subscribeServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (subscribeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new subscribeServiceFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
