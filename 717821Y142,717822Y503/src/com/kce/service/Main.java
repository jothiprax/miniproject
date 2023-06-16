package com.kce.service;
import java.util.*;
import com.kce.Dao.CustomerDao;
import com.kce.Dao.CustomerDaoInt;
import com.kce.bean.Customer;
public class Main {
    public static void main(String[] args) {
        String name;
        int id;
        CustomerDaoInt dao=new CustomerDao();
        System.out.println("Welcome to Finance Management!!!");

        try (Scanner sc = new Scanner(System.in)) {
            do{
                System.out.println("1. Add Customer\n" +"2. Show All Customer\n" +"3. Show Customer based on id \n" +"4. Update the Customer\n" +"5. Delete the Customer\n");

                System.out.println("Enter Choice: ");
                int ch=sc.nextInt();
                switch (ch){
                    case 1:
                        Customer user=new Customer();
                        System.out.println("Enter ID : ");
                         id=sc.nextInt();
                        System.out.println("Enter name ");
                         name=sc.next();
                        System.out.println("Enter Loan amount ");
                        double amount=sc.nextDouble();
                        System.out.println("Enter age");
                        int age=sc.nextInt();
                        // System.out.println("Enter Interest ");
                        // int interest = sc.nextInt();
                        user.setId(id);
                        user.setName(name);
                        user.setAmount(amount);
                        user.setAge(age);
                        //user.setInterest(interest);
                        dao.createCustomer(user);
                        break;
                    case 2:
                        dao.showAllCustomer();
                        break;
                    case 3:
                        System.out.println("Enter id to show the details ");
                        int empid=sc.nextInt();
                        dao.showCustomerBasedOnID(empid);
                        break;
                    case 4:
                        System.out.println("Enter id to update the details");
                        int empid1=sc.nextInt();
                        System.out.println("Enter the new name");
                         name=sc.next();
                        dao.updateCustomer(empid1,name);
                        break;
                    case 5:
                        System.out.println("Enter the id to delete");
                        id=sc.nextInt();
                        dao.deleteCustomer(id);
                        break;

                    case 6:
                        System.out.println("Thank you so much for know your Loan details!!!");
                        System.exit(0);
                    default:
                        System.out.println("Enter valid choice !");
                        break;


                }

            }while (true);
        }
         catch (Exception e) {
            System.out.println(e);
        }

    }
}