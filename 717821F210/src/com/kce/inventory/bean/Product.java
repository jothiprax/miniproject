package com.kce.inventory.bean;

public class Product {
	
	private int productId;
	private String productCode;
	private String productName;
	private int costPrice;
	private int sellPrice;
	
	public Product(int productId, String productCode, String productName, int costPrice, int sellPrice) {
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.costPrice = costPrice;
		this.sellPrice = sellPrice;
	}

	public Product() {
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(int costPrice) {
		this.costPrice = costPrice;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String toString() {
		return "Product [productId=" + productId + ", productCode=" + productCode + ", productName=" + productName
				+ ", costPrice=" + costPrice + ", sellPrice=" + sellPrice + "]";
	}
	
}
