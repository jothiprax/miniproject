package com.kce.util;

public class FoodItemNotFoundException extends Exception  {
    public FoodItemNotFoundException() {
    }

    public FoodItemNotFoundException(String message) {
        super(message);
    }
}
