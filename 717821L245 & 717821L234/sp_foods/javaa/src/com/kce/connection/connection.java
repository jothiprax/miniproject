package com.kce.connection;
import java.sql.*;
public class connection {
public static Connection connection1;
	public static Connection createConnection()
	{
		if(connection1==null)
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection1= DriverManager.getConnection("jdbc:mysql://localhost:3306/sp_foods","root","root");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return connection1;
	}
}
