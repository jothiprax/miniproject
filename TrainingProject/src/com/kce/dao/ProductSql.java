package com.kce.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kce.DbUtil.ConnectToDB;
import com.kce.entity.Product;

public class ProductSql {
private Product p;
public ProductSql(Product p) {
	super(); 
	this.p = p;
}
public ProductSql() {
	// TODO Auto-generated constructor stub
}
public Product getP() {
	return p;
}
public void setP(Product p) {
	this.p = p;
}
public Product collectProductData(int id) {
	try {
Connection con=ConnectToDB.ConnectDB();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("Select * from Product where PId="+id+"");
Product p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
}
catch(SQLException e) {
	e.printStackTrace();
}
	return p;
}
public void AddProduct(Product p) {
	try {
		Connection con=ConnectToDB.ConnectDB();
		Statement stmt=con.createStatement();
		stmt.executeUpdate("insert into Product values("+p.getPId()+",'"+p.getPName()+"',"+p.getStock()+","+p.getPrice()+")");
		stmt.close();
		con.close();
}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
public void DisplayProduct() {
		try {
			Connection con=ConnectToDB.ConnectDB();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from Product order by CustomerName asc");
			System.out.println("DISPLAYING PRODUCTS");
			while(rs.next()) {
				System.out.println(""+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getDouble(4)+"");
			}
			rs.close();
			stmt.close();
			con.close();		
	}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}	
public void UpdatePrice(double price,int id) {
	try {
		Connection con=ConnectToDB.ConnectDB();
		Statement stmt=con.createStatement();
		stmt.executeUpdate("update Product set Price="+price+" where PId="+id+"");
		stmt.close();
		con.close();
}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
public void addStock(int bags,int id) {
	try {
		Connection con=ConnectToDB.ConnectDB();
		Statement stmt=con.createStatement();
		p.newLoad(bags);
		stmt.executeUpdate("update Product set Stock="+p.getStock()+" where PId="+id+"");
		stmt.close();
		con.close();
}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
}

