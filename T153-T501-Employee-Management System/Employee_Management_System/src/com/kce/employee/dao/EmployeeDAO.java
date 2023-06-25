package com.kce.employee.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.kce.employee.util.DBConnection;
import com.kce.employee.util.EmailValidation;
import com.kce.employee.util.InvalidNumber;

import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeDAO implements EmployeeDAOInterface {

    Connection connection;

    //Method to create or add a new employee to the database
    @Override
    public void createEmployee(){
        try{
            
            //Getting the connection from DBConnecion class
            connection = DBConnection.createDBConnection();
            //Creating the Scanner Object
            Scanner sc = new Scanner(System.in);
            String query1 = "insert into employeeofficialdetails values(? , ? , ? , ? , ?);";
            String query2 = "insert into employeepersonaldetails values(? , ? , ? , ? , ?);";

            PreparedStatement stmt1 = connection.prepareStatement(query1);
            PreparedStatement stmt2 = connection.prepareStatement(query2);
            System.out.println("\n\t\t\t\t*Please enter the details carefully...*\n\n"+
                                "Enter the id of the employee: ");
            int id = sc.nextInt();sc.nextLine();
            Statement s1 = connection.createStatement();
            ResultSet r1 = s1.executeQuery("Select * from employeeofficialdetails");

            while(r1.next()){
                if(r1.getInt(1)==id){
                   System.out.println("\nEmployee ID has already been in use...");
                   return;
                }
                
            }
            System.out.println("\nEnter the full name of the employee: ");
            String name = sc.nextLine();
            System.out.println("\nEnter the age of the employee: ");
            int age = sc.nextInt();sc.nextLine();
            System.out.println("\nEnter the genger of the employee : ");
            String gender  = sc.nextLine();
            System.out.println("\nEnter the designation of the employee: ");
            String designation = sc.nextLine();
            System.out.println("\nEnter the salary of the employee: ");
            double salary = sc.nextDouble();
            System.out.println("\nEnter the contact number of the employee : ");
            long contact_number = sc.nextLong();sc.nextLine();
            if((contact_number+"").length() != 10){
                try{
                throw new InvalidNumber("Invalid phone number ");
                }catch(Exception e){
                    e.printStackTrace();
                }
                return;
            }
            System.out.println("\nEnter the email id of the employee: ");
            String email = sc.nextLine();
            boolean flag = EmailValidation.validateEmail(email);
            if(flag == false){
                System.out.println("\nThe email format is not valid\n\nFor your reference : emaple123@gmail.com\n");
                return;
            }

            System.out.println("\nEnter the address : ");
            String address = sc.nextLine();
            stmt1.setInt(1 , id);
            stmt1.setString(2 , name);
            stmt1.setString(3 , gender);
            stmt1.setString(4 , designation);
            stmt1.setDouble(5 , salary);
            stmt2.setInt(1, id);
            stmt2.setLong(2 , age);
            stmt2.setString(3 , address);
            stmt2.setLong(4 , contact_number);
            stmt2.setString(5 , email);
            
            int c1 , c2;
            c1 = stmt1.executeUpdate();
            c2 = stmt2.executeUpdate();
            if(c1!=0 && c2!=0) 
            System.out.println("\nStatement Executed successfully...\n");
            stmt1.close();
            stmt2.close();
            System.out.println("Details have been successfully entered\n");
            DBConnection.deleteDBConnection();
            }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //Method to Search for an employee based on the employee id
    @Override
    public void searchForEmployee(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Please the valid id to search for the employee: ");
        int id = sc.nextInt();sc.nextLine();
        
        try{
        connection = DBConnection.createDBConnection();
        PreparedStatement stmt1 = connection.prepareStatement("Select * from employeeofficialdetails where id = ?;");
        PreparedStatement stmt2 = connection.prepareStatement("Select * from employeepersonaldetails where id = ?;");
        stmt1.setInt(1 , id);
        stmt2.setInt(1 , id);
        ResultSet rs1 = stmt1.executeQuery();
        ResultSet rs2 = stmt2.executeQuery();

        System.out.println("Printing the Employee Details...\n");
        
        System.out.format("%-4s  %-15s  %-3s  %-8s  %-10s  %-10s  %-14s  %-18s  %-20s\n" , "ID" , "NAME" , "AGE" , "GENDER" , "DESIGNATION" , "SALARY" , "CONTACT_NUMBER" , "EMAIL" , "ADDRESS");

        while(rs1.next() && rs2.next()){
            System.out.format("\n%-4s  %-15s  %-3s  %-8s  %-10s  %-10s  %-14s  %-18s  %-20s\n" , String.valueOf(rs1.getInt(1)) 
            , String.valueOf(rs1.getString(2))
             , String.valueOf(rs2.getInt(2)) 
             , String.valueOf(rs1.getString(3))
             , String.valueOf(rs1.getString(4))
              , String.valueOf(rs1.getDouble(5))
              , String.valueOf(rs2.getLong(4))
               , String.valueOf(rs2.getString(5))
               , String.valueOf(rs2.getString(3)));
            System.out.println("\n\n");
        }
        if(rs1!=null){
            try{
                rs1.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(rs2!=null){
            try{
                rs2.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(stmt1!=null){
            try{
                stmt1.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(stmt2!=null){
            try{
                stmt2.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        DBConnection.deleteDBConnection();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //Method to display all the employee and their details
    @Override
    public void showAllEmployee() {
        try{
        connection = DBConnection.createDBConnection();
        Statement stmt1 = connection.createStatement();
        Statement stmt2 = connection.createStatement();

        stmt1.executeQuery("select * from employeeofficialdetails");
        stmt2.executeQuery("select * from employeepersonaldetails");

        ResultSet rs1 = stmt1.getResultSet();
        ResultSet rs2 = stmt2.getResultSet();
        
        System.out.println("\nDisplaying the details of all employees\n");
        
        System.out.format("%-4s  %-15s  %-3s  %-8s  %-10s  %-10s  %-14s  %-18s  %-20s\n" , "ID" , "NAME" , "AGE" , "GENDER" , "DESIGNATION" , "SALARY" , "CONTACT_NUMBER" , "EMAIL" , "ADDRESS");

        while(rs1.next() && rs2.next()){
           System.out.format("\n%-4s  %-15s  %-3s  %-8s  %-10s  %-10s  %-14s  %-18s  %-20s\n" , String.valueOf(rs1.getInt(1)) 
                                                                                    , String.valueOf(rs1.getString(2))
                                                                                     , String.valueOf(rs2.getInt(2)) 
                                                                                     , String.valueOf(rs1.getString(3))
                                                                                     , String.valueOf(rs1.getString(4))
                                                                                      , String.valueOf(rs1.getDouble(5))
                                                                                      , String.valueOf(rs2.getLong(4))
                                                                                       , String.valueOf(rs2.getString(5))
                                                                                       , String.valueOf(rs2.getString(3)));
        }
        System.out.println();
        if(rs1!=null){
            try{
                rs1.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(rs2!=null){
            try{
                rs2.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(stmt2!=null){
            try{
                stmt2.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(stmt2!=null){
            try{
                stmt2.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        DBConnection.deleteDBConnection();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Method to update the employee details using employee id    @Override
    public void updateEmployee() {
        
        try{
            Scanner sc = new Scanner(System.in);
            connection = DBConnection.createDBConnection();
            System.out.println("\nPlease enter the id of the employee to be updated : ");
            int id = sc.nextInt();sc.nextLine();
            System.out.println("\nPlease enter the name of the field to be updated: ");
            String column = sc.nextLine();
            System.out.println("\nPlease enter the new data : ");
            String val = sc.nextLine();
            boolean flag = false;
            PreparedStatement stmt;
            ArrayList<String> l = new ArrayList<>();
            l.add("id");
            l.add("name");
            l.add("gender");
            l.add("designation");
            l.add("salary");
            ArrayList<String> sl1 = new ArrayList<>();
            sl1.add("salary");
            ArrayList<String> sl2 = new ArrayList<>();
            sl2.add("age");
            sl2.add("contact_number");

            if(l.contains(column)){
                if(sl1.contains(column)){
                    stmt = connection.prepareStatement("Update employeeofficialdetails set "+ column + "=" + val + " where id in ("+ id +")");
                    stmt.executeUpdate();
                    flag = true;
                }
                else{
                    stmt = connection.prepareStatement("Update employeeofficialdetails set "+ column + "= '" + val + "' where id in ("+ id +")");
                    stmt.executeUpdate();
                    flag = true;
                }
            }
            else{
                if(sl2.contains(column)){
                stmt = connection.prepareStatement("Update employeepersonaldetails set " +  column  + "= " + val +" where id in ( " + id + ")");
                stmt.executeUpdate();
                flag = true;
                }
                else{
                    stmt = connection.prepareStatement("Update employeepersonaldetails set " +  column  + "= '" + val +"' where id in ( " + id + ")");
                    stmt.executeUpdate();
                    flag = true;
                }
            }
            if(flag){
                System.out.println("\nEmployee details updated successfully...\n");
            }
            else{
                System.out.println("\nEmployee details not updated...\n");
            }
            if(stmt!=null){
                try{
                    stmt.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            DBConnection.deleteDBConnection();
            
        }catch(SQLException e){
            e.printStackTrace();

        }
    }

    //Method to delete the employee based on the employee id
    @Override
    public void deleteEmployee() {

        try{
            Scanner sc = new Scanner(System.in);
            connection = DBConnection.createDBConnection();
            System.out.println("\nNote that this action cannot be undone...");
            System.out.println("\nPlease enter the id of the employee to be removed : ");
            int id = sc.nextInt();sc.nextLine();
            PreparedStatement stmt1 = connection.prepareStatement("delete from employeeofficialdetails where id = ?;");
            PreparedStatement stmt2 = connection.prepareStatement("delete from employeepersonaldetails where id = ?;");

            stmt1.setInt(1 , id);
            stmt2.setInt(1 , id);
            int c1 = stmt1.executeUpdate() , c2 = stmt2.executeUpdate();
            if(c1!=0 && c2!=0){
                System.out.println("Employee removed from the database successfully...");
            }
            if(stmt1!=null){
                try{
                    stmt1.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(stmt2!=null){
                try{
                    stmt2.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            DBConnection.deleteDBConnection();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    //Method to delete all the employee
    @Override
    public void deleteAllEmployee(){
        
        //Getting the connection
        try{
        connection = DBConnection.createDBConnection();
        Statement stmt1 = connection.createStatement();
        Statement stmt2 = connection.createStatement();

        stmt1.executeUpdate("Truncate employeeofficialdetails;");
        stmt2.executeUpdate("Truncate employeepersonaldetails;");
        System.out.println("\nTable truncated successfully\n");
        if(stmt1!=null){
            try{
                stmt1.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(stmt2!=null){
            try{
                stmt2.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        DBConnection.deleteDBConnection();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }   
}
