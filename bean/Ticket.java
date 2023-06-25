package com.kce.bean;
public class Ticket {
    private int ticketId;
    private int busId;
    private String passengerName;

    public Ticket(int ticketId, int busId, String passengerName) {
        this.ticketId = ticketId;
        this.busId = busId;
        this.passengerName = passengerName;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getBusId() {
        return busId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void displayDetails() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Bus ID: " + busId);
        System.out.println("Passenger Name: " + passengerName);
    }
}
