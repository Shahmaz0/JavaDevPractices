import java.sql.*;

class Main {
    public static void main(String[] args) {


        try {

            // load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //Creating the connection
            String url = "jdbc:mysql://localhost:3306/student ";
            String username = "root";
            String password = "abushahma";
            Connection con = DriverManager.getConnection(url, username, password);

            if (con.isClosed()){
                System.out.println("Connection is closed") ;
            }else {
                System.out.println("Connection is created");
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}