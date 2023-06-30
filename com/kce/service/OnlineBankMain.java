package com.kce.service;

import com.kce.bean.TransferBean;
import com.kce.dao.OnlineTransaction;
import com.kce.util.DButil;
import com.kce.util.BankException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class OnlineBankMain {
	static long ac=1234567907;
	public static final String pass="nkbank@2023";
@SuppressWarnings("resource")
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	OnlineTransaction ot=new OnlineTransaction();
	
	//welcome message!!!
	
	System.out.println("$$$$$$$$$$$$$$$$$$$$$");
	System.out.println(" WELCOME TO NK BANKS  ");
	System.out.println("$$$$$$$$$$$$$$$$$$$$$");
	System.out.println();
	
	//choice
	
	System.out.println("enter the choice:");
	System.out.println("1.admin");
	System.out.println("2.user");
	int ch1=s.nextInt();
	if(ch1==1)
	{
		System.out.println("enter the password:");
		String pass1=s.next();
		if(pass1.equals(pass))
		{
			System.out.println("enter the choice:");
			System.out.println("1.show user table");
			System.out.println("2.show transfer table");
			int ch2=s.nextInt();
			if(ch2==1)
			{
				//View Account Table
				
				try {
				Connection con=DButil.getDBConnection();
				PreparedStatement pst=con.prepareStatement("select * from BANK");
		        ResultSet rs=pst.executeQuery();
		        System.out.println("--------------------------------------------");
		        System.out.printf("%-13s| %-13s| %-13s|\n","AC NUMBER","NAME","BALANCE");
		        System.out.println("-------------|--------------|--------------|");
		        while(rs.next())
		        {
		        	System.out.printf("%-13s| %-13s| %-13s|\n",rs.getString(1),rs.getString(2),rs.getString(3));
		        }
		        System.out.println("--------------------------------------------");
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			else if(ch2==2)
			{
				//View Transfer table
				
				try {										
				Connection con=DButil.getDBConnection();
				PreparedStatement pst=con.prepareStatement("select * from TRANSFER");
				ResultSet rs1=pst.executeQuery();
				System.out.println("--------------------------------------------------------------------------");
		        System.out.printf("%-13s| %-13s| %-13s| %-13s| %-13s|\n","TRAID","FROM","TO","DATE","BALANCE");
		        System.out.println("-------------|--------------|--------------|--------------|--------------|");
		        while(rs1.next())
		        {
		        	System.out.printf("%-13s| %-13s| %-13s| %-13s| %-13s|\n",rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5));
		        }
				System.out.println("--------------------------------------------------------------------------");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else
		{
			System.out.println("INVALID CHOICE");
		}
		}
		else
		{
			System.out.println("WRONG PASSWORD");
	    }
	}
	else if(ch1==2)
	{
		// User Choices
		
	System.out.println("1.create account");
	System.out.println("2.deposit");
	System.out.println("3.withdraw");
	System.out.println("4.find balance");
	System.out.println("5.transfer");
	System.out.println("6.display Transfers");
	System.out.println("other to exit");
	System.out.println("Enter the choice:");
	int ch=s.nextInt();
	while(ch>0 && ch<7)
	{
	try {
     	Connection con=DButil.getDBConnection();
     	
     	//Bank table create query
     	
	    String ss="create table if not exists BANK(acno varchar(10) primary key,"
				+ "custname varchar(15),"
				+ "balance varchar(10))";
		PreparedStatement pst=con.prepareStatement(ss);
		pst.executeUpdate();
		
		//Transfer table create query
		
		/*
        String ss1="create table if not exists TRANSFER(traid varchar(4) primary key,"
        		+ "fromacno varchar(10),"
        		+ "toacno varchar(10),"
        		+ "tradate DATE,"
        		+ "traamt varchar(10))";
        pst=con.prepareStatement(ss1);
        pst.executeUpdate();
        pst=con.prepareStatement("alter table TRANSFER add tradate varchar(12)");
        pst.executeUpdate();
        */
		switch(ch)
		{
		case 1:
			//insert query into bank table
			pst=con.prepareStatement("insert into BANK values(?,?,?)");
			pst.setString(1,String.valueOf(ac));
			System.out.println("enter the name:");
			pst.setString(2,s.next());
			System.out.println("enter the balance:");
	        String bal2=s.next();
	        if(bal2.matches("[0-9]+.[0-9]+"))
	        {
			pst.setString(3,bal2);
			pst.executeUpdate();
			System.out.println("your account number is "+ac);
			System.out.println("DON'T FORGOT");
			ac++;
	        }
	        else
	        {
	        	throw new BankException("INVALID BALANCE AMOUNT");
	        }
			break;
		case 2:
			//Deposit money
			System.out.println("enter the account number:");
			String acnum=s.next();
			if(ot.ValidateAcc(acnum))
			{
				System.out.println("enter the  amount to deposit:");
				float upbal=s.nextFloat();
				ot.deposit(acnum,upbal);
				System.out.println("deposited successfully!!!");
				System.out.println("your balance is:"+ot.findBal(acnum));
			}
			else
			{
				throw new BankException("INVALID ACCOUNT NUMBER");
			}
			break;
		case 3:
			//WithDraw Money
			System.out.println("enter the account number:");
			String accnum=s.next();
			if(ot.ValidateAcc(accnum))
			{
				System.out.println("enter the  amount to withdraw:");
				float upbal=s.nextFloat();
				if(ot.findBal(accnum)>=upbal)
				{
				ot.withdraw(accnum,upbal);
				System.out.println("withdraw successfull!!!");
				System.out.println("your balance is:"+ot.findBal(accnum));
				}
				else
				{
					throw new BankException("INFUSSIENT BALANCE");
				}
			}
			else
			{
				throw new BankException("INVALID ACCOUNT NUMBER");
			}
			break;
		case 4:
			// Check Balance
			System.out.println("enter the account number:");
			String acnum1=s.next();
			if(ot.ValidateAcc(acnum1))
			{
				System.out.println("Your balance is:"+ot.findBal(acnum1));
			}
			else
			{
				throw new BankException("INVALID ACCOUNT NUMBER");
			}
			break;
		case 5:
			// Transfer Money
			System.out.println("Enter your account number:");
			String fromac=s.next();
			if(ot.ValidateAcc(fromac))
			{
			System.out.println("enter to account number:");
			String toac=s.next();
			if(ot.ValidateAcc(toac))
			{
				float bal=ot.findBal(fromac);
				System.out.println("enter amt to transfer :");
				float tamt=s.nextFloat();
				if(tamt>bal)
				{
					throw new BankException("INFUSSIENT BALANCE");
				}
				else
				{
					String traid=ot.GetSeqNo();
					Date date = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd"); 
					String dat=formatter.format(date);
                    String tat=String.valueOf(tamt);
        			TransferBean tb=new TransferBean(traid,fromac,toac,dat,tat);
        			ot.TransferMoney(tb);
        			System.out.println("Transaction successfull!!!!");
        			System.out.println();
				}
			}
			else
			{
				throw new BankException("INVALID ACCOUNT NUMBER");
			}
			}
			else
			{
				throw new BankException("INVALID ACCOUNT NUMBER");
			}
			break;
		case 6:
			//view Transfer table by user for reference
			System.out.println("enter the account number:");
			String temp=s.next();
			if(ot.ValidateAcc(temp))
			{
			pst=con.prepareStatement("select * from TRANSFER where fromacno=(?)");
			pst.setString(1,temp);
			ResultSet rs1=pst.executeQuery();
			System.out.println("--------------------------------------------------------------------------");
	        System.out.printf("%-13s| %-13s| %-13s| %-13s| %-13s|\n","TRAID","FROM","TO","DATE","BALANCE");
	        System.out.println("-------------|--------------|--------------|--------------|--------------|");
	        while(rs1.next())
	        {
	        	System.out.printf("%-13s| %-13s| %-13s| %-13s| %-13s|\n",rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5));
	        }
			System.out.println("--------------------------------------------------------------------------");
			}
			else
			{
				throw new BankException("INVALID ACCOUNT NUMBER");
			}
			break;
		}
	}
	catch(Exception e)
	{
		System.err.println(e);
	}
	System.out.println("-------------------------------------");
	System.out.println("enter the choice:");
	ch=s.nextInt();
	}
	}
	// The End
	System.out.println("THANK YOU!!!!");
	s.close();
}
}
