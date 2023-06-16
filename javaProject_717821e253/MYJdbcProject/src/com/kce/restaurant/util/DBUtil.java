package com.kce.restaurant.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil 
{
  public static Connection getDBConnection()
  {
	  Connection con = null;
	  try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  con=DriverManager.getConnection("jdbc:mysql://localhost/restaurant", "root", "Sujithra@53");
		  
	  }catch(SQLException e) {
		  e.printStackTrace();
	  }catch(ClassNotFoundException e) {
		  System.out.println(e);
	  }
	  return con;
  }
	

}
