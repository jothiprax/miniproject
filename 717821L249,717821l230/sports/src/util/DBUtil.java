package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
		
		
		static Connection con;
		public static Connection createConnection()
		{
		try{

		con=DriverManager.getConnection("jdbc:mysql://localhost:3316/21L249","root","shalini");
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return con;
		}
		}

