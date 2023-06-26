package com.kce.bean;

public class Restaurant {
       String name;
       double price;
       int quantity;
       double totalPrice;
       public Restaurant(String name, double price, int quantity) {
    	   this.name=name;
    	   this.price=price;
    	   this.quantity=quantity;
    	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getTotalPrice() {
	    totalPrice = price * quantity;
	    return totalPrice;
	}
	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", price=" + price + ", quantity=" + quantity + ", totalPrice=" + totalPrice
				+ "]";
	}  
}
