package com.kce.dao;

import com.kce.bean.Flight;
import com.kce.bean.Passenger;

import java.util.List;

public class PassengersDAO {
    public static void main(String[] args) {
        PassengersDAO service = new PassengersDAOService();

        // Add new flights
        Flight flight1 = new Flight(null, null, null, 0);
        flight1.setFlightNumber("F123");
        flight1.setOrigin("New York");
        flight1.setDestination("Los Angeles");
        flight1.setAvailableSeats(150);
        service.addFlight(flight1);

        Flight flight2 = new Flight();
        flight2.setFlightNumber("F456");
        flight2.setOrigin("Chicago");
        flight2.setDestination("San Francisco");
        flight2.setAvailableSeats(100);
        service.addFlight(flight2);

        // Get all flights
        List<Flight> flights = service.getAllFlights();
        for (Flight flight : flights) {
            System.out.println("Flight Number: " + flight.getFlightNumber());
            System.out.println("Origin: " + flight.getOrigin());
            System.out.println("Destination: " + flight.getDestination());
            System.out.println("Available Seats: " + flight.getAvailableSeats());
            System.out.println();
        }

        // Add a passenger
        Passenger passenger = new Passenger();
        passenger.setPassengerName("John Doe");
        passenger.setFlightNumber("F123");
        service.addPassenger(passenger);
    }
}
