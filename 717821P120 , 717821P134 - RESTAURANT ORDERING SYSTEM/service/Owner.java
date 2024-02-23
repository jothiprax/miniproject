package com.kce.service;

import com.kce.dao.DBConnection;

import java.security.spec.ECField;
import java.sql.*;
import java.util.Scanner;
public class Owner {
    private Class c;
    private Connection con;
    private PreparedStatement pst;
    private Scanner sc = new Scanner(System.in);
    public Owner() {
        DBConnection db = new DBConnection();
        this.con = db.con;
    }
    public void addItem(){
        try {

            pst = con.prepareStatement("insert into fooditem  values(?,?,?,?,?)") ;
            PreparedStatement pst2 = con.prepareStatement("select max(foodid) from fooditem where food_category = ?");
            System.out.println("Enter food category : ");
            String foodCategory = sc.nextLine();
            //finding next food id available in food category
            pst2.setString(1,foodCategory);
            ResultSet rs = pst2.executeQuery();
            rs.next();
            int newFoodId = rs.getInt(1) +1;

            // getting food details
            System.out.println("Enter food name : ");
            String foodName = sc.nextLine();
            System.out.println("Enter quantity available : ");
            int quantity = sc.nextInt();
            System.out.println("Enter price : ");
            double price = sc.nextDouble();

            pst.setInt(1,newFoodId);
            pst.setString(2,foodName);
            pst.setString(3,foodCategory);
            pst.setInt(4,quantity);
            pst.setDouble(5,price);

            if(!pst.execute()){
                System.out.println("\n\tFood Item successfully Added");
            }else{
                System.out.println("Food Item not added try again\n");
                addItem();
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void removeItem(){
        try{
            System.out.print("Enter food item Id : ");
            int id = sc.nextInt();
            System.out.println();

            pst = con.prepareStatement("select * from fooditem where foodid = ?");
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                PreparedStatement pst2 = con.prepareStatement("delete from fooditem where foodid = ?");
                pst2.setInt(1,id);
                pst2.execute();
                System.out.println("\n\tItem removed successfully");
            }else{
                System.out.println("\n\titem not found ");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void updateQuantity(){
        try{
            System.out.print("Enter the food item id to Enter new quantity : ");
            int foodId = sc.nextInt();
            System.out.println();
            pst = con.prepareStatement("select * from fooditem where foodid = ?");
            pst.setInt(1,foodId);
            ResultSet rs = pst.executeQuery();

            System.out.println("\t\tSearching...\n");
            Thread.sleep(800);

            if(rs.next()){
                System.out.print("Item found \nEnter the quantity to update : ");
                int quantity = sc.nextInt();
                pst = con.prepareStatement("update fooditem set quantity = ? where foodid = ?");
                pst.setInt(1,quantity);
                pst.setInt(2,foodId);
                pst.executeUpdate();
                System.out.println("\n\t\t Quantity Successfully updated");
            }else {
                System.out.println("Sorry!...Item not found\n\n\tPlease retry");
            }

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void showAllFoodItem(){
        try {
            pst = con.prepareStatement("select * from fooditem order by foodid");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd= rs.getMetaData();
            System.out.println(String.format("%-13s%-17s%-17s%-13s%-13s",rsmd.getColumnLabel(1),rsmd.getColumnLabel(2),rsmd.getColumnLabel(3),rsmd.getColumnLabel(4),rsmd.getColumnLabel(5)));
            while(rs.next()){
                System.out.println(String.format("%-13s%-17s%-17s%-13s%-13s",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5)));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void displayOrderHistory() {
        try{
            LogIn l = new LogIn();
            pst = con.prepareStatement("select * from orderhistory order by ORDER_ID");
            ResultSet rs = pst.executeQuery();
            double totalOrdersCost=0;
            System.out.format("%-12s%-12s%-12s%-18s%-15s%-12s%-12s%-12s\n", "Order Id", "Customer Id", "FoodId Id", "Item Name", "Food Category", "Price", "Quantity", "Ordered Price");
            while (rs.next()) {
                if (rs.getInt("food_id") != 0)
                    System.out.format("%-12s%-12s%-12s%-18s%-15s%-12s%-12s%-12s\n", rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getDouble(8));
                else {
                    System.out.format("%90s : %5s\n", "Total", rs.getDouble("Total_price"));
                    totalOrdersCost += rs.getDouble("Total_price");
                }
            }
            System.out.format("\n%90s : %5s\n", "Total Cost of All Orders",totalOrdersCost);
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public void searchItem(){
        try{
            System.out.print("Enter the food item id : ");
            int foodId = sc.nextInt();
            System.out.println();
            pst = con.prepareStatement("select * from fooditem where foodid = ?");
            pst.setInt(1,foodId);
            ResultSet rs = pst.executeQuery();

            System.out.println("\t\tSearching...\n");
            Thread.sleep(600);
            if(rs.next()) {
                System.out.println("Item found...\n");
                ResultSetMetaData rsmd= rs.getMetaData();
                System.out.println(String.format("%-13s%-17s%-17s%-13s%-13s",rsmd.getColumnLabel(1),rsmd.getColumnLabel(2),rsmd.getColumnLabel(3),rsmd.getColumnLabel(4),rsmd.getColumnLabel(5)));
                System.out.println(String.format("%-13s%-17s%-17s%-13s%-13s",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5)));
            }
            else {
                System.out.println("Sorry!...Item not found\n\n\tPlease retry");
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
