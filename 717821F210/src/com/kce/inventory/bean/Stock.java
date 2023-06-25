package com.kce.inventory.bean;

public class Stock {
	
	private String productName;
	private int quantity;
	
	public Stock(String productName, int quantity) {
		this.productName = productName;
		this.quantity = quantity;
	}

	public Stock() {
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {
		return "Stock [productName=" + productName + ", quantity=" + quantity + "]";
	}
	
}
