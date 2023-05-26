package trafficStatistics.server;

import com.google.common.math.Stats;
import com.proto.trafficStatistics.StatsRequest;
import com.proto.trafficStatistics.StatsResponse;
import com.proto.trafficStatistics.*;
import com.proto.trafficStatistics.subscribeServiceGrpc;
import io.grpc.stub.StreamObserver;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;
import org.yaml.snakeyaml.*;

/**
 * Each class here implements the service definition defined in the proto file. For now two services are active, more services will be
 * active in the future.
 */

public class trafficServerImpl extends subscribeServiceGrpc.subscribeServiceImplBase{
    @Override
    public void subscribe (StatsRequest request, StreamObserver<StatsResponse> responseObserver) {
        StatsResponse response = StatsResponse.newBuilder().setResult(FileIOTopic1() + request.getSubscriptionPath()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    static class SysHealthService extends SysHealthServiceGrpc.SysHealthServiceImplBase {
        public void subscribe (SysHealthRequest request, StreamObserver<SysHealthResponse> responseObserver) {
            SysHealthResponse response = SysHealthResponse.newBuilder().setResult(FileIOTopic2() + request.getSubscriptionPath()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    /**
     *
     * @return contents from the file read.
     *
     * The below code requires a good classifer that can classify based on incoming request and respond with the appropriate contents from the yaml file.
     *
     * The server uses a .yaml file with appropriate headers. With proper classifier, there won't be a need to repeat the code snippet for each service.
     *
     * The yaml file is parsed based on header and stored in a map. Later the key from the map data structure is used to retrieve the contents of that specific
     * key. Later the retried key is returned to the method call which is then included in to subscribe() method above.
     *
     * If the FileReader object is not able to locate the file, then appropriate exception is raised using the try , catch block.
     * Pre-condition : A yaml file exist with all relevant information for all the services implemented.
     * post-condition : The Yaml file is parsed such that only relevant information for a given service is streamed to the client.
     *
     */
    public static String FileIOTopic1()  {
        StringBuilder s = new StringBuilder();
        Yaml parse = new Yaml();
        try {
            FileReader ServiceFile = new FileReader("src/main/java/trafficStatistics/server/services.yaml");
            Map<String, Object> input = parse.load(ServiceFile);
            Scanner ServiceReader = new Scanner(ServiceFile);
            s.append(input.get("TrafficStatsService").toString());
            ServiceReader.close();
        }
        catch (FileNotFoundException e ) {
//            System.out.println("File not found at the specified path.");
            return "File not found at the specified path.";
        }
        return s.toString();
    }

    public static String FileIOTopic2()  {
        StringBuilder s = new StringBuilder();
        Yaml parse = new Yaml();
        try {
            FileReader ServiceFile = new FileReader("src/main/java/trafficStatistics/server/services.yaml");
            Map<String, Object> input = parse.load(ServiceFile);
            Scanner ServiceReader = new Scanner(ServiceFile);
            s.append(input.get("SysHealthService").toString());
            ServiceReader.close();
        }
        catch (FileNotFoundException e ) {
//            System.out.println("File not found at the specified path.");
            return "File not found at the specified path.";
        }
        return s.toString();
    }
}


