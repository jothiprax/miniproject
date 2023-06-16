package com.kce.dao;

import com.kce.bean.Guest;
import com.kce.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestDao {
    public void addGuest(Guest guest) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseUtil.getConnection();
            String query = "INSERT INTO Guest (name, email, phone_number) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, guest.getName());
            statement.setString(2, guest.getEmail());
            statement.setString(3, guest.getPhone_number());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Guest getGuestById(int guest_id) {
        Guest guest = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseUtil.getConnection();
            String query = "SELECT * FROM Guest WHERE guest_id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, guest_id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                guest = new Guest();
                guest.setGuest_id(resultSet.getInt("guest_id"));
                guest.setName(resultSet.getString("name"));
                guest.setEmail(resultSet.getString("email"));
                guest.setPhone_number(resultSet.getString("phone_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return guest;
    }

    public void updateGuest(Guest guest) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseUtil.getConnection();
            String query = "UPDATE Guest SET name=?, email=?, phone_number=? WHERE guest_id=?";
            statement = connection.prepareStatement(query);
            statement.setString(1, guest.getName());
            statement.setString(2, guest.getEmail());
            statement.setString(3, guest.getPhone_number());
            statement.setInt(4, guest.getGuest_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public void deleteGuest(int guest_id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseUtil.getConnection();
            String query = "DELETE FROM Guest WHERE guest_id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, guest_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}