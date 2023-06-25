package com.kce.service;
import com.kce.dao.FlightDAO;
import com.kce.util.*;
import java.util.Scanner;
import com.kce.bean.Flight;
public class ConsoleMenu {
	 private Scanner scanner;
	    private FlightDAO flightDAO;
	    public ConsoleMenu() {
	        scanner = new Scanner(System.in);
	        flightDAO = new FlightDAO();
	    }

	    public void displayMenu() {
	        boolean running = true;

	        while (running) {
	            System.out.println("Flight Reservation System");
	            System.out.println("1. View Available Flights");
	            System.out.println("2. Search for Flights");
	            System.out.println("3. Book a Flight");
	            System.out.println("4. Modify a Booking");
	            System.out.println("5. Cancel a Booking");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline character

	            switch (choice) {
	                case 1:
	                    viewAvailableFlights();
	                    break;
	                case 2:
	                    searchFlights();
	                    break;
	                case 3:
	                    bookFlight();
	                    break;
	                case 4:
	                    modifyBooking();
	                    break;
	                case 5:
	                    cancelBooking();
	                    break;
	                case 6:
	                    running = false;
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }

	            System.out.println();
	        }
	    }

	    private void viewAvailableFlights() {
	        System.out.println("Available Flights:");
	        try {
	            flightDAO.displayAvailableFlights();
	        } catch (FlightNotFoundException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    private void searchFlights() {
	        System.out.print("Enter source city: ");
	        String sourceCity = scanner.nextLine();

	        System.out.print("Enter destination city: ");
	        String destinationCity = scanner.nextLine();

	        System.out.println("Search Results:");
	        try {
	            flightDAO.searchFlights(sourceCity, destinationCity);
	        } catch (FlightNotFoundException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    private void bookFlight() {
	        System.out.print("Enter your name: ");
	        String name = scanner.nextLine();

	        System.out.print("Enter your contact number: ");
	        String contactNumber = scanner.nextLine();

	        System.out.print("Enter flight ID to book: ");
	        int flightId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline character

	        try {
	            Flight flight = flightDAO.getFlightById(flightId);
	            if (flight != null) {
	                flightDAO.bookFlight(flight, name, contactNumber);
	                System.out.println("Flight booked successfully!");
	            } else {
	                System.out.println("Invalid flight ID or no available seats.");
	            }
	        } catch (FlightNotFoundException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    private void modifyBooking() {
	        System.out.print("Enter your name: ");
	        String name = scanner.nextLine();

	        System.out.print("Enter your contact number: ");
	        String contactNumber = scanner.nextLine();

	        System.out.println("Your Booked Flights:");
	        try {
	            flightDAO.displayBookedFlights(name, contactNumber);
	        } catch (FlightNotFoundException e) {
	            System.out.println(e.getMessage());
	        }

	        System.out.print("Enter booking ID to modify: ");
	        int bookingId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline character

	        System.out.println("Enter new details:");

	        System.out.print("Enter your name: ");
	        String newName = scanner.nextLine();

	        System.out.print("Enter your contact number: ");
	        String newContactNumber = scanner.nextLine();

	        try {
	            flightDAO.modifyBooking(bookingId, newName, newContactNumber);
	            System.out.println("Booking modified successfully!");
	        } catch (FlightNotFoundException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    private void cancelBooking() {
	        System.out.print("Enter your name: ");
	        String name = scanner.nextLine();

	        System.out.print("Enter your contact number: ");
	        String contactNumber = scanner.nextLine();

	        System.out.println("Your Booked Flights:");
	        try {
	            flightDAO.displayBookedFlights(name, contactNumber);
	        } catch (FlightNotFoundException e) {
	            System.out.println(e.getMessage());
	        }

	        System.out.print("Enter booking ID to cancel: ");
	        int bookingId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline character

	        try {
	            flightDAO.cancelBooking(bookingId);
	            System.out.println("Booking canceled successfully!");
	        } catch (FlightNotFoundException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	}
}
