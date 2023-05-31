package com.proto.trafficStatistics;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: trafficStatistics/trafficStatistics.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProductAvailabilityGrpc {

  private ProductAvailabilityGrpc() {}

  public static final String SERVICE_NAME = "trafficStatistics.ProductAvailability";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.trafficStatistics.QueryProductAvailability,
      com.proto.trafficStatistics.ProductAvailabilityResponse> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribe",
      requestType = com.proto.trafficStatistics.QueryProductAvailability.class,
      responseType = com.proto.trafficStatistics.ProductAvailabilityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.trafficStatistics.QueryProductAvailability,
      com.proto.trafficStatistics.ProductAvailabilityResponse> getSubscribeMethod() {
    io.grpc.MethodDescriptor<com.proto.trafficStatistics.QueryProductAvailability, com.proto.trafficStatistics.ProductAvailabilityResponse> getSubscribeMethod;
    if ((getSubscribeMethod = ProductAvailabilityGrpc.getSubscribeMethod) == null) {
      synchronized (ProductAvailabilityGrpc.class) {
        if ((getSubscribeMethod = ProductAvailabilityGrpc.getSubscribeMethod) == null) {
          ProductAvailabilityGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<com.proto.trafficStatistics.QueryProductAvailability, com.proto.trafficStatistics.ProductAvailabilityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.trafficStatistics.QueryProductAvailability.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.trafficStatistics.ProductAvailabilityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductAvailabilityMethodDescriptorSupplier("subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductAvailabilityStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductAvailabilityStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductAvailabilityStub>() {
        @java.lang.Override
        public ProductAvailabilityStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductAvailabilityStub(channel, callOptions);
        }
      };
    return ProductAvailabilityStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductAvailabilityBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductAvailabilityBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductAvailabilityBlockingStub>() {
        @java.lang.Override
        public ProductAvailabilityBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductAvailabilityBlockingStub(channel, callOptions);
        }
      };
    return ProductAvailabilityBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductAvailabilityFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductAvailabilityFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductAvailabilityFutureStub>() {
        @java.lang.Override
        public ProductAvailabilityFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductAvailabilityFutureStub(channel, callOptions);
        }
      };
    return ProductAvailabilityFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void subscribe(com.proto.trafficStatistics.QueryProductAvailability request,
        io.grpc.stub.StreamObserver<com.proto.trafficStatistics.ProductAvailabilityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProductAvailability.
   */
  public static abstract class ProductAvailabilityImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ProductAvailabilityGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProductAvailability.
   */
  public static final class ProductAvailabilityStub
      extends io.grpc.stub.AbstractAsyncStub<ProductAvailabilityStub> {
    private ProductAvailabilityStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductAvailabilityStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductAvailabilityStub(channel, callOptions);
    }

    /**
     */
    public void subscribe(com.proto.trafficStatistics.QueryProductAvailability request,
        io.grpc.stub.StreamObserver<com.proto.trafficStatistics.ProductAvailabilityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProductAvailability.
   */
  public static final class ProductAvailabilityBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProductAvailabilityBlockingStub> {
    private ProductAvailabilityBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductAvailabilityBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductAvailabilityBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.proto.trafficStatistics.ProductAvailabilityResponse> subscribe(
        com.proto.trafficStatistics.QueryProductAvailability request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProductAvailability.
   */
  public static final class ProductAvailabilityFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProductAvailabilityFutureStub> {
    private ProductAvailabilityFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductAvailabilityFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductAvailabilityFutureStub(channel, callOptions);
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
          serviceImpl.subscribe((com.proto.trafficStatistics.QueryProductAvailability) request,
              (io.grpc.stub.StreamObserver<com.proto.trafficStatistics.ProductAvailabilityResponse>) responseObserver);
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
              com.proto.trafficStatistics.QueryProductAvailability,
              com.proto.trafficStatistics.ProductAvailabilityResponse>(
                service, METHODID_SUBSCRIBE)))
        .build();
  }

  private static abstract class ProductAvailabilityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductAvailabilityBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.trafficStatistics.TrafficStatistics.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductAvailability");
    }
  }

  private static final class ProductAvailabilityFileDescriptorSupplier
      extends ProductAvailabilityBaseDescriptorSupplier {
    ProductAvailabilityFileDescriptorSupplier() {}
  }

  private static final class ProductAvailabilityMethodDescriptorSupplier
      extends ProductAvailabilityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductAvailabilityMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProductAvailabilityGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductAvailabilityFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
