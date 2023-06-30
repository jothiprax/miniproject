package com.kce.bank.dao;
import java.util.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.kce.bank.util.DBUtil;
import com.kce.bank.util.UserException;
import java.sql.PreparedStatement;
import com.kce.bank.service.BankMain;
public class BankDAO {
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	public static int option;
	Scanner sc = new Scanner(System.in);
	public static void insert() throws ClassNotFoundException, SQLException{
		Scanner sc = new Scanner(System.in);
		Random ra = new Random();
		System.out.println("Enter your name:");
		String name = sc.nextLine();
		System.out.println("Enter your gender:");
		String gender = sc.nextLine();
		System.out.println("Enter your date of birth:");
		String dob = sc.nextLine();
		System.out.println("Enter your address:");
		String add = sc.nextLine();
		System.out.println("Enter your phone number:");
		String phno = sc.nextLine();
		System.out.println("Enter your password:");
		String password =sc.nextLine();
		int accno = (int)(Math.random()*1000000000L);
		String query = "insert into client values(?,?,?,?,?,?,?)";
		con =DBUtil.getConnection();
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1,name);
		pst.setString(2,gender);
		pst.setString(3,dob);
		pst.setString(4,add);
		pst.setString(5,phno);
		pst.setString(6,password);
		pst.setInt(7,accno);
		pst.executeUpdate();
		stmt = con.createStatement();
		stmt.executeUpdate("insert into transactions values("+accno+",SYSDATE,'Default',0,0)");
		System.out.println("Account Successfully created.");
		System.out.println("Your Account no is:"+accno);
		BankMain.calling();
		}
	public static void Login() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Account number:");
		int accno = sc.nextInt();sc.nextLine();
		System.out.println("Enter your Password:");
		String password = sc.nextLine();
		con = DBUtil.getConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from client where password = '"+password+"' and accno = "+accno); 
		if(rs.next()){
			System.out.println("Login Successfull.");
			System.out.println("Your Bank Details:");
		    System.out.println("Name:"+rs.getString(1));
			System.out.println("Gender:"+rs.getString(2));
		    System.out.println("DOB:"+rs.getString(3));
			System.out.println("Address:"+rs.getString(4));
			System.out.println("Phone Number:"+rs.getString(5));
			System.out.println("\n");
			String str;
			do {
			System.out.println("Enter the your choice:");
			System.out.println("Enter 1 for view Transaction details.");
			System.out.println("Enter 2 for deposit.");
			System.out.println("Enter 3 for withdraw.");
			System.out.println("Enter 4 for transfer to another account.");
			System.out.println("Enter 5 to visit the main page.");
			option = sc.nextInt();
			sc.nextLine();
			switch(option) {
			case 1:
				View(accno);
				break;
			case 2:
				Deposit(accno);
				break;
			case 3:
				Withdraw(accno);
				break;
			case 4:
				Transfer(accno);
				break;
			case 5:
				try {
					BankMain.calling();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Enter a valid number.");
			
			}
			System.out.println("Enter yes to continue...");
			 str = sc.nextLine();
			}while(str.equals("yes"));
			
		}
		else {
			try {
			throw new UserException("Login Failed.");
			}catch(UserException e) {
			    System.out.println(e);
				Login();
		}
		}
	  }
	public static void Deposit(int accno)throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount to deposit:");
		Double amount = sc.nextDouble();
		if(amount==0) {
			try {
			throw new UserException("Please enter an valid amount.");
		}catch(UserException e) {
			System.out.println(e);
			Deposit(accno);
		}
		}
		else {
		Double bal=0.0;
		con=DBUtil.getConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select balance from transactions where accno="+accno);
	    if(rs.next()) {
		while(rs.next()) {
	    	bal=rs.getDouble(1);
	    }
	    }
	        bal = bal+amount;
	    	String query="insert into transactions values("+accno+",SYSDATE,'Deposit',"+amount+","+bal+")";
		    stmt = con.createStatement();
	        stmt.executeUpdate(query);
	        Balance(accno);
		}
	}
	
	public static void Withdraw(int accno) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount to be withdrawn:");
		double amount = sc.nextDouble();
		if(amount==0) {
			try {
			throw new UserException("Please enter an valid amount.");
		}catch(UserException e) {
			System.out.println(e);
			Withdraw(accno);
		}
		}
		else {
		double bal=0;
		con=DBUtil.getConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select balance from transactions where accno="+accno);
	    if(rs.next()) {
		while(rs.next()) {
	    	bal=rs.getDouble(1);
	    }
	    }
	    if(bal>amount) {
	        bal = bal-amount;
	    	String query="insert into transactions values("+accno+",SYSDATE,'Withdraw',"+amount+","+bal+")";
		    stmt = con.createStatement();
	        stmt.executeUpdate(query);
	        Balance(accno);
	    }
	    else {
	    	try {
	    	throw new UserException("Insufficient Funds");
	    	}catch(UserException e) {
	    		System.out.println(e);
	    		Withdraw(accno);
	    	}
	    }
		}
	}
    public static void View(int accno) throws SQLException {
    	con=DBUtil.getConnection();
    	String query="select * from transactions where accno="+accno;
    	stmt=con.createStatement();
    	ResultSet rs = stmt.executeQuery(query);
    	System.out.println("Your transaction details:");
    	System.out.println("Account_Number  DATE  TYPE  AMOUNT  BALANCE");
    	while(rs.next()) {
    		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getInt(4)+"  "+rs.getInt(5));
    	}
      }
    public static void Balance(int accno) throws SQLException {
		double bal=0;
    	con=DBUtil.getConnection();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select balance from transactions where accno="+accno);
	    if(rs.next()) {
		while(rs.next()) {
	    	bal=rs.getDouble(1);
	       }
		System.out.println("balance is : "+bal);
	    }
	   }
    public static void Transfer(int accno) {
    	Scanner sc = new Scanner(System.in);
    	double balance=0;
    	System.out.println("Enter the Transfer Account number:");
    	int toaccno = sc.nextInt();
    	System.out.println("Enter the amount:");
    	double amount =sc.nextDouble();
    	try {
    	Connection con=DBUtil.getConnection();
    	Statement st=con.createStatement();
    	ResultSet rs=st.executeQuery("select balance from transactions where accno="+toaccno);
    	if(rs.next()) {
             ResultSet rsts=st.executeQuery("select balance from transactions where accno="+accno);
    	while(rsts.next()) {
    	     balance=rsts.getDouble(1);
    	}
    	if(amount<=balance) {
    	     balance=balance-amount;
    	     st.executeUpdate("insert into transactions values("+accno+",SYSDATE,'T"+toaccno+"',"+amount+","+balance+")");
    	     ResultSet rst=st.executeQuery("select balance from transactions where accno="+toaccno);
    	while(rst.next()) {
    	balance=rst.getDouble(1);
    	}
    	balance=balance+amount;
    	     st.executeUpdate("insert into transactions values("+toaccno+",SYSDATE,'C"+accno+"',"+amount+","+balance+")");
    	}
    	else 
    	{
    	 try {
    	   throw new UserException("Insufficient balance!!!!!!!!!!");
    		}catch(UserException e) {
    			System.out.println(e);
    			Transfer(accno);
    		}
    	   }
    	}
    	else {
    		try {
    			throw new UserException("Invalid account number");
    		}catch(UserException e) {
    			System.out.println(e);
    			Transfer(accno);
    		}
    	}
    	}
    	catch(Exception e) {
    	   System.out.println(e);
    	}
    	}
	}
