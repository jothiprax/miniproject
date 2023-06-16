package com.kce.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class DBUtil {
	public void ConnectiongetDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_ordering_system","root","AR@123nd");
			PreparedStatement ps1=con.prepareStatement("create table food_items(Dish_ID int,Dishes varchar(50),Price int);");
			ps1.execute();
			PreparedStatement ps5=con.prepareStatement("create table ordered_items(Dish_ID int,Dishes varchar(50),Quantity int);");
			ps5.execute();
			PreparedStatement ps8=con.prepareStatement("create table bill(Dish_ID int,Dishes varchar(50),Quantity int,Price int);");
			ps8.execute();
			if(con!=null) {
				System.out.println("Database Connected");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void CloseConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_ordering_system","root","AR@123nd");
			PreparedStatement ps13=con.prepareStatement("Drop table ordered_items");
			ps13.execute();
			PreparedStatement ps14=con.prepareStatement("Drop table bill");
			ps14.execute();
			PreparedStatement ps15=con.prepareStatement("Drop table food_items");
			ps15.execute();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
