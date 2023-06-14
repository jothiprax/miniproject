package com.RKFoodOrder.bean;

public class Customer {
   String Customer_name;
   String Customer_address;
  private String Customer_phonenum;
  String Customer_mail;
public Customer(String customer_name,  String customer_phonenum, String customer_address,String customer_mail) {
	super();
	this.Customer_name = customer_name;
	this.Customer_phonenum = customer_phonenum;
	this.Customer_address = customer_address;
	this.Customer_mail = customer_mail;
}
public Customer(String customer_name) {
	this.Customer_name = customer_name;
}
public Customer() {
	// TODO Auto-generated constructor stub
}
public String getCustomer_name() {
	return Customer_name;
}
public void setCustomer_name(String customer_name) {
	Customer_name = customer_name;
}
public String getCustomer_phonenum() {
	return Customer_phonenum;
}
public void setCustomer_phonenum(String customer_phonenum) {
	Customer_phonenum = customer_phonenum;
}
public String getCustomer_address() {
	return Customer_address;
}
public void setCustomer_address(String customer_address) {
	Customer_address = customer_address;
}
public String getCustomer_mail() {
	return Customer_mail;
}
public void setCustomer_mail(String customer_mail) {
	Customer_mail = customer_mail;
}
   
}
