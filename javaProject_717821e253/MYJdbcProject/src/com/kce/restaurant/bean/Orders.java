package com.kce.restaurant.bean;

public class Orders 
{
	  private int id;
	  private String customerName;
	  private String orderName;
	  private int quantity;
	 
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
    	  return id;
      }
      public void setId(int id) {
    	  this.id = id;
      }
      public String getCustomerName() {
  			return customerName;
  	}

  		public void setCustomerName(String customerName) {
  		this.customerName = customerName;
  	}
      public String getOrderName() {
    	  return orderName;
      }
      public void setOrderName(String orderName) {
    	  this.orderName = orderName;
      }

      public int getQuantity() {
    	  return quantity;
      }
public void setQuantity(int quantity) {
    	  this.quantity = quantity;
      }
	@Override
	public String toString() {
		return "Orders [id=" + id + ", customerName=" + customerName + ", orderName=" + orderName + ", quantity="
				+ quantity + "]";
	}
  
}
