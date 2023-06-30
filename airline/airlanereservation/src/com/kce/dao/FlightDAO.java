package com.kce.dao;

import com.kce.bean.Flight;
import com.kce.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {
    public void addFlight1(Flight flight) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO flights (flightNumber, origin, destination, availableSeats) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, flight.getFlightNumber());
            stmt.setString(2, flight.getOrigin());
            stmt.setString(3, flight.getDestination());
            stmt.setInt(4, flight.getAvailableSeats());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Flight> getAllFlights1() {
        List<Flight> flights = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM flights");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Flight flight = new Flight(null, null, null, 0);
                flight.setFlightNumber(rs.getString("flightNumber"));
                flight.setOrigin(rs.getString("origin"));
                flight.setDestination(rs.getString("destination"));
                flight.setAvailableSeats(rs.getInt("availableSeats"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }

	public void addFlight(Flight flight) {
		// TODO Auto-generated method stub
		
	}

	public List<Flight> getAllFlights() {
		// TODO Auto-generated method stub
		return null;
	}

    // Add other DAO methods as needed
}
