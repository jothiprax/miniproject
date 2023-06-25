package com.kce.inventory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kce.inventory.bean.Stock;
import com.kce.inventory.util.DBconnection;

public class StockDAO {
	
	static PreparedStatement ps;
	static Connection c=DBconnection.getConnection();
	static ResultSet rs;
	
	public static boolean addStock(Stock s) {
		try {
			ps=c.prepareStatement("select productname from Stock");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getString(1).equals(s.getProductName())) count++;
			}
			if(count==0) {
				ps=c.prepareStatement("insert into Stock values(?,?)");
				ps.setString(1,s.getProductName());
				ps.setInt(2,s.getQuantity());
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
	public static boolean deleteStock(Stock s) {
		try {
			ps=c.prepareStatement("select productname from Stock");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getString(1).equals(s.getProductName())) count++;
			}
			if(count==0) return false;
			else {
				ps=c.prepareStatement("delete from Stock where productname=?");
				ps.setString(1, s.getProductName());
				ps.execute();
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	public static boolean updateQuantity(Stock s) {
		try {
			ps=c.prepareStatement("select productname from Stock");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getString(1).equals(s.getProductName())) count++;
			}
			if(count==0) return false;
			else {
				ps=c.prepareStatement("update Stock set quantity=? where productname=?");
				ps.setInt(1, s.getQuantity());
				ps.setString(2, s.getProductName());
				ps.execute();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static List<Stock> viewAllStock() {
		List<Stock> list=new ArrayList<>();
		try {
			ps=c.prepareStatement("select * from Stock");
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Stock(rs.getString(1),rs.getInt(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static Stock viewOneStock(Stock s) {
		Stock stock=null;
		try {
			ps=c.prepareStatement("select * from stock where productname=?");
			ps.setString(1,s.getProductName());
			rs=ps.executeQuery();
			while(rs.next()) {
				stock=new Stock(rs.getString(1),rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stock;
	}
}
