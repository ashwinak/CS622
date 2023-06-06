package trafficStatistics.client;

import com.proto.trafficStatistics.StatsRequest;
import com.proto.trafficStatistics.subscribeServiceGrpc;
import com.proto.trafficStatistics.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        while (true) {
            System.out.println("\n");
            System.out.println("########################################################");
            System.out.println("Select topics to subscribe: \n" +
                    "1) QueryTrafficStatistics: \n" +
                    "2) QuerySystemHealth:  \n" +
                    "3) QueryFullInventoryList: \n" +
                    "4) QueryProductAvailability: \n" +
                    "5) QueryHighestLeadTimeAndCost: \n" +
                    "6) QueryProductCostAndLeadTime: \n" +
                    "7) StopSubscription/ShutDown: \n" +
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
                            File create = new File(SaveLocation + "Topic1_TrafficStats.txt");
                            create.setWritable(true);
                            FileWriter SaveFile = new FileWriter(create);
//                            SaveFile.write(statsResponse.getResult());
                            SaveFile.write(Arrays.toString(statsResponse.getResult().split(","))
                                    .replace("["," ")
                                    .replace("{","")
                                    .replace("}",""));
                            SaveFile.close();
                            /**
                             * The following code creates a new object to store the contents received from the server as a binary file.
                             * The binary file is used only for interface statistics and not for rest of the switch cases because the interface
                             * statistics output is expected to be large.
                             */
                            System.out.println("### Writing the response from server to a binary file");
                            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(SaveLocation+ "Topic1_TrafficStats.dat"));
                            file.writeObject(Arrays.toString(statsResponse.getResult().split(","))
                                    .replace("["," ")
                                    .replace("{","")
                                    .replace("}",""));
                            /**
                             * The following code reads the stored binary file that was previously created.
                             *
                             */
                            System.out.println("Reading from the binary file..");
                            System.out.println(" ");
                            ObjectInputStream fileRead = new ObjectInputStream(new FileInputStream(SaveLocation + "Topic1_TrafficStats.dat"));
                            Stream<String> TrafficStatStream = Stream.of(fileRead.readObject().toString());
                            TrafficStatStream.forEach(s -> System.out.printf("%s%n",s));

                        } catch (IOException e) {
                            //e.printStackTrace();
                            System.out.println("");
                            System.out.println("File write failed, if executing as JAR file this is expected.");
                            System.out.println("");
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }

                        ArrayList pPrint= new ArrayList(Arrays.asList(statsResponse.getResult().split(",")));
                        for(int i=0;i<pPrint.size();i++)
                        {
                            System.out.println(pPrint.get(i).toString()
                                    .replace("["," ")
                                    .replace ("]"," ")
                                    .replace("{","")
                                    .replace("}",""));
                        }
                    });
                    break;
                case 2:
                    System.out.println("#### Subscription topic is : System Health");
                    SysHealthServiceGrpc.SysHealthServiceBlockingStub stub2 = SysHealthServiceGrpc.newBlockingStub(channel);
                    stub2.subscribe(SysHealthRequest.newBuilder().build()).forEachRemaining(SysHealthResponse -> {
                        try {
                            File create = new File(SaveLocation + "Topic2_SystemHealth.txt");
                            create.setWritable(true);
                            FileWriter SaveFile = new FileWriter(create);
                            SaveFile.write(SysHealthResponse.getResult());
                            SaveFile.close();
                        } catch (IOException e) {
                            //                    e.printStackTrace();
                            System.out.println("");
                            System.out.println("File write failed, if executing as JAR file this is expected.");
                            System.out.println("");
                        }
                        ArrayList pPrint= new ArrayList(Arrays.asList(SysHealthResponse.getResult().split(",")));
                        for(int i=0;i<pPrint.size();i++)
                        {
                            System.out.println(pPrint.get(i).toString()
                                    .replace("["," ")
                                    .replace ("]"," ")
                                    .replace("{","")
                                    .replace("}",""));
                        }
//                        System.out.println(SysHealthResponse.getResult());
                    });
                    break;
                case 3:
                    System.out.println("#### Subscription topic is : FullInventoryList");
                    FullInventoryListGrpc.FullInventoryListBlockingStub stub3 = FullInventoryListGrpc.newBlockingStub(channel);
                    stub3.subscribe(QueryFullInventoryList.newBuilder().build()).forEachRemaining(FullInventoryListResponse -> {
                        try {
                            File create = new File(SaveLocation + "Topic3_FullInventoryList.txt");
                            create.setWritable(true);
                            FileWriter SaveFile = new FileWriter(create);
                            SaveFile.write(FullInventoryListResponse.getResult());
                            SaveFile.close();
                        } catch (IOException e) {
                            //                    e.printStackTrace();
                            System.out.println("");
                            System.out.println("File write failed, if executing as JAR file this is expected.");
                            System.out.println("");
                        }
                        ArrayList pPrint= new ArrayList(Arrays.asList(FullInventoryListResponse.getResult().split(",")));
                        for(int i=0;i<pPrint.size();i++)
                        {
                            System.out.println(pPrint.get(i).toString()
                                    .replace("["," ")
                                    .replace ("]"," ")
                                    .replace("{","")
                                    .replace("}",""));
                        }
//                        System.out.println(FullInventoryListResponse.getResult());
                    });
                    break;
                case 4:
                    System.out.println("#### Subscription topic is : ProductAvailability");
                    ProductAvailabilityGrpc.ProductAvailabilityBlockingStub stub4 = ProductAvailabilityGrpc.newBlockingStub(channel);
                    stub4.subscribe(QueryProductAvailability.newBuilder().build()).forEachRemaining(ProductAvailabilityResponse -> {
                        try {
                            File create = new File(SaveLocation + "Topic4_ProductAvailability.txt");
                            create.setWritable(true);
                            FileWriter SaveFile = new FileWriter(create);
                            SaveFile.write(ProductAvailabilityResponse.getResult());
                            SaveFile.close();
                        } catch (IOException e) {
                            //                    e.printStackTrace();
                            System.out.println("");
                            System.out.println("File write failed, if executing as JAR file this is expected.");
                            System.out.println("");
                        }
                        ArrayList pPrint= new ArrayList(Arrays.asList(ProductAvailabilityResponse.getResult().split(",")));
                        for(int i=0;i<pPrint.size();i++)
                        {
                            System.out.println(pPrint.get(i).toString()
                                    .replace("["," ")
                                    .replace ("]"," ")
                                    .replace("{","")
                                    .replace("}",""));
                        }
//                        System.out.println(ProductAvailabilityResponse.getResult());
                    });
                    break;
                case 5:
                    /**
                     *  A generic class will be used for case 5. Here the user can input either an integer or string, a common generic class will execute irrespective
                     *  of the user data type and fetch the results. In this case the user input is expected to be an integer or "200" in days for lead time and
                     *  "150$" as string to stream device information expensive than 150$.
                     *  Pre-condition : User enters an integer or string as input.
                     *
                     *  Post-condition : Based on user's input a common generic class is used to fetch information requested by the user.
                     *
                     */
                    class genericClass <T> {
                        T query;
                        genericClass(T query) {
                            this.query = query;
                        }
                        public T getQuery() {
                            return this.query;
                        }
                    }
                    System.out.println("#### Subscription topic is : ProductCostAndLeadTime");
                    System.out.println("Enter More Specific Queries in ProductCostAndLeadTime Topic: \n" +
                            "5a) List Products with N lead time in Days (200 days) : \n");

                    Scanner inp5a = new Scanner(System.in);
                    int option5a = inp5a.nextInt();
                    switch (option5a) {
                        case 200:
                            HigherLeadTimesGrpc.HigherLeadTimesBlockingStub stub5a = HigherLeadTimesGrpc.newBlockingStub(channel);
                            stub5a.subscribe(QueryHigherLeadTimes.newBuilder().build()).forEachRemaining(HigherLeadTimesResponse -> {
                            try {
                                genericClass<Integer> intQuery = new genericClass<Integer>(option5a);
                                File create = new File(SaveLocation + "Topic5a_HigherLeadTimes.txt");
                                create.setWritable(true);
                                FileWriter SaveFile = new FileWriter(create);
                                SaveFile.write(HigherLeadTimesResponse.getResult());
                                SaveFile.close();
                                System.out.println(intQuery.getQuery());
                            }
                            catch (InputMismatchException | IOException e) {
                                System.out.println(e.getMessage());
                            }
                            System.out.println(HigherLeadTimesResponse.getResult());
                            });
                        break;
                        default:
                            try {
                                throw new InvalidOption("Invalid Option Selected, only supports '200' days as input!");
                            }
                            catch (InvalidOption e) {
                                System.out.println(e.getMessage());
                            }
                    }
                    System.out.println("Enter More Specific Queries in ProductCostAndLeadTime Topic: \n" +
                            "5b) List products greater than N Cost in $ (150 $) :  \n");
                    Scanner inp5b = new Scanner(System.in);
                    String  option5b = inp5b.next();
                    switch (option5b) {
                        case "150$":
                            HigherCostProductsGrpc.HigherCostProductsBlockingStub stub5b = HigherCostProductsGrpc.newBlockingStub(channel);
                            stub5b.subscribe(QueryHigherCostProducts.newBuilder().build()).forEachRemaining(HigherCostProductsResponse -> {
                                try {
                                    genericClass<String> strQuery = new genericClass<String>(option5b);
                                    File create = new File(SaveLocation + "Topic5b_HigherCostProducts.txt");
                                    create.setWritable(true);
                                    FileWriter SaveFile = new FileWriter(create);
                                    SaveFile.write(HigherCostProductsResponse.getResult());
                                    SaveFile.close();
                                    System.out.println(strQuery.getQuery());
                                }
                                catch (InputMismatchException | IOException e) {
                                    System.out.println(e.getMessage());
                                }
                                System.out.println(HigherCostProductsResponse.getResult());
                            });
                        break;
                        default:
                            try {
                                throw new InvalidOption("Invalid Option Selected, only supports '150$'  as input!");
                            }
                            catch (InvalidOption e) {
                                System.out.println(e.getMessage());
                            }
                    }
                case 6:
                    System.out.println("#### Subscription topic is : ProductCostAndLeadTime");
                    ProductCostAndLeadTimeGrpc.ProductCostAndLeadTimeBlockingStub stub5 = ProductCostAndLeadTimeGrpc.newBlockingStub(channel);
                    stub5.subscribe(QueryProductCostAndLeadTime.newBuilder().build()).forEachRemaining(ProductCostAndLeadTimeResponse -> {
                        try {
                            File create = new File(SaveLocation + "Topic5_ProductCostAndLeadTime.txt");
                            create.setWritable(true);
                            FileWriter SaveFile = new FileWriter(create);
                            SaveFile.write(ProductCostAndLeadTimeResponse.getResult());
                            SaveFile.close();
                        } catch (IOException e) {
                            //                    e.printStackTrace();
                            System.out.println("");
                            System.out.println("File write failed, if executing as JAR file this is expected.");
                            System.out.println("");
                        }
                        ArrayList pPrint= new ArrayList(Arrays.asList(ProductCostAndLeadTimeResponse.getResult().split(",")));
                        for(int i=0;i<pPrint.size();i++)
                        {
                            System.out.println(pPrint.get(i).toString()
                                    .replace("["," ")
                                    .replace ("]"," ")
                                    .replace("{","")
                                    .replace("}",""));
                        }
//                        System.out.println(ProductCostAndLeadTimeResponse.getResult());
                    });
                break;
                case 7:

                    /**
                     * Functionality is added to keep the channel open until explicitly requested by the user using case 7.
                     */
                    System.out.println("Shutting Down");
                    channel.shutdown();
                    break;

                case 8:
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

            /**
             * This if conditions ensures the channel is shutdown and the progrom stops executing.
             */
            if (option == 7) {
                break;
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
            System.out.println("Server supports streaming inventory information, traffic stats and more!!!!");
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

//        System.out.println("Shutting Down");
//        channel.shutdown();
    }
}