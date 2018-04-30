package de.fhws.fiw.pvs.assignment05;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: assignment05.proto")
public final class PersonManagementServiceGrpc {

  private PersonManagementServiceGrpc() {}

  public static final String SERVICE_NAME = "de.fhws.fiw.pvs.grpc.PersonManagementService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<de.fhws.fiw.pvs.assignment05.PersonManagement.Person,
      de.fhws.fiw.pvs.assignment05.PersonManagement.CreateReply> METHOD_CREATE_PERSON =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "de.fhws.fiw.pvs.grpc.PersonManagementService", "createPerson"),
          io.grpc.protobuf.ProtoUtils.marshaller(de.fhws.fiw.pvs.assignment05.PersonManagement.Person.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(de.fhws.fiw.pvs.assignment05.PersonManagement.CreateReply.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<de.fhws.fiw.pvs.assignment05.PersonManagement.SearchRequest,
      de.fhws.fiw.pvs.assignment05.PersonManagement.SearchResponse> METHOD_SEARCH =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "de.fhws.fiw.pvs.grpc.PersonManagementService", "search"),
          io.grpc.protobuf.ProtoUtils.marshaller(de.fhws.fiw.pvs.assignment05.PersonManagement.SearchRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(de.fhws.fiw.pvs.assignment05.PersonManagement.SearchResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<de.fhws.fiw.pvs.assignment05.PersonManagement.SearchRequest,
      de.fhws.fiw.pvs.assignment05.PersonManagement.SearchResponse> METHOD_LIST_ALL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "de.fhws.fiw.pvs.grpc.PersonManagementService", "listAll"),
          io.grpc.protobuf.ProtoUtils.marshaller(de.fhws.fiw.pvs.assignment05.PersonManagement.SearchRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(de.fhws.fiw.pvs.assignment05.PersonManagement.SearchResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PersonManagementServiceStub newStub(io.grpc.Channel channel) {
    return new PersonManagementServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PersonManagementServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PersonManagementServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static PersonManagementServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PersonManagementServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PersonManagementServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createPerson(de.fhws.fiw.pvs.assignment05.PersonManagement.Person request,
        io.grpc.stub.StreamObserver<de.fhws.fiw.pvs.assignment05.PersonManagement.CreateReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_PERSON, responseObserver);
    }

    /**
     */
    public void search(de.fhws.fiw.pvs.assignment05.PersonManagement.SearchRequest request,
        io.grpc.stub.StreamObserver<de.fhws.fiw.pvs.assignment05.PersonManagement.SearchResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEARCH, responseObserver);
    }

    /**
     */
    public void listAll(de.fhws.fiw.pvs.assignment05.PersonManagement.SearchRequest request,
        io.grpc.stub.StreamObserver<de.fhws.fiw.pvs.assignment05.PersonManagement.SearchResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_ALL, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE_PERSON,
            asyncUnaryCall(
              new MethodHandlers<
                de.fhws.fiw.pvs.assignment05.PersonManagement.Person,
                de.fhws.fiw.pvs.assignment05.PersonManagement.CreateReply>(
                  this, METHODID_CREATE_PERSON)))
          .addMethod(
            METHOD_SEARCH,
            asyncUnaryCall(
              new MethodHandlers<
                de.fhws.fiw.pvs.assignment05.PersonManagement.SearchRequest,
                de.fhws.fiw.pvs.assignment05.PersonManagement.SearchResponse>(
                  this, METHODID_SEARCH)))
          .addMethod(
            METHOD_LIST_ALL,
            asyncUnaryCall(
              new MethodHandlers<
                de.fhws.fiw.pvs.assignment05.PersonManagement.SearchRequest,
                de.fhws.fiw.pvs.assignment05.PersonManagement.SearchResponse>(
                  this, METHODID_LIST_ALL)))
          .build();
    }
  }

  /**
   */
  public static final class PersonManagementServiceStub extends io.grpc.stub.AbstractStub<PersonManagementServiceStub> {
    private PersonManagementServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonManagementServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonManagementServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonManagementServiceStub(channel, callOptions);
    }

    /**
     */
    public void createPerson(de.fhws.fiw.pvs.assignment05.PersonManagement.Person request,
        io.grpc.stub.StreamObserver<de.fhws.fiw.pvs.assignment05.PersonManagement.CreateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_PERSON, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void search(de.fhws.fiw.pvs.assignment05.PersonManagement.SearchRequest request,
        io.grpc.stub.StreamObserver<de.fhws.fiw.pvs.assignment05.PersonManagement.SearchResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEARCH, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listAll(de.fhws.fiw.pvs.assignment05.PersonManagement.SearchRequest request,
        io.grpc.stub.StreamObserver<de.fhws.fiw.pvs.assignment05.PersonManagement.SearchResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_ALL, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PersonManagementServiceBlockingStub extends io.grpc.stub.AbstractStub<PersonManagementServiceBlockingStub> {
    private PersonManagementServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonManagementServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonManagementServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonManagementServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public de.fhws.fiw.pvs.assignment05.PersonManagement.CreateReply createPerson(de.fhws.fiw.pvs.assignment05.PersonManagement.Person request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_PERSON, getCallOptions(), request);
    }

    /**
     */
    public de.fhws.fiw.pvs.assignment05.PersonManagement.SearchResponse search(de.fhws.fiw.pvs.assignment05.PersonManagement.SearchRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEARCH, getCallOptions(), request);
    }

    /**
     */
    public de.fhws.fiw.pvs.assignment05.PersonManagement.SearchResponse listAll(de.fhws.fiw.pvs.assignment05.PersonManagement.SearchRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIST_ALL, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PersonManagementServiceFutureStub extends io.grpc.stub.AbstractStub<PersonManagementServiceFutureStub> {
    private PersonManagementServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonManagementServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonManagementServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonManagementServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.fhws.fiw.pvs.assignment05.PersonManagement.CreateReply> createPerson(
        de.fhws.fiw.pvs.assignment05.PersonManagement.Person request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_PERSON, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.fhws.fiw.pvs.assignment05.PersonManagement.SearchResponse> search(
        de.fhws.fiw.pvs.assignment05.PersonManagement.SearchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEARCH, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.fhws.fiw.pvs.assignment05.PersonManagement.SearchResponse> listAll(
        de.fhws.fiw.pvs.assignment05.PersonManagement.SearchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_ALL, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PERSON = 0;
  private static final int METHODID_SEARCH = 1;
  private static final int METHODID_LIST_ALL = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PersonManagementServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PersonManagementServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_PERSON:
          serviceImpl.createPerson((de.fhws.fiw.pvs.assignment05.PersonManagement.Person) request,
              (io.grpc.stub.StreamObserver<de.fhws.fiw.pvs.assignment05.PersonManagement.CreateReply>) responseObserver);
          break;
        case METHODID_SEARCH:
          serviceImpl.search((de.fhws.fiw.pvs.assignment05.PersonManagement.SearchRequest) request,
              (io.grpc.stub.StreamObserver<de.fhws.fiw.pvs.assignment05.PersonManagement.SearchResponse>) responseObserver);
          break;
        case METHODID_LIST_ALL:
          serviceImpl.listAll((de.fhws.fiw.pvs.assignment05.PersonManagement.SearchRequest) request,
              (io.grpc.stub.StreamObserver<de.fhws.fiw.pvs.assignment05.PersonManagement.SearchResponse>) responseObserver);
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

  private static final class PersonManagementServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return de.fhws.fiw.pvs.assignment05.PersonManagement.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PersonManagementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PersonManagementServiceDescriptorSupplier())
              .addMethod(METHOD_CREATE_PERSON)
              .addMethod(METHOD_SEARCH)
              .addMethod(METHOD_LIST_ALL)
              .build();
        }
      }
    }
    return result;
  }
}
