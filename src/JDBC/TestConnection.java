package JDBC;

import java.sql.*;

public class TestConnection {

    public static void main(String[] args) {

        //create url, user, password
        String url = "jdbc:oracle:thin:@localhost:1524:orcl2";
        String user = "scott";
        String password = "system";

        try {
            //loading driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver loaded...");

            //create connection
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected...");

            //close connection after execute all task
            connection.close();

        } catch (ClassNotFoundException e) {
            //if driver is not load
            System.out.println("Driver not loaded");

        } catch (SQLException e) {
            //if connection is not established & all about database related exception
            System.out.println("Not connected");
        }
    }
}
