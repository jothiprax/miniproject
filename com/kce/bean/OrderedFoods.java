package com.kce.bean;
import java.util.*;
public class OrderedFoods {
	private Menu Items;
	private int quantity;
	public OrderedFoods(Menu items, int quantity) {
		super();
		Items = items;
		this.quantity = quantity;
	}
	public Menu getMenuItems() {
		return Items;
	}
	public int getQuantity() {
		return quantity;
	}
	
	
	
	public double getTotalPrice()
	{

		return  Items.getPrice(Items.getName())*quantity;
		
	}
	
	@Override
	public String toString() {
		return "OrderedFoods [Items=" + Items + ", quantity=" + quantity + ", TotalPrice="+ getTotalPrice() +"]";
	}
	
    

}
