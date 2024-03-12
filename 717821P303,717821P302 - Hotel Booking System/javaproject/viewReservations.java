package javaproject;

import java.util.*;
import java.sql.*;
public class viewReservations {
	public void view(Connection connection) throws SQLException {
		Scanner sc=new Scanner(System.in);
	System.out.print("Enter your name: ");
    String guestName = sc.next();

    PreparedStatement statement = connection.prepareStatement("SELECT * FROM reservations WHERE guest_name = ?");
    statement.setString(1, guestName);
    ResultSet resultSet = statement.executeQuery();

    System.out.println("\nYour Reservations:");
    System.out.println("Reservation ID\tRoom ID\tCheck-in Date\tCheck-out Date");

    while (resultSet.next()) {
        int reservationId = resultSet.getInt("reservation_id");
        int roomId = resultSet.getInt("room_id");
        String checkInDate = resultSet.getString("check_in_date");
        String checkOutDate = resultSet.getString("check_out_date");

        System.out.println(reservationId + "\t\t" + roomId + "\t\t" + checkInDate + "\t" + checkOutDate);
    }

    statement.close();
}
}
