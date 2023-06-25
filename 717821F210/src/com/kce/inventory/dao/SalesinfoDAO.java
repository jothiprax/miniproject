package com.kce.inventory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kce.inventory.bean.SalesInfo;
import com.kce.inventory.util.DBconnection;

public class SalesinfoDAO {
	
	static PreparedStatement ps;
	static Connection c=DBconnection.getConnection();
	static ResultSet rs;
	
	public static boolean addSalesInfo(SalesInfo s) {
		try {
			ps=c.prepareStatement("select productid from Salesinfo");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getInt(1)==s.getProductId()) count++;
			}
			if(count==0) {
				ps=c.prepareStatement("insert into Salesinfo values(?,?,?,?)");
				ps.setInt(1,s.getProductId());
				ps.setString(2,s.getProductName());
				ps.setInt(3,s.getQuantity());
				ps.setInt(4, s.getTotalCost());
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
	public static boolean deleteSalesInfo(SalesInfo s) {
		try {
			ps=c.prepareStatement("select productid from Salesinfo");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getInt(1)==s.getProductId()) count++;
			}
			if(count==0) return false;
			else {
				ps=c.prepareStatement("delete from Salesinfo where productid=?");
				ps.setInt(1, s.getProductId());
				ps.execute();
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	public static boolean updateSalesQuantity(SalesInfo s) {
		try {
			ps=c.prepareStatement("select productid from Salesinfo");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getInt(1)==s.getProductId()) count++;
			}
			if(count==0) return false;
			else {
				ps=c.prepareStatement("update Salesinfo set quantity=? where productid=?");
				ps.setInt(1, s.getQuantity());
				ps.setInt(2, s.getProductId());
				ps.execute();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean updateSalesCost(SalesInfo s) {
		try {
			ps=c.prepareStatement("select productid from Salesinfo");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getInt(1)==s.getProductId()) count++;
			}
			if(count==0) return false;
			else {
				ps=c.prepareStatement("update Salesinfo set totalcost=? where productid=?");
				ps.setInt(1, s.getTotalCost());
				ps.setInt(2, s.getProductId());
				ps.execute();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static List<SalesInfo> viewAllSalesInfo() {
		List<SalesInfo> list=new ArrayList<>();
		try {
			ps=c.prepareStatement("select * from SalesInfo");
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new SalesInfo(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static SalesInfo viewOneSalesInfo(SalesInfo s) {
		SalesInfo sales=null;
		try {
			ps=c.prepareStatement("select * from Salesinfo where productid=?");
			ps.setInt(1,s.getProductId());
			rs=ps.executeQuery();
			while(rs.next()) {
				sales=new SalesInfo(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sales;
	}
}
