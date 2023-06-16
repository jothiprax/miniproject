package com.kce.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
   public static Connection getConnection() throws SQLException{
	   try {
	       Class.forName("com.mysql.jdbc.Driver");
		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","Gaya3#SQL");
   }
	   catch(Exception e) {
		   System.out.println(e);
	   }
	return getConnection();
}
}