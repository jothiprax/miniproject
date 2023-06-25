package com.kce.util;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(){
        System.out.println("Product Not Found");
    }
}
