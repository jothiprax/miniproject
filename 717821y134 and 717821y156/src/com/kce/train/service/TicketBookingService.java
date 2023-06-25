package com.kce.train.service;

import java.util.HashMap;
import java.util.Map;

import com.kce.train.bean.Passenger;
import com.kce.train.bean.Ticket;

public class TicketBookingService {
    private Map<Integer, Ticket> tickets;
    private int ticketIdCounter;

    public TicketBookingService() {
        tickets = new HashMap<>();
        ticketIdCounter = 1;
    }

    public Ticket bookTicket(Passenger passenger, String trainNumber, double concession) {
        Ticket ticket = new Ticket();
        ticket.setTicketId(ticketIdCounter);
        ticket.setPassengerId(passenger.getPassengerId());
        ticket.setTrainNumber(trainNumber);
        double fare = calculateFare(trainNumber, passenger.getAge(), concession);
        ticket.setFare(fare);
        ticket.setConcession(concession);
        tickets.put(ticketIdCounter, ticket);
        ticketIdCounter++;
        return ticket;
    }

    private double calculateFare(String trainNumber, int passengerAge, double concession) {
        // Add your fare calculation logic here based on train number, passenger age, and concession
        return 0.0; // Placeholder return value, replace with your calculation
    }

    public void viewTicket(int ticketId) {
        if (tickets.containsKey(ticketId)) {
            Ticket ticket = tickets.get(ticketId);
            System.out.println("Ticket ID: " + ticket.getTicketId());
            System.out.println("Passenger ID: " + ticket.getPassengerId());
            System.out.println("Train Number: " + ticket.getTrainNumber());
            System.out.println("Fare: " + ticket.getFare());
            System.out.println("Concession: " + ticket.getConcession());
        } else {
            System.out.println("Ticket not found.");
        }
    }
}
