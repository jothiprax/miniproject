package com.kce.bean;

public class BookingDetails {
	private String name;
	private int phNo;
	private int busNo;
	private int noOfSeats;
	public BookingDetails(String name, int phNo, int busNo, int noOfSeats) {
		super();
		this.name = name;
		this.phNo = phNo;
		this.busNo = busNo;
		this.noOfSeats = noOfSeats;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhNo() {
		return phNo;
	}
	public void setPhNo(int phNo) {
		this.phNo = phNo;
	}
	public int getBusNo() {
		return busNo;
	}
	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	@Override
	public String toString() {
		return "BookingDetails [name=" + name + ", phNo=" + phNo + ", busNo=" + busNo + ", noOfSeats=" + noOfSeats + "]";
	}

}
