package info;

import java.sql.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws SQLException, Exceeds_balanceException{
		Scanner sc =new Scanner(System.in);
		System.out.println("1)Create Account");
		System.out.println("2)View Balance");
		System.out.println("3)Deposit");
		System.out.println("4)Withdraw");
		System.out.println("5)Exit");
		int Choice = sc.nextInt();
		String url="jdbc:mysql://localhost:3306/Bank";
		String id="root";
		String pw="nike";
		Connection con =DriverManager.getConnection(url,id,pw);
		
		while(true) {
		switch (Choice) {
		case 1: {
			System.out.println("1)Saving Account");
			System.out.println("2)Current Account");
			int a=sc.nextInt();
			switch (a) {
			case 1: {
				System.out.println("Account Number:");
				int accno = sc.nextInt();
				System.out.println("Customer Name:");
				String name = sc.next();
				Saving_Account sa = new Saving_Account();
				System.out.println("deposit");
				double d=sc.nextDouble();
				Statement st=con.createStatement();
				st.executeUpdate("insert into Savings_Account values("+accno+",'"+name+"',"+d+")");
				break;
			}
			case 2: {
				System.out.println("Account Number:");
				int accno = sc.nextInt();
				System.out.println("Customer Name:");
				String name = sc.next();
				Saving_Account ca = new Saving_Account();
				System.out.println("deposit");
				double d=sc.nextDouble();
				Statement st=con.createStatement();
				st.executeUpdate("insert into Current_Account values("+accno+",'"+name+"',"+d+")");
				break;
			}
			}
		break;	
		}
			
		
		case 2:{
			System.out.println("1)Saving Account");
			System.out.println("2)Current Account");
			int a=sc.nextInt();
			switch (a) {
			case 1: {
				Saving_Account sa=new Saving_Account();
				sa.viewBalance();
				break;
			}
			case 2:{
				Current_Account ca=new Current_Account();
				ca.viewBalance();
				break;
			}
			}
			break;
		}
		case 3:{
			System.out.println("1)Saving Account");
			System.out.println("2)Current Account");
			int a=sc.nextInt();
			switch (a) {
			case 1: {
				Saving_Account sa=new Saving_Account();
				sa.deposit();
				break;
			}
			case 2:{
				Current_Account ca=new Current_Account();
				ca.deposit();
				break;
			}
			}
			break;
		}
		case 4:{
			System.out.println("1)Saving Account");
			System.out.println("2)Current Account");
			int a=sc.nextInt();
			switch (a) {
			case 1: {
				Saving_Account sa=new Saving_Account();
				sa.withDraw();
				break;
			}
			case 2:{
				Current_Account ca=new Current_Account();
				ca.withDraw();
				break;
			}
			}
			break;
		}
		case 5:{
			return;
		}
		}
		System.out.println("1)Create Account");
		System.out.println("2)View Balance");
		System.out.println("3)Deposit");
		System.out.println("4)Withdraw");
		System.out.println("5)Exit");
		Choice = sc.nextInt();
	}
	}
	
}



