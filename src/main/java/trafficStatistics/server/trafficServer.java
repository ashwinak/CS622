package trafficStatistics.server;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.w3c.dom.ls.LSOutput;
import java.io.IOException;

/**
 *  This is the server code that enables all servers and opens the port for client to communicate.
 *  For the inventory management project to work, this code must be run first before the client code.
 *  pre-condition : User executes the server code.
 *  post-condition : The server enables all services and listens on a specific port. The client can use that port to communicate to the server.
 */

public class trafficServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50051;
        Server server = ServerBuilder
                .forPort(port)
                .addService(new trafficServerImpl())
                .addService(new trafficServerImpl.SysHealthService())
                .addService(new trafficServerImpl.FullInventoryList())
                .addService(new trafficServerImpl.ProductAvailability())
                .addService(new trafficServerImpl.ProductCostAndLeadTime())
                .addService(new trafficServerImpl.HigherLeadTimes())
                .addService(new trafficServerImpl.HigherCostProducts())
                .build();

        server.start();
        System.out.println("Server Started");
        System.out.println("Listening on port: " + port);


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received shutdown request");
            server.shutdown();
            System.out.println("Server Stopped");
        }));

        server.awaitTermination();
    }
}
