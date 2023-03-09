package com.jdbc;

import java.sql.*;

//this class for create connection if connection is not established

public class MyConnection {

    private static Connection con;

    public static Connection getConnection() {
        try {
            if (con == null) {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1524:orcl2", "scott", "system");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return con;
    }
}
