package BusReservation;
import java.sql.*;
public class DBconnection {
     private static final String url="jdbc:mysql://localhost:3306/busresv1";
     private static final String username="root";
     private static final String password="Vinith@123"; 
	
     public static Connection getConnection()throws SQLException{
    	 return DriverManager.getConnection(url,username,password);
     }
}
