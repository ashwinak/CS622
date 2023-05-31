package com.proto.trafficStatistics;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: trafficStatistics/trafficStatistics.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProductCostAndLeadTimeGrpc {

  private ProductCostAndLeadTimeGrpc() {}

  public static final String SERVICE_NAME = "trafficStatistics.ProductCostAndLeadTime";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.trafficStatistics.QueryProductCostAndLeadTime,
      com.proto.trafficStatistics.ProductCostAndLeadTimeResponse> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribe",
      requestType = com.proto.trafficStatistics.QueryProductCostAndLeadTime.class,
      responseType = com.proto.trafficStatistics.ProductCostAndLeadTimeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.trafficStatistics.QueryProductCostAndLeadTime,
      com.proto.trafficStatistics.ProductCostAndLeadTimeResponse> getSubscribeMethod() {
    io.grpc.MethodDescriptor<com.proto.trafficStatistics.QueryProductCostAndLeadTime, com.proto.trafficStatistics.ProductCostAndLeadTimeResponse> getSubscribeMethod;
    if ((getSubscribeMethod = ProductCostAndLeadTimeGrpc.getSubscribeMethod) == null) {
      synchronized (ProductCostAndLeadTimeGrpc.class) {
        if ((getSubscribeMethod = ProductCostAndLeadTimeGrpc.getSubscribeMethod) == null) {
          ProductCostAndLeadTimeGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<com.proto.trafficStatistics.QueryProductCostAndLeadTime, com.proto.trafficStatistics.ProductCostAndLeadTimeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.trafficStatistics.QueryProductCostAndLeadTime.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.trafficStatistics.ProductCostAndLeadTimeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductCostAndLeadTimeMethodDescriptorSupplier("subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductCostAndLeadTimeStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductCostAndLeadTimeStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductCostAndLeadTimeStub>() {
        @java.lang.Override
        public ProductCostAndLeadTimeStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductCostAndLeadTimeStub(channel, callOptions);
        }
      };
    return ProductCostAndLeadTimeStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductCostAndLeadTimeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductCostAndLeadTimeBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductCostAndLeadTimeBlockingStub>() {
        @java.lang.Override
        public ProductCostAndLeadTimeBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductCostAndLeadTimeBlockingStub(channel, callOptions);
        }
      };
    return ProductCostAndLeadTimeBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductCostAndLeadTimeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductCostAndLeadTimeFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductCostAndLeadTimeFutureStub>() {
        @java.lang.Override
        public ProductCostAndLeadTimeFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductCostAndLeadTimeFutureStub(channel, callOptions);
        }
      };
    return ProductCostAndLeadTimeFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void subscribe(com.proto.trafficStatistics.QueryProductCostAndLeadTime request,
        io.grpc.stub.StreamObserver<com.proto.trafficStatistics.ProductCostAndLeadTimeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProductCostAndLeadTime.
   */
  public static abstract class ProductCostAndLeadTimeImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ProductCostAndLeadTimeGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProductCostAndLeadTime.
   */
  public static final class ProductCostAndLeadTimeStub
      extends io.grpc.stub.AbstractAsyncStub<ProductCostAndLeadTimeStub> {
    private ProductCostAndLeadTimeStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductCostAndLeadTimeStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductCostAndLeadTimeStub(channel, callOptions);
    }

    /**
     */
    public void subscribe(com.proto.trafficStatistics.QueryProductCostAndLeadTime request,
        io.grpc.stub.StreamObserver<com.proto.trafficStatistics.ProductCostAndLeadTimeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProductCostAndLeadTime.
   */
  public static final class ProductCostAndLeadTimeBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProductCostAndLeadTimeBlockingStub> {
    private ProductCostAndLeadTimeBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductCostAndLeadTimeBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductCostAndLeadTimeBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.proto.trafficStatistics.ProductCostAndLeadTimeResponse> subscribe(
        com.proto.trafficStatistics.QueryProductCostAndLeadTime request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProductCostAndLeadTime.
   */
  public static final class ProductCostAndLeadTimeFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProductCostAndLeadTimeFutureStub> {
    private ProductCostAndLeadTimeFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductCostAndLeadTimeFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductCostAndLeadTimeFutureStub(channel, callOptions);
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
          serviceImpl.subscribe((com.proto.trafficStatistics.QueryProductCostAndLeadTime) request,
              (io.grpc.stub.StreamObserver<com.proto.trafficStatistics.ProductCostAndLeadTimeResponse>) responseObserver);
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
              com.proto.trafficStatistics.QueryProductCostAndLeadTime,
              com.proto.trafficStatistics.ProductCostAndLeadTimeResponse>(
                service, METHODID_SUBSCRIBE)))
        .build();
  }

  private static abstract class ProductCostAndLeadTimeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductCostAndLeadTimeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.trafficStatistics.TrafficStatistics.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductCostAndLeadTime");
    }
  }

  private static final class ProductCostAndLeadTimeFileDescriptorSupplier
      extends ProductCostAndLeadTimeBaseDescriptorSupplier {
    ProductCostAndLeadTimeFileDescriptorSupplier() {}
  }

  private static final class ProductCostAndLeadTimeMethodDescriptorSupplier
      extends ProductCostAndLeadTimeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductCostAndLeadTimeMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProductCostAndLeadTimeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductCostAndLeadTimeFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
