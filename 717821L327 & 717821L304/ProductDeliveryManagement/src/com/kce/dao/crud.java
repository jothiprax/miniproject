package com.kce.dao;

import com.kce.bean.Customer;
import com.kce.bean.Order;
import com.kce.bean.Product;
import com.kce.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class crud 
{
	    private DBUtil mycon;

	    public crud() 
	    {
	        mycon = new DBUtil();
	    }
     public void addOrder(Customer customer,Product product,Order order) throws SQLException 
	 {
	Connection con = mycon.getConnection();
		 String query = "INSERT INTO orders (customerid,customername,productid,productname,ordereddate,deliverydate,status) VALUES (?, ?, ?, ?, ?, ?, ?)";
		 try (PreparedStatement statement = con.prepareStatement(query)) 
	 	   { 
	            statement.setInt(1, customer.getCustomerid());
	            statement.setString(2, customer.getCustomername());
	            statement.setInt(3, product.getProductid());
	            statement.setString(4, product.getProductname());
	            statement.setString(5, order.getOrdereddate());
	            statement.setString(6, order.getDeliverydate());
	            statement.setString(7, order.getStatus());
	            statement.executeUpdate();
	           System.out.println("Order added in database successfully.");
	       }
	 }
     
	public void updateOrder(String status,int customerid) throws SQLException 
	 {
	 Connection con = mycon.getConnection();
	     String query = "UPDATE orders SET  status = ?  WHERE customerid = ?";
	     try (PreparedStatement statement = con.prepareStatement(query)) 
	     {
	            statement.setString(1, status);
	            statement.setInt(2, customerid);
	            statement.executeUpdate();
	            System.out.println("Status of Order in database successfully changed.");
	     }
	 }
	
	public void updateOrder(int customerid,String deliverydate) throws SQLException 
	 {
	 Connection con = mycon.getConnection();
	     String query = "UPDATE orders SET  deliverydate = ?  WHERE customerid = ?";
	     try (PreparedStatement statement = con.prepareStatement(query)) 
	     {
	            statement.setString(1, deliverydate);
	            statement.setInt(2, customerid );
	            statement.executeUpdate();
	            System.out.println("Delivery date of Order in database successfully changed.");
	     }
	 }
	
	 public void deleteOrder(String status) throws SQLException 
	 {
	 Connection con = mycon.getConnection();
	      String query = "DELETE FROM orders WHERE status = ?";
	      try (PreparedStatement statement = con.prepareStatement(query)) 
	      {
	         statement.setString(1,status);
	         statement.executeUpdate();
	         System.out.println("ORDER CANCELLED SUCCESSFULLY ");
	      }
	 }
	 
	 public void deleteOrder(int customerid) throws SQLException 
	 {
	 Connection con = mycon.getConnection();
	      String query = "DELETE FROM orders WHERE customerid = ?";
	      try (PreparedStatement statement = con.prepareStatement(query)) 
	      {
	    	  statement.setInt(1,customerid);
	         statement.executeUpdate();
	         System.out.println("ORDER CANCELLED SUCCESSFULLY ");
	      }
	 }
	 
	  public String getDetails(String status) throws SQLException 
	  {
		 Connection con = mycon.getConnection();
		   String query = "SELECT * FROM orders WHERE status = ? ";
		   try (PreparedStatement statement = con.prepareStatement(query)) 
		   {
		     statement.setString(1, status);
		     try (ResultSet rs = statement.executeQuery()) 
		     {
		      if (rs.next()) 
		      {
		    	  return "["+rs.getInt(1)+", "+rs.getString(2)+", "+rs.getInt(3)+", "+rs.getString(4)+", "+rs.getString(5)+", "+rs.getString(6)+", "+rs.getString(7)+"]";
		      }
		     }
		  }
		 return null;
	 }
	  
	 public String getDetails(int customerid) throws SQLException 
	 {
	 Connection con = mycon.getConnection();
	   String query = "SELECT * FROM orders WHERE customerid = ?";
	   try (PreparedStatement statement = con.prepareStatement(query)) 
	   {
	     statement.setInt(1, customerid);
	     try (ResultSet rs = statement.executeQuery()) 
	     {
	      if (rs.next()) 
	      {
	    	  return "["+rs.getInt(1)+", "+rs.getString(2)+", "+rs.getInt(3)+", "+rs.getString(4)+", "+rs.getString(5)+", "+rs.getString(6)+", "+rs.getString(7)+"]";
	      }
	     }
	   }
	 return null;
	 }
	 
	 public void getAllOrders() throws SQLException
	 {
	 Connection con = mycon.getConnection();
	     String query = "SELECT * FROM orders";
	 	System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "CUSTOMER ID", "CUSTOMER NAME", "PRODUCT ID", "PRODUCT NAME", 
	 			                                                                                           "ORDERED DATE", "DELIVERY DATE", "STATUS");
	 	System.out.println();
	     PreparedStatement statement = con.prepareStatement(query);
	     ResultSet rs = statement.executeQuery() ;
	     {
	 		while (rs.next()) 
			{
				System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n",rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)
						                                                                                 ,rs.getString(5),rs.getString(6),rs.getString(7));
			} 
	     }
     }
}
