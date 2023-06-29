package com.kce.service;

import java.util.Scanner;

import com.kce.dao.*;

public class Service {
	public static void main(String args[]) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to vibes music store");
		while(true)
		{
			System.out.println("Enter the choice");
			System.out.println("1 To display available product");
			System.out.println("2 To buy the product");
			System.out.println("3 To return product");
			System.out.println("4 To get discount");
			System.out.println("5 exit");
			int c=sc.nextInt();
			switch(c)
			{
			case 1:Dao.display();break;
			case 2:System.out.println("What album do you want?");
			       String s=sc.nextLine();
			       System.out.println("No of requirement needed");
			       int r=sc.nextInt();
			       Dao.sold(s, r);
			       break;
			case 3:System.out.println("Why want happen");
			       System.out.println("Enter your feeback:");
			       String f=sc.nextLine();
			       System.out.println(f+"sorry for your inconvient");
			       break;
			case 4:System.out.println("If purchase for 1000 discount available thank you");
				   break;
			case 5:System.exit(0);
			}
		}
	}
}
