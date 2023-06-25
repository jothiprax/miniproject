package com.kce.hotel.bean;

public class Payment {
private String CustomerName;
private String PaymentType;
private String PaymentStatus;
private String Roomtype;
public Payment(String customerName, String paymentType, String paymentStatus, String roomtype) {
	super();
	CustomerName = customerName;
	PaymentType = paymentType;
	PaymentStatus = paymentStatus;
	Roomtype = roomtype;
}
public String getCustomerName() {
	return CustomerName;
}
public void setCustomerName(String customerName) {
	CustomerName = customerName;
}
public String getPaymentType() {
	return PaymentType;
}
public void setPaymentType(String paymentType) {
	PaymentType = paymentType;
}
public String getPaymentStatus() {
	return PaymentStatus;
}
public void setPaymentStatus(String paymentStatus) {
	PaymentStatus = paymentStatus;
}
public String getRoomtype() {
	return Roomtype;
}
public void setRoomtype(String roomtype) {
	Roomtype = roomtype;
}

}
