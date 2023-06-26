package com.kce.service;

import com.kce.bean.CustomerBill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import com.kce.dao.DBConnection;
import com.kce.util.*;
public class Customer {
    private Connection con;
    private PreparedStatement pst;


    private Scanner sc = new Scanner(System.in);
    private List<CustomerBill> list = new ArrayList<>();
    public Customer() {
        DBConnection db = new DBConnection(); this.con = db.con;
    }
    public void menu(){
        try {
            pst = con.prepareStatement("select * from fooditem order by foodid");

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd= rs.getMetaData();
            String category = "";
            System.out.println("-------Menu-----");
            while(rs.next()){
                if(!rs.getString(3).equals(category)){
                    category = rs.getString(3);
                    System.out.println("\n"+category.toUpperCase());
                    System.out.println(String.format("%-13s%-17s%-13s",rsmd.getColumnLabel(1),rsmd.getColumnLabel(2),rsmd.getColumnLabel(5)));
                }
                System.out.println(String.format("%-13s%-17s%-13s",rs.getInt(1),rs.getString(2),rs.getDouble(5)));
            }
            System.out.println();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void buyItem() {
        try {
            System.out.println("To terminate buying enter 100 as food Id");
            System.out.print("Enter food Id to buy : ");
            int foodid = sc.nextInt();

            while (foodid != 100) {
                pst = con.prepareStatement("select * from fooditem where foodid = ?");
                pst.setInt(1, foodid);
                ResultSet rs = pst.executeQuery();

                    if (rs.next() && foodid == rs.getInt(1)) {
                        System.out.print("Food Quantity : ");
                        int quantity = sc.nextInt();
                        if (rs.getInt(4) <= quantity) {
                            throw new QuantityExceededException();
                        } else {
                            int finalFoodid = foodid;
                            Optional<CustomerBill> obj = list.parallelStream().filter(c -> c.getFoodId() == finalFoodid).findFirst();
                            //int prevQuantity = 0;
                            if (obj.isPresent()) {

                                obj.get().setOrderedQuantity(obj.get().getOrderedQuantity() + quantity);
                                obj.get().setCostOfGivenQuantity(obj.get().getPrice() * obj.get().getOrderedQuantity());
                            } else {
                                list.add(new CustomerBill(rs.getInt(1), rs.getString(2), rs.getDouble(5), quantity,rs.getString("food_category")));
                            }
                            PreparedStatement ps2 = con.prepareStatement("update fooditem set quantity = ? where foodid = ?");
                            ps2.setInt(1, rs.getInt(4) - quantity);
                            ps2.setInt(2, foodid);
                            ps2.executeUpdate();
                        }
                    } else {
                        System.out.println();
                        throw new FoodItemNotFoundException("Food item not found\nPlease....Try again");
                    }
                System.out.print("Enter food Id to buy : ");
                foodid = sc.nextInt();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void billing(){
        try{
            CustomerBill cb = new CustomerBill();
            LogIn l = new LogIn();
            cb.setOrderId(cb.getOrderId());
            System.out.println("Order no : " + cb.getOrderId());
            double total = 0.0d;

            //total = list.stream().mapToDouble(x -> x.getCostOfGivenQuantity()).sum();
            pst = con.prepareStatement("insert into orderhistory values(?,?,?,?,?,?,?,?)");
            pst.setString(2,l.getCustomerId());
            pst.setInt(1,cb.getOrderId());
            for (CustomerBill custb : list) {
                System.out.println(custb);
                pst.setInt(1,custb.getOrderId());
                pst.setInt(3,custb.getFoodId());
                pst.setString(4,custb.getFoodName());
                pst.setString(5,custb.getFoodCategory());
                pst.setDouble(6,custb.getPrice());
                pst.setInt(7,custb.getOrderedQuantity());
                pst.setDouble(8,custb.getCostOfGivenQuantity());
                pst.executeUpdate();

                total += custb.getCostOfGivenQuantity();
            }

            pst.setInt(3,0);
            pst.setString(4,null);
            pst.setString(5,null);
            pst.setDouble(6,0);
            pst.setInt(7,0);
            pst.setDouble(8,total);
            pst.executeUpdate();
            list.clear();

            System.out.format("%67s%s", "Total :  ", total);
            cb.setSno(0);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void updateCart(){
        try {
            System.out.print("Enter Food id to update your order with new quantity: ");
            int foodid = sc.nextInt();
            System.out.print("Enter the quantity you have to remove : ");
            int updateQuantity = sc.nextInt();

            Optional<CustomerBill> option = list.stream().filter(x -> x.getFoodId() == foodid).findFirst();
            CustomerBill obj = option.get();
            if (option.isPresent()) {
                PreparedStatement ps = con.prepareStatement("select * from fooditem where foodid = ?");
                ps.setInt(1, foodid);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    pst = con.prepareStatement("update fooditem set quantity = ? where foodid = ?");
                    if (rs.getInt(4) + obj.getOrderedQuantity() >= updateQuantity) {
                        if (updateQuantity < obj.getOrderedQuantity()) {
                            pst.setInt(1, rs.getInt(4) + obj.getOrderedQuantity() - updateQuantity);
                        } else {
                            pst.setInt(1, rs.getInt(4) - updateQuantity + obj.getOrderedQuantity());
                        }
                        pst.setInt(2,foodid);
                        pst.executeUpdate();
                        obj.setOrderedQuantity(updateQuantity);
                        obj.setCostOfGivenQuantity(obj.getPrice() * updateQuantity);
                        System.out.println("Cart updated successfully");
                    } else {
                        throw new QuantityExceededException();
                    }
                }
            }else {
                System.out.println("Item not found exception");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void displayOrderHistory() {
        try{
            LogIn l = new LogIn();
            pst = con.prepareStatement("select * from orderhistory where customer_id = ? ");
            pst.setString(1, l.getCustomerId());
            ResultSet rs = pst.executeQuery();
            System.out.format("%-12s%-12s%-20s%-12s%-12s%-12s\n", "Order Id", "Food Id", "Item Name", "Price", "Quantity", "Product Price");
            while (rs.next()) {
                if (rs.getInt("food_id") != 0)
                    System.out.format("%-12s%-12s%-20s%-12s%-12s%-12s\n", rs.getInt("order_id"), rs.getInt("food_id"), rs.getString("food_name"), rs.getDouble("price"), rs.getInt("ordered_quantity"), rs.getDouble("total_price"));
                else
                    System.out.format("%64s : %6s\n\n", "Total", rs.getDouble("Total_price"));
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
