package com.kce.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import db.format.*;

public class HotelDatabase {
	public static Scanner in=new Scanner(System.in);

	                       //VIEW DATABASE
	public static void ViewDatabase() {
		System.out.println("CUSTOMER DETAILS:");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Dhesigan123@kkm");
			Statement stmt=con.createStatement();
			DBTablePrinter.printTable(con, "rooms");
			/*ResultSet rs=stmt.executeQuery("select * from rooms");
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
			}*/
}
		catch(Exception a) {
		System.out.println(a.toString());}
}
	
	
	                      //INSERT DATA INTO DATABASE
	public static void InsertData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Dhesigan123@kkm");
			Statement stmt=con.createStatement();
			int Roomno=0;
			ResultSet rs=stmt.executeQuery("select * from rooms");
			while(rs.next()) {
				Roomno++;
			}
		
		System.out.print("ENTER YOUR NAME:");
		String name=in.nextLine();
		System.out.print("ENTER YOUR PHONE NUMBER:");
		String number=in.nextLine();
		System.out.print("ENTER YOUR ADDRESS:");
		String Address=in.nextLine();
		System.out.println("THERE IS TWO TYPE OF ROOMS:");
		System.out.println("     =>SINGLE BEDROOM");
		System.out.println("     =>DOUBLE BEDROOM");
		System.out.print("ENTER THE ROOM TYPE YOU WANT:");
		String Room_type=in.nextLine();
		System.out.print("ENTER THE NO OF DAYS:");
		int Days=in.nextInt();
		int cost=0;
		if(Room_type.toLowerCase().equals("single")){
			cost=Days*1500;}
		if(Room_type.toLowerCase().equals("double")) {
			cost=Days*2500;
		}
		String sql="insert into rooms(Room_no,User_name,Phone,Address,Room_Type,Days,Cost) values(?,?,?,?,?,?,?)";
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		Roomno++;
		preparedstatement.setInt(1, Roomno);
		preparedstatement.setString(2, name);
		preparedstatement.setString(3, number);
		preparedstatement.setString(4, Address);
		preparedstatement.setString(5, Room_type);
		preparedstatement.setInt(6, Days);
		preparedstatement.setInt(7, cost);
		int rows=preparedstatement.executeUpdate();
		if(rows>0) {
			System.out.println("YOUR DATA STORED SUCCESSFULLY!!");
		}
	}
	catch(Exception a) {
		System.out.println(a.toString());}
}

}


