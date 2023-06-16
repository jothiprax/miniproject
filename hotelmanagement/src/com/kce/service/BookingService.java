package com.kce.service;

import com.kce.bean.Booking;
import com.kce.dao.BookingDao;

import java.util.List;

public class BookingService {
    private BookingDao bookingDao;

    public BookingService() {
        bookingDao = new BookingDao();
    }

    public void createBooking(Booking booking) {
        bookingDao.createBooking(booking);
    }

    public void updateBooking(Booking booking) {
        bookingDao.updateBooking(booking);
    }

    public void cancelBooking(int bookingId) {
        bookingDao.cancelBooking(bookingId);
    }

    public List<Booking> getBookingsByGuest(int guestId) {
        return bookingDao.getBookingsByGuest(guestId);
    }

    public List<Booking> getBookingsByRoom(int roomId) {
        return bookingDao.getBookingsByRoom(roomId);
    }

	public Booking getBookingById(int bookingToUpdateId) {
		// TODO Auto-generated method stub
		return null;
	}
}
