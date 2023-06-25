package com.kce.Airline.bean;

public class AirlinePassengersDetails {
	public String name;
	public int age;
	public String gender;
	public String moblieNumber;
	public String Address;
	public int AirlineNo;
	public String date;
	public String aadharNumber;
	public AirlinePassengersDetails(String name, int age, String gender, String moblieNumber, String address,
			int airlineNo, String date, String aadharNumber) {
		
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.moblieNumber = moblieNumber;
		this.Address = address;
		this.AirlineNo = airlineNo;
		this.date = date;
		this.aadharNumber = aadharNumber;
	}
	public AirlinePassengersDetails() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMoblieNumber() {
		return moblieNumber;
	}
	public void setMoblieNumber(String moblieNumber) {
		this.moblieNumber = moblieNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getAirlineNo() {
		return AirlineNo;
	}
	public void setAirlineNo(int airlineNo) {
		AirlineNo = airlineNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	@Override
	public String toString() {
		return "AirlinePassengersDetails [name=" + name + ", age=" + age + ", gender=" + gender + ", moblieNumber="
				+ moblieNumber + ", Address=" + Address + ", AirlineNo=" + AirlineNo + ", date=" + date
				+ ", aadharNumber=" + aadharNumber + "]";
	}
	
	
	

}
