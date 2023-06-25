package com.kce.bean;

public class Customer {
    String name;
    int noOfPerson;
    String address;
    String phno;
	public Customer() {
		super();
	}
	public Customer(String name, int noOfPerson, String address, String phno) {
		super();
		this.name = name;
		this.noOfPerson = noOfPerson;
		this.address = address;
		this.phno = phno;
	}
	public String getName() {
		return name;
	}
	public int getNoOfPerson() {
		return noOfPerson;
	}
	public String getAddress() {
		return address;
	}
	public String getPhno() {
		return phno;
	}
	public String toString() {
		return "Customer [name=" + name + ", noOfPerson=" + noOfPerson + ", address=" + address + ", phno=" + phno
				+ "]";
	}
    
}
