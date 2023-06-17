package util;

public class DBUtil {
		
		
		static Connection con;
		public static Connection createConnection()
		{
		try{

		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/21L243","root","roopika");
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return con;
		}
		}

