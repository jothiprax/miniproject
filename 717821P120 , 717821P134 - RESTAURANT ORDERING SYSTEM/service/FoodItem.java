package com.kce.service;
import com.kce.util.*;
class FoodItem {
    private int foodId;
    private String foodName;
    private int quantity;
    private double price;

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
    public boolean isAvailable(){
        if(quantity > 0)
            return true;
        return false;
    }
    public void updateQuantity(int quantity) {
        try{
            if(quantity > this.quantity){
                throw new QuantityExceededException("Available fooditem Quantity is exceeded");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The available quantity is : "+getQuantity());
        }
    }
}