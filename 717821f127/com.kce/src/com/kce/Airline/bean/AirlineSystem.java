package com.kce.Airline.bean;

public class AirlineSystem {
	public int AirlineNo;
	public String source;
	public String destination;
	public String date;
	public String takeoftime;
	public int noOfseats;
	public AirlineSystem(int airlineNo, String source, String destination, String date, String takeoftime,
			int noOfseats) {
		
		this.AirlineNo = airlineNo;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.takeoftime = takeoftime;
		this.noOfseats = noOfseats;
	}
	public AirlineSystem() {
		
	}
	public int getAirlineNo() {
		return AirlineNo;
	}
	public void setAirlineNo(int airlineNo) {
		AirlineNo = airlineNo;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTakeoftime() {
		return takeoftime;
	}
	public void setTakeoftime(String takeoftime) {
		this.takeoftime = takeoftime;
	}
	public int getNoOfseats() {
		return noOfseats;
	}
	public void setNoOfseats(int noOfseats) {
		this.noOfseats = noOfseats;
	}
	@Override
	public String toString() {
		return "AirlineSystem [AirlineNo=" + AirlineNo + ", source=" + source + ", destination=" + destination
				+ ", date=" + date + ", takeoftime=" + takeoftime + ", noOfseats=" + noOfseats + "]";
	}
	
	
}
