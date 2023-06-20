package com.kce.bean;
	public class Bus {
	    private int busId;
	    private String busName;

	    public Bus(int busId, String busName) {
	        this.busId = busId;
	        this.busName = busName;
	    }

	    public int getBusId() {
	        return busId;
	    }

	    public String getBusName() {
	        return busName;
	    }

	    public void displayDetails() {
	        System.out.println("Bus ID: " + busId);
	        System.out.println("Bus Name: " + busName);
	    }
	}
