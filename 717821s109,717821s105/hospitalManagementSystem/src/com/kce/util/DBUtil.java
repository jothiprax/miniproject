package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	
	static Connection con;
	public static Connection createConnection()
	{
	try{
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dhanush","root","root");
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	return con;
	}
	}
