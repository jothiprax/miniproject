package com.kce.ecommerce.bean;

public class Shopping {
private int TransactionID;
private String CustomerName;
private String ProductName;
private String ProductId;
private String CustomerMailId;
private String Password;
private String AddressLine;
private String OrderId;
private String OrderStatus;

public int getTransactionID() {
	return TransactionID;
}
public void setTransactionID(int transactionID) {
	TransactionID = transactionID;
}

public String getCustomerName() {
	return CustomerName;
}
public void setCustomerName(String customerName) {
	CustomerName = customerName;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getCustomerMailId() {
	return CustomerMailId;
}
public void setCustomerMailId(String customerMailId) {
	CustomerMailId = customerMailId;
}
public String getAddressLine() {
	return AddressLine;
}
public void setAddressLine(String addressLine) {
	AddressLine = addressLine;
}
public String getOrderId() {
	return OrderId;
}
public void setOrderId(String orderId) {
	OrderId = orderId;
}
public String getOrderStatus() {
	return OrderStatus;
}
public void setOrderStatus(String orderStatus) {
	OrderStatus = orderStatus;
}
public String getProductName() {
	return ProductName;
}
public void setProductName(String productName) {
	ProductName = productName;
}
public String getProductId() {
	return ProductId;
}
public void setProductId(String productId) {
	ProductId = productId;
}


}
