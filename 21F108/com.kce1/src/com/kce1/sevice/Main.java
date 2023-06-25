package com.kce1.sevice;

import com.kce1.bean.Employee;
import com.kce1.dao.EmployeeDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        String name;
        int id;
        EmployeeDAO dao=new EmployeeDAO();
       
        Scanner sc=new Scanner(System.in);
        do{
        	 System.out.println("\t\t\t\t   ****Welcome to Employee Management Application****\n\n"+
                     "1. Add employee to the database : \n"+
                 
                     "2. Show all the Employees : \n"+
                     "3. show employee based on id: \n"+
                     "4. update employee: \n " +
                     "5. delete employee: ");
            System.out.println("Enter choice: ");
            int ch=sc.nextInt();
            switch(ch){
                case 1 :
                    Employee emp=new Employee();
                    System.out.println("Enter id: ");
                    id=sc.nextInt();
                    System.out.println("Enter name:");
                     name= sc.next();
                    System.out.println("Enter salary:");
                    double salary=sc.nextDouble();
                    System.out.println("Enter age:");
                    int age=sc.nextInt();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    dao.createEmployee(emp);
                    break;
                case 2:
                    dao.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter id to show details:");
                    int empid=sc.nextInt();
                    dao.showEmployeeBasedOnID(empid);
                    break;
                case 4:
                    System.out.println("Enter id to update the details:");
                    int empid1=sc.nextInt();
                    System.out.println("Enter the new name:");
                    name=sc.next();
                    dao.updateEmployee(empid1,name);
                    break;
                case 5:
                    System.out.println("Enter the id to delete");
                    id=sc.nextInt();
                    dao.deleteEmployee(id);
                    break;
                case 6:
                    System.out.println("thank you");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice ");
                    break;


            }
        }while(true);

    }
}
