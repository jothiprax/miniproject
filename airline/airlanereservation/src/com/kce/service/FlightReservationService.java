package com.kce.service;

import com.kce.bean.Flight;
import com.kce.dao.FlightDAO;

import java.util.List;

public class FlightReservationService {
    private FlightDAO flightDAO;

    public FlightReservationService() {
        this.flightDAO = new FlightDAO();
    }

    public void addFlight(Flight flight) {
        flightDAO.addFlight1(flight);
    }

    public List<Flight> getAllFlights() {
        return flightDAO.getAllFlights();
    }

    public static void main(String[] args) {
        FlightReservationService service = new FlightReservationService();

        // Add new flights
        Flight flight1 = new Flight();
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
    }
}
