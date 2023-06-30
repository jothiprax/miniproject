
package com.kce.bean;

public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private int availableSeats;
	public Flight(String flightNumber,String origin,String destination,int availableSeats) {
		super();
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.availableSeats = availableSeats;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber1(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination1(String destination) {
		this.destination = destination;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public void setFlightNumber(String flightNumber2) {
		// TODO Auto-generated method stub
		
	}
	public void setDestination(String destination2) {
		// TODO Auto-generated method stub
		
	}
	public String getFlightNumber1() {
		// TODO Auto-generated method stub
		return null;
	}

    
}

