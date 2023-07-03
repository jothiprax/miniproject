package com.kce.flight.bean;

public class PassengerDAO extends FlightDAO {
	private int passengerId;
	private String passengerName;
	private String passengerAddress;
	private String date;

	public PassengerDAO(int passengerId, String passengerName, String passengerAddress, int flightId, String date) {
		super(flightId);
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerAddress = passengerAddress;
		this.date = date;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerAddress() {
		return passengerAddress;
	}

	public void setPassengerAddress(String passengerAddress) {
		this.passengerAddress = passengerAddress;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
