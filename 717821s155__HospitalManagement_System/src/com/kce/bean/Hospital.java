package com.kce.bean;

public class Hospital {

	private String Name;
	private String Address;
	

	public Hospital(String name, String address) {
		
		Name = name;
		Address = address;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "Hospital [Name=" + Name + ", Address=" + Address + "]";
	}
	
}
