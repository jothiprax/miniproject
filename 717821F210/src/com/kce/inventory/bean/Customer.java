package com.kce.inventory.bean;

public class Customer {
	
	private int customerId;
	private String customerName;
	private String location;
	private long number;
	
	public Customer(int customerId, String customerName, String location, long number) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.location = location;
		this.number = number;
	}

	public Customer() {
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", location=" + location
				+ ", number=" + number + "]";
	}
	
}
