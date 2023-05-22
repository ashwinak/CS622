package trafficStatistics.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class fileRead {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(FileIO());
    }
    public static String FileIO() throws FileNotFoundException {
        StringBuilder s = new StringBuilder();
        try {
            File ServiceFile = new File("src/main/java/trafficStatistics/server/service1.txt");
            Scanner ServiceReader = new Scanner(ServiceFile);
            while (ServiceReader.hasNext()) {
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
