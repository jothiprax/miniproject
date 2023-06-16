package com.kce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kce.bean.Guest;

public class GuestDAO {
	private Connection connection;
    public GuestDAO(Connection connection) {
        this.connection = connection;
    }

    public void createGuest(Guest guest) throws SQLException {
        String query = "INSERT INTO guests (name, email) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, guest.getName());
            statement.setString(2, guest.getEmail());
            statement.executeUpdate();
        }
    }

    public Guest getGuestById(int id) throws SQLException {
        String query = "SELECT * FROM guests WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    return new Guest(id, name, email);
                }
            }
        }
        return null; // Guest not found
    }

    public List<Guest> getAllGuests() throws SQLException {
        List<Guest> guests = new ArrayList<>();
        String query = "SELECT * FROM guests";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                guests.add(new Guest(id, name, email));
            }
        }
        return guests;
    }

    public void updateGuest(Guest guest) throws SQLException {
        String query = "UPDATE guests SET name = ?, email = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, guest.getName());
            statement.setString(2, guest.getEmail());
            statement.setInt(3, guest.getId());
            statement.executeUpdate();
        }
    }

    public void deleteGuest(int id) throws SQLException {
        String query = "DELETE FROM guests WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

}
