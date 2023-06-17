package com.kce.bean;

public class CustomerBill extends CustomerDetails{
	private double total,gstTax;
	public CustomerBill() {
		super();
	}
	
	//GETTER AND SETTER
	
	public double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public double getGstTax() {
		return gstTax;
	}
	public void setGstTax(double gstTax) {
		this.gstTax = gstTax;
	}
}
