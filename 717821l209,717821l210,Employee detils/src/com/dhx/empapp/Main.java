package com.dhx.empapp;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        String name;
        int id;
        EmployeeDaoInt dao=new EmployeeDaoImpl();
        System.out.println("Welcome");
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("1.Add employee\n" +
                    "2. show all employee\n" +
                    "3. show employee based on id\n"+
                    "4. update employee\n " +
                    "5. delete employee");
            System.out.println("Enter choice ");
            int ch=sc.nextInt();
            switch(ch){
                case 1 :
                    Employee emp=new Employee();
                    System.out.println("enter id");
                    id=sc.nextInt();
                    System.out.println("enter name");
                     name= sc.next();
                    System.out.println("enter salary");
                    double salary=sc.nextDouble();
                    System.out.println("enter age");
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
                    System.out.println("enter id to show details");
                    int empid=sc.nextInt();
                    dao.showEmployeeBasedOnID(empid);
                    break;
                case 4:
                    System.out.println("Enter id to update the details");
                    int empid1=sc.nextInt();
                    System.out.println("enter the new name");
                    name=sc.next();
                    dao.updateEmployee(empid1,name);
                    break;
                case 5:
                    System.out.println("enter the id to delete");
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
