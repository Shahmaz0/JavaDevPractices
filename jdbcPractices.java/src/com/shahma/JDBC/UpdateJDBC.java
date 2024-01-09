//Updating the data of the table JDBC.
package com.shahma.JDBC;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateJDBC {
    public static void main(String[] args) {
        try {

            Connection con = ConnectionProvider.getConnection();

            String query = "update table1 set tName=?, tCity=? where tId=?";

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter new Name : ");
            String name = br.readLine();

            System.out.println("Enter new City : ");
            String city = br.readLine();

            System.out.println("Enter Id : ");
            int id = Integer.parseInt(br.readLine());

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, city);
            pstmt.setInt(3, id);

            pstmt.executeUpdate();
            System.out.println("Updated successfully");

            con.close();




        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
