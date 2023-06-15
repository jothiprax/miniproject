package com.RKFoodOrder.bean;
import java.sql.Date;
import java.sql.Time;
public class Payment extends Customer{
private double paid_amount;
private String transaction_id;
private Date paid_date;
private Time paid_time;
public Payment(String Customer_name) {
	super(Customer_name);
} 
public Payment() {
	// TODO Auto-generated constructor stub
}
public String Customer_name(){
	return Customer_name;
}
public void Customer_name(String Customer_name) {
	this.Customer_name = Customer_name;
}
public double getPaid_amount() {
	return paid_amount;
}
public void setPaid_amount(double paid_amount){
	this.paid_amount = paid_amount;
}
public String getTransaction_id() {
	return transaction_id;
}
public void setTransaction_id(String transaction_id) {
	this.transaction_id = transaction_id;
}
public Date getPaid_date() {
	return paid_date;
}
public void setPaid_date(Date paid_date) {
	this.paid_date = paid_date;
}
public Time getPaid_time() {
	return paid_time;
}
public void setPaid_time(Time paid_time) {
	this.paid_time = paid_time;
}
}
