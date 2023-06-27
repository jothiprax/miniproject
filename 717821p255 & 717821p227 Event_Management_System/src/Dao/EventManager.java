package Dao;

import Bean.*;

import java.sql.*;


// CRUD Operations
public class EventManager {
    private Connection connection;

    public EventManager() {
        // Establish database connection
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/events","root","#Nesamani5");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createEvent(Event event) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO events (eventName, eventDate, eventTime) VALUES (?, ?, ?)");
            statement.setString(1, event.getEventName());
            statement.setString(2, event.getEventDate());
            statement.setString(3, event.getEventTime());

            statement.executeUpdate();
            System.out.println("Event created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Event readEvent(int eventId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM events WHERE eventId = ?");
            statement.setInt(1, eventId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String eventName = resultSet.getString("eventName");
                String eventDate = resultSet.getString("eventDate");
                String eventTime = resultSet.getString("eventTime");

                return new Event(eventId, eventName, eventDate, eventTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateEvent(Event event) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE events SET eventName = ?, eventDate = ?, eventTime = ? WHERE eventId = ?");
            statement.setString(1, event.getEventName());
            statement.setString(2, event.getEventDate());
            statement.setString(3, event.getEventTime());
            statement.setInt(4, event.getEventId());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Event updated successfully!");
            } else {
                System.out.println("Event not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public void deleteEvent(int eventId) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM events WHERE eventId = ?");
            statement.setInt(1, eventId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Event deleted successfully!");
            } else {
                System.out.println("Event not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




