package trafficStatistics.client;

import com.proto.trafficStatistics.StatsRequest;
import com.proto.trafficStatistics.subscribeServiceGrpc;
import com.proto.trafficStatistics.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class clientSubscribe {
    /**
     * @param channel
     *  This is the main function that uses the channel handle. Based on user's input, a switch case is implemented to process the request.
     *  For the time being only two services are offered. Service 1 and 2. Rest of the service will lead to invalid service message to the user.
     *  The first service will initiate gRPC request to the server and server responds back with the response , followed by the connection is closed.
     *  The second service will stream the system health via gRPC request/response.
     *
     *
     */
    public static void SubscribeRequest(ManagedChannel channel)  {
        System.out.println("Enter from the following topics to subscribe: \n" +
                "1) Stream Traffic statistics: \n" +
                "2) Stream System Health:  \n" +
                "3) Stream Common Friends in FB Acct: \n" +
                "4) Stream Weather Information: \n" +
                "5) Stream Flight Status: \n" +
                "Enter your choice: ");
        Scanner inp = new Scanner(System.in);
        int option = inp.nextInt();
        /**
         *  The SaveLocation variable ensures all the file writes are happening at the same path without any error.
         *  The switch case below ensures a file is created with proper permission and the received information from the gRPC server is written to the file.
         *  Each case implements a separate service. In case the file write is not successful, then the appropriate exception is raised.
         */
        String SaveLocation = "src/main/java/trafficStatistics/client/";
        switch (option) {
            case 1:
            System.out.println("#### Subscription Topic is: r1/openconfig/interfaces/interface/state" );
            subscribeServiceGrpc.subscribeServiceBlockingStub stub1 = subscribeServiceGrpc.newBlockingStub(channel);
            stub1.subscribe(StatsRequest.newBuilder().build()).forEachRemaining(statsResponse -> {
                try {
                    File create = new File(SaveLocation + "Topic1");
                    create.setWritable(true);
                    FileWriter SaveFile = new FileWriter("src/main/java/trafficStatistics/server/Topic1.txt");
                    SaveFile.write(statsResponse.getResult());
                    SaveFile.close();
                } catch (IOException e) {
//                    e.printStackTrace();
                    System.out.println("");
                    System.out.println("File write failed, if executing as JAR file this is expected.");
                    System.out.println("");
                }
                System.out.println(statsResponse.getResult());
            });
            break;
            case 2:
                System.out.println("#### Subscription topic is : System Health");
            SysHealthServiceGrpc.SysHealthServiceBlockingStub stub2 = SysHealthServiceGrpc.newBlockingStub(channel);
            stub2.subscribe(SysHealthRequest.newBuilder().build()).forEachRemaining(SysHealthResponse -> {
                try {
                    File create = new File(SaveLocation + "Topic2");
                    create.setWritable(true);
                    FileWriter SaveFile = new FileWriter("src/main/java/trafficStatistics/server/Topic2.txt");
                    SaveFile.write(SysHealthResponse.getResult());
                    SaveFile.close();
                } catch (IOException e) {
//                    e.printStackTrace();
                    System.out.println("");
                    System.out.println("File write failed, if executing as JAR file this is expected.");
                    System.out.println("");
                }
                System.out.println(SysHealthResponse.getResult());
            });
            break;
            case 4:
                clientCapabilityRequest myReq = new clientCapabilityRequest();
                myReq.display();
                myReq.displayVersion(); //Inheritance
            break;
            default:
                try {
                    throw new InvalidOption("Invalid Option Selected");
                }
                catch (InvalidOption e) {
                    System.out.println(e.getMessage());
                }
        }
    }

    /**
     * This is a user defined exception. If the user enters an invalid input, then this exception is called and the message is sent back to the user.
     *
     * pre-condition : invalid input by the user.
     * post-condition : An exception is generated and error back to the user indication that an invalid option was used.
     */
    static class InvalidOption extends Exception {
        public InvalidOption(String s) {
            super(s);
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
    public static void main(String[] args)  {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost",50051)
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
