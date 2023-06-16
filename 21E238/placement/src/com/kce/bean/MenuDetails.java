package com.kce.bean;

public class MenuDetails {//class that is used to get menu details
	private int pid;
	private String dish;
	private int rating;
	private Double price;
	public MenuDetails(int pid, String dish, int rating, Double price) {//constructors
		super();
		this.pid = pid;
		this.dish = dish;
		this.rating = rating;
		this.price = price;
	}
	public int getPid() {//getters and setters
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getDish() {
		return dish;
	}
	public void setDish(String dish) {
		this.dish = dish;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "MenuDetails [pid=" + pid + ", dish=" + dish + ", rating=" + rating + ", price=" + price + "]";
	}
}
