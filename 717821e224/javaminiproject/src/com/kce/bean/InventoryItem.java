package com.kce.bean;

public class InventoryItem {
	private int itemId;
    private String itemName;
    private int quantity;
	public InventoryItem(int itemId, String itemName, int quantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "InventoryItem [itemId=" + itemId + ", itemName=" + itemName + ", quantity=" + quantity + "]";
	}


}
