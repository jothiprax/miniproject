package com.kce.service;

import com.kce.bean.Booking;
import com.kce.dao.BookingDAO;

import java.util.List;

public class BookingService {
    public static void addBooking(Booking booking) {
        BookingDAO.addBooking(booking);
    }

    public static List<Booking> getAllBookings() {
        return BookingDAO.getAllBookings();
    }

    public static Booking getBookingById(int id) {
        return BookingDAO.getBookingById(id);
    }
}
