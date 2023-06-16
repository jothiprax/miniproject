package com.kce.bean;

public class OrderDetails {//class used to get customerdetails
	private String name;
	private long phnno;
	private int pid;
	private int quantity;
	public OrderDetails(String name, long phnno, int pid, int quantity) {//constructor
		super();
		this.name = name;
		this.phnno = phnno;
		this.pid = pid;
		this.quantity = quantity;
	}
	public String getName() {//getters and setters
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhnno() {
		return phnno;
	}
	public void setPhnno(long phnno) {
		this.phnno = phnno;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderDetails [name=" + name + ", phnno=" + phnno + ", pid=" + pid + ", quantity=" + quantity + "]";
	}
	public static void Customer(OrderDetails order) {
		// TODO Auto-generated method stub
		
	}

}
