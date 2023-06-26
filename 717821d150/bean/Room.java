package com.kce.bean;
public class Room {

	    private int room_id;
	    private int room_number;
	    private String room_type;
	    private double room_rate;
	    private boolean is_available;

	    public Room() {
	    }

	    public Room(int room_id, int room_number, String room_type, double room_rate, boolean is_available) {
	        this.room_id = room_id;
	        this.room_number = room_number;
	        this.room_type = room_type;
	        this.room_rate = room_rate;
	        this.is_available = is_available;
	    }

	    public int getRoom_id() {
	        return room_id;
	    }

	    public void setRoom_id(int room_id) {
	        this.room_id = room_id;
	    }

	    public int getRoom_number() {
	        return room_number;
	    }

	    public void setRoom_number(int room_number) {
	        this.room_number = room_number;
	    }

	    public String getRoom_type() {
	        return room_type;
	    }

	    public void setRoom_type(String room_type) {
	        this.room_type = room_type;
	    }

	    public double getRoom_rate() {
	        return room_rate;
	    }

	    public void setRoom_rate(double room_rate) {
	        this.room_rate = room_rate;
	    }

	    public boolean isIs_available() {
	        return is_available;
	    }

	    public void setIs_available(boolean is_available) {
	        this.is_available = is_available;
	    }
	    public String toString() {
	        return "Room ID: " + getRoom_id() +
	                ", Room Number: " + getRoom_number() +
	                ", Room Type: " + getRoom_type() +
	                ", Room Rate: " + getRoom_rate() +
	                ", Availability: " + (isIs_available() ? "Available" : "Not Available");
	    }
}
	


