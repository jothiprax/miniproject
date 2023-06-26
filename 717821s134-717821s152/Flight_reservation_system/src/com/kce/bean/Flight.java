package com.kce.bean;

public class Flight {
    private int id;
    private String airline;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    public Flight() {
    	
    }
	public Flight(int id,String airline,String source,String destination,String departureTime,String arrivalTime) {
		this.id = id;
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
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
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", airline=" + airline + ", source=" + source + ", destination=" + destination
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + "]";
	}
	
	
    
    // Constructor, getters, and setters
}
