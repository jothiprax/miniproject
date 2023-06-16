package com.kce.bean;

public class InventoryLevel {
	private int levelId;
    private int itemId;
    private int quantity;
	public InventoryLevel(int levelId, int itemId, int quantity) {
		super();
		this.levelId = levelId;
		this.itemId = itemId;
		this.quantity = quantity;
	}
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
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
		return "InventoryLevel [levelId=" + levelId + ", itemId=" + itemId + ", quantity=" + quantity + "]";
	}
	


}
