package com.kce.bean;

public class BookingDetails {
	private String name;

	private String phNo;

	private int busNo;

	private int noOfSeats;

	public BookingDetails(String name, String phNo, int busNo, int noOfSeats) {

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

	public String getPhNo() {

		return phNo;

	}

	public void setPhNo(String phNo) {

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
