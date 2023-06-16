package com.kce.price;
import java.sql.*;
import java.util.Scanner;
public class price {
	public void setprice1(int qty)
	{
		try
		{
			Connection connection=com.kce.connection.connection.createConnection();
			Scanner sc=new Scanner(System.in);
			Statement s=connection.createStatement();
			System.out.println("PRICE DETAILS: ");
			ResultSet row=s.executeQuery("select * from orders where item like '%riyani'");
			if(row.next()) {
				System.out.print("Each briyani costs Rs.150.00\n");
				int price1=qty*150;
				System.out.println("Price : "+price1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void setprice2(int qty)
	{
		try
		{
			Connection connection=com.kce.connection.connection.createConnection();
			Scanner sc=new Scanner(System.in);
			Statement s=connection.createStatement();
			System.out.println("PRICE DETAILS: ");
			ResultSet row=s.executeQuery("select * from orders where item like '%oup'");
			if(row.next()) {
				System.out.print("Each soup costs Rs.100.00\n");
				int price2=qty*100;
				System.out.println("Price : "+price2);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void setprice3(int qty)
	{
		try
		{
			Connection connection=com.kce.connection.connection.createConnection();
			Scanner sc=new Scanner(System.in);
			Statement s=connection.createStatement();
			System.out.println("PRICE DETAILS: ");
			ResultSet row=s.executeQuery("select * from orders where item like '%tarter'");
			if(row.next()) {
				System.out.print("Each Starter costs Rs.75.00\n");
				int price3=qty*75;
				System.out.println("Price : "+price3);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
