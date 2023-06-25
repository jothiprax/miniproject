package com.kce.inventory.bean;

public class SalesInfo {
	
	private int productId;
	private String productName;
	private int quantity;
	private int totalCost;
	
	public SalesInfo(int productId, String productName, int quantity, int totalCost) {
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}

	public SalesInfo() {
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public String toString() {
		return "SalesInfo [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", totalCost=" + totalCost + "]";
	}
	
}
