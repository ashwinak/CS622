package trafficStatistics.server;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.w3c.dom.ls.LSOutput;
import java.io.IOException;

public class trafficServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50051;
        Server server = ServerBuilder
                .forPort(port)
                .addService(new trafficServerImpl())
                .addService(new trafficServerImpl.SysHealthService())
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
