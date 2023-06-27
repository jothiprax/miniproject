package info;

import java.sql.*;
import java.util.Scanner;

public class Saving_Account extends Account {
	String url="jdbc:mysql://localhost:3306/Bank";
	String id="root";
	String pw="nike";
	public Saving_Account() {
		super();
	}
	public void viewBalance() throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name of the Account Holder:");
		String s=sc.next();
		Connection con =DriverManager.getConnection(url,id,pw);
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery("select balance from Savings_Account where name='"+s+"'");
		rs.next();
		int n=rs.getInt(1);
		System.out.println(n);
	}
	public void deposit() throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name of the Account Holder:");
		String s=sc.next();
		Connection con =DriverManager.getConnection(url,id,pw);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select balance from Savings_Account where name='"+s+"'");
		rs.next();
		double bal=rs.getDouble(1);
		System.out.println("Enter the amount to deposit:");
		int dep=sc.nextInt();
		bal+=dep;
		st.executeUpdate("update Current_Account set balance="+bal);
		System.out.println("Amount Deposited ");
	}
	public void withDraw() throws SQLException, Exceeds_balanceException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name of the Account Holder:");
		String s=sc.next();
		Connection con =DriverManager.getConnection(url,id,pw);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select balance from Savings_Account where name='"+s+"'");
		rs.next();
		double bal=rs.getDouble(1);
		System.out.println("Enter the amount to Withdraw:");
		int dep=sc.nextInt();
		if(bal<dep)
		{
			throw new Exceeds_balanceException();
		}
		else {
		bal-=dep;
		st.executeUpdate("update Savings_Account set balance="+bal);
		System.out.println("Amount Deposited ");
		}
	}
	

}
