package busRev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusDataObject {
	public void displayBusInformation() throws SQLException{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus", "root", "Pari@123");
		Statement st=con.createStatement();
		ResultSet rs =st.executeQuery("select * from bus");
		while(rs.next()) {
			System.out.println("Bus No: "+rs.getInt(1));
			if(rs.getInt(2)==0) {
				System.out.println("AC : NO");
			}
			else
			{
				System.out.println("AC : YES");
			}
			System.out.println("Capacity: "+rs.getInt(3));
		}
		System.out.println("_________________________");
	}
	public int getCapacity(int id) throws SQLException{
		String query="Select capacity from bus where busNo="+id;
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","Pari@123");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
		
		}
}
