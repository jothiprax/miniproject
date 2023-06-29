package OnlineShop.src.com.kce.services;

import java.util.*;
import java.io.*;
import java.sql.*;
import OnlineShop.src.com.kce.dao.DatabaseConnection;

public class Cart {
	 ArrayList<Integer> pid=new ArrayList<Integer>();
	 ArrayList<String> pname=new ArrayList<String>();
	 ArrayList<String> ptype=new ArrayList<String>();
	 ArrayList<Integer> qpur=new ArrayList<Integer>();
	 ArrayList<Float> qprice=new ArrayList<Float>();
	public ArrayList<Integer> getpid()throws IOException
	{
		return pid;
	}
	public ArrayList<String> getpname()throws IOException
	{
		return pname;
	}
	public ArrayList<Integer> getpqty()throws IOException
	{
		return qpur;
	}
	public ArrayList<Float> getprice()throws IOException
	{
		return qprice;
	}
	public void addToCart(int p_id,String p_name,String p_type,int q_pur,float q_price)throws IOException
	{
		pid.add(p_id);
		pname.add(p_name);
		ptype.add(p_type);
		qpur.add(q_pur);
		qprice.add(q_price);
	}
	public void viewCart()throws IOException
	{
		int x=pid.size();
		if(x!=0)
		{
			System.out.println("\n---------------------------------------------------------------------\n");
			System.out.println("YOUR CART IS : \n");
			int i;
			System.out.println("***********************************************************************************************************************\n");
			System.out.printf("%-20s \t %-20s \t %-20s \t %-20s \t %-20s\n", "Product_ID","Product_Name","Product_Type","Quantity_Purchased","Total_Price");
			System.out.println("***********************************************************************************************************************\n");
			for(i=0;i<x;i++)
			{
				System.out.printf("%-20d \t %-20s \t %-20s \t %-20d \t %-20f\n",pid.get(i),pname.get(i),ptype.get(i),qpur.get(i),qprice.get(i) );
			}
			System.out.println("***********************************************************************************************************************\n");
		}
		else
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("CART IS EMPTY !");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	
	}
	public void removeFromCart(int p_id)throws IOException
	{
		int res;
		int x=-1;
		int prevq=0;
		int newq=0;
		res=pid.indexOf(p_id);
		if(res==-1)
			System.out.println("YOU HAVE NOT PURCHASED THIS PRODUCT !");
		else
		{
			pid.remove(res);
			pname.remove(res);
			ptype.remove(res);
			qprice.remove(res);
			try
			{
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root",DatabaseConnection.root);
				PreparedStatement ps1=con.prepareStatement("select Quantity from products where productID=?");
				ps1.setString(1, Integer.toString(p_id));
				ResultSet rs=ps1.executeQuery();
				while(rs.next())
				{
					prevq=Integer.parseInt(rs.getString(1));
				}
				newq=prevq+qpur.get(res);
				qpur.remove(res);
				PreparedStatement ps2=con.prepareStatement("update products set Quantity=? where productID=?");
				ps2.setString(1,Integer.toString(newq));
				ps2.setString(2, Integer.toString(p_id));
				x=ps2.executeUpdate();
			}
			
			catch(Exception e)
			{
				System.out.println(e);
			}
			if(x!=0)
				System.out.println("CART UPDATED SUCCESSFULLY !");
		}
		
	}
	public void cancelCart()throws IOException
	{
		try
		{
			int prevq=0;
			int newq=0;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop?autoReconnect=true&useSSL=false","root",DatabaseConnection.root);
			PreparedStatement ps=con.prepareStatement("update products set Quantity=? where productId=?");
			int x;
			int y;
			for(x=0;x<pid.size();x++)
			{
				PreparedStatement ps1=con.prepareStatement("select Quantity from products where productID=?");
				ps1.setString(1, Integer.toString(pid.get(x)));
				ResultSet rs=ps1.executeQuery();
				while(rs.next())
				{
					prevq=Integer.parseInt(rs.getString(1));
				}
				newq=prevq+qpur.get(x);
				ps.setString(1, Integer.toString(newq));
				ps.setString(2, Integer.toString(pid.get(x)));
				y=ps.executeUpdate();
				if(y==0)
					System.out.println("PRODUCT NOT UPDATED BACK TO PRODUCTS TABLE !");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
