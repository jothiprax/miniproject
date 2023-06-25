package com.kce.inventory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kce.inventory.bean.Customer;
import com.kce.inventory.util.DBconnection;

public class CustomerDAO {
	
	static PreparedStatement ps;
	static Connection c=DBconnection.getConnection();
	static ResultSet rs;
	
	public static boolean addCustomer(Customer cus) {
		try {
			ps=c.prepareStatement("select customerid from Customer");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getInt(1)==cus.getCustomerId()) count++;
			}
			if(count==0) {
				ps=c.prepareStatement("insert into Customer values(?,?,?,?)");
				ps.setInt(1, cus.getCustomerId());
				ps.setString(2, cus.getCustomerName());
				ps.setString(3, cus.getLocation());
				ps.setLong(4, cus.getNumber());
				ps.execute();
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean deleteCustomer(Customer cus) {
		try {
			ps=c.prepareStatement("select customerid from Customer");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getInt(1)==cus.getCustomerId()) count++;
			}
			if(count==0) return false;
			else {
				ps=c.prepareStatement("delete from Customer where customerid=?");
				ps.setInt(1, cus.getCustomerId());
				ps.execute();
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	public static boolean updateCustomerLocation(Customer cus) {
		try {
			ps=c.prepareStatement("select customerid from Customer");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getInt(1)==cus.getCustomerId()) count++;
			}
			if(count==0) return false;
			else {
				ps=c.prepareStatement("update Customer set location=? where customerid=?");
				ps.setString(1, cus.getLocation());
				ps.setInt(2, cus.getCustomerId());
				ps.execute();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean updateCustomerNumber(Customer cus) {
		try {
			ps=c.prepareStatement("select customerid from Customer");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getInt(1)==cus.getCustomerId()) count++;
			}
			if(count==0) return false;
			else {
				ps=c.prepareStatement("update Customer set number=? where customerid=?");
				ps.setLong(1, cus.getNumber());
				ps.setInt(2, cus.getCustomerId());
				ps.execute();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static List<Customer> viewAllCustomer() {
		List<Customer> list=new ArrayList<>();
		try {
			ps=c.prepareStatement("select * from Customer");
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static Customer viewOneCustomer(Customer cus) {
		Customer customer=null;
		try {
			ps=c.prepareStatement("select * from customer where customerid=?");
			ps.setInt(1, cus.getCustomerId());
			rs=ps.executeQuery();
			while(rs.next()) {
				customer=new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
}
