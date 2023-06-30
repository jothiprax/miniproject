package com.kce.service;

import com.kce.bean.*;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create some hotels
        Hotel hotel1 = new Hotel("Hotel A", "Location A");
        Hotel hotel2 = new Hotel("Hotel B", "Location B");

        // Add hotels to the database
        HotelService.addHotel(hotel1);
        HotelService.addHotel(hotel2);

        // Get all hotels from the database
        List<Hotel> hotels = HotelService.getAllHotels();
        System.out.println("All Hotels:");
        for (Hotel hotel : hotels) {
            System.out.println(hotel);
        }
        System.out.println();

        // Create some rooms
        Room room1 = new Room("101", "Standard", 100.0, hotel1);
        Room room2 = new Room("201", "Deluxe", 150.0, hotel2);

        // Add rooms to the database
        RoomService.addRoom(room1);
        RoomService.addRoom(room2);

        // Get all rooms from the database
        List<Room> rooms = RoomService.getAllRooms();
        System.out.println("All Rooms:");
        for (Room room : rooms) {
            System.out.println(room);
        }
        System.out.println();

        // Create a customer
        Customer customer = new Customer("John Doe", "1234567890", "john.doe@example.com");

        // Add customer to the database
        CustomerService.addCustomer(customer);

        // Get all customers from the database
        List<Customer> customers = CustomerService.getAllCustomers();
        System.out.println("All Customers:");
        for (Customer c : customers) {
            System.out.println(c);
        }
        System.out.println();

        // Create a booking
        Booking booking = new Booking(checkInDate, checkOutDate, customer, room1);

        // Add booking to the database
        BookingService.addBooking(booking);

        // Get all bookings from the database
        List<Booking> bookings = BookingService.getAllBookings();
        System.out.println("All Bookings:");
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }
}
