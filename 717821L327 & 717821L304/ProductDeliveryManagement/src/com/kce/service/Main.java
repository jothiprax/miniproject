package com.kce.service;

import java.util.*;
import com.kce.bean.Customer;
import com.kce.bean.Order;
import com.kce.bean.Product;
import com.kce.dao.crud;
import com.kce.util.DBUtil;
import com.kce.util.customerException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main 
{
  public static void main(String[] args) throws Exception
  {
	Scanner sc=new Scanner(System.in);
	System.out.println("WELCOME TO ONLINE PRODUCT ORDER \n");
	System.out.println("1. PLACE AN ORDER");
	System.out.println("2. REPLACE AN ORDER ");
	System.out.println("3. CANCEL THE ORDER ");
	System.out.println("4. DISPLAY THE ORDER");
	System.out.println("5. DISPLAY ALL DETAILS");
	System.out.println("6. EXIT");
	System.out.println();
	int option;
	System.out.print("OPTION : ");
	option=sc.nextInt();
	System.out.println();
	crud doo=new crud();
	
	if(option>=1 && option<=6)
	{
		DBUtil db=new DBUtil();
	    db.getConnection(option); 
	    System.out.println();
	}
	switch(option) 
	{
	case 1: 
		System.out.println("ENTER THE CUSTOMER DETAILS : ");
	    System.out.println("ENTER THE CUSTOMER ID : ");
	    int customerid=sc.nextInt();
	    sc.nextLine();
	    System.out.println("ENTER THE CUSTOMER NAME : ");
	    String customername=sc.nextLine();
	    System.out.println("ENTER THE CUSTOMER EMAIL :");
	    String email=sc.nextLine();
	    System.out.println("ENTER THE CUSTOMER MOBILENO :");
        String mobile=	sc.nextLine();
        System.out.println("ENTER THE CUSTOMER ADDRESS : ");
        String address=sc.nextLine();
        System.out.println();
        
        System.out.println("ENTER THE PRODUCT DETAILS : ");
        System.out.println("ENTER THE PRODUCT ID : ");
        int productid=sc.nextInt();
        sc.nextLine();
        System.out.println("ENTER THE PRODUCT NAME : ");
	    String productname=sc.nextLine();
	    System.out.println("ENTER THE PRODUCT BRAND : ");
	    String brand=sc.nextLine();
	    System.out.println("ENTER THE PRODUCT PRICE : ");
	    int price=sc.nextInt();
	    System.out.println("ENTER THE PRODUCT RATING : ");
	    int rating=sc.nextInt();
	    sc.nextLine();
	    System.out.println();
	    
	    System.out.println("ENTER THE ORDER DETAILS :");
	    System.out.println("ENTER THE ORDERED DATE:(Format-dd/mm/yyyy)");
	    String ordereddate=sc.nextLine();
	    System.out.println("ENTER THE DELIVERY DATE:(Format-dd/mm/yyyy)");
	    String deliverydate=sc.nextLine();
	    System.out.println("ENTER THE PRODUCT STATUS : ");
	    String status=sc.nextLine();
	    
	    Customer c=new Customer();
		c.setCustomerid(customerid);
		c.setCustomername(customername);
		c.setEmail(email);
		c.setMobile(mobile);
		c.setAddress(address);

		Product p=new Product();
		p.setProductid(productid);
		p.setProductname(productname);
		p.setBrand(brand);
		p.setPrice(price);
		p.setRating(rating);

		Order o=new Order();
		o.setOrdereddate(ordereddate);
		o.setDeliverydate(deliverydate);
		o.setStatus(status);

		doo.addOrder(c,p,o);
	    break;
	    
	case 2 :
		System.out.println("ENTER CHOICE WHICH TO BE REPLACE : (status / deliverydate)");
		sc.nextLine();
		String option1=sc.nextLine();
		if(option1.equals("status"))
		{
			System.out.println("ENTER THE CUSTOMER ID WHICH TO BE REPLACE : ");
			int customerid1=sc.nextInt();
			sc.nextLine();
		    System.out.println("CHANGE THE STATUS TO REPLACE : ");
		    String status1=sc.nextLine();
	        doo.updateOrder(status1,customerid1);
	    }
	    else if(option1.equals("deliverydate"))
	    {
			System.out.println("ENTER THE CUSTOMER ID WHICH TO BE REPLACE : ");
			int customerid1=sc.nextInt();
			sc.nextLine();
	        System.out.println("ENTER THE DELIVERY DATE TO REPLACE : ");
		    String ddate1=sc.nextLine();
		    doo.updateOrder(customerid1,ddate1);
	    }
	    else
	    {
	    	System.out.println();
	    	throw new customerException("YOU HAVE ENTERED INVALID USER DETAILS.");
	    }
	    break;
	    
	case 3 :
		sc.nextLine();
		System.out.println("ENTER CHOICE TO CANCEL : (status / customerid)");
		String option2=sc.nextLine();
		if(option2.equals("status"))
		{
		System.out.println("ENTER THE ORDER STATUS TO CANCEL: ");
		String status2=sc.nextLine();
		 doo.deleteOrder(status2);
		}
		 else if(option2.equals("customerid"))
		 {
		System.out.println("ENTER THE CUSTOMER ID TO CANCEL: ");
		int customerid2=sc.nextInt();
	    doo.deleteOrder(customerid2);   
		 }
	    else
	    {
	    	System.out.println();
	    	throw new customerException("YOU HAVE ENTERED INVALID USER DETAILS.");
	    }
	    break;
	    
	case 4 :
		sc.nextLine();
		System.out.println("ENTER CHOICE TO VIEW THE DETAILS : (status / customerid)");
		String option3=sc.nextLine();
		if(option3.equals("status"))
		{
		System.out.println("ENTER THE ORDER STATUS TO VIEW DETAILS: ");
		String status2=sc.nextLine();
		System.out.println(doo.getDetails(status2));
		}
		 else if(option3.equals("customerid"))
		 {
		System.out.println("ENTER THE CUSTOMER ID TO VIEW DETAILS: ");
		int customerid2=sc.nextInt();
		System.out.println(doo.getDetails(customerid2));
		 }
	    else
	    {
	    	System.out.println();
	    	throw new customerException("YOU HAVE ENTERED INVALID USER DETAILS.");
	    }
	    break;
	    
	case 5 :
		System.out.println("THE DETAILS OF ORDERS ARE : ");
		doo.getAllOrders();
		break;
		
	case 6 : 
		System.out.println("Thank You!!!!");
		System.exit(0);
		break;

	default :
		System.out.println("Enter correct option!");
	}
	
  }
}
