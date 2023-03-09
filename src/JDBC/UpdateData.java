package JDBC;

import com.jdbc.MyConnection;

import java.sql.*;
import java.util.*;

public class UpdateData {

    public static void main(String[] args) {

        try {

            //call connection method
            Connection connection = MyConnection.getConnection();

            //query
            String q1 = "update student set name = ?, dept = ? where id = ?";

            //to get input from user
            Scanner sc = new Scanner(System.in);

            //create preparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(q1);

            //taking value from user
            System.out.print("Enter ID: ");
            preparedStatement.setInt(3, sc.nextInt());

            System.out.print("Enter name to update: ");
            preparedStatement.setString(1, sc.next());

            System.out.print("Enter department to update: ");
            preparedStatement.setString(2, sc.next());

            //execute query
            preparedStatement.executeUpdate();
            System.out.println("Updated...");

            //close connection
            connection.close();

        } catch (Exception e) {
            //handle checked exception
            System.out.println("Error: " + e);
        }
    }
}
