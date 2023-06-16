package busreservation;

import java.sql.*;
import java.sql.SQLException;

public class BusDao {
	public  void displayBusInfo() throws SQLException
	{
		String query="Select * from bus";
		Connection con =dbconnection.getconnection();
		Statement st = con .createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			System .out.print("BUSNO : "+rs.getInt(1));
			if(rs.getInt(2)==0)
			{
				System.out.print("  AC : No ");
			}
			else
				System .out.print("  AC : YES ");
System.out.println("   CAPACITY :  "+rs.getInt(3));			
		}
		
	}
	
	public int getcapacity(int id) throws SQLException 
	{
		Connection con =dbconnection.getconnection();
	String 	query="select capacity from bus  where id="+ id;
	Statement st = con .createStatement();
	ResultSet rs=st.executeQuery(query);
	rs.next();
 return rs.getInt(1);

	
	}
	
}
