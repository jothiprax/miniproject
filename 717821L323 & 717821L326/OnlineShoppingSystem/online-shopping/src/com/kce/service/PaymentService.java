package com.kce.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.kce.exception.OnlineShoppingException;

public class PaymentService {
    BillService customerBill;
    public int billPaid_f = 0;
    private CartService customerCart;

    public PaymentService(CartService cart, String customerName, String customerAddress, String contactNumber)
            throws IOException, ClassNotFoundException, SQLException {
        customerCart = cart;
        customerBill = new BillService(customerName, customerAddress, contactNumber, customerCart.getpid(),
                customerCart.getpname(), customerCart.getpqty(), customerCart.getprice());
        billPaid_f = 0;
    }

    public void paymentPage() throws IOException, OnlineShoppingException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("WELCOME TO PAYMENTS PAGE\n");
        int ch;
        do {
            System.out.println("*****************************************\n");
            System.out.println("1 - Pay bill");
            System.out.println("2 - Display bill");
            System.out.println("3 - Exit");
            System.out.println("*****************************************\n");
            System.out.print("Enter choice : ");
            ch = Integer.parseInt(br.readLine());
            if (ch == 1) {
                customerBill.displayBill();
                System.out.println("\nEnter amount to pay = ");
                float flag;
                flag = Float.parseFloat(br.readLine());
                while (flag < customerBill.total_amount || flag > customerBill.total_amount) {
                    System.out.println("Invalid amount entered !");
                    System.out.println("Enter again : ");
                    flag = Float.parseFloat(br.readLine());
                }
                customerBill.addToDatabase();
                System.out.println("Bill paid successfully !");
                billPaid_f = 1;
                ch = 3;
            }
            else if (ch == 2)
                customerBill.displayBill();
            else if (ch == 3)
                System.out.println("Thank you");
            else
                System.out.println("Wrong choice");

        } while (ch != 3);

    }
}
