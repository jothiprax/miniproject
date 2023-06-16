package com.kce.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import com.kce.bean.CustomerDet;
import com.kce.dao.Stock_table;


public class Test {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("1 -> Managing the stock table");
		System.out.println("2 -> Order items");
		
		int select=sc.nextInt();
		if(select==1) {
			System.out.println("Enter your Choice::");
			System.out.println("1 -> insert items in stock table");
			System.out.println("2 -> update the stock table");
			System.out.println("3 -> delete items in stock table");
			System.out.println("4 -> display the items");
			System.out.println("5 -> drop the table");
			int choice=sc.nextInt();
			
			switch(choice) {
			
			case 1:
				System.out.println("Enter number of items to insert");
				Stock_table.insert(sc.nextInt());
				break;
				
			case 2:
				Stock_table.update();
				break;
				
			case 3:
				Stock_table.delete();
				break;
				
			case 4:
				Stock_table.show();
				
			case 5:
				Stock_table.drop();
				
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
		else if(select==2) {
			
			while(true) {
				System.out.println(" Enter your Choice::");
				System.out.println("\t 1 -> Enter the details");
				System.out.println("\t 2 ->Exit ");
				int choice=sc.nextInt();
				switch(choice) {
				case 1:
					Stock_table.show();
					System.out.println("Enter your name:");
					String name=sc.next();
					System.out.println("Enter your mobile number:");
					long mobilenumber=sc.nextLong();
					System.out.println("Enter the address:");
					String address=sc.next();
					System.out.println("Enter the product id:");
					int pid=sc.nextInt();
					System.out.println("Enter the quantity:");
					int quantity=sc.nextInt();
					
					double price=Stock_table.getPrice(pid);
					double total=quantity*price;
					
					System.out.println(" Booking Successfull");
					System.out.println("*____________________Bill____________________*");
					System.out.println("\t\nCustomer Name: "+name);
					System.out.println("\tMobile number: "+mobilenumber);
					System.out.println("\tAddress: "+address);
					System.out.println("\tProduct id: "+pid);
					System.out.println("\tQuatity: Rs."+quantity);
					System.out.println("\t Grand Total:"+total);
					System.out.println("\n______________________****____________________");
					
					//CustomerDet order=new CustomerDet(name,mobilenumber,address,pid,quantity);
					//CustomerDet.Person(order);
				case 2:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Choice");
					break;

				}	}
		}  }
}
