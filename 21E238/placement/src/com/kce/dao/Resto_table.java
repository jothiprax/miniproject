package com.kce.dao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

import com.kce.bean.MenuDetails;
import com.kce.util.DBUtil;
class MyException extends Exception{//user defined exception
	public MyException(String s) {
		super(s);
	}
}
public class Resto_table {//class contains the database related operation
	public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void insert(int a) {//insert record in a table
		try {
			MenuDetails[]arr=new MenuDetails[a];
			for(int i=0;i<a;i++) {
				System.out.println("Enter the product id: ");
				int pid=Integer.parseInt(br.readLine());
				System.out.println("Enter the Dish Name: ");
				String dish=br.readLine();
				System.out.println("Enter the rating of dish: ");
				int rating=Integer.parseInt(br.readLine());
				System.out.println("Enter the price: ");
				Double price=Double.parseDouble(br.readLine());
				
				arr[i]=new MenuDetails(pid,dish,rating,price);
			}
			Connection con=DBUtil.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into menu values(?,?,?,?)");
			for(int i=0;i<a;i++) {
				ps.setInt(1, arr[i].getPid());
				ps.setString(2, arr[i].getDish());
				ps.setInt(3, arr[i].getRating());
				ps.setDouble(4, arr[i].getPrice());
				ps.executeUpdate();
			}
			System.out.println("Data inserted successfully..");
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void update() {//method to update record in a table
		try {
   	 Connection con=DBUtil.getConnection();
   	 int id;
   	 System.out.println("Enter the product id to update the price: ");
   	 id=Integer.parseInt(br.readLine());
   	 System.out.println("Enter the price to be updated:");
   	 Double cost=Double.parseDouble(br.readLine());
   	 PreparedStatement ps=con.prepareStatement("update menu set price=?where pid=?");
   	 ps.setDouble(1, cost);
   	 ps.setInt(2, id);
    int updated=ps.executeUpdate();
    if(updated>0) {
    	System.out.println("Updated..");
    }else {
    	System.out.println("Invalid input");
    }
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}
	public static void delete()throws SQLException,ClassNotFoundException, NumberFormatException, IOException {//method to delete record in a table
		Connection con=DBUtil.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from menu where pid=?");
		System.out.println("Enter the product id to be deleted: ");
		int id=Integer.parseInt(br.readLine());
		ps.setInt(1, id);
		ps.executeUpdate();
	}
public static void show()throws SQLException,ClassNotFoundException {//method to display data
	Connection con=DBUtil.getConnection();
	PreparedStatement ps=con.prepareStatement("select * from menu");
	ResultSet rs=ps.executeQuery();
	System.out.println("\t\tMENU\t\t");
	System.out.println("\n");
	
	while(rs.next()) {
		System.out.println(rs.getInt(1)+rs.getString(2)+rs.getInt(3)+rs.getDouble(4));	
	}rs.close();	
}
public static double getPrice(int pid) {//method to get price of the product
	try {
	Connection con=DBUtil.getConnection();
	PreparedStatement ps=con.prepareStatement("select price from menu where pid=?");
	ps.setInt(1, pid);
	ResultSet rs=ps.executeQuery();
	if(rs.next()) {
	double cost=rs.getDouble("price");
	return cost;
	//return pid;
}else {
	throw new MyException("No suitable data found");
}
	}catch(MyException ex) {
		System.out.println(ex.getMessage());
	}catch(Exception e) {
		System.out.println(e);
	}
	return pid;
}
}