package com.kce.dao;
import com.kce.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kce.service.Main;
import com.kce.util.DBUtil;

public class BankDAO {
	
	public static void transfer(int username,double tamount) {
		Scanner sc=new Scanner(System.in);
		double balance=0;
		try {
			System.out.println("Enter the Benificiary Account Number:");
int toAccount=sc.nextInt();
			Connection con=DBUtil.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select balance from transactions where account_number="+toAccount);
			if(rs.next()) {
			
			ResultSet rsts=st.executeQuery("select balance from transactions where account_number="+username);
			
			while(rsts.next()) {
				balance=rsts.getDouble(1);
			}
			
			if(tamount<=balance) {
				balance=balance-tamount;
		      st.executeUpdate("insert into transactions values("+username+",SYSDATE,'T->"+toAccount+"',"+tamount+","+balance+")");
		      
		      ResultSet rst=st.executeQuery("select balance from transactions where account_number="+toAccount);
				while(rst.next()) {
					balance=rst.getDouble(1);
				}
			
				balance=balance+tamount;
		      st.executeUpdate("insert into transactions values("+toAccount+",SYSDATE,'C<-"+username+"',"+tamount+","+balance+")");
System.out.println("Transfered Successfully.");
System.out.println("\n_____________________________________________________\n\n");
		      BankDAO.balance(username);
			
			
			
			}else {
				try {
					throw new UserDefinedExceptions("\n\nInSufficient Balance to transfer!!!!\n\n");
					}catch(UserDefinedExceptions e) {
						System.out.println(e);
						BankDAO.continueService(username);			
						}
			}
			}
			
		
		else {
			
			try {
				throw new UserDefinedExceptions("\n\nInvalid Benificiary account Number\n\n");
				}catch(UserDefinedExceptions e) {
					System.out.println(e);
					BankDAO.transfer(username, tamount);			
					}
		}
		}
			catch(Exception e) {
			System.out.println(e);
		}
		
		
		BankDAO.continueService(username);
	}
	
	public static void balance(int username) {
		
		double balance=0;
		try {
			Connection con=DBUtil.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select balance from transactions where account_number="+username);
			
			while(rs.next()) {
				balance=rs.getDouble(1);
				
			}
			System.out.println("Your Balance Amount is: "+balance);
			}catch(Exception e){
				System.out.println(e);
			}
		System.out.println("\n_____________________________________________________\n\n");
		BankDAO.continueService(username);
		
	}
	

