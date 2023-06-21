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

public class trafficServer  {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50051;
        Server server = ServerBuilder
                .forPort(port)
                .addService(new trafficServerImpl())
                .addService(new trafficServerImpl.SysHealthService())
                //.addService(new trafficServerImpl.FullInventoryList())
                .addService(new trafficServerImpl.ProductAvailability())
                .addService(new trafficServerImpl.ProductCostAndLeadTime())
                .addService(new trafficServerImpl.HigherLeadTimes())
                .addService(new trafficServerImpl.HigherCostProducts())
                .build();

        server.start();
        System.out.println("Starting Thread1 for port " + port);
        System.out.println("Listening on port: " + port);
/**
 * A new thread is created to handle requests from port 50052 for full inventory request from client.  This thread will spawn
 * a new port 50052 and the attached services. The main thread will spawn  port 50051 and its attached services.
 * <p>
 *      * pre-condition : The new service Full inventory download is not spawned or attached to the new port.
 *      * post-condition : An exception is generated and error back to the user indicating that an invalid option was used.
 */
        Thread FullInventory = new Thread(new trafficServerFullInventory() {
            public void run() {
                System.out.println("### Starting new Thread and new port for full inventory list subscription....");
                int port = 50052;
                Server server2 = ServerBuilder
                        .forPort(port)
                        .addService(new trafficServerImpl())
                        .addService(new trafficServerImpl.FullInventoryList())
                        .build();
                try {
                    server2.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Starting Thread2 for port " + port);
                System.out.println("Listening on port: " + port);

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    System.out.println("Received shutdown request");
                    server2.shutdown();
                    System.out.println("Server Stopped");
                }));
                try {
                    server2.awaitTermination();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        FullInventory.start();
        /**
         *  Printing active thread count before shutting down services.
         */

        System.out.println("Number of threads " + Thread.activeCount());
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received shutdown request");
            server.shutdown();
            System.out.println("Server Stopped");
        }));
        server.awaitTermination();
    }
}
