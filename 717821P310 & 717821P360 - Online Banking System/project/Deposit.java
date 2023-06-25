package project;

import java.sql.*;
import java.util.*;

public class Deposit {
	public void Depositbalance() throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/kodi","root","kodi@123");
		Statement st=c.createStatement();
		int a=sc.nextInt();
		double d=sc.nextDouble();
		String s="select Available_balance from Bank where Account_number="+a;
		ResultSet rs=st.executeQuery(s);
		while(rs.next())
		{
			st.executeUpdate("Update Bank set Available_balance="+(rs.getDouble(1)+d)+"where Account_number="+a);
			System.out.println("Deposited Successfully");
		}
	}

}