	public static void details(int username) {
		try {
			
			Connection con=DBUtil.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from transactions where account_number="+username);
			System.out.printf("%10s %15s %12s %11s %11s\n","AccountNo","Date&Time","Type","Amount","Balance");

			while(rs.next()) {
				
			//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDouble(4)+" "+rs.getDouble(5));
//				System.out.printf("%10s %10s %10s %10s %10s","AccountNo","date","Type","Amount","Balance");
			System.out.printf("%10s %15s %12s %11s %11s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5));

			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("\n_____________________________________________________\n\n");
		BankDAO.continueService(username);
	}
	
public static void deposit(int username,int damount) {
	double balance=0;
	try {
		Connection con=DBUtil.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select balance from transactions where account_number="+username);
		
		while(rs.next()) {
			balance=rs.getDouble(1);
		}
		
		balance=balance+damount;
      st.executeUpdate("insert into transactions values("+username+",SYSDATE,'deposit',"+damount+","+balance+")");
      System.out.println("Deposited Successfully.");
      BankDAO.balance(username);
      System.out.println("\n_____________________________________________________\n\n");
	
		}catch(Exception e){
			System.out.println(e);
		}BankDAO.continueService(username);
	}

public static void withdraw(int username,int wamount) {
	double balance=0;
	try {
		Connection con=DBUtil.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select balance from transactions where account_number="+username);
		
		while(rs.next()) {
			balance=rs.getDouble(1);
			
		}
		
		if(wamount<=balance) {
		balance=balance-wamount;
      st.executeUpdate("insert into transactions values("+username+",SYSDATE,'withdraw',"+wamount+","+balance+")");
      System.out.println("Rs."+wamount+" withdraweded .");
      BankDAO.balance(username);
      System.out.println("\n_____________________________________________________\n\n");
		}else {
			try {
				throw new UserDefinedExceptions("\n\nInSufficient Balance!!!!\n\n");
				}catch(UserDefinedExceptions e) {
					System.out.println(e);
					BankDAO.continueService(username);
				}
			
		}
		}catch(Exception e){
			System.out.println(e);
		}BankDAO.continueService(username);
}
public static void continueService(int username) {
	Scanner sc=new Scanner(System.in);
	char coption=0;
	System.out.println("1. to view your Transaction Details.");
	System.out.println("2. to deposit amount.");
	System.out.println("3. to withdraw.");
	System.out.println("4. to transfer money.");
	System.out.println("press any key except(1,2,3,4) to EXIT:");
	coption=sc.next().charAt(0);
	switch(coption) {
	case '1':BankDAO.details(username);break;
	case '2':
		System.out.println("Enter amount to depostit:");
		int damount=sc.nextInt();
		
		BankDAO.deposit(username,damount);
		break;
	case '3':
		System.out.println("Enter amount to withdraw:");
		int wamount=sc.nextInt();			
		BankDAO.withdraw(username,wamount);break;
	
	
case '4':
	
	
	System.out.println("Enter amount to be transfered:");
	double tamount=sc.nextInt();			
	BankDAO.transfer(username,tamount);break;
	
default:
	System.out.println("\n_____________________________________________________\n\n");
	Main.call();
	
}
	
sc.close();
	
}

	public static void login() {
		Scanner sc=new Scanner(System.in);
		char toption=0;
		int username=0;
		
		try {
			System.out.println("Enter your account number:");
			 username=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter your password:");
			String password=sc.nextLine();
			Connection con=DBUtil.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from clients where account_number="+username+" and password='"+password+"'");
			if(rs.next()) {
				System.out.println("\nLogin Successful");
				BankDAO.balance(username);
				BankDAO.continueService(username);
			}else {
				try {
				throw new UserDefinedExceptions("\n\nInvalid username/password\n\n");
				}catch(UserDefinedExceptions e) {
					System.out.println(e);
					BankDAO.login();
				}
				
			}
		}catch(InputMismatchException e) {
			System.out.println("\nInvalid account number");
			BankDAO.login();
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		
		switch(toption) {
		case '1':BankDAO.details(username);break;
		case '2':
			System.out.println("Enter amount to depostit:");
			int damount=sc.nextInt();
			
			BankDAO.deposit(username,damount);
			break;
		case '3':
			System.out.println("Enter amount to withdraw:");
			int wamount=sc.nextInt();			
			BankDAO.withdraw(username,wamount);break;
		
		
	case '4':
		
		System.out.println("Enter amount to be transfered:");
		double tamount=sc.nextInt();			
		BankDAO.transfer(username,tamount);
	}
		
sc.close();
	}
	
	
	
	
	public static void createAccount() {
		Scanner sc=new Scanner(System.in);
		int accNo = (int) (Math. random() * 1000000000);
//		System.out.println(accNo);
		System.out.print("Enter your name:");
		String name=sc.nextLine();
		
		String gender="";
		System.out.print("Enter option for Gender:\n1.male\n2.female");
		switch(sc.nextInt()) {
		
		case 1:gender="male";break;
		case 2:gender="female";break;
		}

	System.out.print("Phone Number:");
	
	long pnoneNo=sc.nextLong();
	sc.nextLine();
	System.out.print("Date of Birth[12-DEC-2012]:");
	String dob=sc.nextLine();
	System.out.print("Address:");
	String Address=sc.nextLine();
	System.out.print("create Password for user login[exactly 8 characters]:");
	String pass=sc.nextLine();
	try {
	Connection con=DBUtil.getConnection();
	PreparedStatement pst=con.prepareStatement("insert into clients values(?,?,?,?,?,?,?)");
	pst.setLong(1, accNo);
	pst.setString(2, name);
	pst.setString(3, gender);
	pst.setString(4, dob);
	pst.setLong(5, pnoneNo);
	pst.setString(6, Address);
	pst.setString(7,pass);
	pst.executeUpdate();
	Statement st=con.createStatement();
	st.executeUpdate("insert into transactions values("+accNo+",SYSDATE,'newAccount',0.00,0.00)");

	}catch(Exception e) {
//		System.out.println("Invalid details: please re-enter the details correctly according to given hints:");
System.out.println(e);
		BankDAO.createAccount();	
	}
	
	System.out.println("\n\nAccount created successfully");
	System.out.println("your account number is:"+accNo);
	System.out.println("password is that you have been created.\n\n");
	System.out.println("\n_____________________________________________________\n\n");
Main.call();

	sc.close();
		}
	
	
	
	
	
}
