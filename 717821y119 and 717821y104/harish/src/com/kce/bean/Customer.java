package com.kce.bean;

public class Customer {
	public Customer(String customerName, int hotelId, int bookingId, int roomNo,int noOfDays, String bookDate,String roomtype) {
		this.customerName = customerName;
		this.hotelId = hotelId;
		this.bookingId = bookingId;
		this.roomNo = roomNo;
		this.noOfDays=noOfDays;
		this.bookDate=bookDate;
		this.roomtype=roomtype;
	}
	private String customerName;
	private int hotelId;
	private int bookingId;
	private int roomNo;
	private int noOfDays;
	private String bookDate;
	private String roomtype;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public String getBookDate() {
		return bookDate;
	}
	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	
}
