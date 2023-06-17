package com.kce.bean;

public class flightDetails {
	private int flightId;
	private String source;
	private String destination;
	private int seatsAvailable;
	private String date;
	private double priceOfSingleSeat;

	public flightDetails(int flightId, String source, String destination, int seatsAvailable, String date,double priceOfSingleSeat) {
		super();
		this.flightId = flightId;
		this.source = source;
		this.destination = destination;
		this.seatsAvailable = seatsAvailable;
		this.date = date;
		this.priceOfSingleSeat=priceOfSingleSeat;
	}

	public int getflightId() {
		return flightId;
	}

	public void setflightId(int flightId) {
		this.flightId = flightId;
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

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public double getPriceOfSingleSeat() {
		return priceOfSingleSeat;
	}
	public void setPriceOfSingleSeat(double priceOfSingleSeat) {
		this.priceOfSingleSeat=priceOfSingleSeat;
	}

	@Override
	public String toString() {
		return "BusDetails [flightId=" + flightId + ", source=" + source + ", destination=" + destination + ", seatsAvailable="
				+ seatsAvailable + ", date=" + date + ", priceOfSingleSeat=" + priceOfSingleSeat + "]";
	}
}
