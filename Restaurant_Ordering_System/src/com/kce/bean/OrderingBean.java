package com.kce.bean;
import com.kce.util.*;
import com.kce.service.*;
import java.sql.*;
import java.util.*;
public class OrderingBean {
	public static int xx=0;
public void foodOrders() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_ordering_system","root","AR@123nd");
	Scanner sc=new Scanner(System.in);
	boolean b=true;
	while(b){
		int count=0;
		String dish=sc.nextLine();
		if(dish.contains("BUY NOW")) {
			break;
		}
		int q=sc.nextInt();sc.nextLine();
		PreparedStatement ps4=con.prepareStatement("Select * from food_items");
		ResultSet rs1=ps4.executeQuery();
		PreparedStatement ps6=con.prepareStatement("INSERT INTO ordered_items(Dish_ID,Dishes,Quantity) VALUES(?,?,?)");
		while(rs1.next()){
			    int x=rs1.getInt("Dish_ID");
			    String y=rs1.getString("Dishes");
			        if(y.equals(dish)){
			        	count++;
				 		ps6.setInt(1,x);
						ps6.setString(2,y);
						ps6.setInt(3,q);
						ps6.executeUpdate();
			         }
			}
		if(count==0){
			throw new DishOutOfStockException("Dish Out OF Stock");
		}
		}
	}
	catch(Exception e) {
		System.out.println(e);
		xx=1;
	}
}
public void displayOrder() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_ordering_system","root","AR@123nd");
		PreparedStatement ps7=con.prepareStatement("Select * from ordered_items ORDER BY Dish_ID");
		ResultSet rs=ps7.executeQuery();
		while(rs.next()) {
			System.out.printf("%-30d%-30s%-30d\n",rs.getInt(1),rs.getString(2),rs.getInt(3));
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
}
