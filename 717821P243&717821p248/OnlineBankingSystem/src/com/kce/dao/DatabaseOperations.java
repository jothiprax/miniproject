package com.kce.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kce.util.DButil;

public class DatabaseOperations {
	public void addAmount(String account_no, float amount)
	{
		try {
			PreparedStatement psmt = DButil.getConnection().prepareStatement("update account_details set Balance = ? where AccountNumber = ?");
			psmt.setFloat(1, amount);
			psmt.setString(2, account_no);
			psmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public String getAccountNo(String userName)
	{
		try {
		
		PreparedStatement psmt = DButil.getConnection().prepareStatement("select AccountNumber from user_details where username=?");
		psmt.setString(1, userName);
		ResultSet rs=psmt.executeQuery();
		while(rs.next())
			return rs.getString(1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return "";
	}
	public float getBalance(String account_no)
	{
		try {
		PreparedStatement psmt = DButil.getConnection().prepareStatement("select Balance from account_details where AccountNumber=?");
		psmt.setString(1, account_no);
		ResultSet rs=psmt.executeQuery();
		while(rs.next())
			return rs.getFloat(1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return 0;
	}
	public int Transaction(String sender_account_no, float amount, String receiver_account_no)
	{
		int t1=0;
		try {
		PreparedStatement psmt = DButil.getConnection().prepareStatement("update account_details set balance=balance+? where AccountNumber=?");
		psmt.setFloat(1, amount);
		psmt.setString(2, receiver_account_no);
		t1=psmt.executeUpdate();
		psmt = DButil.getConnection().prepareStatement("update account_details set balance=balance-? where AccountNumber=?");
		psmt.setFloat(1, amount);
		psmt.setString(2, sender_account_no);
		t1+=psmt.executeUpdate();
		if(t1==2) {
		psmt = DButil.getConnection().prepareStatement("insert into Transactions values(?,?,?)");
		psmt.setString(2, receiver_account_no);
		psmt.setString(1, sender_account_no);
		psmt.setFloat(3, amount);
		psmt.executeUpdate();
		return 1;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return 0;
	}
	public void getTransactions()
	{
		try {
		PreparedStatement psmt = DButil.getConnection().prepareStatement("select * from Transactions");
		ResultSet rs=psmt.executeQuery();
		System.out.printf("%-20s%-20s%-20s","FromAccountNumber", "ToAccountNumber", "Amount");
		System.out.println();
		while(rs.next())
		{
			System.out.printf("%-20s%-20s%-20s",rs.getString(1),rs.getString(2),rs.getString(3));
			System.out.println();
		}
		System.out.println();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void getUserDetails()
	{
		try {
			PreparedStatement psmt = DButil.getConnection().prepareStatement("select * from user_details");
			ResultSet rs=psmt.executeQuery();
			System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s","Name", "Gender", "DOB","MobileNo", "Address", "Email", "username", "password", "AccountNo");
			System.out.println();
			while(rs.next())
			{
				System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				System.out.println();
			}
			System.out.println();
			}
			catch(Exception e){
				System.out.println(e);
			}
	}
}

