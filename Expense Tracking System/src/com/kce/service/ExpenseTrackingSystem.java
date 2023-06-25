package com.kce.service;

import java.util.Scanner;

public class ExpenseTrackingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseTracker et = new ExpenseTracker();
        System.out.println("Welcome to Expense Tracking System");
        while (true) {
            System.out.println("Enter 1: Add Expense");
            System.out.println("Enter 2 : View Expenses");
            System.out.println("Enter 3 : Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:


                    et.addExpense();
                    System.out.println("Expense added successfully!");

                    break;
                case 2:
                    et.printExpenses();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }
}