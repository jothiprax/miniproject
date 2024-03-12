package com.kce.entity;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
public class Customer {
int CId;
int PId;
String CustomerName;
String ContactNumber;
double PendingAmount;
Date orderDate;
/*public Customer(int cId, String customerName, String contactNumber, double pendingAmount,Date Orderint pId) {
	super();
	CId = cId;
	CustomerName = customerName;
	ContactNumber = contactNumber;
	PendingAmount = pendingAmount;
	/*LocalDate localDate = LocalDate.now();
	LocalDateTime localDateTime = localDate.atStartOfDay();
	Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
	Date date = (Date) Date.from(instant);
	OrderDate=date;
	PId=pId;
}*/
public Customer(int cId, String customerName, String contactNumber, double pendingAmount,int pId) {
	super();
	CId = cId;
	CustomerName = customerName;
	ContactNumber = contactNumber;
	PendingAmount = pendingAmount;
	PId=pId;
}
public int getPId() {
	return PId;
}
public void setPId(int pId) {
	PId = pId;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public void setOrderDate1() {
	LocalDate localDate = LocalDate.now();
	LocalDateTime localDateTime = localDate.atStartOfDay();
	Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
	Date date = (Date) Date.from(instant);
	this.orderDate = date;
}
public int getCId() {
	return CId;
}
public void setCId(int cId) {
	CId = cId;
}
public String getCustomerName() {
	return CustomerName;
}
public void setCustomerName(String customerName) {
	CustomerName = customerName;
}
public String getContactNumber() {
	return ContactNumber;
}
public void setContactNumber(String contactNumber) {
	ContactNumber = contactNumber;
}
public double getPendingAmount() {
	return PendingAmount;
}
public void setPendingAmount(double PAmount,int mode) {
	switch(mode) {
	case 1:
	PendingAmount=PendingAmount+PAmount;
	break;
	case 2:
	PendingAmount=PendingAmount-PAmount;
	break;
	}
}
public double PurchaseAmount(Product p, int quantity) {
	return p.getPrice()*quantity;
}
}
