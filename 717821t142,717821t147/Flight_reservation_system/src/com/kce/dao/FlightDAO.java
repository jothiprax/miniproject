package com.kce.dao;

import com.kce.bean.Flight;
import com.kce.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightDAO {
    public Flight getFlightById(int flightId) {
        Flight flight = null;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM flights WHERE id = ?")) {

            stmt.setInt(1, flightId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                flight = new Flight();
                flight.setId(rs.getInt("id"));
                flight.setAirline(rs.getString("airline"));
                flight.setSource(rs.getString("source"));
                flight.setDestination(rs.getString("destination"));
                flight.setDepartureTime(rs.getString("departure_time"));
                flight.setArrivalTime(rs.getString("arrival_time"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flight;
    }

	 
}


