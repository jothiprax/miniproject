package com.kce.bean;

public class Booking1 {
    private int id;
    private int roomId;
    private int customerId;
    private String checkInDate;
    private String checkOutDate;
    private double totalPrice;
	public Booking1(int id2, int roomId2, int customerId2, String checkInDate2, String checkOutDate2,
			double totalPrice2) {
		
	}
	
	public Booking1(int i, String string, String string2, int j, int k) {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
    
}

