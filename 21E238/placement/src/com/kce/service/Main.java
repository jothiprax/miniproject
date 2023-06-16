package com.kce.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.kce.bean.OrderDetails;
import com.kce.dao.Resto_table;
import com.kce.util.*;
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter 1 to update the menu");//used to insert,update,delete,show the menu
		System.out.println("Enter 2 to order the food");//used to order food
		int c=Integer.parseInt(br.readLine());
		if(c==1) {
			System.out.println("\nEnter your Choice");
			System.out.println("press 1 to insert data");
			System.out.println("press 2 to update data");
			System.out.println("press 3 to delete data");
			System.out.println("press 4 to display data");
			System.out.println("press 5 to exit ");
			int choice=Integer.parseInt(br.readLine());
			
			switch(choice) {
			case 1:
				System.out.println("Enter number of items to insert");
				Resto_table.insert(Integer.parseInt(br.readLine()));
				break;
			case 2:
				Resto_table.update();
				break;
			case 3:
				Resto_table.delete();
				break;
			case 4:
				Resto_table.show();
			case 5:
				System.out.println("Completed..");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
		else if(c==2) {
			while(true) {
				System.out.println("\n Enter your Choice");
				System.out.println("\n press 1 to Enter Customer Details");
				System.out.println("\n press 2 to exit ");
				int choice=Integer.parseInt(br.readLine());
				switch(choice) {
				case 1:
					Resto_table.show();
					System.out.println("Enter your name:");
					String name=br.readLine();
					System.out.println("Enter your mobile number:");
					long phnno=Long.parseLong(br.readLine());
					System.out.println("Enter the product id:");
					int pid=Integer.parseInt(br.readLine());
					System.out.println("Enter the quantity:");
					int quantity=Integer.parseInt(br.readLine());
					
					double cost=Resto_table.getPrice(pid);
					double total=quantity*cost;
					System.out.println("Order Recieved");
					System.out.println("********************Bill********************");
					System.out.println("\tCustomer Name: "+name);
					System.out.println("\tMobile number: "+phnno);
					System.out.println("\tProduct id: "+pid);
					System.out.println("\tQuantity: "+quantity);
					System.out.println("\t\bTotal: Rs."+total);
					OrderDetails order=new OrderDetails(name,phnno,pid,quantity);
					OrderDetails.Customer(order);
					break;
					
				case 2:
					System.exit(0);
					break;
					
				default:
					System.out.println("Invalid Choice");
					break;

				}
			}
		}
	}

}
