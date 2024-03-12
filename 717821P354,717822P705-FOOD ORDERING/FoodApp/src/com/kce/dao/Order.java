package com.kce.dao;
import java.sql.*;
import java.util.*;

import com.kce.service.Main;
import com.kce.util.StatusManager;
public class Order{
	Scanner sc=new Scanner (System.in);
	
	Connection con;
	Statement stmt;
	String url="jdbc:mysql://localhost:3306/foodapp";
	String user="root";
	String password="Royalenfield9442.";
	String print="";
	String setupdate="SET SQL_SAFE_UPDATES = 0";
	String delete="delete from order_placing";
	StatusManager statusManager=new StatusManager();
public void display_order() {

	try
	{
		con=DriverManager.getConnection(url,user,password);
		stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select *from order_placing");
		System.out.println("ORDERS                       QUANTITY");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"                                                                                   "+rs.getString(2));
		}
		int status=statusManager.order_status();
		if(status==1)
		{
			stmt.executeUpdate(setupdate);
			stmt.executeUpdate(delete);
			statusManager.update_order_status(1);
		}
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}
	
}
public void place_order()
{
	try
	{
		con=DriverManager.getConnection(url,user,password);
		stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select *from menu");
		System.out.println("********************ORDERS AVAILABLE TODAY********************");
		while(rs.next())
		{
			System.out.printf("|%-20s|%-20s|\n",rs.getString(1),rs.getInt(2));
		}
		System.out.println("ENTER THE NUMBER OF ORDERS :");
		int n=sc.nextInt();
		while(n>0)
		{
			System.out.println("ENTER THE FOOD_ID  ");
			int food_id=sc.nextInt();
			System.out.println("ENTER THE QUANTITY OF "+food_id);
			int quantity=sc.nextInt();
			stmt.executeUpdate("insert into order_placing values ("+quantity+","+food_id+")");
			n--;
		}
		System.out.println("********************ORDERS PLACED SUCCESSFULLY********************");
		Main.main(null);
		
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}
}
public void get_menu() throws Exception 
{
	
	if(statusManager.menu_attempts()==1)
	{
		try
		{
			con=DriverManager.getConnection(url,user,password);
			stmt=con.createStatement();
			System.out.println("ENTER THE NO OF ITEMS :");
			int n=sc.nextInt();
			while(n>0)
			{
				System.out.println("ENTER THE FOOD NAME");
				String food_name=sc.next();
				System.out.println("ENTER THE FOOD_ID");
				int food_id=sc.nextInt();
				stmt.executeUpdate("insert into menu values('"+food_name+"',"+food_id+")");
				n--;
			}
			System.out.println("*******************MENU UPDATED SUCCESSFULLY*******************");
			Main.main(null);
			
		}
		catch(Exception e)
		{
			stmt.executeUpdate(setupdate);
			stmt.executeUpdate("delete from menu");
			System.out.println("INVALID FOOD ID ITS BEEN USED");
		}
	}
	else {
		System.out.println("*******************MENU HAVE BEEN UPDATED*******************");
		System.out.println("TO RE-UPDATE PRESS 1 ELSE 0");
		int n=sc.nextInt();
		switch(n)
		{
		case 1:
			try {
			stmt.executeUpdate(delete);
			statusManager.setMenu_attempts(0);
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
			break;
		case 0:
			System.out.println("*******************NO CHANGES OCCURED*******************");
			break;
		}
	}
	}
//public void display_menu() throws Exception
//{
//	con=DriverManager.getConnection(url,user,password);
//	PreparedStatement dmenu=con.prepareStatement("select * from menu");
//	ResultSet rs=dmenu.executeQuery();
//	while(rs.next())
//	{
//		System.out.printf("|%-30s|\n",rs.getString(1));
//	}
//   Order order= new Order();
//   order.place_order();
//}
}
