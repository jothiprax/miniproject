package com.kce.bus.util;
import java.util.*;
import java.sql.*;

public class DButil {
	public static Connection con = null;
	public static Connection getConnection() {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_Booking","root","Anusiya@5");
		// System.out.println("Connection Established successfully");
	}catch(SQLException e)
	{
		e.printStackTrace();
	}
	catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	return con;
}
}
class BusIsNotAvailable extends Exception{
	public String toString()
	{
		return "Not Available......";
	}
}