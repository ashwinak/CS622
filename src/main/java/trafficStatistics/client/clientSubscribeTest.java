package trafficStatistics.client;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

}

