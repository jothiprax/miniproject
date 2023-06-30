package com.kce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.kce.bean.Account;
import com.kce.bean.Current_Account;
import com.kce.bean.Savings_Account;
import com.kce.bean.User;
import com.kce.util.DButil;

public class Jdbc {
	public boolean DatacaseConnectionUser(User u)
	{
		User user=u;
		try {
		PreparedStatement psmt = DButil.getConnection().prepareStatement("insert into User_details values(?,?,?,?,?,?,?,?,?)");
		psmt.setString(1, user.getName());
		psmt.setString(2, user.getGender());
		psmt.setString(3, user.getDob());
		psmt.setString(4, user.getMobile_no());
		psmt.setString(5, user.getAddress());
		psmt.setString(6, user.getEmail());
		psmt.setString(7, user.getUsername());
		psmt.setString(8, user.getPassword());
		psmt.setString(9, user.getAccount_no());
		return psmt.execute();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	public boolean DatacaseConnectionSavingsAccount(Savings_Account account)
	{
		try {
			PreparedStatement psmt = DButil.getConnection().prepareStatement("insert into account_details values(?,?)");
			psmt.setString(1, account.getUser().getAccount_no());
			psmt.setFloat(2, (float)account.getBalance());
			return psmt.execute();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	public boolean DatacaseConnectionCurrentAccount(Current_Account a)
	{
		Account account=a;
		try {
			PreparedStatement psmt = DButil.getConnection().prepareStatement("insert into account_details(AccountNumber, Balance) values(?,?)");
			psmt.setString(1, account.getUser().getAccount_no());
			psmt.setFloat(2, account.getBalance());
			return psmt.execute();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
}
