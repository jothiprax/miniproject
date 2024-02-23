package com.kce.service;

import com.kce.bean.Booking;
import com.kce.bean.Flight;
import com.kce.bean.Passenger;
import com.kce.dao.BookingDAO;
import com.kce.dao.FlightDAO;
import com.kce.dao.PassengerDAO;

public class FlightReservationSystemApp {
    public static void main(String[] args) {
        // Create instances of DAO classes
        FlightDAO flightDAO = new FlightDAO();
        PassengerDAO passengerDAO = new PassengerDAO();
        BookingDAO bookingDAO = new BookingDAO();
        
        // Retrieve flight by ID
        int flightId=1;
        Flight flight = flightDAO.getFlightById(flightId);
        if (flight != null) {
            System.out.println("FLIGHT DETAILS:");
            System.out.println("    Flight ID: " + flight.getId());
            System.out.println("    Airline: " + flight.getAirline());
            System.out.println("    Source: " + flight.getSource());
            System.out.println("    Destination: " + flight.getDestination());
            System.out.println("    Departure Time: " + flight.getDepartureTime());
            System.out.println("    Arrival Time: " + flight.getArrivalTime());
            System.out.println();
        } else {
            System.out.println("Flight not found.");
        }

        // Retrieve passenger by ID
        int passengerId=1;
        Passenger passenger = passengerDAO.getPassengerById(passengerId);
        if (passenger != null) {
            System.out.println("PASSENGER DETAILS:");
            System.out.println("    Passenger ID: " + passenger.getId());
            System.out.println("    Name: " + passenger.getName());
            System.out.println("    Email: " + passenger.getEmail());
            System.out.println("    Phone: " + passenger.getPhone());
            System.out.println();
        } else {
            System.out.println("Passenger not found.");
        }

        // Create a booking
        Booking booking = new Booking();
        booking.setFlight(flight);
        booking.setPassenger(passenger);
        booking.setDate("2023-06-18");

        boolean success = bookingDAO.createBooking(booking);
        if (success) {
            System.out.println("Booking created successfully.");
            System.out.println();
        } else {
            System.out.println("Failed to create booking.");
        }

        // Retrieve booking by ID
        int bookingId=1;
        Booking retrievedBooking = bookingDAO.getBookingById(bookingId);
        if (retrievedBooking != null) {
            System.out.println("BOOKING DETAILS:");
            System.out.println("     Booking ID: " + retrievedBooking.getId());
            System.out.println("     Flight Details:");
            System.out.println("     Flight ID: " + retrievedBooking.getFlight().getId());
            System.out.println("     Airline: " + retrievedBooking.getFlight().getAirline());
            System.out.println("     Source: " + retrievedBooking.getFlight().getSource());
            System.out.println("     Destination: " + retrievedBooking.getFlight().getDestination());
            System.out.println("     Departure Time: " + retrievedBooking.getFlight().getDepartureTime());
            System.out.println("     Arrival Time: " + retrievedBooking.getFlight().getArrivalTime());
            System.out.println("     Passenger Details:");
            System.out.println("     Passenger ID: " + retrievedBooking.getPassenger().getId());
            System.out.println("     Name: " + retrievedBooking.getPassenger().getName());
            System.out.println("     Email: " + retrievedBooking.getPassenger().getEmail());
            System.out.println("     Phone: " + retrievedBooking.getPassenger().getPhone());
            System.out.println("     Date: " + retrievedBooking.getDate());
        }
        else {
        	System.out.println("Booking not found.");
        }
    }
}

