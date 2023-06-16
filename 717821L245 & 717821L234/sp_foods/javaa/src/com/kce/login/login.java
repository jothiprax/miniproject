package com.kce.login;
import com.kce.customercheck.*;
import com.kce.orders.*;
import com.kce.ordersdao.*;
import com.kce.price.price;
import java.util.*;
public class login {
	public void login()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter the UserName");
		String usern=sc.next();
		System.out.println("***WHAT DO YOU PREFER?***");
		System.out.println("1.VEG");
		System.out.println("2.NON VEG");
		System.out.println("3.DESSERTS");
		System.out.print("Please enter your choice");
		int ch=sc.nextInt();
		switch(ch)
		{
			case 1:
				System.out.println("***MENU***");
				System.out.println(" ");
				System.out.println("HOT AND SOUR SOUP");
				System.out.println("VEG CLEAR SOUP");
				System.out.println("MILAGUTHANI SOUP");
				System.out.println("TOMATO SOUP");
				System.out.println(" ");
				System.out.println("Veg Paneer Roll Starter");
				System.out.println("Gobi 65 Starter");
				System.out.println("Panneer 65 Starter");
				System.out.println("Mushroom Pepper Fry Starter");
				System.out.println("Gobi Manchurian Starter");
				System.out.println("Panner Tikka Starter");
				System.out.println("Cutlet Starter");
				System.out.println(" ");
				System.out.println("Pani Puri Starter");
				System.out.println("Masalaa Puri Starter");
				System.out.println("Bhel Puri Starter");
				System.out.println(" ");
				System.out.println("Dosa Starter");
				System.out.println("Idli Starter");
				System.out.println("Chappathi Starter");
				System.out.println("Parotta Starter");
				System.out.println(" ");
				System.out.println("Empty Briyani");
				System.out.println("Mushroom Briyani");
				System.out.println("Panneer Briyani");
				System.out.println(" ");
				System.out.println("Enter the Item: ");
				String item=sc.next();
				System.out.print("Enter the Quantity: ");
				int qty=sc.nextInt();
				orders o1=new orders(usern,item,qty);
				ordersdao odao=new ordersdao();
				boolean res=odao.odetails(o1);
				if(res)
				{
					System.out.println("HAVE A GREAT DAY!!!");
					price pr=new price();
					if(item.contains("riyani"))
					{
						pr.setprice1(qty);
					}
					else if(item.contains("oup"))
					{
						pr.setprice2(qty);
					}
					else
					{
						pr.setprice3(qty);
					}
				}
				break;
			case 2:
				System.out.println("***MENU***");
				System.out.println(" ");
				System.out.println("CRAB SOUP");
				System.out.println("CHICKEN CLEAR SOUP");
				System.out.println("MUTTON SOUP");
				System.out.println("AATUKAL SOUP");
				System.out.println(" ");
				System.out.println("CHICKEN 65 Starter");
				System.out.println("PEPPER CHICKEN Starter");
				System.out.println("FISH 65 Starter");
				System.out.println("FISH FINGER Starter");
				System.out.println("LOLLIPOP CHICKEN Starter");
				System.out.println("CHICKEN TIKKA Starter");
				System.out.println("Chicken Cutlet Starter");
				System.out.println(" ");
				System.out.println(" ");
				System.out.println("Naan Starter");
				System.out.println("Butter Naan Starter");
				System.out.println("Panner Butter Masala Starter");
				System.out.println("Mutton chuka Starter");
				System.out.println(" ");
				System.out.println("Chicken Briyani");
				System.out.println("Mutton Briyani");
				System.out.println("Enter the Item: ");
				String item1=sc.next();
				System.out.print("Enter the Quantity: ");
				int qty1=sc.nextInt();
				orders o2=new orders(usern,item1,qty1);
				ordersdao odao1=new ordersdao();
				boolean res1=odao1.odetails(o2);
				if(res1)
				{
					System.out.println("HAVE A GREAT DAY!!!");
					price pr1=new price();
					if(item1.contains("riyani"))
					{
						pr1.setprice1(qty1);
					}
					else if(item1.contains("oup"))
					{
						pr1.setprice2(qty1);
					}
					else
					{
						pr1.setprice3(qty1);
					}
				}
				break;
			case 3:
				System.out.println("***MENU***");
				System.out.println(" ");
				System.out.println("FALOODA SCOOP");
				System.out.println("BUTTERSCOTCH SCOOP");
				System.out.println("VANNILLA SCOOP");
				System.out.println("STRAWBERRY SCOOP");
				System.out.println("PISTA SCOOP");
				System.out.println(" ");
				String item2=sc.next();
				System.out.print("Enter the Quantity: ");
				int qty2=sc.nextInt();
				orders o3=new orders(usern,item2,qty2);
				ordersdao odao2=new ordersdao();
				boolean res2=odao2.odetails(o3);
				if(res2)
				{
					System.out.println("HAVE A GREAT DAY!!!");
					System.out.print("Each Scoop costs Rs.90.00");
					int price=qty2*90;
					System.out.println("Price : "+price);
				}
				break;
			default:
				System.out.println("Invalid Option");
		}
	}
}
