package com.kce.bean;

public class Battery {
	private String battery_id;
	private String brand;
	private String model;
	private int warranty;
	private int amps;
	private int quantity; 
	private int price;
	
	//CONSTRUCTOR
	
	public Battery() {
		super();
	}
	public Battery(String battery_id, String brand, String model, int warranty, int amps, int quantity, int price) {
		super();
		this.battery_id = battery_id;
		this.brand = brand;
		this.model = model;
		this.warranty = warranty;
		this.amps = amps;
		this.quantity = quantity;
		this.price = price;
	}
	
	//GETTER AND SETTER
	
	public String getBattery_id() {
		return battery_id;
	}
	public void setBattery_id(String battery_id) {
		this.battery_id = battery_id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getWarranty() {
		return warranty;
	}
	public void setWarranty(Integer warranty) {
		this.warranty = warranty;
	}
	public int getAmps() {
		return amps;
	}
	public void setAmps(Integer amps) {
		this.amps = amps;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}
