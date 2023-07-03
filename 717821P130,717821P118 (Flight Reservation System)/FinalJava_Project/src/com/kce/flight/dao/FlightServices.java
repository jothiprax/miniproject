package com.kce.flight.dao;

import java.util.Random;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.kce.flight.bean.PassengerDAO;
import com.kce.flight.util.DBUtil;
import com.kce.flight.util.FlightNumberNotFoundException;
import com.kce.flight.util.InSufficientAvailabilityException;

public class FlightServices {

	public FlightServices() {

	}

	public static Scanner in = new Scanner(System.in);

	public void flightBooking() {

		try {
			Connection con = DBUtil.getDBConnection();
			System.out.print("Enter the Number of Passengers:");
			int no = in.nextInt();
			Random random = new Random();
			while (no-- > 0) {
				System.out.println("\nEnter the Passenger Details");
				System.out.println("---------------------------------------------------------------");
				int PId = random.nextInt(10000);
				System.out.println("FlightNumber: ");
				int FId = in.nextInt();
				if (!Validation(FId)) {
					Thread.sleep(3000);
					throw new FlightNumberNotFoundException("Please see the (4.)Flight List...");
				}
				in.nextLine();
				System.out.println("Journey Date: ");
				String date = in.nextLine();
				if (!isAvailable(FId, date)) {
					Thread.sleep(3000);
					throw new InSufficientAvailabilityException(
							"Sorry Seats are Filled..Try Other Flight or JourneyDate");
				} else {
					Statement st = con.createStatement();
					int row = st.executeUpdate("Insert Into Booking Values(" + PId + "," + FId + ",'" + date + "');");
					System.out.println(row + "Booking is Confirmed");
				}
				System.out.println("Passenger Name: ");
				String Pname = in.nextLine();
				System.out.println("Passenger Address: ");
				String Paddress = in.nextLine();
				PreparedStatement pst = con.prepareStatement("Insert Into Passenger Values(?,?,?,?,?);");
				pst.setInt(1, PId);
				pst.setString(2, Pname);
				pst.setString(3, Paddress);
				pst.setInt(4, FId);
				pst.setString(5, date);
				pst.executeUpdate();
				System.out.println("Your Booking Details:");
				System.out.println("Passenger Id:" + PId + "\nPassenger Name: " + Pname + "\nFlight Number: " + FId);
			}
		} catch (InputMismatchException | SQLException k) {
			System.out.println(k);
		} catch (InSufficientAvailabilityException e) {
			System.out.println(e + "\n" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e + "\n" + e.getMessage());
		}
	}

	public PassengerDAO viewDetails() {
		PassengerDAO fi = null;
		try {
			Connection con = DBUtil.getDBConnection();
			System.out.println("\nEnter the Passenger_ID: ");
			int passengerId = in.nextInt();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM Passenger WHERE PId=?;");
			pst.setInt(1, passengerId);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				fi = new PassengerDAO(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4),
						res.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fi;
	}

	public void cancelTicket() throws InterruptedException {
		try {
			Connection con = DBUtil.getDBConnection();
			System.out.println("\nEnter the Passenger_ID: ");
			int passengerId = in.nextInt();
			PreparedStatement pst = con.prepareStatement("DELETE FROM Passenger WHERE PId=?;");
			pst.setInt(1, passengerId);
			int rows = pst.executeUpdate();
			pst = con.prepareStatement("DELETE FROM Booking WHERE passengerId=?;");
			pst.setInt(1, passengerId);
			rows += pst.executeUpdate();
			System.out.println("Processing.....");
			Thread.sleep(3000);
			if (rows != 0)
				System.out.println("Ticket Cancelled SuccessFully..\n Refund 80% Paid Amount Soon");
			else
				System.out.println("PasssengerId Not Found");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void flightDetails(int FId) throws SQLException {
		Connection con = DBUtil.getDBConnection();
		PreparedStatement pst = con.prepareStatement("Select * From Flight WHERE flightId=?;");
		pst.setInt(1, FId);
		ResultSet res = pst.executeQuery();
		while (res.next()) {
			System.out.println("Flight Name: " + res.getString(2) + "\nDepature Place: " + res.getString(3)
					+ "\nArrival Place: " + res.getString(4) + "\nAmount Paid: " + res.getInt(5));
		}
	}

	public void flightList() throws SQLException {
		Connection con = DBUtil.getDBConnection();
		PreparedStatement pst = con.prepareStatement("Select * From Flight;");
		ResultSet res = pst.executeQuery();
		System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s\n", "Flight Number", "Flight Name", "Depature",
				"Arrival", "Price", "Availability");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		while (res.next()) {
			System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s\n", res.getInt(1), res.getString(2),
					res.getString(3), res.getString(4), res.getInt(5), res.getInt(6));
		}
	}

	public boolean isAvailable(int Fid, String date) throws Exception {
		Connection con = DBUtil.getDBConnection();
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("Select Availability from Flight where FlightId=" + Fid + ";");
		res.next();
		int capacity = res.getInt(1);
		// System.out.println(capacity);

		res = st.executeQuery(
				"Select COUNT(PassengerId) FROM Booking WHERE FlightId=" + Fid + " AND journeyDate='" + date + "';");
		res.next();
		int booked = res.getInt(1);

		return (booked < capacity) ? true : false;
	}

	public boolean Validation(int fid) throws SQLException {
		Connection con = DBUtil.getDBConnection();
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("Select flightId from Flight;");
		while (res.next()) {
			if (res.getInt(1) == fid)
				return true;
		}
		return false;
	}
}
