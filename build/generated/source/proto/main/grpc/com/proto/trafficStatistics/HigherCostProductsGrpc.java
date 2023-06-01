package com.proto.trafficStatistics;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: trafficStatistics/trafficStatistics.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HigherCostProductsGrpc {

  private HigherCostProductsGrpc() {}

  public static final String SERVICE_NAME = "trafficStatistics.HigherCostProducts";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.trafficStatistics.QueryHigherCostProducts,
      com.proto.trafficStatistics.HigherCostProductsResponse> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribe",
      requestType = com.proto.trafficStatistics.QueryHigherCostProducts.class,
      responseType = com.proto.trafficStatistics.HigherCostProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.trafficStatistics.QueryHigherCostProducts,
      com.proto.trafficStatistics.HigherCostProductsResponse> getSubscribeMethod() {
    io.grpc.MethodDescriptor<com.proto.trafficStatistics.QueryHigherCostProducts, com.proto.trafficStatistics.HigherCostProductsResponse> getSubscribeMethod;
    if ((getSubscribeMethod = HigherCostProductsGrpc.getSubscribeMethod) == null) {
      synchronized (HigherCostProductsGrpc.class) {
        if ((getSubscribeMethod = HigherCostProductsGrpc.getSubscribeMethod) == null) {
          HigherCostProductsGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<com.proto.trafficStatistics.QueryHigherCostProducts, com.proto.trafficStatistics.HigherCostProductsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.trafficStatistics.QueryHigherCostProducts.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.trafficStatistics.HigherCostProductsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HigherCostProductsMethodDescriptorSupplier("subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HigherCostProductsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HigherCostProductsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HigherCostProductsStub>() {
        @java.lang.Override
        public HigherCostProductsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HigherCostProductsStub(channel, callOptions);
        }
      };
    return HigherCostProductsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HigherCostProductsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HigherCostProductsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HigherCostProductsBlockingStub>() {
        @java.lang.Override
        public HigherCostProductsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HigherCostProductsBlockingStub(channel, callOptions);
        }
      };
    return HigherCostProductsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HigherCostProductsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HigherCostProductsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HigherCostProductsFutureStub>() {
        @java.lang.Override
        public HigherCostProductsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HigherCostProductsFutureStub(channel, callOptions);
        }
      };
    return HigherCostProductsFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void subscribe(com.proto.trafficStatistics.QueryHigherCostProducts request,
        io.grpc.stub.StreamObserver<com.proto.trafficStatistics.HigherCostProductsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service HigherCostProducts.
   */
  public static abstract class HigherCostProductsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return HigherCostProductsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service HigherCostProducts.
   */
  public static final class HigherCostProductsStub
      extends io.grpc.stub.AbstractAsyncStub<HigherCostProductsStub> {
    private HigherCostProductsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HigherCostProductsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HigherCostProductsStub(channel, callOptions);
    }

    /**
     */
    public void subscribe(com.proto.trafficStatistics.QueryHigherCostProducts request,
        io.grpc.stub.StreamObserver<com.proto.trafficStatistics.HigherCostProductsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service HigherCostProducts.
   */
  public static final class HigherCostProductsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HigherCostProductsBlockingStub> {
    private HigherCostProductsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HigherCostProductsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HigherCostProductsBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.proto.trafficStatistics.HigherCostProductsResponse> subscribe(
        com.proto.trafficStatistics.QueryHigherCostProducts request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service HigherCostProducts.
   */
  public static final class HigherCostProductsFutureStub
      extends io.grpc.stub.AbstractFutureStub<HigherCostProductsFutureStub> {
    private HigherCostProductsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HigherCostProductsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HigherCostProductsFutureStub(channel, callOptions);
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
          serviceImpl.subscribe((com.proto.trafficStatistics.QueryHigherCostProducts) request,
              (io.grpc.stub.StreamObserver<com.proto.trafficStatistics.HigherCostProductsResponse>) responseObserver);
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
              com.proto.trafficStatistics.QueryHigherCostProducts,
              com.proto.trafficStatistics.HigherCostProductsResponse>(
                service, METHODID_SUBSCRIBE)))
        .build();
  }

  private static abstract class HigherCostProductsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HigherCostProductsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.trafficStatistics.TrafficStatistics.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HigherCostProducts");
    }
  }

  private static final class HigherCostProductsFileDescriptorSupplier
      extends HigherCostProductsBaseDescriptorSupplier {
    HigherCostProductsFileDescriptorSupplier() {}
  }

  private static final class HigherCostProductsMethodDescriptorSupplier
      extends HigherCostProductsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HigherCostProductsMethodDescriptorSupplier(String methodName) {
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
      synchronized (HigherCostProductsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HigherCostProductsFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
