package com.kce.hotel.dao;
import com.kce.hotel.bean.Hotel;
import com.kce.hotel.util.DBUtil;
import com.kce.hotel.util.HotelException;

import java.sql.*;

public class HotelDAO {
    private Connection connection;
    public HotelDAO() {
        // Establishing database connection
        connection= DBUtil.createConnection();
    }
    // CRUD operations using prepared statement
    public  void createHotel(Hotel hotel) throws SQLException, HotelException {
        try {
            String query = "INSERT INTO hotels (id, name, location) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, hotel.getId());
            statement.setString(2, hotel.getName());
            statement.setString(3, hotel.getLocation());
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new HotelException();
        }
    }
    public void updateHotel(Hotel hotel) throws SQLException {
        String query = "UPDATE hotels SET name = ?, location = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, hotel.getName());
        statement.setString(2, hotel.getLocation());
        statement.setInt(3, hotel.getId());
        statement.executeUpdate();
    }
    public void deleteHotel(int id) throws SQLException {
        String query = "DELETE FROM hotels WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
    public Hotel getHotelById(int id) throws SQLException {
        String query = "SELECT * FROM hotels WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String location = resultSet.getString("location");
            return new Hotel(id, name, location);
        }
        return null;
    }
}

