// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: greeting/greeting.proto

package com.proto.greeting;

public final class Greeting {
  private Greeting() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_greeting_GreetingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_greeting_GreetingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_greeting_GreetingResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_greeting_GreetingResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\027greeting/greeting.proto\022\010greeting\"%\n\017G" +
      "reetingRequest\022\022\n\nfirst_name\030\001 \001(\t\"\"\n\020Gr" +
      "eetingResponse\022\016\n\006result\030\001 \001(\t2\234\001\n\017Greet" +
      "ingService\022>\n\005greet\022\031.greeting.GreetingR" +
      "equest\032\032.greeting.GreetingResponse\022I\n\016gr" +
      "eetManyTimes\022\031.greeting.GreetingRequest\032" +
      "\032.greeting.GreetingResponse0\001B\026\n\022com.pro" +
      "to.greetingP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_greeting_GreetingRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_greeting_GreetingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_greeting_GreetingRequest_descriptor,
        new java.lang.String[] { "FirstName", });
    internal_static_greeting_GreetingResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_greeting_GreetingResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_greeting_GreetingResponse_descriptor,
        new java.lang.String[] { "Result", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
