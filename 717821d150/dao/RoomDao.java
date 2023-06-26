package com.kce.dao;

import com.kce.bean.Room;
import com.kce.util.DatabaseUtil;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDao {
	public  static void insertRoom() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter room no:");
		int roomno=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the roomtype:");
		String str=sc.nextLine();
		System.out.println("Enter the roomrate:");
		int roomrate=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter boolean value");
		boolean is=sc.nextBoolean();
		sc.nextLine();
		  try {
	            Connection connection = DatabaseUtil.getConnection();

	            // Create the SQL statement
	            String sql = "INSERT INTO Room (room_number, room_type, room_rate, is_available) VALUES (?, ?, ?, ?)";

	            // Create a prepared statement with the SQL statement
	            PreparedStatement statement = connection.prepareStatement(sql);

	            // Set the values for the parameters
	            statement.setInt(1, roomno);
	            statement.setString(2, str);
	            statement.setDouble(3, (double)roomrate);
	            statement.setBoolean(4, is);
	            statement.executeUpdate();
		  }catch(Exception e) {}
	}
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseUtil.getConnection();
            String query = "SELECT * FROM Room";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Room room = new Room();
                room.setRoom_id(resultSet.getInt("room_id"));
                room.setRoom_number(resultSet.getInt("room_number"));
                room.setRoom_type(resultSet.getString("room_type"));
                room.setRoom_rate(resultSet.getDouble("room_rate"));
                room.setIs_available(resultSet.getBoolean("is_available"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return rooms;
    }

    public Room getRoomById(int room_id) {
        Room room = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseUtil.getConnection();
            String query = "SELECT * FROM Room WHERE room_id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, room_id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                room = new Room();
                room.setRoom_id(resultSet.getInt("room_id"));
                room.setRoom_number(resultSet.getInt("room_number"));
                room.setRoom_type(resultSet.getString("room_type"));
                room.setRoom_rate(resultSet.getDouble("room_rate"));
                room.setIs_available(resultSet.getBoolean("is_available"));
                System.out.println(room.getRoom_id()+room.getRoom_number()+room.getRoom_rate()+room.getRoom_type());
                room.toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return room;
    }

    public void updateRoom(Room room) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseUtil.getConnection();
            String query = "UPDATE Room SET room_number=?, room_type=?, room_rate=?, is_available=? WHERE room_id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, room.getRoom_number());
            statement.setString(2, room.getRoom_type());
            statement.setDouble(3, room.getRoom_rate());
            statement.setBoolean(4, room.isIs_available());
            statement.setInt(5, room.getRoom_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public void deleteRoom(int room_id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseUtil.getConnection();
            String query = "DELETE FROM Room WHERE room_id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, room_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
