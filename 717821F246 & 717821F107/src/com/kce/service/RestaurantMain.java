package com.kce.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.kce.bean.Restaurant;


//import com.kce.dao.DBUtil;
//import com.kce.dao.Restaurant;
//import com.kce.dao.RestaurantDAO;

public class RestaurantMain extends Restaurant{
	
	public RestaurantMain(String name, double price, int quantity) {
		super(name, price, quantity);
	}


	String name;
    double price;
    int quantity;
    double totalPrice;
    static double tp1;
	static double tp2;
	static double tp3;

	public static void createTable() {
    	try {
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
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
    		System.out.println("Could'nt create table!");
    }
}
	
	public static void displayMenu() {
		System.out.println("--------------MENU--------------");
		System.out.println("-----Starters-----");
		System.out.println("1.Chicken Soup         120.0");
		System.out.println("2.Chilli Chicken       150.0");
		System.out.println("3.Fried Chicken        130.0");
		System.out.println("4.Mutton Kebab         220.0");
		System.out.println("5.Prawn Chilli         300.0");
		System.out.println("-----Main Course-----");
		System.out.println("1.Chicken Briyani      165.0");
		System.out.println("2.Prawn Briyani        260.0");
		System.out.println("3.Butter Naan (2 Nos)  50.0");
		System.out.println("4.Parotta (2 Nos)      90.0");
		System.out.println("5.Mutton Briyani       200.0");
		System.out.println("-----Desserts-----");
		System.out.println("1.Vanilla Ice Cream    90.0");
		System.out.println("2.Oreo Milkshake       120.0");
		System.out.println("3.Rose Milk            80.0");
		System.out.println("4.Rasamalai            100.0");
		System.out.println("5.Lime Soda            60.0");
		System.out.println("-------------------------------");
	}
	
	public static void Starters(String name,int quantity) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
        Statement stmt=con.createStatement();
    	ResultSet result = stmt.executeQuery("select * from Menu where Items='"+name+"'");
    	while(result.next()) {
    	Restaurant rest = new Restaurant(name,result.getDouble(2),quantity);
		tp1 = rest.getTotalPrice();
    	}
		System.out.println(name+" "+tp1);
		}
	    catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void MainCourse(String name,int quantity) {
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
        Statement stmt=con.createStatement();
    	ResultSet result = stmt.executeQuery("select * from Menu where Items='"+name+"'");
    	while(result.next()) {
    	Restaurant rest = new Restaurant(name,result.getDouble(2),quantity);
    	tp2 = rest.getTotalPrice() ;
    	}
    	System.out.println(name+" "+tp2);
    	}
    	catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void Desserts(String name,int quantity) {
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
        Statement stmt=con.createStatement();
    	ResultSet result = stmt.executeQuery("select * from Menu where Items='"+name+"'");
    	while(result.next()) {
    	Restaurant rest = new Restaurant(name,result.getDouble(2),quantity);
    	tp3 = rest.getTotalPrice();
    	}
    	System.out.println(name+" "+tp3);
    	} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public static void TotalAmount(){
		System.out.println("Order Total : "+(tp1+tp2+tp3));
    }


	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//RestaurantMain.createTable();
		RestaurantMain.displayMenu();
		System.out.println("Enter Your Order and Quantity : ");
		String name1 = sc.nextLine();
		//sc.nextLine();
		int quantity1 = sc.nextInt();
		String name2 = sc.nextLine();
		sc.nextLine();
		int quantity2 = sc.nextInt();
		String name3 = sc.nextLine();
		sc.nextLine();
		int quantity3 = sc.nextInt();
		RestaurantMain.Starters(name1,quantity1);
		RestaurantMain.MainCourse(name2,quantity2);
		RestaurantMain.Desserts(name3,quantity3);
		RestaurantMain.TotalAmount();
	}

}
