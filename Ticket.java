package com.kce.bean;
public class Ticket {

	    private int ticketId;
	    private int trainId;
	    private String passengerName;

	    public Ticket(int ticketId, int trainId, String passengerName) {
	        this.ticketId = ticketId;
	        this.trainId = trainId;
	        this.passengerName = passengerName;
	    }

	    public int getTicketId() {
	        return ticketId;
	    }

	    public int getTrainId() {
	        return trainId;
	    }

	    public String getPassengerName() {
	        return passengerName;
	    }

	    public void displayDetails() {
	        System.out.println("Ticket ID: " + ticketId);
	        System.out.println("Train ID: " + trainId);
	        System.out.println("Passenger Name: " + passengerName);
	    }
}
