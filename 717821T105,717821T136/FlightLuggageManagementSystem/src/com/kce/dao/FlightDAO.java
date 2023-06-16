package com.kce.dao;

import com.kce.bean.Flight;
import com.kce.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {
    private static final String INSERT_FLIGHT = "INSERT INTO flights (flight_number, origin, destination) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_FLIGHTS = "SELECT * FROM flights";

    public static void addFlight(Flight flight) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_FLIGHT)) {
            statement.setString(1, flight.getFlightNumber());
            statement.setString(2, flight.getOrigin());
            statement.setString(3, flight.getDestination());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_FLIGHTS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String flightNumber = resultSet.getString("flight_number");
                String origin = resultSet.getString("origin");
                String destination = resultSet.getString("destination");
                Flight flight = new Flight(flightNumber, origin, destination);
                flight.setId(id);
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }

    public static Flight getFlightById(int id) {
        Flight flight = null;
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM flights WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String flightNumber = resultSet.getString("flight_number");
                String origin = resultSet.getString("origin");
                String destination = resultSet.getString("destination");
                flight = new Flight(flightNumber, origin, destination);
                flight.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;
    }
}
