package com.jdbc;

import javax.swing.*;
import java.io.*;
import java.sql.*;

public class InsertWithDialog {

    public static void main(String[] args) {

        //call connection
        Connection c = MyConnection.getConnection();

        //query
        String q1 = "insert into images(id,pic) values(?,?)";

        try {

            PreparedStatement preparedStatement = c.prepareStatement(q1);

            //show a dialog for choose the file to upload
            JFileChooser f = new JFileChooser();

            //show dialog
            f.showOpenDialog(null);

            //select file
            File file = f.getSelectedFile();

            FileInputStream fis = new FileInputStream(file);

            preparedStatement.setInt(1, 01);
            preparedStatement.setBinaryStream(2, fis, fis.available());

            preparedStatement.executeUpdate();

            //show dialog message
            JOptionPane.showMessageDialog(null,"Inserted");
            System.out.println("Inserted...");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }
}
