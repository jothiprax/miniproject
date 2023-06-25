package com.kce.dao;

import java.sql.*;
import java.util.*;
public class Owner {
    private Connection con;
    private Class c;
    private PreparedStatement ps;
    private Statement st;
    private Scanner sc=new Scanner(System.in);
    public Owner() {
        try {
            c=Class.forName("oracle.jdbc.driver.OracleDriver");
             con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "commerce", "9894");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void addProduct() throws Exception {
        ps=con.prepareStatement("insert into products values(?,?,?,?)");
        System.out.println("Product ID:");
        int productId=sc.nextInt();
        sc.nextLine();
        System.out.println("Product Name:");
        String productName=sc.nextLine();
        System.out.println("Product Price:");
        double price=sc.nextDouble();
        System.out.println("Product Quantity:");
        int quantity=sc.nextInt();
        ps.setInt(1,productId);
        ps.setString(2,productName);
        ps.setDouble(3,price);
        ps.setInt(4,quantity);
        ps.executeQuery();
        System.out.println(productId+" Productid number added");
    }
    public void showAllProduct() throws Exception{
        ps=con.prepareStatement("select * from products order by productId");
        ResultSet rs=ps.executeQuery();
        System.out.format("%-30s%-30s%-30s%-30s\n","ProductId","ProductName","Price","Quantity");
        while(rs.next()){
            System.out.format("%-30s%-30s%-30s%-30s\n",rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
        }
    }
    public void removeProduct() throws Exception{
        ps=con.prepareStatement("delete from products where productId = ?");
        System.out.println("Product ID:");
        int productId=sc.nextInt();
        ps.setInt(1,productId);
        ps.executeQuery();
        System.out.println(productId+" Product removed");
    }
    public void updateProduct() throws Exception{
        ps=con.prepareStatement("update products set quantity = ? where productId = ?");
        System.out.println("Product ID:");
        int productId=sc.nextInt();
        System.out.println("Product Quantity:");
        int quantity=sc.nextInt();
        ps.setInt(1,quantity);
        ps.setInt(2,productId);
        ps.executeQuery();
        System.out.println(productId+" Product updated");
    }


    public void displayOrders() throws Exception{
        ps = con.prepareStatement("select * from orders");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            if(rs.getInt(4) != 0) {
                System.out.format("%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getInt(4), rs.getString(5),
                        rs.getDouble(6), rs.getInt(7), rs.getDouble(8));
            }
            else {
                System.out.format("%70s : %s\n","Total",rs.getDouble(8));
            }
        }
    }
}
