package com.kce.bean;

public class Hotel {
	int roomno;
    String status;
    int floor;
    public Hotel() {
		super();
	}
	public Hotel(int roomno,int floor,String status) {
    	this.roomno=roomno;
    	this.floor=floor;
    	this.status=status;
    }
	public int getRoomno() {
		return roomno;
	}
	public String getStatus() {
		return status;
	}
	public int getFloor() {
		return floor;
	}
	public String toString() {
		return "Hotel [roomno=" + roomno + ", status=" + status + ", floor=" + floor + "]";
	}
	
    
}
