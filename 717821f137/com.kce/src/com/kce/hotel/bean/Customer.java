package com.kce.hotel.bean;

public class Customer {
private String CustomerId;
private String CustomerName;
private String ContactNo;
private String Gender;
public Customer(String customerId, String customerName, String contactNo, String gender) {
	super();
	CustomerId = customerId;
	CustomerName = customerName;
	ContactNo = contactNo;
	Gender = gender;
}
public String getCustomerId() {
	return CustomerId;
}
public void setCustomerId(String customerId) {
	CustomerId = customerId;
}
public String getCustomerName() {
	return CustomerName;
}
public void setCustomerName(String customerName) {
	CustomerName = customerName;
}
public String getContactNo() {
	return ContactNo;
}
public void setContactNo(String contactNo) {
	ContactNo = contactNo;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender = gender;
}

}
