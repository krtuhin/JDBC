package JDBC;

import java.sql.*;
import java.util.*;

public class InsertData {

    public static void main(String[] args) {

        //to get input from user
        Scanner sc = new Scanner(System.in);

        try {
            //loading driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //create connection
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1524:orcl2", "scott", "system");

            //query for insert data into table
            String q1 = "insert into student values(001,'Hello','IT')";

            //insert data dynamically
            String q2 = "insert into student(id,name,dept) values(?,?,?)";

            //prepare statement
            PreparedStatement preparedStatement = connection.prepareStatement(q2);

            //getting data dynamically
            preparedStatement.setString(2, "Rahul");
            preparedStatement.setString(3, "CSE");
            preparedStatement.setInt(1, 002);

            //getting data from user to insert
            System.out.print("Enter your ID number: ");
            preparedStatement.setInt(1,sc.nextInt());

            System.out.print("Enter your name: ");
            preparedStatement.setString(2,sc.next());

            System.out.print("Enter your department: ");
            preparedStatement.setString(3,sc.next());

            //execute query
            preparedStatement.executeUpdate();
            System.out.println("Inserted...");

            //close connection
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
