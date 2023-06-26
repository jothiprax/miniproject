package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kce.bean.Restaurant;
import com.kce.util.DBUtil;
//import com.kce.bean.Restaurant;

 class RestaurantDAO extends Restaurant{
	double tp1;
	double tp2;
	double tp3;
	private static Connection con;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

    
    public RestaurantDAO(String name, double price, int quantity) {
		super(name, price, quantity);
	}
    
    public void createTable() {
    	try {
    	DBUtil util=new DBUtil();
        Connection con = util.getConnection();
        Statement stmt=con.createStatement();
    
    stmt.execute("create table Menu(Items varchar(255), price number(40))");
    stmt.executeUpdate("insert into Menu values('Chicken Soup',120.0)");
    stmt.executeUpdate("insert into Menu values('Chilli Chicken',150.0)");
    stmt.executeUpdate("insert into Menu values('Fried Chicken',130.0)");
    stmt.executeUpdate("insert into Menu values('Mutton Kebab',220.0)");
    stmt.executeUpdate("insert into Menu values('Prawn Chilli',300.0)");
    stmt.executeUpdate("insert into Menu values('Chicken Briyani',165.0)");
    stmt.executeUpdate("insert into Menu values('Prawn Briyani',260.0)");
    stmt.executeUpdate("insert into Menu values('Parotta',50.0)");
    stmt.executeUpdate("insert into Menu values('Butter Naan',90.0)");
    stmt.executeUpdate("insert into Menu values('Mutton Briyani',200.0)");
    stmt.executeUpdate("insert into Menu values('Vanilla IceCream',90.0)");
    stmt.executeUpdate("insert into Menu values('Oreo Milkshake',120.0)");
    stmt.executeUpdate("insert into Menu values('Rose Milk',80.0)");
    stmt.executeUpdate("insert into Menu values('Rasamalai',100.0)");
    stmt.executeUpdate("insert into Menu values('Lime Soda',60.0)");
    }
    	catch(Exception e) {
    		System.out.println("Could'nt insert table");
    	}
    }

	public void Starters(String name,int quantity) {
		try {
		DBUtil util=new DBUtil();
        Connection con = util.getConnection();
        Statement stmt=con.createStatement();
    	ResultSet result = stmt.executeQuery("select * from Menu where Items="+name);
    	Restaurant rest = new Restaurant(name,result.getInt(2),quantity);
    	tp1 = rest.getTotalPrice() ;
    	System.out.println(name+" "+tp1);
		}
		catch(SQLException e) {
			System.out.println("Order not available");
		}
		
    }
    
    public void MainCourse(String name,int quantity) {
    	try {
    	DBUtil util=new DBUtil();
        Connection con = util.getConnection();
        Statement stmt=con.createStatement();
    	ResultSet result = stmt.executeQuery("select * from Menu where Items="+name);
    	Restaurant rest = new Restaurant(name,result.getInt(2),quantity);
    	tp2 = rest.getTotalPrice() ;
    	System.out.println(name+" "+tp2);
    	}
    	catch(SQLException e) {
			System.out.println("Order not available");
		}
    }
    
    public void Desserts(String name,int quantity) {
    	try {
    	DBUtil util=new DBUtil();
        Connection con = util.getConnection();
        Statement stmt=con.createStatement();
    	ResultSet result = stmt.executeQuery("select * from Menu where Items="+name);
    	Restaurant rest = new Restaurant(name,result.getInt(2),quantity);
    	tp3 = rest.getTotalPrice();
    	System.out.println(name+" "+tp3);
    	}
    	catch(SQLException e) {
			System.out.println("Order not available");
		}
    }
    
    public void TotalAmount(){
		System.out.println("Order Total : "+(tp1+tp2+tp3));
    }

}
