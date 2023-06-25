package com.kce.dao;

import com.kce.bean.Hotel;
import com.kce.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {
    private static final String INSERT_HOTEL = "INSERT INTO hotels (name, location) VALUES (?, ?)";
    private static final String SELECT_ALL_HOTELS = "SELECT * FROM hotels";

    public static void addHotel(Hotel hotel) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_HOTEL)) {
            statement.setString(1, hotel.getName());
            statement.setString(2, hotel.getLocation());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_HOTELS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                Hotel hotel = new Hotel(name, location);
                hotel.setId(id);
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotels;
    }

    public static Hotel getHotelById(int id) {
        Hotel hotel = null;
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM hotels WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                hotel = new Hotel(name, location);
                hotel.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotel;
    }
}
