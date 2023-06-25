package databaseConnectionCRUD;
import java.sql.*;
public class DBConnection 
{
	 static Connection con;
     public static Connection createDBConnection()
     {
    	 try
    	 {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	 String url="jdbc:mysql://localhost:3306/employeedb";
    	 String username="root";
    	 String password="Sneha@2003";
    	 con=DriverManager.getConnection(url,username,password);
    	 }
    	 catch(Exception ex)
    	 {
    		 ex.printStackTrace();
    	 }
		return con;
     }
}
