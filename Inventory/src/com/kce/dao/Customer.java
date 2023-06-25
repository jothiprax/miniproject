package com.kce.dao;

import com.kce.bean.CustomerBill;
import com.kce.util.MinimumStockException;
import com.kce.util.ProductNotFoundException;

import java.sql.*;
import java.util.*;

public class Customer {
    private Connection con;
    private Class c;
    private PreparedStatement ps;
    private Statement st;
    private Scanner sc=new Scanner(System.in);

    private double totalCost;
    List<CustomerBill>list =new ArrayList<>();
    public Customer() {
        try {
            c=Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "commerce", "9894");
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    public void buyItem(int productId) throws Exception{
        System.out.println("Product Quantity: ");
        int quantity=sc.nextInt();
        ps=con.prepareStatement("select * from products where productId = ?");
        ps.setInt(1,productId);
        ResultSet rs=ps.executeQuery();
        if(rs.next()) {
            list.add(new CustomerBill(rs.getInt(1), rs.getString(2), rs.getDouble(3), quantity));
            System.out.println("Item added");
        }
        else{
            throw new ProductNotFoundException();
        }
        ps=con.prepareStatement("select quantity from products where productId = ?");
        ps.setInt(1,productId);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            int availableQuantity = resultSet.getInt(1);
            if (availableQuantity >= quantity) {
                int updatedQuantity = availableQuantity - quantity;
                ps = con.prepareStatement("UPDATE products SET quantity = ? WHERE productId = ?");
                ps.setInt(1, updatedQuantity);
                ps.setInt(2, productId);
                ps.executeUpdate();
            }
            else{
                throw new MinimumStockException();
            }
        }
        else{
            throw new ProductNotFoundException();
        }
    }
    public void showBuyItems() throws Exception{
        CustomerBill cb = new CustomerBill();
        cb.setOrderId(cb.getOrderId()+1);
        Login l = new Login();
        System.out.println("com.kce.dao.Customer Name: "+l.getUsername());
        System.out.println("com.kce.dao.Customer Id : "+l.getCustomerId());
        System.out.println("Order Id : "+cb.getOrderId());
        PreparedStatement ps1 = con.prepareStatement("insert into orders values(?,?,?,?,?,?,?,?)");
        ps1.setString(1,l.getCustomerId());
        ps1.setString(2,l.getUsername());
        ps1.setInt(3,cb.getOrderId());

        totalCost=0;
        for(CustomerBill c:list){
            System.out.println(c);
            ps1.setInt(4,c.getProductId());
            ps1.setString(5,c.getProductName());
            ps1.setDouble(6,c.getPrice());
            ps1.setInt(7,c.getQuantity());
            ps1.setDouble(8,c.getPrice()*c.getQuantity());
            ps1.executeQuery();
            totalCost+=(c.getPrice()*c.getQuantity());
        }
        ps1.setString(1,l.getCustomerId());
        ps1.setString(2,null);
        ps1.setInt(3,cb.getOrderId());
        ps1.setInt(4,0);
        ps1.setDouble(6,0);
        ps1.setInt(7,0);

        ps1.setString(5,"Total");
        ps1.setDouble(8,totalCost);
        ps1.execute();
        System.out.println("\n\t\tTotal cost : "+totalCost);
        cb.setOrderId(cb.getOrderId()+1);
    }



