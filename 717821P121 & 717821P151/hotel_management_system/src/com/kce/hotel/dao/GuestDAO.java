package com.kce.hotel.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.kce.hotel.bean.Guest;
import com.kce.hotel.util.DBUtil;
import com.kce.hotel.util.GuestException;

public class GuestDAO {
    private Connection connection;
    public GuestDAO() {
        connection= DBUtil.createConnection();
    }
    public void createGuest(Guest guest) throws GuestException, SQLException {
        String query = "INSERT INTO guests (id,name, email) VALUES (?, ?,?)";
        try  {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,guest.getId());
            statement.setString(2, guest.getName());
            statement.setString(3, guest.getEmail());
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e){
            throw new GuestException();
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
    public void updateGuest(Guest guest)  {
        String query = "UPDATE guests SET name = ?, email = ? WHERE id = ?";
        try  {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, guest.getName());
            statement.setString(2, guest.getEmail());
            statement.setInt(3, guest.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
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
