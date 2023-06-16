package com.kce.bean;

public class Bus {
	private int busid;

	private String origin;

	private String desti;

	private int seatsavail;

	private String date;

	private double price;



	public Bus(int busid, String origin, String desti, int seatsavail, String date, double price) {

	super();

	this.busid = busid;

	this.origin = origin;

	this.desti = desti;

	this.seatsavail = seatsavail;

	this.date = date;

	this.price=price;

	}



	public int getBusId() {

	return busid;

	}



	public void setBusId(int busid) {

	this.busid = busid;

	}



	public String getOrigin() {

	return origin;

	}



	public void setOrigin(String origin) {

	this.origin=origin;

	}



	public String getDesti() {

	return desti;

	}



	public void setDesti(String desti) {

	this.desti = desti;

	}



	public int getSeatsAvail() {

	return seatsavail;

	}



	public void setSeatsAvail(int seatsavail) {

	this.seatsavail = seatsavail;

	}



	public String getDate() {

	return date;

	}



	public void setDate(String date) {

	this.date = date;

	}

	public double getPrice() {

	return price;

	}

	public void setPrice(double price) {

	this.price=price;

	}



	@Override

	public String toString() {

	return "Bus [busId=" + busid + ", origin=" + origin + ", desti=" + desti + ", seatsavail="

	+ seatsavail + ", date=" + date + ", price=" + price + "]";

	}



}
