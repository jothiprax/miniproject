package com.kce.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerBill {
    private Connection con;
    private Class c;
    private PreparedStatement ps;
    private int productId;
    private String productName;
    private double price;
    private int quantity;
    private static int sno;
    private static int orderId=0;

    public CustomerBill() {
        try {
            c=Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "commerce", "9894");
            ps = con.prepareStatement("select count(count(order_id)) from orders group by order_id");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                orderId = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public CustomerBill(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }



    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String toString() {
        if(sno == 0) {

            System.out.format("%-10s%-30s%-30s%-30s%-30s\n", "S.no", "Product Id", "Product Name", "Price", "Quantity");
        }
        sno++;
        return String.format("%-10s%-30s%-30s%-30s%-30s", sno, productId, productName, price,quantity);
    }
}
