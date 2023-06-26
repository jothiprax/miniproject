package com.RKFoodOrder.bean;

public class Ordered_list extends Menu_list{ 
	int seraial_no;
	public Ordered_list(int id, String dish_name, int quantity, double price) {
		super(id, dish_name, quantity, price);
	}
	public int getSeraial_no() {
		return seraial_no;
	}
	public void setSeraial_no(int seraial_no) {
		this.seraial_no = seraial_no;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDish_name() {
		return dish_name;
	}
	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
