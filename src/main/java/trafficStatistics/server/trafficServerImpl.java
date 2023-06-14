package trafficStatistics.server;

import com.proto.trafficStatistics.StatsRequest;
import com.proto.trafficStatistics.StatsResponse;
import com.proto.trafficStatistics.*;
import com.proto.trafficStatistics.subscribeServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;

import org.yaml.snakeyaml.*;

/**
 * Each class here implements the service definition defined in the proto file. A total of six services are defined.
 * This is the backend code for the gRPC server that receives and subscribe request and responds back with relevant data based on the
 * definitions on the Yaml file.
 *
 * pre-condition : The server waits for the request from client on any of these defined services.
 * post-condition : The server reads the yaml file contents via FileIOTopic classes and streams the information upon client's request
 * via the response object.
 *
 */

public class trafficServerImpl extends subscribeServiceGrpc.subscribeServiceImplBase  {

    @Override
    public void subscribe(StatsRequest request, StreamObserver<StatsResponse> responseObserver) {
        StatsResponse response = StatsResponse.newBuilder().setResult(FileIOTopic1() + request.getSubscriptionPath()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    static class SysHealthService extends SysHealthServiceGrpc.SysHealthServiceImplBase {
        public void subscribe(SysHealthRequest request, StreamObserver<SysHealthResponse> responseObserver) {
            SysHealthResponse response = SysHealthResponse.newBuilder().setResult(FileIOTopic2() + request.getSubscriptionPath()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    static class FullInventoryList extends FullInventoryListGrpc.FullInventoryListImplBase {
        public void subscribe(QueryFullInventoryList request, StreamObserver<FullInventoryListResponse> responseObserver) {
            FullInventoryListResponse response = FullInventoryListResponse.newBuilder().setResult(FileIOTopic3() + request.getSubscriptionPath()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    static class ProductAvailability extends ProductAvailabilityGrpc.ProductAvailabilityImplBase {
        public void subscribe(QueryProductAvailability request, StreamObserver<ProductAvailabilityResponse> responseObserver) {
            ProductAvailabilityResponse response = ProductAvailabilityResponse.newBuilder().setResult(FileIOTopic4() + request.getSubscriptionPath()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    static class ProductCostAndLeadTime extends ProductCostAndLeadTimeGrpc.ProductCostAndLeadTimeImplBase {
        public void subscribe(QueryProductCostAndLeadTime request, StreamObserver<ProductCostAndLeadTimeResponse> responseObserver) {
            ProductCostAndLeadTimeResponse response = ProductCostAndLeadTimeResponse.newBuilder().setResult(FileIOTopic5() + request.getSubscriptionPath()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    static class HigherLeadTimes extends HigherLeadTimesGrpc.HigherLeadTimesImplBase {
        public void subscribe(QueryHigherLeadTimes request, StreamObserver<HigherLeadTimesResponse> responseObserver) {
            HigherLeadTimesResponse response = HigherLeadTimesResponse.newBuilder().setResult(FileIOTopic6() + request.getSubscriptionPath()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    static class HigherCostProducts extends HigherCostProductsGrpc.HigherCostProductsImplBase {
        public void subscribe(QueryHigherCostProducts request, StreamObserver<HigherCostProductsResponse> responseObserver) {
            HigherCostProductsResponse response = HigherCostProductsResponse.newBuilder().setResult(FileIOTopic7() + request.getSubscriptionPath()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    /**
     * @return contents from the file read.
     * <p>
     * The below code requires a good classifer that can classify based on incoming request and respond with the appropriate contents from the yaml file.
     * <p>
     * The server uses a .yaml file with appropriate headers. With proper classifier, there won't be a need to repeat the code snippet for each service.
     * <p>
     * The yaml file is parsed based on header and stored in a map. Later the key from the map data structure is used to retrieve the contents of that specific
     * key. Later the retried key is returned to the method call which is then included in to subscribe() method above.
     * <p>
     * If the FileReader object is not able to locate the file, then appropriate exception is raised using the try , catch block.
     * Pre-condition : A yaml file exist with all relevant information for all the services implemented.
     * post-condition : The Yaml file is parsed such that only relevant information for a given service is streamed to the client.
     */
    public static String FileIOTopic1() {
        StringBuilder s = new StringBuilder();
        Yaml parse = new Yaml();
        String DBLocation = "src/main/java/trafficStatistics/server/services.yaml";
        try {
            FileReader ServiceFile = new FileReader(DBLocation);
            Map<String, Object> input = parse.load(ServiceFile);
            Scanner ServiceReader = new Scanner(ServiceFile);
            s.append(input.get("QueryTrafficStatistics").toString());
            ServiceReader.close();
        } catch (FileNotFoundException e) {
//            System.out.println("File not found at the specified path.");
            return "File not found at the specified path.";
        }
        return s.toString();
    }

    public static String FileIOTopic2() {
        StringBuilder s = new StringBuilder();
        Yaml parse = new Yaml();
        String DBLocation = "src/main/java/trafficStatistics/server/services.yaml";
        try {
            FileReader ServiceFile = new FileReader(DBLocation);
            Map<String, Object> input = parse.load(ServiceFile);
            Scanner ServiceReader = new Scanner(ServiceFile);
            s.append(input.get("QuerySystemHealth").toString());
            ServiceReader.close();
        } catch (FileNotFoundException e) {
//            System.out.println("File not found at the specified path.");
            return "File not found at the specified path.";
        }
//        String  abc = "123";
//        FileIOTopics(abc);
        return s.toString();

    }


        public static String FileIOTopic3() {
            StringBuilder s = new StringBuilder();
            Yaml parse = new Yaml();
            String DBLocation = "src/main/java/trafficStatistics/server/services.yaml";
            try {
                FileReader ServiceFile = new FileReader(DBLocation);
                Map<String, Object> input = parse.load(ServiceFile);
                Scanner ServiceReader = new Scanner(ServiceFile);
                s.append(input.get("QueryFullInventoryList").toString());
                ServiceReader.close();
            } catch (FileNotFoundException e) {
    //            System.out.println("File not found at the specified path.");
                return "File not found at the specified path.";
            }
            return s.toString();
        }

        public static String FileIOTopic3a() {
            StringBuilder s = new StringBuilder();
            Yaml parse = new Yaml();
            String DBLocation = "src/main/java/trafficStatistics/server/services.yaml";
            try {
                FileReader ServiceFile = new FileReader(DBLocation);
                Map<String, Object> input = parse.load(ServiceFile);
                Scanner ServiceReader = new Scanner(ServiceFile);
                s.append(input.get("QueryFullInventoryList2").toString());
                ServiceReader.close();
            } catch (FileNotFoundException e) {
    //            System.out.println("File not found at the specified path.");
                return "File not found at the specified path.";
            }
            return s.toString();
        }


    public static String FileIOTopic4() {
        StringBuilder s = new StringBuilder();
        Yaml parse = new Yaml();
        String DBLocation = "src/main/java/trafficStatistics/server/services.yaml";
        try {
            FileReader ServiceFile = new FileReader(DBLocation);
            Map<String, Object> input = parse.load(ServiceFile);
            Scanner ServiceReader = new Scanner(ServiceFile);
            s.append(input.get("QueryProductAvailability").toString());
            ServiceReader.close();
        } catch (FileNotFoundException e) {
//            System.out.println("File not found at the specified path.");
            return "File not found at the specified path.";
        }
        return s.toString();
    }

    public static String FileIOTopic5() {
        StringBuilder s = new StringBuilder();
        Yaml parse = new Yaml();
        String DBLocation = "src/main/java/trafficStatistics/server/services.yaml";
        try {
            FileReader ServiceFile = new FileReader(DBLocation);
            Map<String, Object> input = parse.load(ServiceFile);
            Scanner ServiceReader = new Scanner(ServiceFile);
            s.append(input.get("QueryProductCostAndLeadTime").toString());
            ServiceReader.close();
        } catch (FileNotFoundException e) {
//            System.out.println("File not found at the specified path.");
            return "File not found at the specified path.";
        }
        return s.toString();
    }

    public static String FileIOTopic6() {
        StringBuilder s = new StringBuilder();
        Yaml parse = new Yaml();
        String DBLocation = "src/main/java/trafficStatistics/server/services.yaml";
        try {
            FileReader ServiceFile = new FileReader(DBLocation);
            Map<String, Object> input = parse.load(ServiceFile);
            Scanner ServiceReader = new Scanner(ServiceFile);
            s.append(input.get("QueryHigherLeadTimes").toString());
            ServiceReader.close();
        } catch (FileNotFoundException e) {
//            System.out.println("File not found at the specified path.");
            return "File not found at the specified path.";
        }
        return s.toString();
    }

    public static String FileIOTopic7() {
        StringBuilder s = new StringBuilder();
        Yaml parse = new Yaml();
        String DBLocation = "src/main/java/trafficStatistics/server/services.yaml";
        try {
            FileReader ServiceFile = new FileReader(DBLocation);
            Map<String, Object> input = parse.load(ServiceFile);
            Scanner ServiceReader = new Scanner(ServiceFile);
            s.append(input.get("QueryHigherCostProducts").toString());
            ServiceReader.close();
        } catch (FileNotFoundException e) {
            return "File not found at the specified path.";
        }
        return s.toString();
    }


}

