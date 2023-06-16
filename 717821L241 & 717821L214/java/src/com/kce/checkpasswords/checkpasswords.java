package com.kce.checkpasswords;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class checkpasswords {
	public boolean checkpassword()
	{
		try
		{
			Connection connection=com.kce.connection.connection.createConnection();
			Scanner sc=new Scanner(System.in);
			System.out.print("\tEnter the UserName: ");
			String username=sc.next();
			System.out.print("\tEnter the Password: ");
			String password=sc.next();
			String query="select username from customer where username='"+username+"' and password='"+password+"'";
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
