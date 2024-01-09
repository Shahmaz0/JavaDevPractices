package com.shahma.JDBC;
import java.io.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        try {


            Connection con = ConnectionProvider.getConnection();
            String query = "insert into images (pic) values (?)";

            PreparedStatement pstmt = con.prepareStatement(query);

            JFileChooser Jfc = new JFileChooser();
            Jfc.showOpenDialog(null);

            File file = Jfc.getSelectedFile();

            FileInputStream fis = new FileInputStream(file);

            pstmt.setBinaryStream(1, fis, fis.available());
            System.out.println("Memory size = " + fis.available());

            pstmt.executeUpdate();

//            System.out.println("Done ..");
            JOptionPane.showMessageDialog(null, "Success");


        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
