package com.kce.dao;
import java.sql.*;
public class RestaurantUpdateDAO extends RestaurantDAO{
public void updateOrder1() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_ordering_system","root","AR@123nd");
		PreparedStatement pst=con.prepareStatement("UPDATE food_items SET Dishes='Meals',Price=65 WHERE Dish_ID=1");
		pst.executeUpdate();
		PreparedStatement pst1=con.prepareStatement("UPDATE food_items SET Dishes='Chicken Briyani',Price=80 WHERE Dish_ID=2");
		pst1.executeUpdate();
		PreparedStatement pst2=con.prepareStatement("UPDATE food_items SET Dishes='Mutton Briyani',Price=110 WHERE Dish_ID=3");
		pst2.executeUpdate();
		PreparedStatement pst3=con.prepareStatement("UPDATE food_items SET Dishes='Chicken Rice',Price=70 WHERE Dish_ID=4");
		pst3.executeUpdate();
		PreparedStatement pst4=con.prepareStatement("UPDATE food_items SET Dishes='Chicken Noodles',Price=75 WHERE Dish_ID=5");
		pst4.executeUpdate();
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
public void updateOrder2() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_ordering_system","root","AR@123nd");
		PreparedStatement pst5=con.prepareStatement("UPDATE food_items SET Dishes= ?,Price=25 WHERE Dish_ID=1");
		pst5.setString(1,s1);
		pst5.executeUpdate();
		PreparedStatement pst6=con.prepareStatement("UPDATE food_items SET Dishes= ?,Price=25 WHERE Dish_ID=2");
		pst6.setString(1,s2);
		pst6.executeUpdate();
		PreparedStatement pst7=con.prepareStatement("UPDATE food_items SET Dishes='Naan',Price=40 WHERE Dish_ID=3");
		pst7.executeUpdate();
		PreparedStatement pst8=con.prepareStatement("UPDATE food_items SET Dishes= ?,Price=30 WHERE Dish_ID=4");
		pst8.setString(1,s3);
		pst8.executeUpdate();
		PreparedStatement pst9=con.prepareStatement("UPDATE food_items SET Dishes='Omlet',Price=15 WHERE Dish_ID=5");
		pst9.executeUpdate();
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
}
