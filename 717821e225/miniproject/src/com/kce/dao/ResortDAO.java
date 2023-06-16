package com.kce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.kce.bean.Resort;

public class ResortDAO {
    private Connection connection;

    public ResortDAO() throws SQLException {
        // Establishing database connection
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resort","resort_db","kabil");
    }

    // CRUD operations using prepared statement
    public void createResort(Resort resort) throws SQLException {
        String sql = "INSERT INTO resorts (id, name, location) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, resort.getId());
        statement.setString(2, resort.getName());
        statement.setString(3, resort.getLocation());
        statement.executeUpdate();
    }

    public void updateResort(Resort resort) throws SQLException {
        String sql = "UPDATE resorts SET name = ?, location = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, resort.getName());
        statement.setString(2, resort.getLocation());
        statement.setInt(3, resort.getId());
        statement.executeUpdate();
    }

    public void deleteResort(int id) throws SQLException {
        String sql = "DELETE FROM resorts WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public Resort getResortById(int id) throws SQLException {
        String sql = "SELECT * FROM resorts WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String location = resultSet.getString("location");
            return new Resort(id, name, location);
        }

        return null;
    }

}
