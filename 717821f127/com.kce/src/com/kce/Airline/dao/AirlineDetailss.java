package com.kce.Airline.dao;
import com.kce.Airline.bean.AirlineSystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;
import com.kce.Airline.bean.AirlineSystem;

import com.kce.util.DBUtil;
public class AirlineDetailss {
	//Scanner sc = new Scanner(System.in);

	public static void insert(int a) {
		
		Scanner sc = new Scanner(System.in);
		try {
			AirlineSystem[] arr1 = new AirlineSystem[a];
		for (int i = 0; i < a; i++) {
		System.out.println("Enter Airlineno id: ");
		int AirlineNo = sc.nextInt();
		
		System.out.println("Enter the source: ");
		String source = sc.next();
		
		System.out.println("Enter the destination: ");
		String destination = sc.next();
		
		System.out.println("Enter the Date: ");
		String date = sc.next();
		
		System.out.println("Take of time: ");
		String time=sc.next();
		
		System.out.println("Enter the seat to be available: ");
		int seatsAvailable = sc.nextInt();
		
		arr1[i] = new AirlineSystem(AirlineNo,source,destination,date,time,seatsAvailable);
		}
		
		
		Connection con = DBUtil.getConnection();
		PreparedStatement stmt = con.prepareStatement("insert into AirlineSystem values(?,?,?,?,?,?)");
		for (int i = 0; i < a; i++) {
		stmt.setInt(1, arr1[i]. getAirlineNo());
		stmt.setString(2, arr1[i].getSource());
		stmt.setString(3, arr1[i].getDestination());
		stmt.setString(4, arr1[i].getDate());
		stmt.setString(5, arr1[i].getTakeoftime());
		stmt.setInt(6, arr1[i].getNoOfseats());
		
		stmt.executeUpdate();
		}
		System.out.println("Data collected successfully");
		
		}catch(SQLException e) {
	     System.out.println(e);
	
	}
		
}
	public void displayTable() {
		try {
		Connection con = DBUtil.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM AirlineSystem");
		ResultSet rs = stmt.executeQuery();
         System.out.println();
         System.out.println();
         System.out.println();
		System.out.println("Airline Details:");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "AirlineNo", "Source", "Destination","Date","TakeOfTime","noOfseats");

		while (rs.next()) {

		System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
		}

		rs.close();
		} catch (SQLException e) {
		System.out.println("Error: " + e.getMessage());
		}
	}
		public void deleteDetails() {
		
			try {
			Scanner sc=new Scanner(System.in);
		    
			//Establishing connection
			   Connection con=DBUtil.getConnection();
		 	   
			   
			   PreparedStatement stmt=con.prepareStatement("delete from AirlineSystem where AirlineNo = 101 ");
			   
			   
			   stmt.executeUpdate();
			   displayTable();
			   
			  
			   System.out.println("Details Deleted Successfully");
			   
			   
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
		
		}

}
	
