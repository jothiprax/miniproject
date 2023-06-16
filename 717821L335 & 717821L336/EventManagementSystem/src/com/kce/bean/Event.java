package com.kce.bean;

public class Event {
	   protected String name;
	    protected String date;
	    protected int capacity;

	    public Event(String name, String date, int capacity) {
	        this.name = name;
	        this.date = date;
	        this.capacity = capacity;
	    }
	    public String getName1() {
	        return name;
	    }

	    public String getDate() {
	        return date;
	    }

	    public int getCapacity() {
	        return capacity;
	    }
	    
	    public void setDate(String date) {
	    	this.date = date;
	    }
	    public void setCapacity(int capacity) {
	    	this.capacity = capacity;
	    }
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}
	    


}
