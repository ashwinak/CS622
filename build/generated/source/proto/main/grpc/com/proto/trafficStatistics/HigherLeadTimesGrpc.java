package com.proto.trafficStatistics;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: trafficStatistics/trafficStatistics.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HigherLeadTimesGrpc {

  private HigherLeadTimesGrpc() {}

  public static final String SERVICE_NAME = "trafficStatistics.HigherLeadTimes";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.trafficStatistics.QueryHigherLeadTimes,
      com.proto.trafficStatistics.HigherLeadTimesResponse> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribe",
      requestType = com.proto.trafficStatistics.QueryHigherLeadTimes.class,
      responseType = com.proto.trafficStatistics.HigherLeadTimesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.trafficStatistics.QueryHigherLeadTimes,
      com.proto.trafficStatistics.HigherLeadTimesResponse> getSubscribeMethod() {
    io.grpc.MethodDescriptor<com.proto.trafficStatistics.QueryHigherLeadTimes, com.proto.trafficStatistics.HigherLeadTimesResponse> getSubscribeMethod;
    if ((getSubscribeMethod = HigherLeadTimesGrpc.getSubscribeMethod) == null) {
      synchronized (HigherLeadTimesGrpc.class) {
        if ((getSubscribeMethod = HigherLeadTimesGrpc.getSubscribeMethod) == null) {
          HigherLeadTimesGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<com.proto.trafficStatistics.QueryHigherLeadTimes, com.proto.trafficStatistics.HigherLeadTimesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.trafficStatistics.QueryHigherLeadTimes.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.trafficStatistics.HigherLeadTimesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HigherLeadTimesMethodDescriptorSupplier("subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HigherLeadTimesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HigherLeadTimesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HigherLeadTimesStub>() {
        @java.lang.Override
        public HigherLeadTimesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HigherLeadTimesStub(channel, callOptions);
        }
      };
    return HigherLeadTimesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HigherLeadTimesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HigherLeadTimesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HigherLeadTimesBlockingStub>() {
        @java.lang.Override
        public HigherLeadTimesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HigherLeadTimesBlockingStub(channel, callOptions);
        }
      };
    return HigherLeadTimesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HigherLeadTimesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HigherLeadTimesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HigherLeadTimesFutureStub>() {
        @java.lang.Override
        public HigherLeadTimesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HigherLeadTimesFutureStub(channel, callOptions);
        }
      };
    return HigherLeadTimesFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void subscribe(com.proto.trafficStatistics.QueryHigherLeadTimes request,
        io.grpc.stub.StreamObserver<com.proto.trafficStatistics.HigherLeadTimesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service HigherLeadTimes.
   */
  public static abstract class HigherLeadTimesImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return HigherLeadTimesGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service HigherLeadTimes.
   */
  public static final class HigherLeadTimesStub
      extends io.grpc.stub.AbstractAsyncStub<HigherLeadTimesStub> {
    private HigherLeadTimesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HigherLeadTimesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HigherLeadTimesStub(channel, callOptions);
    }

    /**
     */
    public void subscribe(com.proto.trafficStatistics.QueryHigherLeadTimes request,
        io.grpc.stub.StreamObserver<com.proto.trafficStatistics.HigherLeadTimesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service HigherLeadTimes.
   */
  public static final class HigherLeadTimesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HigherLeadTimesBlockingStub> {
    private HigherLeadTimesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HigherLeadTimesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HigherLeadTimesBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.proto.trafficStatistics.HigherLeadTimesResponse> subscribe(
        com.proto.trafficStatistics.QueryHigherLeadTimes request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service HigherLeadTimes.
   */
  public static final class HigherLeadTimesFutureStub
      extends io.grpc.stub.AbstractFutureStub<HigherLeadTimesFutureStub> {
    private HigherLeadTimesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HigherLeadTimesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HigherLeadTimesFutureStub(channel, callOptions);
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
          serviceImpl.subscribe((com.proto.trafficStatistics.QueryHigherLeadTimes) request,
              (io.grpc.stub.StreamObserver<com.proto.trafficStatistics.HigherLeadTimesResponse>) responseObserver);
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
              com.proto.trafficStatistics.QueryHigherLeadTimes,
              com.proto.trafficStatistics.HigherLeadTimesResponse>(
                service, METHODID_SUBSCRIBE)))
        .build();
  }

  private static abstract class HigherLeadTimesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HigherLeadTimesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.trafficStatistics.TrafficStatistics.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HigherLeadTimes");
    }
  }

  private static final class HigherLeadTimesFileDescriptorSupplier
      extends HigherLeadTimesBaseDescriptorSupplier {
    HigherLeadTimesFileDescriptorSupplier() {}
  }

  private static final class HigherLeadTimesMethodDescriptorSupplier
      extends HigherLeadTimesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HigherLeadTimesMethodDescriptorSupplier(String methodName) {
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
      synchronized (HigherLeadTimesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HigherLeadTimesFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
