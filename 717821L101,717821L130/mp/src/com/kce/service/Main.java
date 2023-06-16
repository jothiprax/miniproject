package com.kce.service;
	import java.util.Scanner;
	//Importing the package of ExpenseDAO
	import com.kce.dao.ExpenseDao;
	//Importing the packages of user defined Exceptions
	import com.kce.util.InvalidExpenseException;
	import com.kce.util.InvalidCategoryException;
	//Importing the package of Database Connection
	import com.kce.util.DBConnection;
	
	public class Main {
		
		public static void main(String[] args) throws InvalidExpenseException {
			
			// Invoking the Connection Method
			ExpenseDao expenseTracker = new ExpenseDao(DBConnection.createDBConnection());
		    Scanner scanner = new Scanner(System.in);
		    int choice = 0;

		    while (choice != 9) {
		    	 System.out.println("\n\t\t\t\t\t---- Expense Tracker Menu ----");
		        System.out.println("1. Add Expense");
		        System.out.println("2. Update Expense");
		        System.out.println("3. Add category");
		        System.out.println("4. Filter Expenses by Category ID");
		        System.out.println("5. Delete Expense");
		        System.out.println("6. Delete Category");
		        System.out.println("7. Display All Expense report");
		        System.out.println("8. Delete All Expenses report");
	            System.out.println("9. Exit");
		        System.out.print("Enter your choice: ");
		        choice = scanner.nextInt();
		        scanner.nextLine(); // Consume the newline character

		        switch (choice) {
		            case 1:
		            	// Add Expense
		                System.out.print("Enter expense amount: ");
		                double amount = scanner.nextDouble();
		                scanner.nextLine(); // Consume the newline character
		                System.out.print("Enter expense date (DD/MM/YYYY): ");
		                String date = scanner.nextLine();
		                System.out.print("Enter category ID: ");
		                int categoryId = scanner.nextInt();
		                scanner.nextLine(); // Consume the newline character
		                System.out.print("Enter expense description: ");
		                String description = scanner.nextLine();
		                expenseTracker.AddExpense(amount, date,categoryId, description);
		                break;
		            case 2:
		            	// Update Expenses
		                System.out.print("Enter updated expense amount: ");
		                double updatedAmount = scanner.nextDouble();
		                scanner.nextLine(); // Consume the newline character
		                System.out.print("Enter updated expense date (DD-MM-YYYY): ");
		                String updatedDate = scanner.nextLine();
		                System.out.print("Enter updated category ID: ");
		                int updatedCategoryId = scanner.nextInt();
		                scanner.nextLine(); // Consume the newline character
		                System.out.print("Enter updated expense description: ");
		                String updatedDescription = scanner.nextLine();
		                expenseTracker.UpdateExpense(updatedAmount, updatedDate, updatedDescription, updatedCategoryId);
		                break;
		            case 3:
		            	// Add Category
		            	System.out.print("Enter category id: ");
		            	int categoryIdNumber=scanner.nextInt();
		            	scanner.nextLine(); // Consume the newline character
		            	System.out.print("Enter category name: ");
	                    String categoryName = scanner.nextLine();
	                    expenseTracker.AddCategory(categoryIdNumber,categoryName);
	                    break;
		            case 4:
		            	// Display Expense by Category ID
		                System.out.print("Enter category ID to filter expenses: ");
		                int categoryToFilter = scanner.nextInt();
		                expenseTracker.filterExpensesByCategory(categoryToFilter);
		                break;
		            case 5:
		            	// Delete Expense by Expense ID
		            	System.out.println("Note that this action cannot be undone!!");
		                System.out.print("Enter expense ID to delete: ");
		                int expenseToDelete = scanner.nextInt();
		                expenseTracker.DeleteExpense(expenseToDelete);
		                break;
		            case 6:
		            	// Delete Categories by Category ID
		            	System.out.print("Enter category ID to delete: ");
	                    int categoryToDelete = scanner.nextInt();
	                    expenseTracker.deleteCategory(categoryToDelete);
	                    break;
		            case 7:
		            	// Display All Expenses
	                    expenseTracker.DisplayAllExpenses();
	                    break;
		            case 8:
		                // Delete All Expenses
		                expenseTracker.DeleteAllExpenses();
		                break;
		            case 9:
		            	// Exit
		                System.out.println("Exiting...");
		                DBConnection.deleteDBConnection();
		                System.out.println("\n\t\t\t\t\t**Thank you for using this application**");
		                break;
		            default:
		                System.out.println("Invalid choice. Please try again.");
		        }

		        System.out.println("\n\t\t\t\t\t****Thank you for using this service****\n\n");
		    }
		    
		    scanner.close();
		}
		}
