package com.kce.bean;

public class StockDetails {
	private int productid;
	private String productName;
	private String made;
	private int price;
	private int gaurentee;
	public StockDetails(int productid, String productName, String made, int price, int gaurentee) {
		super();
		this.productid = productid;
		this.productName = productName;
		this.made = made;
		this.price = price;
		this.gaurentee = gaurentee;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getMade() {
		return made;
	}
	public void setMade(String made) {
		this.made = made;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getGaurentee() {
		return gaurentee;
	}
	public void setGaurentee(int gaurentee) {
		this.gaurentee = gaurentee;
	}
	@Override
	public String toString() {
		return "StockDetails [productid=" + productid + ", productName=" + productName + ", made=" + made + ", price="
				+ price + ", gaurentee=" + gaurentee + "]";
	}

}
