package trafficStatistics.client;
import java.sql.*;
import java.util.ArrayList;

public class clientDB  {
    /**
     *
     * @param TableName
     * @param RouterName
     * @param Stats
     * @throws SQLException
     *
     * A new class clientDB is created with multiple methods to manipulate the DB.
     * For this class to work, SQL lite must be installed with JDBC. JDBC handles all java code to SQL DB interactions.
     * This method takes table name, router host name and stats as input argument. A Table is created with these parameters in hand.
     * SQL create and insert functions are declared in this method.
     *
     * pre-condition : SQL lite must be installed for jdbc to connect to DB instance.
     * post-condition : Tables in DB's are created, displayed, dropped, modified and Joined in the below section of the code.
     *
     */
    public void createDB(String TableName,String RouterName, String Stats) throws SQLException {
        try {
            String connectionString = "jdbc:sqlite:src/main/java/trafficStatistics/client/clientDB.db";
            Connection connection = DriverManager.getConnection(connectionString);
                System.out.println();
                Statement cmd = connection.createStatement();
                ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
                ArrayList<String> tbl = new ArrayList<String>();
                while (rs.next()) {
//                    System.out.println(rs.getString("TABLE_NAME"));
                    tbl.add(rs.getString("TABLE_NAME"));
                }
                if(!tbl.contains(TableName)) {
                    String sqlCreate = "CREATE TABLE " + TableName  +
                            " (RouterName VARCHAR(255), " +
                            " Stats VARCHAR(255), " +
                            " PRIMARY KEY ( RouterName ))";
                    cmd.executeUpdate(sqlCreate);
                }
                cmd.executeUpdate("insert into " + TableName+ " (RouterName,Stats) values('" + RouterName + " ',' " + Stats + "')");
            } catch (SQLException e ) {
            if(e.getErrorCode() == 0) {
                System.out.println("jdbc connection error. Install sqlite if not installed already.");
            } else {
                System.out.println("Router name " +RouterName+ " already exist!Record update failed.Retry with unique Router name.");
            }
            }
    }
    public void createDB2(String TableName,String RouterName, String CPUStats) throws SQLException {
        /**
         *  This method is used to create a 2nd table to store info related to CPU. SQL create and insert functions are declared in this method.
         */
        try {
            String connectionString = "jdbc:sqlite:src/main/java/trafficStatistics/client/clientDB.db";
            Connection connection = DriverManager.getConnection(connectionString);
            System.out.println();
            Statement cmd = connection.createStatement();
            ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
            ArrayList<String> tbl = new ArrayList<String>();
            while (rs.next()) {
//                    System.out.println(rs.getString("TABLE_NAME"));
                tbl.add(rs.getString("TABLE_NAME"));
            }
            if(!tbl.contains(TableName)) {
                String sqlCreate = "CREATE TABLE " + TableName  +
                        " (RouterName VARCHAR(255), " +
                        " CPUStats VARCHAR(255), " +
                        " PRIMARY KEY ( RouterName ))";
                cmd.executeUpdate(sqlCreate);
            }
            cmd.executeUpdate("insert into " + TableName+ " (RouterName,CPUStats) values('" + RouterName + " ',' " + CPUStats + "')");
        } catch (SQLException e ) {
            if(e.getErrorCode() == 0) {
                System.out.println("jdbc connection error. Install sqlite if not installed already.");
            } else {
                System.out.println("Router name " +RouterName+ " already exist!Record update failed.Retry with unique Router name.");
            }
        }
    }
    public void showDB(String TableName) throws SQLException {

        /**
         * This method is used to show the contents of the table from a given DB. SQL Aggregate function, order functions are declared
         * in this method.
         */
        try {
            String connectionString = "jdbc:sqlite:src/main/java/trafficStatistics/client/clientDB.db";
            Connection connection = DriverManager.getConnection(connectionString);
            Statement cmd = connection.createStatement();
            ResultSet shTableCount = cmd.executeQuery("SELECT count(*) FROM "  + TableName);
            shTableCount.next();
            int count = shTableCount.getInt(1);
            System.out.println("#Reading from SQLite Database....");
            System.out.println("#Number of rows in the Table TrafficStats from SQLite DB is " + count);
            ResultSet shTable = cmd.executeQuery("SELECT * FROM "  + TableName);
            System.out.println();
            System.out.println("##Printing TrafficStats Table as is");
            System.out.println("RouterName  Stats");
            while (shTable.next()) {
                String RName = shTable.getString("RouterName");
                String AggrStats = shTable.getString("Stats");
                System.out.println(RName + "   " +AggrStats );
            }
            ResultSet shTableOrder = cmd.executeQuery("SELECT RouterName, Stats FROM "  + TableName + " ORDER BY Stats");
            System.out.println();
            System.out.println("##Printing TrafficStats Table Ordered view");
            System.out.println("RouterName  Stats");
            while (shTableOrder.next()) {
                String RName = shTableOrder.getString("RouterName");
                String AggrStats = shTableOrder.getString("Stats");
                System.out.println(RName + "   " +AggrStats );
            }


        } catch (SQLException e ) {
            System.out.println("error code " + e.getErrorCode());
            if(e.getErrorCode() == 0) {
                System.out.println("jdbc connection error. Install sqlite if not installed already.");
            }
            else {
                System.out.println("SQL Query Error");
            }
        }
    }
    public void joinTable(String Table1, String Table2) {

        /**
         * This method is used to join two tables with common key and display the merged contents of both tables.
         * The Join function of the SQL query is used in this method.
         */
        try {
            String connectionString = "jdbc:sqlite:src/main/java/trafficStatistics/client/clientDB.db";
            Connection connection = DriverManager.getConnection(connectionString);
            Statement cmd = connection.createStatement();
            ResultSet joinTable = cmd.executeQuery("SELECT * FROM "  + Table1 + " NATURAL JOIN " + Table2);
            System.out.println();
            System.out.println("##Printing TrafficStats Table joined with SysInfo Table");
            System.out.println("RouterName  Stats  CPUStats");
            while (joinTable.next()) {
                String RName = joinTable.getString("RouterName");
                String AggrStats = joinTable.getString("Stats");
                String CPUStats = joinTable.getString("CPUStats");
                System.out.println(RName + "   " +AggrStats + "  " + CPUStats );
            }
        } catch (SQLException e ) {
            System.out.println("SQL Query Error");
        }
    }
    public void dropDB(String TableName) throws SQLException {

        /**
         * This method is used do drop DB. When the code starts execution, all
         * the DB's are dropped to start from scratch.
         */
        try {
            String connectionString = "jdbc:sqlite:src/main/java/trafficStatistics/client/clientDB.db";
            Connection connection = DriverManager.getConnection(connectionString);
            Statement cmd = connection.createStatement();
            String sql = "DROP TABLE " + TableName;
            cmd.executeUpdate(sql);
            cmd.close();
        } catch (SQLException e ) {
            System.out.println("error code " + e.getErrorCode());
            if(e.getErrorCode() == 0) {
                System.out.println("jdbc connection error. Install sqlite if not installed already.");
            }
        }
    }
}
