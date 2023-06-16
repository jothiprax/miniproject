package com.kce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.kce.bean.BookingDetails;
import com.kce.util.DButil;

public class BookingDAO {
	static Scanner sc = new Scanner(System.in);

	public static void Customer(BookingDetails bd) {
	try {

	Connection con = DButil.getConnection();
	PreparedStatement stmt = con.prepareStatement("INSERT INTO cus_details (name, phNo, busNo, noOfSeats) VALUES (?, ?, ?, ?)");
	stmt.setString(1, bd.getName());
	stmt.setString(2,bd.getPhNo());
	stmt.setInt(3, bd.getBusNo());
	stmt.setInt(4, bd.getNoOfSeats());
	stmt.executeUpdate();


	System.out.println("SUCCESSFULLY DATA INSERTED..");
	} catch (SQLException e) {
	System.out.println("Error: " + e.getMessage());
	}
	}
	public static void update() {
	try {
	Connection con = DButil.getConnection();
	PreparedStatement stmt = con.prepareStatement("UPDATE cus_details SET noOfSeats = ? WHERE name = ?");
	System.out.println("Enter the No Of Seats to be Update: ");
	int noOfSeats = sc.nextInt();
	System.out.println("Enter the new Customer Name: ");
	String name = sc.next();
	stmt.setInt(1, noOfSeats);
	stmt.setString(2, name);
	int rowsAffected = stmt.executeUpdate();

	if (rowsAffected > 0) {
	System.out.println("SUCCESSFULLY UPDATED..");
	} else {
		System.out.println("NO RECORDS FOUND...");
		}
		} catch (SQLException e) {
		System.out.println("Error: " + e.getMessage());
		}
		}
		public static void deleteRows() {

		try {

		Connection con = DButil.getConnection();

		PreparedStatement stmt = con.prepareStatement("TRUNCATE TABLE cus_details");

		stmt.executeUpdate();

		System.out.println("TABLE RECORD IS SUCCESSFULLY DELETED");

		} catch (SQLException e) {

		System.out.println(e);

		}

		}


		public static void display() {
		try {
		Connection con = DButil.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM cus_details");
		ResultSet rs = stmt.executeQuery();
		System.out.println("CUSTOMER DETAILS");
		System.out.println("*********************************************************************************************************");
		System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n", "NAME", "PHONE NUMBER", "BUSNO","NO OF SEATS");

		while (rs.next()) {

		System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n",rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
		}

		rs.close();
		} catch (SQLException e) {
		System.out.println("Error: " + e.getMessage());
		}
		}

}
