package javaproject;

import java.sql.*;
import java.util.Scanner;

public class HotelReservationSystem {
	private static final String URL = "jdbc:mysql://localhost/hotel_reservation";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "aravindhan1272004";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println("Connected to the database");

            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\nHotel Reservation System");
                System.out.println("1. Search for available rooms");
                System.out.println("2. Make a reservation");
                System.out.println("3. View your reservations");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                    	searchAvailableRooms sr=new searchAvailableRooms();
                    	sr.search(connection);
                        break;
                    case 2:
                    	makeReservation mr=new makeReservation();
                    	mr.make(connection);
                        break;
                    case 3:
                    	viewReservations vr=new viewReservations();
                    	vr.view(connection);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);

        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
}
}
