package com.kce.bus.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DBUtil 
{
	public static  Connection createConnection()
	{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/21l232","root","Blackpre15*");
	return con;
	}
	catch(Exception e)
	{
	System.out.println(e);
	}
	return null;
	}
}
