package JDBC;

import com.jdbc.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectData {

    public static void main(String[] args) {

        try {
            //connection establishment
            Connection connection = MyConnection.getConnection();

            //query
            String q1 = "select * from student";

            //not get any input so use createStatement method
            Statement statement = connection.createStatement();

            //this query return data so we use executeQuery method
            ResultSet set = statement.executeQuery(q1);

            while (set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                String dept = set.getString(3);
                System.out.println("Roll: " + id + " Name: " + name + " Department: " + dept);
            }
            connection.close();
        }catch (Exception e){
            //handle checked or unchecked exception
            System.out.println("Error: " + e);
        }
    }
}
