package com.kce.restaurant.service;


import java.util.List;
import java.util.Scanner;

import com.kce.restaurant.dao.*;
import com.kce.restaurant.bean.Orders;
import com.kce.restaurant.util.OutOfStockException;


public class Main {
	
	
	private static final OrderDAO dao = new OrderDAO();
	private static final Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {
		

	
	 
     int option=sc.nextInt();
     switch (option) {
     case 1:
         insert();
         break;
     case 2:
         update();
         break;
     case 3:
         delete();
         break;
     case 4:
         display();
         break;
     default:
         System.out.println("Invalid choice.");
         break;
    }

	}
	
	
	private static void insert()
	{
		System.out.println("Enter the id:");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enetr the customer name:");
		String customerName = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter Order Name: ");
        String itemName = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter Quantity: ");
        int quantity = sc.nextInt();

        Orders od = new Orders();
        od.setId(id);
        od.setCustomerName(customerName);
        od.setOrderName(itemName);
        od.setQuantity(quantity);

        dao.insertOrders(od);
        System.out.println("Order inserted successfully.");
	}
	
	private static void update() {
        System.out.println("Enter Order ID: ");
        int orderId = sc.nextInt();
        sc.nextLine(); 

        Orders od = new Orders();
        od.setId(orderId);

        System.out.println("Enter Customer Name: ");
        od.setCustomerName(sc.nextLine());

        System.out.println("Enter Item Name: ");
        od.setOrderName(sc.nextLine());

        System.out.println("Enter Quantity: ");
        od.setQuantity(sc.nextInt());
        sc.nextLine(); 

        try {
            dao.updateOrders(od);
            System.out.println("Order updated successfully.");
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }
    }
	
	private static void delete() {
        System.out.println("Enter Order ID: ");
        int orderId = sc.nextInt();
        sc.nextLine(); 

        try {
            dao.deleteOrders(orderId);
            System.out.println("Order deleted successfully.");
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }
    }

	private static void display() {
        List<Orders> list = dao.displayOrders();

        if (list.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            for (Orders od : list) {
                System.out.println("Order ID: " + od.getId());
                System.out.println("Customer Name: " + od.getCustomerName());
                System.out.println("Item Name: " + od.getOrderName());
                System.out.println("Quantity: " + od.getQuantity());
            }
        }
    }

}
