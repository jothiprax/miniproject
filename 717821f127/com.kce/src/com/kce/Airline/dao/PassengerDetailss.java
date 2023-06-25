package com.kce.Airline.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.kce.Airline.bean.*;
import com.kce.util.DBUtil;
public class PassengerDetailss extends Thread {
public static void insertPassengerDetails() {
		
		Scanner sc = new Scanner(System.in);
		try {
			AirlinePassengersDetails[] arr1 = new AirlinePassengersDetails[1];
		for (int i = 0; i < 1; i++) {
		System.out.println("Enter FullName : ");
		String Name = sc.next();
		
		System.out.println("Enter Age: ");
		int age = sc.nextInt();
		
		System.out.println("Enter Gender: ");
		String Gender = sc.next();
		
		System.out.println("Enter ContactNumber: ");
		String Number = sc.next();
		
		System.out.println("Enter the Address: ");
		String address=sc.next();
		
		System.out.println("Enter Required AirlineNo: ");
		int Airlineno = sc.nextInt();
		
		System.out.println("Enter the date: ");
		String date=sc.next();
		
		System.out.println("Enter your aadharNumber: ");
		String aadhar = sc.next();
		
		arr1[i] = new AirlinePassengersDetails(Name,age,Gender,Number,address,Airlineno,date,aadhar);
		}
		
		
		Connection con = DBUtil.getConnection();
		PreparedStatement stmt = con.prepareStatement("insert into AirlinePassenger values(?,?,?,?,?,?,?,?)");
		for (int i = 0; i < 1; i++) {
		stmt.setString(1, arr1[i]. getName());
		stmt.setInt(2, arr1[i].getAge());
		stmt.setString(3, arr1[i].getGender());
		stmt.setString(4, arr1[i].getMoblieNumber());
		stmt.setString(5, arr1[i].getAddress());
		stmt.setInt(6, arr1[i].getAirlineNo());
		stmt.setString(7, arr1[i].getDate());
		stmt.setString(8, arr1[i].getAadharNumber());
		
		stmt.executeUpdate();
		}
		//System.out.println("Data collected successfully");
		
		}catch(SQLException e) {
	     System.out.println(e);
	
	}

}
public void displayPassengerTable() {
	try {
	Connection con = DBUtil.getConnection();
	PreparedStatement stmt = con.prepareStatement("SELECT * FROM AirlinePassenger");
	ResultSet rs = stmt.executeQuery();

	System.out.println("Passenger Details:");
	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
	System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "Name", "Age", "Gender","MoblieNumber","Address","AirlineNo","Date","AadharNumber");

	while (rs.next()) {

	System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n",rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8));
	}

	rs.close();
	} catch (SQLException e) {
	System.out.println("Error: " + e.getMessage());
	}
}
public void payment(int count) {
	
	System.out.println("Total amount is :"+count*5000);
	
	
}
public void delete() {
	try {
	Connection con=DBUtil.getConnection();
	   
	   
	   PreparedStatement stmt=con.prepareStatement("delete from AirlinePassenger ");
	   
	   
	   stmt.executeUpdate();
	   
	   
	  
	   //System.out.println("Details Deleted Successfully");
	   
	   
}
	catch(SQLException e) {
		e.printStackTrace();
	}

}

public void permission(int count) {
	
	
	System.out.println();
	System.out.println();
	System.out.println();
	
	System.out.println("Proceed Payment method: ");
	System.out.println("1.credit card");
	System.out.println("2.debit card");
	System.out.println("3.UPI");
	System.out.println();
	Scanner sc=new Scanner(System.in);
	int num=sc.nextInt();
	System.out.println("Total amount is :"+count*5000);
	System.out.println("Payment completed successfully...");
}

		
	
public void paymentdetails(int count) {
	try {
		Connection con = DBUtil.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT Name FROM AirlinePassenger");
		ResultSet rs = stmt.executeQuery();
		System.out.println();
		System.out.println();
		System.out.println("Payment Details:");
	System.out.println("------------------------------------------");
	
	System.out.printf("| %-20s | %-20s |%n","PassengerName","Total");
	while (rs.next()) {
	System.out.printf("| %-20s | %-20s |%n",rs.getString(1),"5000");
	}
	System.out.println();
	System.out.printf("| %-20s | %-20s |%n","TotalAmount: ",count*5000);
	
}catch(Exception e) {
	System.out.println(e);
}
}

}

