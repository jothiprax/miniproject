package com.kce.hotel.bean;
public class Booking {
    private int bookingId;
    private int roomNumber;
    private String guestName;
    private String checkInDate;
    private String checkOutDate;
    
    public Booking(int bookingId,int roomNumber,String guestName,String checkInDate,String checkOutDate){
    	this.bookingId=bookingId;
    	this.roomNumber=roomNumber;
    	this.guestName=guestName;
    	this.checkInDate=checkInDate;
    	this.checkOutDate=checkOutDate;
    }
    public Booking(){
	}
	public int getBookingId(){
    	return bookingId;
    }
    public void setBookingId(int bookingId){
    	this.bookingId=bookingId;
    }
    public int getRoomNumber(){
    	return roomNumber;
    }
    public void setRoomNumber(int roomNumber){
    	this.roomNumber=roomNumber;
    }
    public String getGuestName(){
    	return guestName;
    }
    public void setGuestName(String guestName){
    	this.guestName=guestName;
    }
    public String getCheckInDate(){
    	return checkInDate;
    }
    public void setCheckInDate(String checkInDate){
    	this.checkInDate=checkInDate;
    }
    public String getCheckOutDate(){
    	return checkOutDate;
    }
    public void setCheckOutDate(String checkOutDate){
    	this.checkOutDate=checkOutDate;
    }
}