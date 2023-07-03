package com.kce.employee.service;

import java.util.Scanner;
//Importing the package of EmployeeDAO
import com.kce.employee.dao.EmployeeDAO;
//Importing the package ofEmployeeDAOInterface
import com.kce.employee.dao.EmployeeDAOInterface;

public class Main {
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        EmployeeDAOInterface dao = new EmployeeDAO();
        //DBConnection.createTable();
        do{
            
            System.out.println("\t\t\t\t   ****Welcome to Employee Management Application****\n\n"+
                                "1. Add employee to the database : \n"+
                                "2. Search for an employee : \n"+
                                "3. Show all the Employees : \n"+
                                "4. Update the Employee: \n"+
                                "5. Delete the Employee: \n"+
                                "6. Delete all the Employee : \n"+
                                "7. Exit.\n"); 
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1 : 
                try{
                    dao.createEmployee();
                }catch(Exception e){
                    e.printStackTrace();
                }
                    break;

                case 2 :
                    dao.searchForEmployee();
                    break;

                case 3 : 
                    dao.showAllEmployee();
                    break;

                case 4 :
                    dao.updateEmployee();
                    break;    

                case 5 :
                    dao.deleteEmployee();
                   
                    break;

                case 6 :
                    System.out.println("\n\nDeleting all the employee details\n");
                    dao.deleteAllEmployee();
                    break;

                case 7 :
                    System.out.println("\n\t\t\t\t\t*Thank you for using this application*");
                    System.exit(0);

                default :
                    System.out.println("\nPlease enter a valid choice!!!\n");
                    break;

            } 
            System.out.println("\n\t\t\t\t\t***Thank you for using this service***\n\n");

        }while(true);
        
    }
}
