package trafficStatistics.client;

import com.proto.trafficStatistics.StatsRequest;
import com.proto.trafficStatistics.StatsResponse;
import com.proto.trafficStatistics.subscribeServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.Scanner;

public class clientSubscribe {
    private static void SubscribeRequest(ManagedChannel channel) {
        System.out.println("Enter from the following topics to subscribe: \n" +
                "1) Traffic statistics: \n" +
                "2) Health of the System: \n" +
                "3) Uptime of the System \n" +
                 "Enter your choice: ");
        Scanner inp = new Scanner(System.in);
        int option = inp.nextInt();
        switch (option) {
            case 1:
            System.out.println("Subscription Topic is: r1/openconfig/interfaces/interface/state" );
            subscribeServiceGrpc.subscribeServiceBlockingStub stub = subscribeServiceGrpc.newBlockingStub(channel);
    //        stub.subscribe(StatsRequest.newBuilder().setSubscriptionPath("").build()).forEachRemaining(statsResponse -> {
    //            System.out.println(statsResponse.getResult());
    //        });
            stub.subscribe(StatsRequest.newBuilder().build()).forEachRemaining(statsResponse -> {
                System.out.println(statsResponse.getResult());
            });
            break;
            default:
                System.out.println("Service invalid");
        }
    }
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost",50052)
                .usePlaintext()
                .build();
        SubscribeRequest(channel);
        System.out.println("Shutting Down");
        channel.shutdown();
    }
}
