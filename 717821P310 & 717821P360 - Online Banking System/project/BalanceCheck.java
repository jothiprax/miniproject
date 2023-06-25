package project;

import java.sql.*;
import java.util.Scanner;

public class BalanceCheck {
	public void checkbalance() throws SQLException {
		Scanner sc=new Scanner(System.in);
	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/kodi","root","kodi@123");
	Statement st=c.createStatement();
	int acc_number=sc.nextInt();
	String query="select Available_balance from Bank where Account_number="+acc_number;
	ResultSet rs=st.executeQuery(query);
	while(rs.next()) {
	System.out.println(rs.getInt(1));
	}
}
}
