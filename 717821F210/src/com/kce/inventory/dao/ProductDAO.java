package com.kce.inventory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kce.inventory.bean.Product;
import com.kce.inventory.util.DBconnection;

public class ProductDAO {
	
	static PreparedStatement ps;
	static Connection c=DBconnection.getConnection();
	static ResultSet rs;
	
	public static boolean addProduct(Product p) {
		try {
			ps=c.prepareStatement("select productid from Product");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getInt(1)==p.getProductId()) count++;
			}
			if(count==0) {
				ps=c.prepareStatement("insert into Product values(?,?,?,?,?)");
				ps.setInt(1, p.getProductId());
				ps.setString(2, p.getProductCode());
				ps.setString(3, p.getProductName());
				ps.setInt(4, p.getCostPrice());
				ps.setInt(5, p.getSellPrice());
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
	public static boolean deleteProduct(Product p) {
		try {
			ps=c.prepareStatement("select productid from Product");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getInt(1)==p.getProductId()) count++;
			}
			if(count==0) return false;
			else {
				ps=c.prepareStatement("delete from product where productid=?");
				ps.setInt(1, p.getProductId());
				ps.execute();
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	public static boolean updateProductCostPrice(Product p) {
		try {
			ps=c.prepareStatement("select productid from product");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getInt(1)==p.getProductId()) count++;
			}
			if(count==0) return false;
			else {
				ps=c.prepareStatement("update Product set costprice=? where productid=?");
				ps.setInt(1, p.getCostPrice());
				ps.setInt(2, p.getProductId());
				ps.execute();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean updateProductSellPrice(Product p) {
		try {
			ps=c.prepareStatement("select productid from product");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getInt(1)==p.getProductId()) count++;
			}
			if(count==0) return false;
			else {
				ps=c.prepareStatement("update Product set sellprice=? where productid=?");
				ps.setInt(1, p.getSellPrice());
				ps.setInt(2, p.getProductId());
				ps.execute();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static List<Product> viewAllProduct() {
		List<Product> list=new ArrayList<>();
		try {
			ps=c.prepareStatement("select * from Product");
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static Product viewOneProduct(Product p) {
		Product product=null;
		try {
			ps=c.prepareStatement("select * from Product where productid=?");
			ps.setInt(1,p.getProductId());
			rs=ps.executeQuery();
			while(rs.next()) {
				product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
}
