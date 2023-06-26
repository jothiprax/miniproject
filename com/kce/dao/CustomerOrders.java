package com.kce.dao;
import com.kce.bean.OrderedFoods;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class CustomerOrders {
     private String CustomerName;
     private List<OrderedFoods> OrderItems;
	public CustomerOrders(String customerName, List<OrderedFoods> orderItems) {
		super();
		CustomerName = customerName;
		OrderItems = orderItems;
	}
     
     public void DisplayOrders(){
    	 int i;
    	 for(i=0;i<OrderItems.size();i++)
    	 {
    		 System.out.println(OrderItems.get(i));
    	 }
     }
     
     
     
     public void addToOrders()
 	{
 		int i;
 		try {
 			Class.forName("com.mysql.jdbc.Driver");
 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
 			PreparedStatement pst = con.prepareStatement("insert into userorder values(?,?,?)");
 			for(i=0;i<OrderItems.size();i++)
 			{
 				pst.setString(1,OrderItems.get(i).getMenuItems().getName());
 				pst.setInt(2,OrderItems.get(i).getQuantity());
 				pst.setDouble(3,OrderItems.get(i).getTotalPrice());
 				pst.executeUpdate();
 			}
 			con.close();
 			
 		}catch(Exception e)
 		{
 			e.printStackTrace();
 		}
 	}
     
     
     
     
     public double TotalBillAmount() {
    	 double totalbillAmount=0;
    	 try {
    		Class.forName("com.mysql.jdbc.Driver");
 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
 			Statement stmt = con.createStatement();
 			ResultSet rs = stmt.executeQuery("select Price from project.userorder");
 			while(rs.next())
 			{
 				totalbillAmount+=(rs.getInt(1));
 			}
 			con.close();
    	 }catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
    	 return totalbillAmount;
     }
     
}
