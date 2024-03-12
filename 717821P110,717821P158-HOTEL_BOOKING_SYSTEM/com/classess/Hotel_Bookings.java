package com.classess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.*;
import java.sql.*;

public class Hotel_Bookings extends Details{
	public Hotel_Bookings(int id,String fname,String lname,int age,long phone_no,long aadhar,String address,int no_persons,int no_rooms,String room)
	{
		super(id,fname,lname,age,phone_no,aadhar,address,no_persons,no_rooms,room);
	}
	public String customer_details() {
	    return "\nCustomer id: "+id+"\nCustomer Name: "+fname+" "+lname+"\nCustomer Age: "+age+"\nCustomer mobile number: "+phone_no+"\nCustomer Address: "+address+"\nNumber of rooms needed: "+no_rooms;
	}
public static void main(String[]args) throws SQLException {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter ID:");
	int id=sc.nextInt();
	System.out.println("Enter First Name:");
	String fname=sc.next();
	sc. nextLine();
	System.out.println("Enter Last Name: ");
	String lname=sc.next();
	sc.nextLine();
    System.out.println("Enter age: ");
	int age=sc.nextInt();
	System.out.println("Enter mobile number: ");
	long phone_no=sc.nextLong();
	System.out.println("Enter aadhar number: ");
	long aadhar=sc.nextLong();
	System.out.println("Enter address: ");
	String address=sc.next();
	sc.nextLine();
	System.out.println("Enter no_of_persons: ");
	int no_persons=sc.nextInt();
	System.out.println("Enter no_of_rooms needed: ");
	int no_rooms=sc.nextInt();
	sc. nextLine();
	System.out.println("Enter room: ");
	String room=sc.next();
	Hotel_Bookings s=new Hotel_Bookings(id,fname,lname,age,phone_no,aadhar,address,no_persons,no_rooms,room);
	ResultSet rs;
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vk_hotelbookings","root","Dream8");
	Statement stmt=con.createStatement();
	int count=0;
	rs=stmt.executeQuery("select sum(rooms_required) from room_details");
	while(rs.next()) {
		int c=rs.getInt(1);
		count+=c;
	}
	try {
		if(count==50) {
			throw new RoomNotAvailibleException();
		}
		else if(no_rooms>(50-count)) {
			throw new OverBookingException();
		}
		else {
			PreparedStatement ps=con.prepareStatement("insert into customer_details values(?,?,?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2,fname);
			ps.setString(3,lname);
			ps.setInt(4,age);
			ps.setLong(5, phone_no);
			ps.setLong(6, aadhar);
			ps.setString(7,address);
			ps.execute();
			ps=con.prepareStatement("insert into room_details values(?,?,?,?)");
			ps.setInt(1, id);
			ps.setInt(2, no_persons);
			ps.setInt(3, no_rooms);
			ps.setString(4,room);
			ps.execute();
			System.out.println(s.customer_details());
			System.out.println("\n***-----------------------------------------------------------------------------------------------------------------------***\nRoom booked.\nHave a pleasent stay!");
			
			
		}
	}
	catch(RoomNotAvailibleException e) {
		System.out.println();
	}
	catch(OverBookingException e) {
		System.out.println("We are sorry to inform you that, we do not have the quantity of rooms you required!!");
	}
}
}

 