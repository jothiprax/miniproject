package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
		
		
		static Connection con;
		public static Connection createConnection()
		{
		try{

		con=DriverManager.getConnection("jdbc:mysql://localhost:3316/21L144","root","santhosh");
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return con;
		}
		}

