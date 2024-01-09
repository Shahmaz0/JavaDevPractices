import java.sql.*;
import java.io.*;

public class InsertJDBC {
    public static void main(String[] args) {

// Without Using prepared statement inserting values in tableq1
        try {
            // load the driver
//            Class.forName("com.mysql.jdbc.Driver");
//
//            //Creating the connection
//            String url = "jdbc:mysql://localhost:3306/student";
//            String username = "root";
//            String password = "abushahma";
//            Connection con = DriverManager.getConnection(url, username, password);

//            String query = "insert into table1 (tName, tCity) values ('AbuShahma', 'Azamgarh'),('DeepakKumar', 'Mathura'),('FaizRahman', 'Bihar')";
//
//            //create statement
//
//            Statement stmt = con.createStatement();
//            //Execute and update
//            stmt.executeUpdate(query);
//
//            System.out.println("Table created in database successfully");
//
//            con.close();



// Using prepared statement inserting values in table1.
            Class.forName("com.mysql.jdbc.Driver");

            //Creating the connection
            String url = "jdbc:mysql://localhost:3306/student";
            String username = "root";
            String password = "abushahma";
            Connection con = DriverManager.getConnection(url, username, password);

            //Create a query.
            String query = "insert into table1 (tName, tCity) values (?,?)";

            //Get the PreparedStatement Object
            PreparedStatement pstmt = con.prepareStatement(query);

            //Inserting data to table with dynamic input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Name : ");
            String name = br.readLine();

            System.out.println("Enter City : ");
            String city = br.readLine();

            //Set the valued to query
            pstmt.setString(1, name);
            pstmt.setString(2, city);

//            pstmt.setString(1, "Faizan Khan");
//            pstmt.setString(2, "Delhi Nigga");

            pstmt.executeUpdate();

            System.out.println("Inserted successfully");

            con.close();



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
