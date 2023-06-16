package com.kce.bean;

public class Luggage {
    private int id;
    private String tag;
    private double weight;
    private Passenger passenger;
    private Flight flight;

    public Luggage(String tag, double weight, Passenger passenger, Flight flight) {
        this.tag = tag;
        this.weight = weight;
        this.passenger = passenger;
        this.flight = flight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
