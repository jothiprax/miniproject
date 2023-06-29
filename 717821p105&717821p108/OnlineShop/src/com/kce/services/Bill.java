package OnlineShop.src.com.kce.services;
import java.util.*;

import OnlineShop.src.com.kce.dao.DatabaseConnection;

import java.io.*;
import java.sql.*;

public class Bill
{
	private int bill_id;
	private String cust_name;
	private String bill_addr;
	private String cust_phone;
	//private float total_amount;
	public float total_amount;
	private ArrayList<Integer> pid=new ArrayList<Integer>();
	private ArrayList<String> pname=new ArrayList<String>();
	private ArrayList<Integer> qty=new ArrayList<Integer>();
	private ArrayList<Float> price=new ArrayList<Float>();
	Bill(String cname,String badd,String cphn,ArrayList<Integer> p_id,ArrayList<String> p_name,ArrayList<Integer> quant,ArrayList<Float> prc)throws IOException
	{
		cust_name=cname;
		bill_addr=badd;
		cust_phone=cphn;
		total_amount=0.0f;
		pid=p_id;
		pname=p_name;
		qty=quant;
		price=prc;
	}
	private void generateBill()throws IOException
	{
		bill_id=setBillId();
		int x;
		float sum=0.0f;
		int i;
		for(i=0;i<pid.size();i++)
		{
			sum=sum+price.get(i);
		}
		total_amount=sum;
		try
		{
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root",DatabaseConnection.root);
			PreparedStatement ps=con.prepareStatement("insert into bills(bill_id,cust_name,bill_addr,total_amt) values(?,?,?,?)");
			ps.setString(1, Integer.toString(bill_id));
			ps.setString(2,cust_name);
			ps.setString(3, bill_addr);
			ps.setString(4, Float.toString(total_amount));
		    x=ps.executeUpdate();
			if(x==0)
				System.out.println("BILL ADDED TO DATABASE !");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	private static int setBillId()throws IOException
	{
		int x=2999;
		try
		{
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root",DatabaseConnection.root);
			PreparedStatement ps=con.prepareStatement("select bill_id from bills");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				x=Integer.parseInt(rs.getString(1));
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return x+1;
	}
	public void displayBill()throws IOException
	{
		generateBill();
		int x;
		System.out.println("\n==========================================================================================\n");
		System.out.println("YOUR BILL IS :\n");
		System.out.println("************************************************************************************************\n");
		System.out.printf("BILL ID                  =  %-5d\n",bill_id);
		System.out.printf("CUSTOMER NAME            =  %-20s\n",cust_name);
		System.out.printf("CUSTOMER CONTACT NUMBER  =  %-20s\n", cust_phone);
		System.out.printf("CUSTOMER ADDRESS         =  %-30s\n", bill_addr);
		System.out.println("************************************************************************************************\n");
		System.out.printf("%-20s \t %-20s \t %-20s \t %-20s\n", "PRODUCT_ID","PRODUCT_NAME","QUANTITY PURCHASED","TOTAL_PRICE");
		for(x=0;x<pid.size();x++)
		{
			System.out.printf("%-20d \t %-20s  \t %-20d \t %-20f\n", pid.get(x),pname.get(x),qty.get(x),price.get(x));
		}
		System.out.println("************************************************************************************************\n");
		System.out.printf("TOTAL AMOUNT PAYABLE = Rs. "+total_amount+"\n");
		System.out.println("************************************************************************************************\n");
	}
	public void addToDatabase()throws IOException
	{
		int x;
		try
		{
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop","root",DatabaseConnection.root);
			PreparedStatement ps=con.prepareStatement("insert into bills(bill_id,cust_name,bill_addr,total_amt) values(?,?,?,?)");
			ps.setString(1, Integer.toString(bill_id));
			ps.setString(2,cust_name);
			ps.setString(3, bill_addr);
			ps.setString(4, Float.toString(total_amount));
		    x=ps.executeUpdate();
			if(x==0)
				System.out.println("BILL NOT ADDED TO DATABASE !");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}
