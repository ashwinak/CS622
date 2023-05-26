package trafficStatistics.server;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class fileRead {

    public static void main(String[] args) throws FileNotFoundException {
        Yaml parse1 = new Yaml();
        try {
            FileReader ServiceFile1 = new FileReader("src/main/java/trafficStatistics/server/services.yaml");
            Map<String, Object> input = parse1.load(ServiceFile1);
//            Scanner ServiceReader = new Scanner(ServiceFile1);
            System.out.println(input.get("TrafficStatsService"));
//            ServiceReader.close();
        }
        catch (FileNotFoundException e ) {
            System.out.println("File not found at the specified path.");
        }
    }
//    public static String FileIO() throws FileNotFoundException {
//        StringBuilder s = new StringBuilder();
//        try {
//            File ServiceFile = new File("src/main/java/trafficStatistics/server/service1.txt");
//            Scanner ServiceReader = new Scanner(ServiceFile);
//            while (ServiceReader.hasNext()) {
//                String txt = ServiceReader.nextLine();
//                s.append(txt).append("\n");
//            }
//            ServiceReader.close();
//        }
//        catch (FileNotFoundException e ) {
//            System.out.println("File not found at the specified path.");
//            return "File not found at the specified path.";
//        }
//        return s.toString();
//    }
}
