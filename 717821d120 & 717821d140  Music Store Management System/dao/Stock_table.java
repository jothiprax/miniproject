package com.kce.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.kce.bean.StockDetails;
import com.kce.util.DBUtil;
class UserDefinedException extends Exception{
	public UserDefinedException(String s) {
		super(s);
	}
}
public class Stock_table {
	
public static Scanner sc=new Scanner(System.in);
	public static void insert(int a) {
			try {
				StockDetails[]arr=new StockDetails[a];
				 //productid, String productName, String made, int price, int gaurentee
				for(int i=0;i<a;i++) {
					
					System.out.println("Enter the product id: ");
					int pid=sc.nextInt();
					System.out.println("Enter the Product name: ");
					String pname=sc.next();
					System.out.println("Enter the made of the product: ");
					String Made=sc.next();
					System.out.println("Enter the price: ");
					int Price=sc.nextInt();
					System.out.println("Enter the gaurentee period: ");
					int Gaurentee=sc.nextInt();
					
					arr[i]=new StockDetails(pid,pname,Made,Price,Gaurentee);
				}
				Connection con=DBUtil.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into music_store values(?,?,?,?,?)");
				for(int i=0;i<a;i++) {
					ps.setInt(1, arr[i].getProductid());
					ps.setString(2, arr[i].getProductName());
					ps.setString(3, arr[i].getMade());
					ps.setInt(4, arr[i].getPrice());
					ps.setInt(4, arr[i].getGaurentee());
					ps.executeUpdate();
				}
				System.out.println("Data inserted successfully..");
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		public static void update() {
			try {
	   	 Connection con=DBUtil.getConnection();
	   	 int id;
	   	 System.out.println("Enter the product id to update the price: ");
	   	 id=sc.nextInt();
	   	 System.out.println("Enter the price to be updated:");
	   	 int cost=sc.nextInt();
	   	 PreparedStatement ps=con.prepareStatement("update music_store set price=?where pid=?");
	   	 ps.setInt(1, cost);
	   	 ps.setInt(2, id);
	    int as=ps.executeUpdate();
	    if(as>0) {
	    	System.out.println("Completed");
	    }else {
	    	System.out.println("Invalid");
	    }
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		}
		public static void delete()throws SQLException,ClassNotFoundException, NumberFormatException, IOException {
			Connection con=DBUtil.getConnection();
			System.out.println("Enter the product id to be deleted: ");
			int id=sc.nextInt();
			PreparedStatement ps=con.prepareStatement("delete from music_store where pid=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		}
	public static void show()throws SQLException,ClassNotFoundException {
		Connection con=DBUtil.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from music_store");
		ResultSet rs=ps.executeQuery();
		System.out.println("\t\tMENU\t\t");
		System.out.println("\n");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+rs.getString(2)+rs.getInt(3)+rs.getDouble(4));	
		}rs.close();	
	}
	public static void drop()throws SQLException,ClassNotFoundException {
		Connection con=DBUtil.getConnection();
		PreparedStatement ps=con.prepareStatement("drop table music_store");
		ps.executeUpdate();
		System.out.println("Table dropped Successfully..");
	}
	public static double getPrice(int pid) {
		try {
		Connection con=DBUtil.getConnection();
		PreparedStatement ps=con.prepareStatement("select price from music_store where pid=?");
		ps.setInt(1, pid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
		double cost=rs.getDouble("cost");
		return cost;
	}else {
		throw new UserDefinedException("ERROR");
	}
		}catch(UserDefinedException x) {
			System.out.println(x.getMessage());
		}catch(Exception e) {
			System.out.println(e);
		}
		return pid;
	}
	}


