package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class newAccount {
	public void nofund() throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/kodi","root","kodi@123");
		Statement st=c.createStatement();
		int a=sc.nextInt();
		double d=sc.nextDouble();
		String q="select Available_balance from Bank where Account_number="+a;
		ResultSet rs=st.executeQuery(q);
		while(rs.next())
		{
			if(rs.getDouble(1)<d) {
				System.out.println("Insufficient Fund");
			}
			else {
				st.executeUpdate("Update Bank set Available_balance="+(rs.getDouble(1)-d)+"where Account_number="+a);
				System.out.println("Withdrawed Successfully");
			}
		}
	}
}
