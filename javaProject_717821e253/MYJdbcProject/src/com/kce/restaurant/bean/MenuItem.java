package com.kce.restaurant.bean;

public class MenuItem 
{
	private int id;
	   private String itemName;
	   private double price;
   
       public MenuItem(int id, String itemName, double price)
       {
		super();
		this.id = id;
		this.itemName = itemName;
		this.price = price;
       }
       
      

       public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId() {
    	   return id;
       }
       public void setId(int id) {
    	   this.id = id;
       }

       public String getItemName() {
    	   return itemName;
       }
      
	public void setItemName(String itemName) {
    	   this.itemName = itemName;
       }


       public double getPrice() {
    	   return price;
       }
       public void setPrice(double price) {
    	   this.price = price;
       }
       
       @Override
   	public String toString() {
   		return "MenuItem [id=" + id + ", itemName=" + itemName + ", price=" + price + "]";
   	}

}
