package trafficStatistics.server;

import com.proto.trafficStatistics.StatsRequest;
import com.proto.trafficStatistics.StatsResponse;
import com.proto.trafficStatistics.subscribeServiceGrpc;
import io.grpc.stub.StreamObserver;


public class trafficServerImpl extends subscribeServiceGrpc.subscribeServiceImplBase{
    @Override
    public void subscribe (StatsRequest request, StreamObserver<StatsResponse> responseObserver) {
//        StatsResponse response = StatsResponse.newBuilder().setResult("/interfaces/interface/state/r1/aggregate/2tbps " + request.getSubscriptionPath()).build();

        for (int i =0; i <10; i++) {
            StatsResponse response = StatsResponse.newBuilder().setResult("openconfig/interfaces/interface/state/r1/aggregate/" + i +"tbps " + request.getSubscriptionPath()).build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }
}
