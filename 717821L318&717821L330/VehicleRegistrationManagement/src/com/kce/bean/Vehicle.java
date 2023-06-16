package com.kce.bean;

public class Vehicle {
	private int id;
	private int vin;
	private String ownername;
	private String brand;
	private String model;
	private String vehicleno;
	private String phoneNumber;
	private String email;

	private String color;
	private String Date;

	public Vehicle() {
	}

	public Vehicle(int id, int vin, String ownername, String brand, String model, String vehicleno, String color,
			String phoneNumber, String email, String Date) {
		this.id = id;
		this.vin = vin;
		this.ownername = ownername;
		this.brand = brand;
		this.model = model;
		this.vehicleno = vehicleno;
		this.color = color;
		this.phoneNumber = phoneNumber;
		this.email = email;

		this.Date = Date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVin() {
		return vin;
	}

	public void setVin(int vin) {
		this.vin = vin;
	}

	public String getOwnerName() {
		return ownername;
	}

	public void setOwnerName(String ownername) {
		this.ownername = ownername;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVehicleNo() {
		return vehicleno;
	}

	public void setVehicleNo(String vehicleno) {
		this.vehicleno = vehicleno;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String Date) {
		this.Date = Date;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}