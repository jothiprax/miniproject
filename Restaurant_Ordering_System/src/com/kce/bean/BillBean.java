package com.kce.bean;
import java.sql.*;
public class BillBean {
public void Bill() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_ordering_system","root","AR@123nd");
		PreparedStatement ps8=con.prepareStatement("Select * from ordered_items");
		ResultSet rs3=ps8.executeQuery();
		PreparedStatement ps6=con.prepareStatement("INSERT INTO bill(Dish_ID,Dishes,Quantity,Price) VALUES(?,?,?,?)");
		while(rs3.next()){
			int x=rs3.getInt("Dish_ID");
		    String y=rs3.getString("Dishes");
		    int z=rs3.getInt("Quantity");
		    PreparedStatement ps9=con.prepareStatement("Select Price from food_items WHERE Dish_Id = " + x);
			ResultSet rs4=ps9.executeQuery();
			int p=0;
			if(rs4.next()){
			p=rs4.getInt("Price");
			p=p*z;
			}
		    ps6.setInt(1,x);
			ps6.setString(2,y);
			ps6.setInt(3,z);
			ps6.setInt(4,p);
			ps6.executeUpdate();
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
public void displayBill() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_ordering_system","root","AR@123nd");
		PreparedStatement ps9=con.prepareStatement("Select * from bill ORDER BY Dish_ID");
		ResultSet rs=ps9.executeQuery();
		while(rs.next()) {
			System.out.printf("%-30d%-30s%-30d%-30d\n",rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
		}
		PreparedStatement ps10=con.prepareStatement("Select sum(Price) From bill");
		ResultSet rs5=ps10.executeQuery();
		if (rs5.next()) {
		    int sumValue = rs5.getInt(1);
		    System.out.println("GRAND TOTAL: " + sumValue);
		}
		PreparedStatement ps11=con.prepareStatement("Truncate table ordered_items");
		ps11.execute();
		PreparedStatement ps12=con.prepareStatement("Truncate table bill");
		ps12.execute();
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
}

