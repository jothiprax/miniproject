package shopManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Retrive_billdetails {
public void retrive(int bill_id,Connection con) throws SQLException
{
	String query="select * from Customer_details where bill_no="+bill_id;
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(query);
	int j=1;
	while(rs.next())
	{
		if(j==1) {
		System.out.println("The details of this "+bill_id+" is");
		System.out.println("Customer Name: "+rs.getString(2));
		System.out.printf("%-20s%-20s\n","Medicine Name","Price");
		j++;
		}
		System.out.printf("%-20s%-20s\n",rs.getString(4),rs.getDouble(5));
	}
	query="select purchased_amount from bill_details where bill_id="+bill_id;
	rs=st.executeQuery(query);
	rs.next();
	System.out.println("Total:               "+rs.getDouble(1));
}
}
