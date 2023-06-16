package com.kce.dao;

import com.kce.bean.Luggage;
import com.kce.bean.Passenger;
import com.kce.bean.Flight;
import com.kce.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LuggageDAO {
    private static final String INSERT_LUGGAGE = "INSERT INTO luggage (tag, weight, passenger_id, flight_id) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_LUGGAGE = "SELECT * FROM luggage";

    public static void addLuggage(Luggage luggage) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_LUGGAGE)) {
            statement.setString(1, luggage.getTag());
            statement.setDouble(2, luggage.getWeight());
            statement.setInt(3, luggage.getPassenger().getId());
            statement.setInt(4, luggage.getFlight().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Luggage> getAllLuggage() {
        List<Luggage> luggageList = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_LUGGAGE);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tag = resultSet.getString("tag");
                double weight = resultSet.getDouble("weight");
                int passengerId = resultSet.getInt("passenger_id");
                int flightId = resultSet.getInt("flight_id");
                Passenger passenger = PassengerDAO.getPassengerById(passengerId);
                Flight flight = FlightDAO.getFlightById(flightId);
                Luggage luggage = new Luggage(tag, weight, passenger, flight);
                luggage.setId(id);
                luggageList.add(luggage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return luggageList;
    }

    public static Luggage getLuggageById(int id) {
        Luggage luggage = null;
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM luggage WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String tag = resultSet.getString("tag");
                double weight = resultSet.getDouble("weight");
                int passengerId = resultSet.getInt("passenger_id");
                int flightId = resultSet.getInt("flight_id");
                Passenger passenger = PassengerDAO.getPassengerById(passengerId);
                Flight flight = FlightDAO.getFlightById(flightId);
                luggage = new Luggage(tag, weight, passenger, flight);
                luggage.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return luggage;
    }
}
