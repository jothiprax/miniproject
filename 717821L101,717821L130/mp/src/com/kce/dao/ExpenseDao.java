package com.kce.dao;
//Importing the package of Database Connection
import com.kce.util.DBConnection;

//Importing the packages of user defined Exceptions
import com.kce.util.InvalidCategoryException;
import com.kce.util.InvalidExpenseException;
//Importing the package of Bean classes
import com.kce.bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDao {
	
	    // Getting the connection from DBConnection class
	    Connection connection;
        private List<Expense> expenses;
    	private List<Category> categories;
    	private double budgetLimit;
    	
        // Constructor 
    	public ExpenseDao(Connection connection) {
    		this.expenses = new ArrayList<>();
    		this.categories = new ArrayList<>();
    		this.budgetLimit = 0.0;
    		this.connection = connection;
    	}
    
    	// Method to add columns in Expenses Table. 
    	
    	public void AddExpense(double amount, String date, int categoryId, String description) {
            try {
            	// checks for validate data
                validateExpense(amount);
                String query = "INSERT INTO expenses (amount, date_spend, category_id, description) VALUES (?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setDouble(1, amount);
                    statement.setString(2, date);
                    statement.setInt(3, categoryId);
                    statement.setString(4, description);
                    int rowsAffected = statement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("EXPENSE ADDED SUCCESSFULLY");
                    } else {
                        System.out.println("Failed to add expense.");
                    }
                }
            } catch (InvalidExpenseException | SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    	
    	// Method to update the added expenses if any update needed.
 
    	public void UpdateExpense(double newAmount, String newDate, String newDescription,int newCategoryId) {
            try {
            	// checks for validate data
                validateExpense(newAmount);
                String query = "UPDATE expenses SET amount = ?, date_spend = ?, description = ? WHERE category_id = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setDouble(1, newAmount);
                    statement.setString(2, newDate);
                    statement.setString(3, newDescription);
                    statement.setInt(4, newCategoryId);
                    int rowsAffected = statement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Expense updated successfully.");
                    } else {
                        System.out.println("Failed to update expense.");
                    }
                }
            } catch (InvalidExpenseException | SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    	
    	// Method to generate all expenses report.
    	
    	public void DisplayAllExpenses() {
            String query = "SELECT * FROM expenses";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                System.out.println("All Expenses:");
                while (resultSet.next()) {
                    double amount = resultSet.getDouble("amount");
                    String date = resultSet.getString("date_spend");
                    int categoryId = resultSet.getInt("category_id");
                    String description = resultSet.getString("description");
                    
                    System.out.println();
                    System.out.println("Amount: " + amount);
                    System.out.println("Date: " + date);
                    System.out.println("Category ID: " + categoryId);
                    System.out.println("Description: " + description);
                    System.out.println("----------------------");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    	
    	// Method to Delete All Added Expenses
    	
    	public void DeleteAllExpenses() {
    	    String query = "DELETE FROM expenses";

    	    try (Statement statement = connection.createStatement()) {
    	        int rowsAffected = statement.executeUpdate(query);
    	        if (rowsAffected > 0) {
    	            System.out.println("All expenses deleted successfully.");
    	        } else {
    	            System.out.println("No expenses found to delete.");
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	}
        
    	// Method to Add columns in the Category Table
    	
    	public void AddCategory(int id,String name) {
            try {
                validateCategory(name,id);
                String query = "INSERT INTO categories (id,name) VALUES (?,?)";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                	statement.setInt(1, id);
                    statement.setString(2, name);
                    int rowsAffected = statement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Category added successfully.");
                    } else {
                        System.out.println("Failed to add category.");
                    }
                }
            } catch (InvalidCategoryException | SQLException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Category ID already exists");
            }
        }
    	
        // Method to Filter Expense Report by Category ID.
    	
        public void filterExpensesByCategory(int categoryId) {
            String query = "SELECT e.amount, e.date_spend, c.name AS category, e.description " +
                    "FROM expenses e " +
                    "JOIN categories c ON e.category_id = c.id " +
                    "WHERE e.category_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, categoryId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    System.out.println("Expenses for Category ID " + categoryId + ":");
                    while (resultSet.next()) {
                        double amount = resultSet.getDouble("amount");
                        String date = resultSet.getString("date_spend");
                        String category = resultSet.getString("category");
                        String description = resultSet.getString("description");

                        System.out.println("Amount: " + amount);
                        System.out.println("Date: " + date);
                        System.out.println("Category: " + category);
                        System.out.println("Description: " + description);
                        System.out.println("----------------------");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        // Method to Delete Expense Report.
        
        public void DeleteExpense(int expenseId) {
            String query = "DELETE FROM expenses WHERE category_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, expenseId);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Expense deleted successfully.");
                } else {
                    System.out.println("Failed to delete expense. Expense ID not found.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        // Method to Delete Category Table.
        
        public void deleteCategory(int categoryId) {
            try {
                String query = "DELETE FROM categories WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, categoryId);
                    int rowsAffected = statement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Category deleted successfully.");
                    } else {
                        System.out.println("Failed to delete category.Category ID not found.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        // Method for data validation of Expense Amount.
        public void validateExpense(double amount) throws InvalidExpenseException {
            if (amount <= 0) {
                throw new InvalidExpenseException("Expense amount should be greater than zero.");
            }
        }
        
        // Method for data validation of  Category Name
        public void validateCategory(String name,int id) throws InvalidCategoryException {
            if (name == null || name.trim().isEmpty()) {
                throw new InvalidCategoryException("Category name cannot be empty.");
            }
            else if(id <= 0) {
            	throw new InvalidCategoryException("Category ID should be greater than zero.");
            }
        }
}

	    
