package com.kce.bean;

import com.kce.dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerBill {
    private int foodId;
    private String foodName;
    private String foodCategory;
    private int orderedQuantity;
    private double price;
    private double costOfGivenQuantity;
    private static int sno=0;
    private static int orderId =1;
    private Connection con;
    public CustomerBill(){
        try{
            DBConnection db = new DBConnection();
            PreparedStatement pst = db.con.prepareStatement("select count(count(order_id)) from orderhistory group by order_id");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                CustomerBill.orderId = rs.getInt(1) + 1;
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }


    public CustomerBill(int foodId, String foodName, double price, int orderedQuantity,String foodCategory) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodCategory = foodCategory;
        this.price = price;
        this.orderedQuantity = orderedQuantity;
        this.costOfGivenQuantity = orderedQuantity * price;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOrderedQuantity(int orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public void setCostOfGivenQuantity(double costOfGivenQuantity) {
        this.costOfGivenQuantity = costOfGivenQuantity;
    }

    public int getFoodId() {
        return foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public double getPrice() {
        return price;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }

    public double getCostOfGivenQuantity() {
        return costOfGivenQuantity;
    }

    public  int getSno() {
        return sno;
    }

    public  void setSno(int sno) {
        CustomerBill.sno = sno;
    }

    public  int getOrderId() {

        return orderId;
    }

    public  void setOrderId(int orderId) {
        CustomerBill.orderId = orderId;
    }

    public String toString() {
        if(sno == 0)
            System.out.println(String.format("%-10s%-10s%-20s%-8s%-19s%-15s","S.no","Food Id","Food Name","Price","Quantity","Cost"));
        sno++;
        return String.format("%-10s%-10s%-20s%-8s%-19s%-15s", sno, foodId, foodName, price,orderedQuantity , costOfGivenQuantity);
    }
}
