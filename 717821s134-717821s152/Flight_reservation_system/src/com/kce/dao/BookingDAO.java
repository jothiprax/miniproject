package com.kce.dao;

import com.kce.bean.Booking;
import com.kce.bean.Flight;
import com.kce.bean.Passenger;
import com.kce.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingDAO {
    public boolean createBooking(Booking booking) {
        boolean success = false;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO reservations (flight_id, passenger_id, date) VALUES (?, ?, ?)")) {

            stmt.setInt(1, booking.getFlight().getId());
            stmt.setInt(2, booking.getPassenger().getId());
            stmt.setString(3, booking.getDate());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public Booking getBookingById(int bookingId) {
        Booking booking = null;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT reservations.id, flights.id AS flight_id, airline, source, destination, departure_time, arrival_time, date " +
             	"FROM reservations " +
             	"JOIN flights ON reservations.flight_id = flights.id " +
             	"WHERE reservations.id = ?"))
        		{

            stmt.setInt(1, bookingId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int flightId = rs.getInt("flight_id");
                String airline = rs.getString("airline");
                String source = rs.getString("source");
                String destination = rs.getString("destination");
                String departureTime = rs.getString("departure_time");
                String arrivalTime = rs.getString("arrival_time");
                String date = rs.getString("date");

                Flight flight = new Flight();
                flight.setId(flightId);
                flight.setAirline(airline);
                flight.setSource(source);
                flight.setDestination(destination);
                flight.setDepartureTime(departureTime);
                flight.setArrivalTime(arrivalTime);

                Passenger passenger = getPassengerById(rs.getInt("id"));

                booking = new Booking();
                booking.setId(bookingId);
                booking.setFlight(flight);
                booking.setPassenger(passenger);
                booking.setDate(date);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return booking;
    }

    private Passenger getPassengerById(int passengerId) {
        PassengerDAO passengerDAO = new PassengerDAO();
        return passengerDAO.getPassengerById(passengerId);
    }
}

