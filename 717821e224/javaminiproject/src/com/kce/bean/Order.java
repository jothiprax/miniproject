package com.kce.bean;

public class Order {
	private int orderId;
    private int itemId;
    private int quantity;
	public Order(int orderId, int itemId, int quantity) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", itemId=" + itemId + ", quantity=" + quantity + "]";
	}
    

}
