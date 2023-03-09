package JDBC;

import java.sql.*;

public class CreateTable {

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
            System.out.println("Connection established...");

            //create query for create table
            String q1 = "create table Student (id number(10) primary key, name varchar2(40) not null, dept varchar2(10))";

            //for delete table
            String q2 = "drop table student";

            //create statement
            Statement stmt = connection.createStatement();

            //when not return any value
            stmt.executeUpdate(q1);
            System.out.println("Table Created...");

            //close connection after execute all task
            connection.close();

        } catch (ClassNotFoundException e) {
            //if driver is not load
            System.out.println("Driver not loaded");

        } catch (SQLException e) {
            //if connection is not established & all about database related exception
            System.out.print("Error: ");
            System.out.print(e);
        }
    }
}
