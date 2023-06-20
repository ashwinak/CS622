package trafficStatistics.client;
import java.sql.*;
import java.util.ArrayList;

public class clientDB  {
    public void createDB(String TableName,String RouterName, String Stats) throws SQLException {
            String connectionString = "jdbc:sqlite:src/main/java/trafficStatistics/client/clientDB.db";
            try (Connection connection = DriverManager.getConnection(connectionString)) {
                System.out.println();
                System.out.println("Database now connected.");
                Statement cmd = connection.createStatement();
                ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
                ArrayList<String> tbl = new ArrayList<String>();

                while (rs.next()) {
//                    System.out.println(rs.getString("TABLE_NAME"));
                    tbl.add(rs.getString("TABLE_NAME"));
                }
//                if (tbl.contains(TableName)){
//                    ResultSet shTableCount = cmd.executeQuery("SELECT count(*) FROM "  + TableName);
//                    shTableCount.next();
//                    int count = shTableCount.getInt(1);
//                    System.out.println("count in createDB " + count);
//                }
                if(!tbl.contains(TableName)) {
                    String sqlCreate = "CREATE TABLE " + TableName  +
                            " (RouterName VARCHAR(255), " +
                            " Stats VARCHAR(255), " +
                            " PRIMARY KEY ( RouterName ))";
                    cmd.executeUpdate(sqlCreate);
                }
                int result = cmd.executeUpdate("insert into " + TableName+ " (RouterName,Stats) values('" + RouterName + " ',' " + Stats + "')");
                if (result > 0) {
                    System.out.println("Record Inserted Successfully");
                } else {
                    System.out.println("Record Insertion failed");
                }

            } catch (SQLException e) {
//                throw new RuntimeException(e);
                System.out.println("Router name " +RouterName+ " already exist!Record update failed.Retry with unique Router name.");
            }
    }
    public void showDB(String TableName) throws SQLException {
        String connectionString = "jdbc:sqlite:src/main/java/trafficStatistics/client/clientDB.db";
        Connection connection = DriverManager.getConnection(connectionString);
        Statement cmd = connection.createStatement();
        ResultSet shTableCount = cmd.executeQuery("SELECT count(*) FROM "  + TableName);
        shTableCount.next();
        int count = shTableCount.getInt(1);
        System.out.println("Number of rows " + count);

        ResultSet shTable = cmd.executeQuery("SELECT * FROM "  + TableName);
        System.out.println("RouterName  Stats");
        while (shTable.next()) {
            String RName = shTable.getString("RouterName");
            String AggrStats = shTable.getString("Stats");
            System.out.println(RName + "   " +AggrStats );
        }
    }
    public void dropDB(String TableName) throws SQLException {
        String connectionString = "jdbc:sqlite:src/main/java/trafficStatistics/client/clientDB.db";
        Connection connection = DriverManager.getConnection(connectionString);
        Statement cmd = connection.createStatement();
        String sql = "DROP TABLE " + TableName;
        cmd.executeUpdate(sql);
        cmd.close();
    }
}
