package javaproject;

import java.util.*;
import java.sql.*;
public class makeReservation {
	public void make(Connection connection) throws SQLException {
		Scanner sc=new Scanner(System.in);
	System.out.print("Enter your name: ");
    String guestName = sc.next();

    System.out.print("Enter the number of guests: ");
    int numOfGuests = sc.nextInt();
    sc.nextLine();
    System.out.print("Enter the check-in date (YYYY-MM-DD): ");
    String checkInDate = sc.next();

    System.out.print("Enter the check-out date (YYYY-MM-DD): ");
    String checkOutDate = sc.next();

    System.out.print("Enter the room ID you want to reserve: ");
    int roomId = sc.nextInt();

    PreparedStatement statement = connection.prepareStatement("INSERT INTO reservations (guest_name, num_of_guests, check_in_date, check_out_date, room_id) VALUES (?, ?, ?, ?, ?)");
    statement.setString(1, guestName);
    statement.setInt(2, numOfGuests);
    statement.setString(3, checkInDate);
    statement.setString(4, checkOutDate);
    statement.setInt(5, roomId);
    statement.executeUpdate();

    System.out.println("Reservation made successfully!");

    statement.close();
}
}
