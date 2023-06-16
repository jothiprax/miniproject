package com.kce.util;
import java.util.Scanner;
import com.kce.dao.*;
import com.kce.bean.*;
public class InventoryManagementSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryItemDAO itemDAO = new InventoryItemDAO();
        InventoryLevelDAO levelDAO = new InventoryLevelDAO();
        OrderDAO orderDAO = new OrderDAO();

        while (true) {
            System.out.println("1. Add Item");
            System.out.println("2. Update Item");
            System.out.println("3. Delete Item");
            System.out.println("4. Add Inventory Level");
            System.out.println("5. Update Inventory Level");
            System.out.println("6. Delete Inventory Level");
            System.out.println("7. Add Order");
            System.out.println("8. Delete Order");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine(); 

                    try {
                        InventoryItem item = new InventoryItem(0, itemName, quantity);
                        itemDAO.addItem(item);
                        System.out.println("Item added successfully");
                    } catch (InventoryException e) {
                        System.out.println("Failed to add item: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter item ID: ");
                    int itemId = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter item name: ");
                    itemName = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    sc.nextLine(); // consume the newline character

                    try {
                        InventoryItem item = new InventoryItem(itemId, itemName, quantity);
                        itemDAO.updateItem(item);
                        System.out.println("Item updated successfully");
                    } catch (InventoryException e) {
                        System.out.println("Failed to update item: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter item ID: ");
                    itemId = sc.nextInt();
                    sc.nextLine(); 

                    try {
                        itemDAO.deleteItem(itemId);
                        System.out.println("Item deleted successfully");
                    } catch (InventoryException e) {
                        System.out.println("Failed to delete item: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Enter item ID: ");
                    itemId = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    sc.nextLine(); 

                    try {
                        InventoryLevel level = new InventoryLevel(0, itemId, quantity);
                        levelDAO.addLevel(level);
                        System.out.println("Inventory level added successfully");
                    } catch (InventoryException e) {
                        System.out.println("Failed to add inventory level: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Enter inventory level ID: ");
                    int levelId = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    sc.nextLine(); 

                    try {
                        InventoryLevel level = new InventoryLevel(levelId, 0, quantity);
                        levelDAO.updateLevel(level);
                        System.out.println("Inventory level updated successfully");
                    } catch (InventoryException e) {
                        System.out.println("Failed to update inventory level: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Enter inventory level ID: ");
                    levelId = sc.nextInt();
                    sc.nextLine(); 

                    try {
                        levelDAO.deleteLevel(levelId);
                        System.out.println("Inventory level deleted successfully");
                    } catch (InventoryException e) {
                        System.out.println("Failed to delete inventory level: " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.print("Enter item ID: ");
                    itemId = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    sc.nextLine(); 

                    try {
                        Order order = new Order(0, itemId, quantity);
                        orderDAO.addOrder(order);
                        System.out.println("Order added successfully");
                    } catch (InventoryException e) {
                        System.out.println("Failed to add order: " + e.getMessage());
                    }
                    break;
                case 8:
                    System.out.print("Enter order ID: ");
                    int orderId = sc.nextInt();
                    sc.nextLine(); 

                    try {
                        orderDAO.deleteOrder(orderId);
                        System.out.println("Order deleted successfully");
                    } catch (InventoryException e) {
                        System.out.println("Failed to delete order: " + e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }


}
