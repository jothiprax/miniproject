package com.kce.dao;

import com.kce.bean.Hotel;
import com.kce.util.MySQLConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelDAO {
    public void addHotel(Hotel hotel) {
        try (Connection connection = MySQLConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO hotels (name, room_no, price) VALUES (?, ?, ?)")) {
            statement.setString(1, hotel.getName());
            statement.setInt(2, hotel.getRoomNo());
            statement.setDouble(3, hotel.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateHotel(Hotel hotel) {
        try (Connection connection = MySQLConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE hotels SET name = ?, price = ? WHERE room_no = ?")) {
            statement.setString(1, hotel.getName());
            statement.setDouble(2, hotel.getPrice());
            statement.setInt(3, hotel.getRoomNo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHotel(int roomNo) {
        try (Connection connection = MySQLConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM hotels WHERE room_no = ?")) {
            statement.setInt(1, roomNo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewHotels() {
        try (Connection connection = MySQLConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM hotels");
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("Hotel List:");
            System.out.println("Room No\tName\t\tPrice");
            while (resultSet.next()) {
                int roomNo = resultSet.getInt("room_no");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                System.out.println(roomNo + "\t\t" + name + "\t\t" + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

