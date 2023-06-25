package com.kce.bean;

public class CustomerDet {
	private String name;
	private long mobilenumber;
	private String address;
	private int pid;
	private int quantity;
	public CustomerDet(String name, long mobilenumber, String address, int pid, int quantity) {
		super();
		this.name = name;
		this.mobilenumber = mobilenumber;
		this.address = address;
		this.pid = pid;
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CustomerDet [name=" + name + ", mobilenumber=" + mobilenumber + ", address=" + address + ", pid=" + pid
				+ ", quantity=" + quantity + "]";
	}

}
