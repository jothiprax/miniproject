package com.kce.checkaccounts;
import java.sql.*;
import java.util.*;
//import com.kce.connection.connection;
public class checkaccounts
{
	public boolean checkaccount() throws Exception
	{
		try
		{
			Connection connection=com.kce.connection.connection.createConnection();
			Scanner sc=new Scanner(System.in);
			System.out.print("\tEnter the UserName: ");
			String username=sc.next();
			String query="select * from customer where username='"+username+"'";
			Statement s=connection.createStatement();
			ResultSet row=s.executeQuery(query);
			if(row.next())
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}