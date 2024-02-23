package javaproject;

import java.util.*;
import java.sql.*;
public class searchAvailableRooms {
	public void search(Connection connection) throws SQLException {
		Scanner sc=new Scanner(System.in);
	System.out.print("Enter the check-in date (YYYY-MM-DD): ");
    String checkInDate = sc.next();

    System.out.print("Enter the check-out date (YYYY-MM-DD): ");
    String checkOutDate = sc.next();

    PreparedStatement statement = connection.prepareStatement("SELECT * FROM rooms WHERE room_id NOT IN (SELECT room_id FROM reservations WHERE (? <= check_out_date) AND (? >= check_in_date))");
    statement.setString(1, checkInDate);
    statement.setString(2, checkOutDate);

    ResultSet resultSet = statement.executeQuery();

    System.out.println("\nAvailable Rooms:");
    System.out.println("Room ID\t\tRoom Type\tPrice\tCapacity");

    while (resultSet.next()) {
        int roomId = resultSet.getInt("room_id");
        String roomType = resultSet.getString("room_type");
        double price = resultSet.getDouble("price");
        int capacity = resultSet.getInt("capacity");

        System.out.println(roomId + "\t\t" + roomType + "\t\t" + price + "\t" + capacity);
    }

    statement.close();
}
}
