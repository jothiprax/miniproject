package com.kce.bean;

import com.kce.bean.Customer;
import com.kce.bean.Product;
import com.kce.util.DBUtil;


public class Order extends Product 
{
	int customerid;
	String customername;
	String productname;
	int productid;
	String ordereddate;
	String deliverydate;
	String status;

	public Order() 
	{

	}

	public Order(int customerid, String customername, String productname, int productid, String ordereddate,
			String deliverydate, String status) 
	{
		super(customerid, customername, productid, productname);
		this.ordereddate = ordereddate;
		this.deliverydate = deliverydate;
		this.status = status;
	}

	Customer c = new Customer();
	Product p = new Product();

	public int getCustomerid() 
	{
		return customerid;
	}

	public void setCustomerid(int customerid)
	{
		this.customerid = c.getCustomerid();
	}

	public String getCustomername() 
	{
		return customername;
	}

	public void setCustomername(String customername) 
	{
		this.customername = c.getCustomername();
	}

	public String getProductname() 
	{
		return productname;
	}

	public void setProductname(String productname) 
	{
		this.productname = p.getProductname();
	}

	public int getProductid() 
	{
		return productid;
	}

	public void setProductid(int productid) 
	{
		this.productid = p.getProductid();
	}

	public String getOrdereddate() 
	{
		return ordereddate;
	}

	public void setOrdereddate(String ordereddate) 
	{
		this.ordereddate = ordereddate;
	}

	public String getDeliverydate() 
	{
		return deliverydate;
	}

	public void setDeliverydate(String deliverydate) 
	{
		this.deliverydate = deliverydate;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	@Override
	public String toString() 
	{
		return "Order [customerid=" + customerid + ", customername=" + customername + ", productname=" + productname
				+ ", productid=" + productid + ", ordereddate=" + ordereddate + ", deliverydate=" + deliverydate
				+ ", status=" + status + "]";
	}
}
