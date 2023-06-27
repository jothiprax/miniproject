package com.kce.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import com.kce.DbUtil.ConnectToDB;
import com.kce.entity.Customer;
import com.kce.entity.Product;

public class CustomerSql {
private static Customer c;
private Product p;
public CustomerSql() {
}
public Customer collectData(String name){
	try {
	Connection con=ConnectToDB.ConnectDB();
	Statement stmt = con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from Customer where CustomerName="+name+"");
		Customer c=new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(6));
		c.setOrderDate(rs.getDate(5));
		stmt=con.createStatement();
		rs=stmt.executeQuery("Select * from Product where PId="+c.getPId()+"");
		Product p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
		rs.close();
		stmt.close();
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return c;
}
public Product collectProductData(int id) {
	try {
Connection con=ConnectToDB.ConnectDB();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("Select * from Product where PId="+c.getPId()+"");
Product p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
rs.close();
stmt.close();
con.close();
}
catch(SQLException e) {
	e.printStackTrace();
}
	return p;
}

public void deleteCustomer(int id) {//deleting record 
	Connection con=ConnectToDB.ConnectDB();
	try {
    Statement stmt=con.createStatement();
   // ResultSet rs=stmt.executeQuery("Select * from Product where PId="+c.getPId()+"");
   // Product p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
    if(c.getPendingAmount()>0) {
    	System.out.println("THIS USER CAN'T BE DELECTED HAS A PENDING AMOUNT OF:"+c.getPendingAmount()+".");
    }
    else {
    stmt.executeUpdate("delete from Customer where CId="+id+"");
    System.out.println("CUSTOMER DELETED SUCCESSFULLY.");
}
    stmt.close();
    con.close();
	}
catch(SQLException e) {
	e.printStackTrace();
}
}
public void OrderUpdate(int quantity,int PId) {//updating after purchase
try {
	if(p.getStock()>quantity) {
	Connection con=ConnectToDB.ConnectDB();
	Statement stmt=con.createStatement();
	double PurchaseAmount=c.PurchaseAmount(p,quantity);
	c.setPendingAmount(PurchaseAmount,1);
	p.AfterPurchase(quantity);
	stmt.executeUpdate("update Customer set PendingAmount="+c.getPendingAmount()+" where CustomerName="+c.getCustomerName()+"");
	stmt.executeUpdate("update Customer set PId="+p.getPId()+" where CustomerName="+c.getCustomerName()+"");
	stmt.close();
	con.close();
	System.out.println("order placed");
	System.out.println("Ledger Updated");
	}
	else {
		System.out.println("NOT ENOUGH STOCK TO PLACE THE ORDER");
	}
}
catch(SQLException e) {
	e.printStackTrace();
}
}
public void addNewCustomer(Customer C) {//inserting new record
	try {
		Connection con=ConnectToDB.ConnectDB();
		Statement stmt=con.createStatement();
		c.setOrderDate1();
		stmt.executeUpdate("insert into Customer values("+c.getCId()+",'"+c.getCustomerName()+"',"+c.getContactNumber()+","+c.getPendingAmount()+",'"+c.getOrderDate()+"',"+c.getPId()+"");
		System.out.println("Customer Added");
		stmt.close();
		con.close();
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
public void DisplayLedger() {
	try {
		Connection con=ConnectToDB.ConnectDB();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from Customers order by CustomerName asc");
		System.out.println("DISPLAYING RECORDS");
		while(rs.next()) {
			System.out.println(""+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getDouble(4)+"  "+rs.getDate(5)+" "+rs.getInt(6)+"");
		}
		rs.close();
		stmt.close();
		con.close();		
}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
public static void TodayOrders() {
	try {
		Connection con=ConnectToDB.ConnectDB();
		Statement stmt=con.createStatement();
		System.out.println("Today's Orders");
		ResultSet rs=stmt.executeQuery("Select * from Customer where OrderDate=sysdate");
		while(rs.next()) {
			System.out.println(""+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getDouble(4)+"  "+rs.getDate(5)+" "+rs.getInt(6)+"");
		}
		rs.close();
		stmt.close();
		con.close();	
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
public void madePayment(double Amount) {
	try {
		Connection con=ConnectToDB.ConnectDB();
		Statement stmt=con.createStatement();
		c.setPendingAmount(Amount, 2);
		stmt.executeUpdate("update Customer set PendingAmount="+c.getPendingAmount()+" where CId="+c.getCId()+"");
		System.out.println("Made Payment and Ledger updated");
		stmt.close();
		con.close();
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
public Customer getCustomer() {
	return c;
}
public void setCustomer(Customer c) {
	this.c = c;
}
public Product getP() {
	return p;
}
public void setP(Product p) {
	this.p = p;
}
}
