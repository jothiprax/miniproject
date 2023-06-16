package com.kce.dao;

import com.kce.bean.Passenger;
import com.kce.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerDAO {
    private static final String INSERT_PASSENGER = "INSERT INTO passengers (name, passport_number) VALUES (?, ?)";
    private static final String SELECT_ALL_PASSENGERS = "SELECT * FROM passengers";

    public static void addPassenger(Passenger passenger) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_PASSENGER)) {
            statement.setString(1, passenger.getName());
            statement.setString(2, passenger.getPassportNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Passenger> getAllPassengers() {
        List<Passenger> passengers = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PASSENGERS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String passportNumber = resultSet.getString("passport_number");
                Passenger passenger = new Passenger(name, passportNumber);
                passenger.setId(id);
                passengers.add(passenger);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passengers;
    }

    public static Passenger getPassengerById(int id) {
        Passenger passenger = null;
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM passengers WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String passportNumber = resultSet.getString("passport_number");
                passenger = new Passenger(name, passportNumber);
                passenger.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passenger;
    }
}
