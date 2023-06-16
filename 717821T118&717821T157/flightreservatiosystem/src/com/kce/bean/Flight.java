package com.kce.bean;


public class Flight {
    private int flightId;
    private String sourceCity;
    private String destinationCity;
    private int availableSeats;

    public Flight(int flightId, String sourceCity, String destinationCity, int availableSeats) {
        this.flightId = flightId;
        this.sourceCity = sourceCity;
        this.destinationCity = destinationCity;
        this.availableSeats = availableSeats;
    }

    public int getFlightId() {
        return flightId;
    }

    public String getSourceCity() {
        return sourceCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}