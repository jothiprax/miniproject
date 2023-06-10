package com.kce.bean;

public class Medicines {
	private int Id;
	private String Name;
	private String Barcode;
	private double Price;
	private int Quantity;
	public Medicines(int id, String name, String barcode, double price, int quantity) {
		super();
		Id = id;
		Name = name;
		Barcode = barcode;
		Price = price;
		Quantity = quantity;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getBarcode() {
		return Barcode;
	}
	public void setBarcode(String barcode) {
		Barcode = barcode;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "Medicines [Id=" + Id + ", Name=" + Name + ", Barcode=" + Barcode + ", Price=" + Price + ", Quantity="
				+ Quantity + "]";
	}

}
