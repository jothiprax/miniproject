package com.kce.dao;

import com.kce.bean.Booking;
import com.kce.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingDao {
    public void createBooking(Booking booking) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseUtil.getConnection();
            String query = "INSERT INTO Booking (guest_id, room_id, check_in_date, check_out_date, total_amount) " +
                    "VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, booking.getGuest_id());
            statement.setInt(2, booking.getRoom_id());
            statement.setDate(3, new java.sql.Date(booking.getCheck_in_date().getTime()));
            statement.setDate(4, new java.sql.Date(booking.getCheck_out_date().getTime()));
            int b=booking.getBooking_id();
            statement.setDouble(5,b++ );
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public void updateBooking(Booking booking) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseUtil.getConnection();
            String query = "UPDATE Booking SET guest_id=?, room_id=?, check_in_date=?, check_out_date=?, total_amount=? " +
                    "WHERE booking_id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, booking.getGuest_id());
            statement.setInt(2, booking.getRoom_id());
            statement.setDate(3, new java.sql.Date(booking.getCheck_in_date().getTime()));
            statement.setDate(4, new java.sql.Date(booking.getCheck_out_date().getTime()));
            statement.setDouble(5, booking.getTotal_amount());
            statement.setInt(6, booking.getBooking_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public void cancelBooking(int booking_id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseUtil.getConnection();
            String query = "DELETE FROM Booking WHERE booking_id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, booking_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Booking> getBookingsByGuest(int guest_id) {
        List<Booking> bookings = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseUtil.getConnection();
            String query = "SELECT * FROM Booking WHERE guest_id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, guest_id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Booking booking = new Booking();
                booking.setBooking_id(resultSet.getInt("booking_id"));
                booking.setGuest_id(resultSet.getInt("guest_id"));
                booking.setRoom_id(resultSet.getInt("room_id"));
                booking.setCheck_in_date(resultSet.getDate("check_in_date"));
                booking.setCheck_out_date(resultSet.getDate("check_out_date"));
                booking.setTotal_amount(resultSet.getDouble("total_amount"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return bookings;
    }

    public List<Booking> getBookingsByRoom(int room_id) {
        List<Booking> bookings = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseUtil.getConnection();
            String query = "SELECT * FROM Booking WHERE room_id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, room_id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Booking booking = new Booking();
                booking.setBooking_id(resultSet.getInt("booking_id"));
                booking.setGuest_id(resultSet.getInt("guest_id"));
                booking.setRoom_id(resultSet.getInt("room_id"));
                booking.setCheck_in_date(resultSet.getDate("check_in_date"));
                booking.setCheck_out_date(resultSet.getDate("check_out_date"));
                booking.setTotal_amount(resultSet.getDouble("total_amount"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return bookings;
    }
}
