package com.kce.orders;
public class orders {
	static String usern;
	static String item;
	static int qty;
   public orders(String usern,String item,int qty)
   {
	   this.usern=usern;
	   this.item=item;
	   this.qty=qty;
   }
   public static String getUsern() {
		return usern;
	}
	
	public static String getItem() {
		return item;
	}
	
	public static int getQty() {
		return qty;
	}
}