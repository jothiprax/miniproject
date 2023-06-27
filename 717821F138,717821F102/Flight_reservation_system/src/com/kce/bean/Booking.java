package com.kce.bean;

public class Booking {
	 private int id;
	 private Flight flight;
	 private Passenger passenger;
	 private String date;
	 public Booking() {
		 
	 }
	public Booking(int id, Flight flight, Passenger passenger, String date) {
		super();
		this.id = id;
		this.flight = flight;
		this.passenger = passenger;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", flight=" + flight + ", passenger=" + passenger + ", date=" + date + "]";
	}
	    // Constructor, getters, and setters
}

