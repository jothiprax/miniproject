package com.kce.dao;

import com.kce.bean.Hotel;
import com.kce.bean.Room;
import com.kce.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    private static final String INSERT_ROOM = "INSERT INTO rooms (room_number, type, price, hotel_id) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_ROOMS = "SELECT * FROM rooms";

    public static void addRoom(Room room) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ROOM)) {
            statement.setString(1, room.getRoomNumber());
            statement.setString(2, room.getType());
            statement.setDouble(3, room.getPrice());
            statement.setInt(4, room.getHotel().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ROOMS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String roomNumber = resultSet.getString("room_number");
                String type = resultSet.getString("type");
                double price = resultSet.getDouble("price");
                int hotelId = resultSet.getInt("hotel_id");
                Hotel hotel = HotelDAO.getHotelById(hotelId);
                Room room = new Room(roomNumber, type, price, hotel);
                room.setId(id);
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public static Room getRoomById(int id) {
        Room room = null;
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM rooms WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String roomNumber = resultSet.getString("room_number");
                String type = resultSet.getString("type");
                double price = resultSet.getDouble("price");
                int hotelId = resultSet.getInt("hotel_id");
                Hotel hotel = HotelDAO.getHotelById(hotelId);
                room = new Room(roomNumber, type, price, hotel);
                room.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }
}
