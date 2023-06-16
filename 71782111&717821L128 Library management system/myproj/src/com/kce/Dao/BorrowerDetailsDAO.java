package com.kce.Dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.kce.bean.BorrowerDetails;
public class BorrowerDetailsDAO {
	static Scanner sc = new Scanner(System.in);

	public static void Borrower(BorrowerDetails bd) throws ClassNotFoundException {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?characterEncoding=latin1","root","root123#@");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO borrower (Borrowerid,Borrowername,BorrowerphNo,due_date) VALUES (?, ?, ?, ?)");
			stmt.setInt(1, bd.getBorrowerid());
			stmt.setString(2, bd.getBorrowername());
			stmt.setString(3, bd.getBorrowerphNo());
			stmt.setString(4, bd.getDue_date());
			stmt.executeUpdate();

			System.out.println("Data inserted successfully!");
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	public static void update() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?characterEncoding=latin1","root","root123#@");
			PreparedStatement stmt = con.prepareStatement("UPDATE borrower SET Borrowerid = ? WHERE Borrowername = ?");
			System.out.println("Enter the Borrowerid to be Update: ");
			int Borrowerid = sc.nextInt();
			System.out.println("Enter the new BorrowerName: ");
			String Borrowername = sc.next();
			stmt.setInt(1, Borrowerid);
			stmt.setString(2, Borrowername);
			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Update successful");
			} else {
				System.out.println("No records found for the given Name");
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	public static void deleteRows() throws ClassNotFoundException {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?characterEncoding=latin1","root","root123#@");

			PreparedStatement stmt = con.prepareStatement("TRUNCATE TABLE borrower");

			stmt.executeUpdate();

			System.out.println("Table Record is Deleted Successfully........");

		} catch (SQLException e) {

			System.out.println(e);

		}

	}


	public static void displayTable() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?characterEncoding=latin1","root","root123#@");
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM borrower");
			ResultSet rs = stmt.executeQuery();

			System.out.println("Borrower Details:");
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n", "Borrowerid","Borrowername","BorrowerphNo","due_date");

			while (rs.next()) {

				System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n",rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDate(4));
			}

			rs.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}

