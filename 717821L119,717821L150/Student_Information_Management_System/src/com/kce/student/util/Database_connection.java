package com.kce.student.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database_connection
{
	static Connection c = null;
	public static Connection createConnection()
	{
		if (c == null)
		{
			try
			{
				//Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/jdemo";
				String uname = "root";String pwd = "John@123";
				c = DriverManager.getConnection(url,uname,pwd);
				return c;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return c;
	}
}
