package com.kce.service;

import com.kce.dao.DBConnection;

import java.util.Scanner;

public class Main {
     Scanner sc = new Scanner(System.in);

    public void customers(){
        Customer customer = new Customer();

        customer.menu(); //Menu display
        customerOptions();
        int i = sc.nextInt();
        while(true){
            switch(i){
                case 1: customer.buyItem(); break;
                case 2: customer.billing();  break;
                case 3: customer.updateCart(); break;
                case 4: customer.displayOrderHistory();break;
                case 5:
                    System.err.println("Process Terminated");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct value");
                    customerOptions();
            }
            customerOptions();
            i = sc.nextInt();
            if(i == 1)
                customer.menu();
        }
    }
    public void customerOptions(){
        System.out.println("\nEnter 1 : Order Items");
        System.out.println("Enter 2 : To print bill");
        System.out.println("Enter 3 : Update orders if any change in quantity");
        System.out.println("Enter 4 : Display your order history");
        System.out.println("Enter 5 : To terminate all processes\n");
    }

    public void owners(){
        Owner admin = new Owner();
        ownerOptions();
        int i = sc.nextInt();
        while(true){
            switch(i){
                case 1: admin.addItem();break;
                case 2: admin.removeItem();break;
                case 3: admin.updateQuantity();break;
                case 4: admin.showAllFoodItem(); break;
                case 5: admin.searchItem();break;
                case 6: admin.displayOrderHistory();break;
                default:
                    System.out.println("\t\tExited");

                    System.exit(0);
            }
            ownerOptions();
            i = sc.nextInt();
        }
    }
    public void ownerOptions(){
        System.out.println("\nEnter 1 : Add an item");
        System.out.println("Enter 2 : Remove an item");
        System.out.println("Enter 3 : Update quantity of an item");
        System.out.println("Enter 4 : Display all items");
        System.out.println("Enter 5 : Search an item");
        System.out.println("Enter 6 : display all the orders taken place");
        System.out.println("Enter 7 : exit\n");
    }


    public static void main(String[] args) {
        try {
            DBConnection db = new DBConnection();

            Scanner sc = new Scanner(System.in);
            Main M = new Main();
            if(db.con != null){
                System.out.println("\nServer Connected\n");

                LogIn l = new LogIn();
                String type = l.logInCheck();

                if(type.equalsIgnoreCase("customer")){
                    M.customers();
                }
                else if (type.equalsIgnoreCase("owner")) {
                   M.owners();
                }

            }else{
                System.out.println("Server Not Found");
            }
            db.con.close();
        }catch(Exception e){
            System.out.println(e);
        }

    }
}