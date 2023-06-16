package com.kce.service;

import com.kce.bean.Flight;
import com.kce.dao.FlightDAO;

import java.util.List;

public class FlightService {
    public static void addFlight(Flight flight) {
        FlightDAO.addFlight(flight);
    }

    public static List<Flight> getAllFlights() {
        return FlightDAO.getAllFlights();
    }

    public static Flight getFlightById(int id) {
        return FlightDAO.getFlightById(id);
    }
}
