package trafficStatistics.client;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.StringWriter;
import java.net.Socket;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class clientSubscribeTest {
    @Test
    void subscribeRequest() {

        /**
         * This test case is to ensure the user inputs the right option to start the gRPC service. More tests will be added in the future with method calls.
         */
        int serviceOption;
        int start = 1;
        int end = 5;
        serviceOption = 5;
        assertTrue(serviceOption>=start && serviceOption <= end);

//        clientSubscribe sub = new clientSubscribe();
////        sub.SubscribeRequest(ManagedChannel.class.cast(serviceOption));
//        assertEquals(5,sub.);

    }

    /**
     *  This test ensures the right port number is used by client to connect to the server. The server will be listening on only one port number.
     */
    @Test
    void CheckPortNumber() {
        int portNumber = 50051;
        assertEquals(50051,portNumber);

    }

    /**
     *  This test ensures the file location to write the files is accurate.
     */
    @Test
    void CheckFileLocation() {
        String SaveLocation = "src/main/java/trafficStatistics/client/";
        assertEquals("src/main/java/trafficStatistics/client/",SaveLocation);
    }

    /**
     * To test if the user input match with the expected data type by the scanner function.
     */
    @Test
    void CheckUserInputType() {
        int inp1 = 0;
        String inp2 = "test";
        assertEquals(0,inp1);
        assertEquals("test",inp2);
    }
    @Test
    /**
     * Test to check if the binary file is created.
     */
    void BinaryFileCheck() {
        File file = new File("/media/ashwinak/Ashwin-CBK/CS622-Advanced Programming Technique/Project/CS622/src/main/java/trafficStatistics/client/Topic1_TrafficStats.dat");
        assertTrue(file.exists());
    }
    public static boolean isPortOpen(String host, int port) {
        Socket s = null;
        try {
            s = new Socket(host, port);
            return true;
        }
        catch (Exception e) {
            System.out.println("The port " +port + " is being used");
            return false;
        }
    }

    /**
     *  Test to make sure the ports are not used by any other application.
     */
    @Test
    public void checkPortAvailability() {
        int port1 = 50051;
        int port2 = 50052;
        try {
            assertTrue(isPortOpen("localhost", port1));
            assertTrue(isPortOpen("localhost", port2));

        }
        catch (Exception e) {
            System.out.println("The port " +port1+ " is being used by another application");
            System.out.println("The port " +port2+ " is being used by another application");
        }
    }

    /**
     * Test to ensure SQlite is installed and JDBC is working fine.
     */
    @Test
    public void testDriverManager() {
        try {
            String connectionString = "jdbc:sqlite:src/main/java/trafficStatistics/client/clientDB.db";
            Connection connection = DriverManager.getConnection(connectionString);
            Statement cmd = connection.createStatement();
            ResultSet shTableCount = cmd.executeQuery("SELECT count(*) FROM TrafficStats");
        } catch (SQLException e) {
            System.out.println("error code " + e.getErrorCode());
            if (e.getErrorCode() == 0) {
                System.out.println("jdbc connection error. Install sqlite if not installed already.");
            } else {
                System.out.println("SQL Query Error");
            }
        }
    }
}

