package com.kce.customercheck;
import java.sql.*;
import java.util.*;
import com.kce.customer.*;
import com.kce.login.*;
import com.kce.customerdao.*;
public class customercheck
{
	public customercheck()
	{
		
	}
	public void checkaccount()
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
				System.out.print("\tEnter the Password: ");
				String password=sc.next();
				String query1="select * from customer where username='"+username+"' and password='"+password+"'";
				Statement s1=connection.createStatement();
				ResultSet row1=s1.executeQuery(query1);
				if(row1.next()) 
				{
					System.out.println("ORDER YOur FaVoUrItEs!!");
					login l2=new login();
					l2.login();
				}
				else
				{
					System.out.println("INVALID PASSWORD");
				}
			}
			else
			{
				System.out.println("INVALID USERNAME");
				System.out.println("***PLEASE CREATE THE ACCOUNT TO CONTINUE!!!***");
				System.out.print("Enter the UserName: ");
				String username1=sc.next();
				System.out.print("Enter the Password: ");
				String password1=sc.next();
				System.out.print ("Enter the Name: ");
				String name1=sc.next();
				System.out.print("Enter the Age: ");
				int age=sc.nextInt();
				System.out.print("Enter the Mobile no: ");
				Long mobile_no=sc.nextLong();
				System.out.print("Enter the Address: ");
				String address=sc.next();
				customer c=new customer(username1,password1,name1,age,mobile_no,address);
				customerdao cdao=new customerdao();
				boolean r=cdao.cdetails(c);
				if(r)
				{
					System.out.println("Welcome To SP Foods");
					login l1=new login();
					l1.login();
				}
				else
				{
					System.out.println("*****Something Went Wrong*****");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}