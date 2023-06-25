package com.kce.service;

import com.kce.DBUnit.DBConnection;
import com.kce.bean.Expense;

import java.sql.*;

import java.time.LocalDate;
import java.util.Scanner;

public class ExpenseTracker {
    private Connection con;
    public ExpenseTracker() {
        DBConnection db = new DBConnection();
        this.con = db.con;
    }

    public void addExpense() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter expense description: ");
        String description = sc.nextLine();
        System.out.print("Enter expense amount: ");
        double price = sc.nextDouble();
        Expense expense = new Expense(description, price);
        try {
            PreparedStatement pst = con.prepareStatement("insert into expenses values(?,?,?)");
            pst.setString(1,description);
            pst.setDouble(2,price);
            pst.setDate(3, Date.valueOf(LocalDate.now()));
            pst.execute();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public double getTotalExpenses() {
        double total = 0;
        try {
            PreparedStatement pst = con.prepareStatement("select * from expenseswww");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                total += rs.getDouble(2);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

            return total;
    }
    public void printExpenses() {
        System.out.println("Expense List:");
        try {
            PreparedStatement pst = con.prepareStatement("select * from expenses");
            ResultSet rs = pst.executeQuery();
            System.out.println(String.format("%-13s%-13s%-13s","Description","Price","Date"));
            while(rs.next()){
                System.out.println(String.format("%-13s%-13s%-13s",rs.getString(1),rs.getDouble(2),rs.getDate(3)));

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Total Expenses: " + getTotalExpenses());
    }
}