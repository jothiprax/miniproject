package com.kce.flight.service;

import java.util.Scanner;
import com.kce.flight.bean.PassengerDAO;
import com.kce.flight.dao.FlightServices;

public class FlightMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		FlightServices kd = new FlightServices();
//		if (con != null) {
//			System.out.println("Connected..");
//		} else {
//			System.out.println("Not Connected.");
//			System.exit(0);
//		}
		System.out.println("\n\n\t\tWelcome to Flight Booking System");
		while (true) {
			System.out.println("\n1.)Flight Booking");
			System.out.println("2.)View Booking Details");
			System.out.println("3.)Cancel Ticket");
			System.out.println("4.)Flight List");
			System.out.println("5.)Exit");
			System.out.print("\nEnter the Choice: ");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				kd.flightBooking();
				break;
			case 2:
				PassengerDAO pas = kd.viewDetails();
				System.out.println("\nPassenger Details..");
				System.out.println("-------------------------------");
				System.out.println("Passenger Id: " + pas.getPassengerId());
				System.out.println("Passenger Name: " + pas.getPassengerName());
				System.out.println("Passenger Address: " + pas.getPassengerAddress());
				System.out.println("FlightNumber: " + pas.getFlightId());
				int fid = pas.getFlightId();
				kd.flightDetails(fid);
				break;
			case 3:
				kd.cancelTicket();
				break;
			case 4:
				kd.flightList();
				break;
			case 5:
				System.out.println("\n\tThank You..!\n\n");
				//System.out.println("Submitted By Kavin.K");
				Thread.sleep(2000);
				System.exit(0);
				break;
			default:
				System.out.println("\n\t<<<<  Invalid Choice  >>>>\nPlease ReEnter the Choice..");
				break;
			}
		}
	}
}
