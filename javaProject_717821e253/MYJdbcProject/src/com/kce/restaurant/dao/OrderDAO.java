package com.kce.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import com.kce.restaurant.bean.Orders;
import com.kce.restaurant.util.DBUtil;
import com.kce.restaurant.util.OutOfStockException;

public class OrderDAO 
{
  private final Connection con;
  
  public OrderDAO() {
	  con = DBUtil.getDBConnection();
  }
  public void Menu() {
	  try {
		String str = "select * from MenuItem" ;
	Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(str);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
		}
		
	  }catch(SQLException e) {
		  System.out.println(e);
	  }
  }
  public void insertOrders(Orders od) {
	  try {
          String query = "INSERT INTO orders (id, customer_name, order_name, quantity) VALUES (?, ?, ?, ?)";
          PreparedStatement ps = con.prepareStatement(query);
          ps.setInt(1, od.getId());
          
          ps.setString(2, od.getCustomerName());
          ps.setString(3, od.getOrderName());
          ps.setInt(4, od.getQuantity());
          

          ps.executeUpdate();
      }	 catch (SQLException e) {
          e.printStackTrace();
      }
  }
  
  public void updateOrders(Orders od) throws OutOfStockException{
	  try {
          String query = "UPDATE orders SET customer_name=?, order_name=?, quantity=? WHERE id=?";
          	PreparedStatement ps = con.prepareStatement(query);
          
          ps.setString(1, od.getCustomerName());
          	ps.setString(2, od.getOrderName());
          ps.setInt(3, od.getQuantity());
          ps.setInt(4, od.getId());

          int update = ps.executeUpdate();
          
          
          if (update == 0) {
              throw new OutOfStockException("Order not found with ID: " + od.getId());
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
  
  public void deleteOrders(int orderId) throws OutOfStockException{
	  try {
          	String query = "DELETE FROM orders WHERE id=?";
          PreparedStatement ps = con.prepareStatement(query);
          ps.setInt(1, orderId);

          int delete = ps.executeUpdate();
          if (delete == 0) {
              throw new OutOfStockException("Order not found with ID: " + orderId);
          }
          
          
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
  
  public List<Orders> displayOrders() {
      List<Orders> list = new ArrayList<>();
      try {
          String query = "SELECT * FROM orders";
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(query);

          while (rs.next()) {
              Orders od = new Orders();
              od.setId(rs.getInt(1));
              od.setCustomerName(rs.getString(2));
              od.setOrderName(rs.getString(3));
              od.setQuantity(rs.getInt(4));

              list.add(od);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return list;
}
  
}
