package com.kce.dao;
import com.kce.bean.Bus;
import com.kce.util.DButil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

class InvalidDateException extends Exception {
private static final long serialVersionUID = 1L;

public InvalidDateException(String message) {
super(message);
}
}
public class BusDAO
{
		static Scanner sc = new Scanner(System.in);

		public static void insert(int a) {
		try {
		Bus[] arr = new Bus[a];
		for (int i = 0; i < a; i++) {
		System.out.println("ENTER BUS ID: ");
		int busid = sc.nextInt();
		System.out.println("ENTER ORIGIN: ");
		String origin = sc.next();
		System.out.println("ENTER DESTINATION: ");
		String desti= sc.next();
		System.out.println("AVAILABLE SEATS: ");
		int seatsAvail = sc.nextInt();
		System.out.println("ENTER DATE (DD/MM/YYYY): ");
		String dateStr = sc.next();
		System.out.println("ENTER SINGLE SEAT PRICE: ");
		double priceOfSingleSeat = sc.nextDouble();

		LocalDate date = validateAndParseDate(dateStr);

		arr[i] = new Bus(busid, origin, desti, seatsAvail, dateStr, priceOfSingleSeat);
		}

		Connection con = DButil.getConnection();
		PreparedStatement stmt = con.prepareStatement("insert into bus values(?,?,?,?,?,?)");
		for (int i = 0; i < a; i++) {
		stmt.setInt(1, arr[i].getBusId());
		stmt.setString(2, arr[i].getOrigin());
		stmt.setString(3, arr[i].getDesti());
		stmt.setInt(4, arr[i].getSeatsAvail());
		stmt.setString(5, arr[i].getDate());
		stmt.setDouble(6, arr[i].getPrice());
		stmt.executeUpdate();
		}

		System.out.println("Data collected successfully");
		} catch (SQLException e) {
		System.out.println(e);
		} catch (InvalidDateException e) {
		System.out.println(e.getMessage());
		}
		}

		private static LocalDate validateAndParseDate(String dateStr) throws InvalidDateException {
		try {
		return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		} catch (DateTimeParseException e) {
		throw new InvalidDateException("Invalid date format. Please enter the date in the format DD/MM/YYYY.");
		}
		}

		public static void update() {
		try {
		Connection con = DButil.getConnection();
		PreparedStatement stmt = con.prepareStatement("UPDATE bus SET origin = ? WHERE busId = ?");
		System.out.println("ENTER BUS ID: ");
		int busid = sc.nextInt();
		System.out.println("Enter the new source: ");
		String origin = sc.next();
		stmt.setString(1, origin);
		stmt.setInt(2, busid);
		int rowsAffected = stmt.executeUpdate();

		if (rowsAffected > 0) {
		System.out.println("SUCCESSFULLY UPDATED");
		} else {
		System.out.println("NO RECORDS FOUND FOR THIS BUS ID");
		}
		} catch (SQLException e) {
		System.out.println("Error: " + e.getMessage());
		}
		}

		public static void delete() {
		try {
		Connection con = DButil.getConnection();
		PreparedStatement stmt = con.prepareStatement("DELETE FROM bus WHERE busId = ?");
		System.out.println("ENTER BUS ID: ");
		int id = sc.nextInt();
		stmt.setInt(1,id);
		int rowsAffected = stmt.executeUpdate();

		if (rowsAffected > 0) {
		System.out.println("SUCCESSFULLY DELETED");
		} else {
		System.out.println("NO RECORDS FOUND FOR THIS BUS ID");
		}
		} catch (SQLException e) {
		System.out.println("Error: " + e.getMessage());
		}
		}
		public static void display() {
		try {
		Connection con = DButil.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM bus");
		ResultSet rs = stmt.executeQuery();

		System.out.println("BUS DETAILS:");
		System.out.println("*************************************************************************************************************************************************");
		System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "Bus Id", "Origin", "Desti","SeatsAvail","Date","priceOfSingleSeat");

		while (rs.next()) {

		System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDouble(6));
		}

		rs.close();
		} catch (SQLException e) {
		System.out.println("Error: " + e.getMessage());
		}
		}
		public static double getSeatPrice(int busId) {
		try {
		Connection con = DButil.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT priceOfSingleSeat FROM bus WHERE busId = ?");
		stmt.setInt(1, busId);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
		double seatPrice = rs.getDouble("priceOfSingleSeat");
		return seatPrice;
		} else {
		throw new IllegalArgumentException("No records found for the given bus id");
		}
		} catch (SQLException e) {
		throw new IllegalArgumentException("Error: " + e.getMessage(), e);
		}
		}

}