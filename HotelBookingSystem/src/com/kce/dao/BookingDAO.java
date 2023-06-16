package com.kce.dao;

import com.kce.bean.Booking;
import com.kce.bean.Customer;
import com.kce.bean.Room;
import com.kce.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private static final String INSERT_BOOKING = "INSERT INTO bookings (check_in_date, check_out_date, customer_id, room_id) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_BOOKINGS = "SELECT * FROM bookings";

    public static void addBooking(Booking booking) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_BOOKING)) {
            statement.setDate(1, new Date(booking.getCheckInDate().getTime()));
            statement.setDate(2, new Date(booking.getCheckOutDate().getTime()));
            statement.setInt(3, booking.getCustomer().getId());
            statement.setInt(4, booking.getRoom().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BOOKINGS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date checkInDate = resultSet.getDate("check_in_date");
                Date checkOutDate = resultSet.getDate("check_out_date");
                int customerId = resultSet.getInt("customer_id");
                int roomId = resultSet.getInt("room_id");
                Customer customer = CustomerDAO.getCustomerById(customerId);
                Room room = RoomDAO.getRoomById(roomId);
                Booking booking = new Booking(checkInDate, checkOutDate, customer, room);
                booking.setId(id);
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public static Booking getBookingById(int id) {
        Booking booking = null;
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM bookings WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Date checkInDate = resultSet.getDate("check_in_date");
                Date checkOutDate = resultSet.getDate("check_out_date");
                int customerId = resultSet.getInt("customer_id");
                int roomId = resultSet.getInt("room_id");
                Customer customer = CustomerDAO.getCustomerById(customerId);
                Room room = RoomDAO.getRoomById(roomId);
                booking = new Booking(checkInDate, checkOutDate, customer, room);
                booking.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booking;
    }
}
