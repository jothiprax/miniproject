package com.RKFoodOrder.bean;

public class Menu_list {
	int id;
	String dish_name;
	int quantity;
	double price;
	public Menu_list(int id, String dish_name, int quantity, double price) {
		super();
		this.id = id;
		this.dish_name = dish_name;
		this.quantity = quantity;
		this.price = price;
	}
	
}