    public void removeItem() throws Exception{
        System.out.println("Product Id: ");
        int productId=sc.nextInt();
        int quantity=0;
        double price=0;
        for(CustomerBill c:list){
            if(c.getProductId()==productId){
                quantity=c.getQuantity();
                price=c.getPrice();
                list.remove(c);
            }
        }
        totalCost-=(quantity*price);
        System.out.println("Item removed");
        ps=con.prepareStatement("select quantity from products where productId = ?");
        ps.setInt(1,productId);
        ResultSet rs= ps.executeQuery();
        if(rs.next()){
            int availableQuantity=rs.getInt(1);
            int updatedQuantity=availableQuantity+quantity;
            ps=con.prepareStatement("update products set quantity = ? where productId = ?");
            ps.setInt(1,updatedQuantity);
            ps.setInt(2,productId);
            ps.executeQuery();
        }
    }
    public void showAllItems() throws Exception{
        System.out.println("\nShowing all products: ");
        ps=con.prepareStatement("select productId,productName,price from products order by productId");

        System.out.format("%-30s%-30s%-30s\n","ProductId","ProductName","Price");
        ResultSet rs=ps.executeQuery();

        while(rs.next()){
            System.out.format("%-30s%-30s%-30s\n",rs.getInt(1),rs.getString(2),rs.getDouble(3));
        }
    }
    public void buyItem1() {
        try {
            System.out.println("To terminate buying enter 100 as Product Id");
            System.out.print("Enter Product Id to buy : ");
            int productId = sc.nextInt();

            while (productId != 100) {
                ps = con.prepareStatement("select * from products where productId = ?");
                ps.setInt(1, productId);
                ResultSet rs = ps.executeQuery();

                if (rs.next() && productId == rs.getInt(1) ) {
                    System.out.print("Product Quantity : ");
                    int quantity = sc.nextInt();
                    if(rs.getInt(4) <= quantity) {
                        throw new MinimumStockException();
                    }
                    else{
                        int finalProductId = productId;
                        Optional<CustomerBill> obj = list.parallelStream().filter(c -> c.getProductId() == finalProductId).findFirst();
                        //int prevQuantity = 0;
                        if(obj.isPresent())
                        {
                            //obj.get().getOrderedQuantity += quantity;
                            obj.get().setQuantity(obj.get().getQuantity() + quantity);
                        }
                        else {
                            list.add(new CustomerBill(rs.getInt(1), rs.getString(2), rs.getInt(3), quantity));
                        }
                        PreparedStatement ps2 = con.prepareStatement("update products set quantity = ? where ProductId = ?");
                        ps2.setInt(1,rs.getInt(4) - quantity );
                        ps2.setInt(2,productId);
                        ps2.executeUpdate();
                    }

                }
                else{
                    throw new ProductNotFoundException();
                    //System.out.println("Item not found\nPlease....Try again");
                }
                System.out.print("Enter Product Id to buy : ");
                productId = sc.nextInt();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void updateCart1(){
        try {
            System.out.print("Enter Product id to update your order with new quantity: ");
            int productId = sc.nextInt();
            System.out.print("Enter the quantity you have to remove : ");
            int updateQuantity = sc.nextInt();

            Optional<CustomerBill> option = list.stream().filter(x -> x.getProductId() == productId).findFirst();
            CustomerBill obj = option.get();
            if (option.isPresent()) {
                PreparedStatement pst = con.prepareStatement("select * from products where productId = ?");
                ps.setInt(1, productId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    pst = con.prepareStatement("update products set quantity = ? where productId = ?");
                    if (rs.getInt(4) + obj.getQuantity() >= updateQuantity) {
                        if (updateQuantity < obj.getQuantity()) {
                            pst.setInt(1, rs.getInt(4) + obj.getQuantity() - updateQuantity);
                        } else {
                            pst.setInt(1, rs.getInt(4) - updateQuantity + obj.getQuantity());
                        }
                        pst.setInt(2,productId);
                        pst.executeUpdate();
                        obj.setQuantity(updateQuantity);
                        //obj.setCostOfGivenQuantity(obj.getPrice() * updateQuantity);
                        System.out.println("Cart updated successfully");
                    } else {
                        throw new MinimumStockException();
                    }
                }
            }else {
                System.out.println("Item not found exception");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void removeOrder(){
        try {
            Login l = new Login();
            System.out.println("Enter order id to remove a product: ");
            int orderId = sc.nextInt();
            System.out.println("Enter product id: ");
            int productId = sc.nextInt();
            ps = con.prepareStatement("select * from orders where customer_id = ? and order_id = ?  and product_id = ?");

            ps.setString(1, l.getCustomerId());
            ps.setInt(2, orderId);
            ps.setInt(3,productId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) ;
                int ordQuantity = rs.getInt("QUANTITY");
                double orderedPrice = rs.getDouble("TOTAL_PRICE");
            System.out.println(orderedPrice);

            PreparedStatement ps1 = con.prepareStatement("select * from orders where product_id = 0 and customer_id = ? and order_id = ?");
            ps1.setString(1,l.getCustomerId());
            ps1.setInt(2,orderId);
            int prdQuantity = 0;
            rs = ps1.executeQuery();
            if(rs.next());
            double total = rs.getDouble(8);
            System.out.println(total);

            ps = con.prepareStatement("select quantity from products where productId = ?");
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            if (rs.next()) {
                prdQuantity = rs.getInt(1);
            }
            ps = con.prepareStatement("update products set quantity = ? where productId = ?");
            ps.setInt(1, prdQuantity + ordQuantity);
            ps.setInt(2,productId);
            ps.executeQuery();

            ps = con.prepareStatement("update orders set total_price = ? where product_id = 0 and order_id = ?");
            ps.setDouble(1,total - orderedPrice);
            ps.setInt(2,orderId);
            ps.executeUpdate();


            ps = con.prepareStatement("update orders set quantity = 0, total_price = 0 where product_id = ?  and order_id = ? ");
            ps.setInt(1,productId);
            ps.setInt(2,orderId);
            ps.executeUpdate();

            System.out.println("Product id =" + productId + " removed from order id =" + orderId);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void displayOrderHistory() throws Exception{
        Login l = new Login();
        ps = con.prepareStatement("select * from orders where customer_id = ?");
        ps.setString(1,l.getCustomerId());
        ResultSet rs = ps.executeQuery();
        System.out.format("%-12s%-12s%-12s%-12s%-12s%-12s\n","Order Id","Product Id","Product Name","Price","Quantity","Product Price");
        while(rs.next()){
            if(rs.getInt("product_id") != 0)
                System.out.format("%-12s%-12s%-12s%-12s%-12s%-12s\n",rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getDouble(6),rs.getInt(7),rs.getDouble(8));
            else
                System.out.format("%55s : %7s\n","Total",rs.getDouble("Total_price"));


        }

    }
}
