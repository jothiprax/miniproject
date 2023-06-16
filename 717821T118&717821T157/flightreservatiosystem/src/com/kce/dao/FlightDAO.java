package com.kce.dao;

import com.kce.util.*;
import com.kce.bean.Flight;

import java.sql.*;

public class FlightDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;

    public FlightDAO() throws ClassNotFoundException {
        connection = DBConnection.getConnection();
    }

    public void displayAvailableFlights() throws FlightNotFoundException {
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM flights WHERE available_seats > 0");

            while (resultSet.next()) {
                System.out.println("Flight ID: " + resultSet.getInt("flight_id"));
                System.out.println("Source: " + resultSet.getString("source_city"));
                System.out.println("Destination: " + resultSet.getString("destination_city"));
                System.out.println("Available Seats: " + resultSet.getInt("available_seats"));
                System.out.println("--------------------");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new FlightNotFoundException("No available flights found.");
        }
    }

    public void searchFlights(String sourceCity, String destinationCity) throws FlightNotFoundException {
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM flights WHERE source_city = ? AND destination_city = ? AND available_seats > 0");
            preparedStatement.setString(1, sourceCity);
            preparedStatement.setString(2, destinationCity);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Flight ID: " + resultSet.getInt("flight_id"));
                System.out.println("Source: " + resultSet.getString("source_city"));
                System.out.println("Destination: " + resultSet.getString("destination_city"));
                System.out.println("Available Seats: " + resultSet.getInt("available_seats"));
                System.out.println("--------------------");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new FlightNotFoundException("No flights found for the given criteria.");
        }
    }

    public Flight getFlightById(int flightId) throws FlightNotFoundException {
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM flights WHERE flight_id = ? AND available_seats > 0");
            preparedStatement.setInt(1, flightId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int availableSeats = resultSet.getInt("available_seats");
                String sourceCity = resultSet.getString("source_city");
                String destinationCity = resultSet.getString("destination_city");
                return new Flight(flightId, sourceCity, destinationCity, availableSeats);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new FlightNotFoundException("Flight not found.");
        }
    }

    public void bookFlight(Flight flight, String name, String contactNumber) throws FlightNotFoundException {
        try {
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO bookings (flight_id, name, contact_number) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, flight.getFlightId());
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, contactNumber);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(
                    "UPDATE flights SET available_seats = available_seats - 1 WHERE flight_id = ?");
            preparedStatement.setInt(1, flight.getFlightId());
            preparedStatement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);

            preparedStatement.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new FlightNotFoundException("Error occurred while booking the flight.");
        }
    }

    public void displayBookedFlights(String name, String contactNumber) throws FlightNotFoundException {
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM bookings WHERE name = ? AND contact_number = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, contactNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Booking ID: " + resultSet.getInt("booking_id"));
                System.out.println("Flight ID: " + resultSet.getInt("flight_id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Contact Number: " + resultSet.getString("contact_number"));
                System.out.println("--------------------");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new FlightNotFoundException("No bookings found for the given criteria.");
        }
    }

    public void modifyBooking(int bookingId, String newName, String newContactNumber) throws FlightNotFoundException {
        try {
            preparedStatement = connection.prepareStatement(
                    "UPDATE bookings SET name = ?, contact_number = ? WHERE booking_id = ?");
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newContactNumber);
            preparedStatement.setInt(3, bookingId);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new FlightNotFoundException("Booking not found or no changes made.");
            }

            preparedStatement.close();
        } catch (SQLException e) {
            throw new FlightNotFoundException("Error occurred while modifying the booking.");
        }
    }

    public void cancelBooking(int bookingId) throws FlightNotFoundException {
        try {
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(
                    "DELETE FROM bookings WHERE booking_id = ?");
            preparedStatement.setInt(1, bookingId);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new FlightNotFoundException("Booking not found.");
            }

            preparedStatement = connection.prepareStatement(
                    "UPDATE flights SET available_seats = available_seats + 1 WHERE flight_id = " +
                    "(SELECT flight_id FROM bookings WHERE booking_id = ?)");
            preparedStatement.setInt(1, bookingId);
            preparedStatement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);

            preparedStatement.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new FlightNotFoundException("Error occurred while canceling the booking.");
        }
    }
}