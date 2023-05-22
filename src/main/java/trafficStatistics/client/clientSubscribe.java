package trafficStatistics.client;

import com.proto.trafficStatistics.StatsRequest;
import com.proto.trafficStatistics.subscribeServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.Scanner;

public class clientSubscribe {
    /**
     * @param channel
     *  This is the main function that uses the channel handle. Based on user's input, a switch case is implemented to process the request.
     *  For the time being only two services are offered. Service 1 and 4. Rest of the service will lead to invalid service message to the user.
     *  The first service will initiate gRPC request to the server and server responds back with the response , followed by the connection is closed.
     *
     *  The fourth service is a capability service that will be implemented in the future via gRPC request/response. For now, it is local to the client.
     *
     *
     */
    public static void SubscribeRequest(ManagedChannel channel) {
        System.out.println("Enter from the following topics to subscribe: \n" +
                "1) Traffic statistics: \n" +
                "2) Check Server Health: \n" +
                "3) Check Server capability \n" +
                "4) Check Active subscription \n" +
                "Enter your choice: ");
        Scanner inp = new Scanner(System.in);
        int option = inp.nextInt();
        switch (option) {
            case 1:
            System.out.println("Subscription Topic is: r1/openconfig/interfaces/interface/state" );
            subscribeServiceGrpc.subscribeServiceBlockingStub stub = subscribeServiceGrpc.newBlockingStub(channel);
            stub.subscribe(StatsRequest.newBuilder().build()).forEachRemaining(statsResponse -> {
                System.out.println(statsResponse.getResult());
            });
            break;
            case 4:
                clientCapabilityRequest myReq = new clientCapabilityRequest();
                myReq.display();
                myReq.displayVersion(); //Inheritance
            break;
            default:
                System.out.println("Service invalid");
        }
    }

    /**
     * Here the abstract class is clientDisplay() with an abstract method. This abstract class will be extended by  other methods that implement various services.
     * Every service will need a common method and hence it is required to make use of an abstract class that has common set of methods for all services.
     */
    static abstract class clientDisplay { //Abstract Class
        public void displayVersion() {
            System.out.println("Client is running gRPC version 1.34");
        }
    }
    static class clientCapabilityRequest extends clientDisplay {
        public void display() {
            System.out.println("Server supports streaming stock information, traffic stats and more!!!!");
        }
    }
    static class ServerAllTopics {
        public void displayAll() {
            System.out.println("Printing all topic schemas supported by Server");
        }
        public void mostSubscribedTopic() {
            System.out.println("The topic most subscribed by the client");
        }
    }
    static class ServerActiveTopics extends ServerAllTopics {
        public void displayActiveTopics() {
            System.out.println("Printing only topics that are streaming currently.");
        }
        public void mostSubscribedTopic() {
            System.out.println("The topic having the longest run time");
        }
    }
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost",50052)
                .usePlaintext()
                .build();
        SubscribeRequest(channel);

        /** Explicit DownCasting
         * Here the child class serverActiveTopics extends from serverAllTopics, however downcasting was required to ensure the child class’s object was able to access the method of the parent class for the method displayAll().
         * During further implementation of this project, more downcasting may be required to avoid code duplications and to ensure the child class can access the methods of the parent class.
         */

        System.out.println("### Implementing Down Casting");
        ServerAllTopics allTopic = new ServerActiveTopics();
        ServerActiveTopics activeTopic = (ServerActiveTopics) allTopic;
        activeTopic.displayAll();

        /** Polymorphism
         * The two classes ServerAllTopics and ServerActiveTopics have a common method but different forms/implementation.
         * For the ServerActiveTopic it's important to get show the topic that has the longest uptime. This telemetry information is important to make decisions later on.
         * While, the ServerAllTopic enables which topic is the most subscribed by the client in other words, which topic was the most interested ones among the many topics involved.
         */

        ServerAllTopics mostSubscribed = new ServerAllTopics();
        ServerAllTopics longestRunTime = new ServerActiveTopics();

        System.out.println("### Polymorphic - > Many Forms");
        mostSubscribed.mostSubscribedTopic();
        longestRunTime.mostSubscribedTopic();

        System.out.println("Shutting Down");
        channel.shutdown();
    }
}
