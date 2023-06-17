package com.kce.ecommerce.service;
import java.sql.SQLException;
import com.kce.ecommerce.bean.*;
import java.util.*;
import com.kce.ecommerce.dao.*;
import com.kce.ecommerce.util.UserNotException;
public class EcommerceMain 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
Shopping s=new Shopping();
int option=0;
EcommerceDAO e=new EcommerceDAO();
Scanner sc=new Scanner(System.in);
while(true) 
{

System.out.println("1:validateAccount");
System.out.println("2:getCustomerDetail");
System.out.println("3:getOrderDetails");
System.out.println("4:getProductDetail");
System.out.println("5:BuyProduct");
System.out.println("Enter your option: ");
option=sc.nextInt();


switch(option) 
{
case 1:
	System.out.println("Enter the username");
	s.setCustomerName(sc.next());
	System.out.println("Enter the password: ");
	s.setPassword(sc.next());
	try {
		e.validateAccount(s.getCustomerName(),s.getPassword());
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (UserNotException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	break;
case 2:
	System.out.println("Enter customer name: ");
	String cName=sc.next();
	e.getCustomerDetails(cName);
	break;
case 3:
	System.out.println("Enter productid: ");
	s.setProductId(sc.next());
	e.getOrderDetails(s.getProductId());
    break;
case 4:
	System.out.println("Enter product name: ");
	s.setProductName(sc.next());
	e.getProductDetails(s.getProductName());
	break;
case 5:
	System.out.println("Enter Customer name: ");
	s.setCustomerName(sc.next());
	System.out.println("Enter productname to buy");
	s.setProductName(sc.next());
	e.BuyProduct(s.getCustomerName(),s.getProductName());
}
}
}
}
