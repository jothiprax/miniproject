package com.kce.dao;

import com.kce.bean.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {
    private Connection connection;

    public EventDAO() {
        // Establish database connection
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Prawin@23");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        // Close database connection
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createEvent(Event event) {
        // Perform create operation using PreparedStatement
        try {
            String query = "INSERT INTO events (name, date, capacity) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, event.getName());
            statement.setString(2, event.getDate());
            statement.setInt(3, event.getCapacity());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Event getEventByName(String eventName) {
        // Perform read operation using PreparedStatement
        try {
            String query = "SELECT * FROM events WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, eventName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String date = resultSet.getString("date");
                int capacity = resultSet.getInt("capacity");
                return new Event(name, date, capacity);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateEvent(Event event) {
        // Perform update operation using PreparedStatement
        try {
            String query = "UPDATE events SET date = ?, capacity = ? WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, event.getDate());
            statement.setInt(2, event.getCapacity());
            statement.setString(3, event.getName());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEvent(String eventName) {
        // Perform delete operation using PreparedStatement
        try {
            String query = "DELETE FROM events WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, eventName);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Event> getAllEvents() {
        // Perform read operation to fetch all events
        List<Event> events = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM events");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String date = resultSet.getString("date");
                int capacity = resultSet.getInt("capacity");
                events.add(new Event(name, date, capacity));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }
}