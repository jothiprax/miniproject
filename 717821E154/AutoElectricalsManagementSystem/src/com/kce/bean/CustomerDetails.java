package com.kce.bean;

public class CustomerDetails {
	private String CustomerName;
	private String Address;
	private String MobileNo;
	private String GstNo;
	
	//CONSTRUCTOR
	
	public CustomerDetails() {
		super();
	}
	public String getGstNo() {
		return GstNo;
	}
	public void setGstNo(String gstNo) {
		GstNo = gstNo;
	}
	public CustomerDetails(String customerName, String address, String mobileNo, String gstNo) {
		super();
		CustomerName = customerName;
		Address = address;
		MobileNo = mobileNo;
		GstNo = gstNo;
	}
	
	//GETTER AND SETTER
	
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}	
}
