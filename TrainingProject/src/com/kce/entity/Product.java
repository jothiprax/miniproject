package com.kce.entity;

import java.sql.Connection;

import com.kce.DbUtil.ConnectToDB;

public class Product {
int	PId;
String PName;
int Stock;
double price;
public Product(int pId, String pName, int stock, double price) {
	super();
	PId = pId;
	PName = pName;
	Stock = stock;
	this.price = price;
}
public int getPId() {
	return PId;
}
public void setPId(int pId) {
	PId = pId;
}
public String getPName() {
	return PName; 
}
public void setPName(String pName) {
	PName = pName;
}
public int getStock() {
	return Stock;
}
public void setStock(int stock) {
	Stock = stock;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public void  newLoad(int bags) {
	Stock=Stock+bags;
}
public void  AfterPurchase(int bags) {
	Stock=Stock-bags;
}
}