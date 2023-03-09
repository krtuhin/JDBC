package JDBC;

import java.io.FileInputStream;
import java.sql.*;
import java.util.*;

public class InsertImage {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1524:orcl2", "scott", "system");

            //query
            String q1 = "create table Images(ID number(10) primary key, pic blob)";
            String q2 = "Insert into Images(ID,pic) values(?,?)";

            //execute for create table
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(q1);

            //execute for insert data
            PreparedStatement preparedStatement = connection.prepareStatement(q2);

//            preparedStatement.setInt(1, 004);

            //set image path
//            FileInputStream fil = new FileInputStream("C:\\Users\\krtuh\\Desktop\\pic.jpg");

            //getting id from user
            System.out.print("Enter ID: ");
            preparedStatement.setInt(1, sc.nextInt());

            //getting image path from user
            System.out.print("Enter image path: ");
            FileInputStream file = new FileInputStream(sc.next());

            //set image value as stream
            preparedStatement.setBinaryStream(2, file, file.available());

            //execute query
            preparedStatement.executeUpdate();
            System.out.println("Inserted...");

            connection.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
