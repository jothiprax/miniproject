 package com.kce.bean;
import java.util.*;
import com.kce.service.*;
import java.sql.*;
import java.lang.*;
public class Menu {
	 private String name;
	 private double price;
	  
	public Menu() {
		super();
	}
	public Menu(String name) {
		this.name = name;
		
		String item="'"+name+"'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select Price from project.foodmenu where Foodname="+item);
			while(rs.next())
			{
				this.price=rs.getDouble(1);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

    

	public static void DisplayMenu() {
		int sno=1;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from project.foodmenu ORDER BY Category DESC");
			System.out.printf("%-20s %-20s %-20s %-20s %-20s\n","Food Number","Name","Category","Cusine","Price");
			
			while(rs.next())
			{
				System.out.printf("%-20s %-20s %-20s %-20s %-20s\n",sno,rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
				sno++;
			}
			con.close();
			
			
			
		}catch (Exception e)
		{
			System.out.println(e);
		}
		 
	 }
	
	
	public double getPrice(String item)
	{
		double amount=0;
		item = "'"+item+"'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from foodmenu where Foodname="+item);
			while(rs.next())
			{
				amount=rs.getDouble(4);
			}
			this.price=amount;
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return price;
	}




	public String getName() {
		return name;
	}




	@Override
	public String toString() {
		return "Menu [name=" + name + ", price=" + price + "]";
	}


 
	
	
	

	
	 
}
