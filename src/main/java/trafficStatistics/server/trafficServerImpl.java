package trafficStatistics.server;

import com.proto.trafficStatistics.StatsRequest;
import com.proto.trafficStatistics.StatsResponse;
import com.proto.trafficStatistics.subscribeServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class trafficServerImpl extends subscribeServiceGrpc.subscribeServiceImplBase{
    @Override
    public void subscribe (StatsRequest request, StreamObserver<StatsResponse> responseObserver) {
        StatsResponse response = StatsResponse.newBuilder().setResult(FileIO() + request.getSubscriptionPath()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    public String FileIO()  {
        StringBuilder s = new StringBuilder();
        try {
            FileReader ServiceFile = new FileReader("src/main/java/trafficStatistics/server/services1.txt");
            Scanner ServiceReader = new Scanner(ServiceFile);
            while (ServiceReader.hasNextLine()) {
                String txt = ServiceReader.nextLine();
                s.append(txt).append("\n");
            }
            ServiceReader.close();
        }
        catch (FileNotFoundException e ) {
            System.out.println("File not found at the specified path.");
            return "File not found at the specified path.";
        }
        return s.toString();
    }
}


