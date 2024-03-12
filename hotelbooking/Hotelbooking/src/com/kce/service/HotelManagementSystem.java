package com.kce.service;

import java.sql.SQLException;
import java.util.List;
import com.kce.bean.Customer;
import com.kce.bean.Booking1;
import com.kce.dao.CustomerDAO;
import com.kce.dao.BookingDAO;

public class HotelManagementSystem {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        BookingDAO bookingDAO = new BookingDAO();
        try {
            Customer customer = new Customer(1, "John Doe", "123-456-7890", "johndoe@email.com", "123 Main St");
            customerDAO.insertCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Customer> customers = customerDAO.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer.getName());
        }
        try {
            Booking1 booking = new Booking1(1, "2022-01-01", "2022-01-05", 1, 1);
            bookingDAO.insertBooking(booking);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Booking1> bookings = bookingDAO.getAllBookings();
        for (Booking1 booking : bookings) {
            System.out.println(booking.getCheckInDate() + " - " + booking.getCheckOutDate());
        }
        try {
            Customer customer = new Customer(1, "John Smith", "123-456-7890", "johnsmith@email.com", "123 Main St");
            customerDAO.updateCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }

      
    }
}