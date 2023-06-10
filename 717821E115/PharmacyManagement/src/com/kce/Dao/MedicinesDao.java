package com.kce.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.kce.bean.Medicines;
import com.kce.util.DButil;

public class MedicinesDao {
	 static Scanner sc = new Scanner(System.in);

	    public static void insertValues(int temp) {
	        try {
	        	int noOfMedicines =temp;
	        	Medicines[] arr=new Medicines[noOfMedicines];
	        	for(int i=0;i<noOfMedicines;i++) {
	        		System.out.println("Enter Id:");
	        		int Id=sc.nextInt();
	        		sc.nextLine();
	        		System.out.println("Enter Name:");
	        		String Name=sc.next();
	        		System.out.println("Enter Barcode:");
	        		String Barcode=sc.next();
	        		System.out.println("Enter Price:");
	        		double Price=sc.nextDouble();
	        		System.out.println("Enter Quantity:");
	        		int Quantity=sc.nextInt();
	        		arr[i]=new Medicines(Id,Name,Barcode,Price,Quantity);
	        	}
	        	 
	            Connection con = DButil.getConnection();
	            PreparedStatement stmt = con.prepareStatement("INSERT INTO medicine VALUES (?, ?, ?, ?, ?)");
	            for (int i = 0; i < temp; i++) {
	                stmt.setInt(1,arr[i].getId());
	                stmt.setString(2, arr[i].getName());
	                
	                stmt.setString(3, arr[i].getBarcode());
	                
	                stmt.setDouble(4, arr[i].getPrice());
	               
	                stmt.setInt(5, arr[i].getQuantity());
	               
	                stmt.executeUpdate();
	                
	            }
	            System.out.println("Values is Inserted Successfully.......");
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }

	    public static void deleteRecord(int id) {
	        try {
	            Connection con = DButil.getConnection();
	            PreparedStatement stmt = con.prepareStatement("DELETE FROM medicine WHERE id = ?");
	            stmt.setInt(1, id);
	            int rows = stmt.executeUpdate();
	            if (rows > 0) {
	                System.out.println("Row is Deleted Successfully........");
	            } else {
	                System.out.println("No row found with the specified ID.");
	            }
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }

	    public static void showDetails() {
	        try {
	            Connection con = DButil.getConnection();
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM medicine");
	            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |%n", "Id", "Name", "Barcode","Price","Quantity");
	            while (rs.next()) {
	            	System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |%n",rs.getInt(1) , rs.getString(2) , rs.getString(3) 
	                        , rs.getDouble(4) , rs.getInt(5));
	            }
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }

	    public static void deleteTable() {
	        try {
	            Connection con = DButil.getConnection();
	            Statement st = con.createStatement();
	            st.executeUpdate("DROP TABLE medicine");
	            System.out.println("Table is Dropped Successfully........");
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }

	    public static void deleteRows() {
	        try {
	            Connection con = DButil.getConnection();
	            Statement st = con.createStatement();
	            st.executeUpdate("TRUNCATE TABLE medicine");
	            System.out.println("Table Record is Deleted Successfully........");
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }

	    public static void updateRecord() {
	        try {
	            Connection con = DButil.getConnection();
	            Statement st = con.createStatement();
	            String str, data;
	            int choice, id;
	            System.out.println("Enter the ID to Update");
	            id = sc.nextInt();
	            ResultSet rs = st.executeQuery("SELECT * FROM medicine");
	            ResultSetMetaData rsMetaData = rs.getMetaData();
	            int columnCount = rsMetaData.getColumnCount();
	            for (int i = 1; i <= columnCount; i++) {
	                System.out.println(i + ". " + rsMetaData.getColumnName(i));
	            }
	            System.out.println("Enter the Choice:");
	            choice = sc.nextInt();
	            sc.nextLine(); 
	            str = rsMetaData.getColumnName(choice);
	            System.out.println("Enter the new data:");
	            data = sc.nextLine();
	            String updateQuery = "UPDATE medicine SET " + str + " = ? WHERE id = ?";
	            PreparedStatement updateStmt = con.prepareStatement(updateQuery);
	            updateStmt.setString(1, data);
	            updateStmt.setInt(2, id);
	            int rowsAffected = updateStmt.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("Record updated successfully.");
	            } else {
	                System.out.println("No record found with the specified ID.");
	            }
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	    public static void buyMedicine() {
	        try {
	            Connection con = DButil.getConnection();
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM medicine");
	            while (rs.next()) {
	                int id = rs.getInt(1);
	                String name = rs.getString(2);
	                String barcode = rs.getString(3);
	                double price = rs.getDouble(4);
	                int quantity = rs.getInt(5);
	                System.out.println("ID: " + id);
	                System.out.println("Name: " + name);
	                System.out.println("Barcode: " + barcode);
	                System.out.println("Price: " + price);
	                System.out.println("Quantity: " + quantity);
	                System.out.println("-----------------------");
	            }
	            System.out.println("Enter No of Medicines You want to Buy");
	            int noOfMedicines =sc.nextInt();
	            System.out.println("Enter the ID And Quantity of the medicine you want to buy:\n\n");
	            int medicineId=0;
	            int quantityToBuy=0;
	            List<Integer> l=new ArrayList<>();
	            List<Integer> q=new ArrayList<>();
	            for(int i=0;i<noOfMedicines;i++) {
	            System.out.println("Enter ID:");
	            medicineId = sc.nextInt();
	            l.add(medicineId);
	            System.out.println("Enter the quantity:");
	            quantityToBuy = sc.nextInt();
	            q.add(quantityToBuy);
	            }
	           
	               List<Double> price=new ArrayList<>();
	               for(int i=0;i<l.size();i++) {
	                PreparedStatement updateStmt = con.prepareStatement("Select Price from medicine Where id=?");
	                updateStmt.setInt(1,l.get(i));
	                ResultSet rs1 = updateStmt.executeQuery();
	                while(rs1 .next()) {
	                	price.add(rs1.getDouble(1));

	                }
	                }
	               double Total =0;
	               System.out.println("Bill Generating................");
	               TimeUnit.SECONDS.sleep(5);
	              
	              
	               for(int i=0;i<l.size();i++) {
	            	   System.out.println("Price of Medicine ID: "+l.get(i)+" Of Quantity "+q.get(i)+" = "+price.get(i)*q.get(i));
	            	 Total=Total+price.get(i)*q.get(i);
	               }
	               System.out.println("Total Price Of Medicines ="+Total);
	        } catch (SQLException e) {
	            System.out.println(e);
	        } catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	    }
}
