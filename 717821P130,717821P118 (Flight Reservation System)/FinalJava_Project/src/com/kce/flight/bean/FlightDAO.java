package com.kce.flight.bean;

public class FlightDAO {
	public int flightId;
	private String flightName;
	private String Depature;
	private String Arrival;
	private int price;
	private int capacity;

	public FlightDAO(int flightId) {
		this.flightId = flightId;
	}

	public FlightDAO(int flightId, String flightName, String depature, String arrival, int price, int capacity) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.Depature = depature;
		this.Arrival = arrival;
		this.price = price;
		this.capacity = capacity;
	}


	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getDepature() {
		return Depature;
	}

	public void setDepature(String depature) {
		Depature = depature;
	}

	public String getArrival() {
		return Arrival;
	}

	public void setArrival(String arrival) {
		Arrival = arrival;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
