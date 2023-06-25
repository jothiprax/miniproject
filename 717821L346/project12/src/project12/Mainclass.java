package project12;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.SQLException;
public class Mainclass {
	    public static void main(String[] args)throws Exception {
	        Scanner scanner = new Scanner(System.in);
	        OrderDAO orderDAO = new OrderDAO();
	        while (true) {
	            System.out.println("Select an action:");
	            System.out.println("1. Add Order");
	            System.out.println("2. Update Order");
	            System.out.println("3. Remove Order");
	            System.out.println("4. Add Menu Item");
	            System.out.println("5. Remove Menu Item");
	            System.out.println("6. todisplay all menuitems");
	            System.out.println("7. todisplay all orders");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();
                if(choice>=1 && choice<=7) {
                	connectionclass co=new connectionclass();
	                 co.getConnection(choice);
	           System.out.println();
                } 
	            switch (choice) {
	                case 1:
	                    System.out.println("Adding an order:");
	                    System.out.print("Enter order ID: ");
	                    int orderId = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline character
	                    System.out.print("Enter customer name: ");
	                    String customerName = scanner.nextLine();
	                    Order order = new Order(orderId, customerName);
	                    orderDAO.addOrder(order);
	                    break;

	                case 2:
	                    System.out.println("Updating an order:");
	                    System.out.print("Enter order ID to update: ");
	                    int updateOrderId = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline character
	                    System.out.print("Enter new customer name: ");
	                    String updatedCustomerName = scanner.nextLine();
	                    Order updatedOrder = new Order(updateOrderId, updatedCustomerName);
	                    orderDAO.updateOrder(updatedOrder);
	                    break;

	                case 3:
	                    System.out.println("Removing an order:");
	                    System.out.print("Enter order ID to remove: ");
	                    int removeOrderId = scanner.nextInt();
	                    orderDAO.removeOrder(removeOrderId);
	                    break;

	                case 4:
	                    System.out.println("Adding a menu item:");
	                    System.out.print("Enter menu item ID: ");
	                    int menuItemId = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline character
	                    System.out.print("Enter menu item name: ");
	                    String menuItemName = scanner.nextLine();
	                    System.out.print("Enter menu item price: ");
	                    double menuItemPrice = scanner.nextDouble();
	                    MenuItem menuItem = new MenuItem(menuItemId, menuItemName, menuItemPrice);
	                    orderDAO.addMenuItem(menuItem);
	                    break;

	                case 5:
	                    System.out.println("Removing a menu item:");
	                    System.out.print("Enter menu item ID to remove: ");
	                    int removeMenuItemId = scanner.nextInt();
	                    orderDAO.removeMenuItem(removeMenuItemId);
	                    break;

	                case 6:
	                	System.out.println("display all menu item:");
	                	System.out.println( orderDAO. getAllMenuItems());
	                	  break;
	                case 7:
	                	System.out.println("display all order:");
	                	 System.out.println( orderDAO. getAllOrders());
	                	  break;
	                	
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
	}


