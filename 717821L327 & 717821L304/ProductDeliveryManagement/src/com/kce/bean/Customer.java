package com.kce.bean;

import java.io.*;
import java.util.*;

public class Customer 
{
		String customername;
		int customerid;
		String email;
	    String mobile;
	    String address;
	    
	    public Customer(int customerid,String customername)
	    {
	    	this.customerid = customerid;
	    	this.customername = customername;
	    }
	    
	    public Customer()
	    {
	    	
	    }
	    
		public Customer(String customername, int customerid, String email, String mobile, String address) 
		{
			super();
			this.customername = customername;
			this.customerid = customerid;
			this.email = email;
			this.mobile = mobile;
			this.address = address;
		}
		
		public String getCustomername() 
		{
			return customername;   
		}
		
		public void setCustomername(String customername) 
		{
			this.customername = customername;
		}
		
		public int getCustomerid() 
		{
			return customerid;
		}
		
		public void setCustomerid(int customerid) 
		{
			this.customerid = customerid;
		}
		
		public String getEmail() 
		{
			return email;
		}
		
		public void setEmail(String email) 
		{
			this.email = email;
		}
		
		public String getMobile() 
		{
			return mobile;
		}
		
		public void setMobile(String mobile) 
		{
			this.mobile = mobile;
		}
		
		public String getAddress() 
		{
			return address;
		}
		
		public void setAddress(String address) 
		{
			this.address = address;
		}
		
		@Override
		public String toString() 
		{
			return "customer [customername=" + customername + ", customerid=" + customerid + ", email=" + email
					+ ", mobile=" + mobile + ", address=" + address + "]";
		}
}
