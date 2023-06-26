package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.kce.bean.Booking1;
import com.kce.util.ConnectionUtil;

public class BookingDAO {
    private static final String INSERT_BOOKING_SQL = "INSERT INTO booking (room_id, customer_id, check_in_date, check_out_date, total_price) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_BOOKINGS_SQL = "SELECT * FROM booking";
    private static final String DELETE_BOOKING_SQL = "DELETE FROM booking WHERE id = ?";
    private static final String UPDATE_BOOKING_SQL = "UPDATE booking SET room_id = ?, customer_id = ?, check_in_date = ?, check_out_date = ?, total_price = ? WHERE id = ?";
    private static final String SELECT_BOOKING_BY_ID_SQL = "SELECT * FROM booking WHERE id = ?";

    public void insertBooking(Booking1 booking) throws SQLException {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKING_SQL)) {
            preparedStatement.setInt(1, booking.getRoomId());
            preparedStatement.setInt(2, booking.getCustomerId());
            preparedStatement.setString(3, booking.getCheckInDate());
            preparedStatement.setString(4, booking.getCheckOutDate());
            preparedStatement.setDouble(5, booking.getTotalPrice());
            preparedStatement.executeUpdate();
        }
    }

    public List<Booking1> selectAllBookings() {
        List<Booking1> bookings = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKINGS_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int roomId = rs.getInt("room_id");
                int customerId = rs.getInt("customer_id");
                String checkInDate = rs.getString("check_in_date");
                String checkOutDate = rs.getString("check_out_date");
                double totalPrice = rs.getDouble("total_price");
                bookings.add(new Booking1(id, roomId, customerId, checkInDate, checkOutDate, totalPrice));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public void deleteBooking(int id) throws SQLException {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOKING_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public void updateBooking(Booking1 booking) throws SQLException {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOKING_SQL)) {
            preparedStatement.setInt(1, booking.getRoomId());
            preparedStatement.setInt(2, booking.getCustomerId());
            preparedStatement.setString(3, booking.getCheckInDate());
            preparedStatement.setString(4, booking.getCheckOutDate());
            preparedStatement.setDouble(5, booking.getTotalPrice());
            preparedStatement.setInt(6, booking.getId());
            preparedStatement.executeUpdate();
        }
    }
    public Booking1 selectBookingById(int id) {
        Booking1 booking=null;
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKING_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int roomId = rs.getInt("room_id");
                int customerId = rs.getInt("customer_id");
                String checkInDate = rs.getString("check_in_date");
                String checkOutDate = rs.getString("check_out_date");
                double totalPrice = rs.getDouble("total_price");
                booking = new Booking1(id,roomId, customerId, checkInDate, checkOutDate, totalPrice);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return booking;
    }
	public List<Booking1> getAllBookings() {
		return null;
	}
}