package com.kce.bean;
import java.io.*;
public class Product extends Customer  
{
		int productid;
		String productname;
		String brand;
		int price;
		int rating;
		
		public Product(int customerid,String customername,int productid, String productname)
		{
			super(customerid,customername);
			this.productid = productid;
			this.productname = productname;
		}
		
		public Product()
		{
			
		}
		
		public Product(int productid, String productname, String brand, int price, int rating) 
		{
			this.productid = productid;
			this.productname = productname;
			this.brand = brand;
			this.price = price;
			this.rating = rating;
		}
		
		public int getProductid() 
		{
			return productid;
		}
		
		public void setProductid(int productid) 
		{
			this.productid = productid;
		}
		
		public String getProductname() 
		{
			return productname;
		}
		
		public void setProductname(String productname) 
		{
			this.productname = productname;
		}
		
		public String getBrand() 
		{
			return brand;
		}
		
		public void setBrand(String brand) 
		{
			this.brand = brand;
		}
		
		public double getPrice() 
		{
			return price;
		}
		
		public void setPrice(int price) 
		{
			this.price = price;
		}
		
		public double getRating() 
		{
			return rating;
		}
		
		public void setRating(int rating) 
		{
			this.rating = rating;
		}
		
		@Override
		public String toString() 
		{
			return "product [productid=" + productid + ", productname=" + productname + ", brand=" + brand + ", price="
					+ price + ", rating=" + rating + "]";
		}
}
