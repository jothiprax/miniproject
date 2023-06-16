package com.kce.dao;
import java.sql.*;

public class RestaurantDAO{
	String s1="Dosa";
	String s2="Parotta";
	String s3="Chapati";
	String s4="Egg gravy";
	String s5="Chicken gravy";
	String s6="Mutton gravy";
public void createRestaurant() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_ordering_system","root","AR@123nd");
		PreparedStatement ps2=con.prepareStatement("INSERT INTO food_items(Dish_ID,Dishes,Price) VALUES(?,?,?)");
		ps2.setInt(1,1);
		ps2.setString(2,"Idli");
		ps2.setInt(3,20);
		ps2.executeUpdate();
		ps2.setInt(1,2);
		ps2.setString(2,s1);
		ps2.setInt(3,25);
		ps2.executeUpdate();
		ps2.setInt(1,3);
		ps2.setString(2,"Poori");
		ps2.setInt(3,40);
		ps2.executeUpdate();
		ps2.setInt(1,4);
		ps2.setString(2,s2);
		ps2.setInt(3,25);
		ps2.executeUpdate();
		ps2.setInt(1,5);
		ps2.setString(2,s3);
		ps2.setInt(3,30);
		ps2.executeUpdate();
		ps2.setInt(1,6);
		ps2.setString(2,s4);
		ps2.setInt(3,60);
		ps2.executeUpdate();
		ps2.setInt(1,7);
		ps2.setString(2,s5);
		ps2.setInt(3,70);
		ps2.executeUpdate();
		ps2.setInt(1,8);
		ps2.setString(2,s6);
		ps2.setInt(3,80);
		ps2.executeUpdate();	
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
public void displayMenu() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_ordering_system","root","AR@123nd");
		PreparedStatement ps3=con.prepareStatement("Select * from food_items");
		ResultSet rs=ps3.executeQuery();
		while(rs.next()) {
			System.out.printf("%-30d%-30s%-30d\n",rs.getInt(1),rs.getString(2),rs.getInt(3));
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
}
