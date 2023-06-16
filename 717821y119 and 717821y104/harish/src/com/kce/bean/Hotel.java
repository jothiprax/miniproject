package com.kce.bean;

public class Hotel {
	private String name;
	private int hotelId;
	private String City;
	private String phoneNumber;
	private int noOfRooms;
	public Hotel(String name, int hotelId, String city, String phoneNumber,int noOfRooms) {
		this.name = name;
		this.hotelId = hotelId;
		City = city;
		this.phoneNumber = phoneNumber;
		this.noOfRooms=noOfRooms;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	
	
}
