package com.kce.service;
import com.kce.util.DBConnection;
import com.kce.util.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

class FoodItem {
    private int foodId;
    private String foodName;
    private int quantity;
    private double price;

    public FoodItem() {
    }

    public FoodItem(int foodId, String foodName, int quantity, double price) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getFoodId() {
        return foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void MinimumQuantityAvailable() {
        try{
            DBConnection db = new DBConnection();
            PreparedStatement pst = db.con.prepareStatement("select foodid , foodname, food_category,quantity from fooditem");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                if (10 > rs.getInt("quantity")) {

                    throw new MinimumStockException("Available fooditem Quantity is exceeded for the\nfood : "
                            +rs.getString("foodname")+"\nfood id : "+ rs.getInt("foodid")
                            +"\nAvailable Quantity : "+rs.getInt("quantity"));
                }
            }

        }catch(Exception e){
            System.out.println(e);
        }

    }
}