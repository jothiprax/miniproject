package com.kce.student.service;
import com.kce.student.bean.*;
import com.kce.student.dao.Operations;

import java.util.Scanner;
public class DriverCode{
    public static void menu(){
        System.out.println("MENU");        
        System.out.println("1:: ADD STUDENT");        
        System.out.println("2:: DELETE STUDENT");
        System.out.println("3:: UPDATE STUDENT");
        System.out.println("4:: UPDATE DEPARTMENT");
        System.out.println("5:: SEARCH WITH ID");
        System.out.println("6:: DISPLAY ALL DETAILS");
        System.out.println("10:: EXIT");
    }

    public static void displayMsg(String msg){
        System.out.println(msg);
    }

    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        ValidationOfValues valid = new ValidationOfValues();
        Operations operations = new Operations();
        displayMsg("Welcome to Student Management System........");
        int option=0;
        do{
            menu();
            System.out.print("Enter your Option: "); 
            option = sc.nextInt();

            switch(option){
                case 1:{

                    displayMsg("Student details");
                    System.out.println("Enter student id between 100 to 999 :: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter student name :: ");
                    String name = sc.nextLine();
                    name = name.toUpperCase();
                    System.out.println("Enter student Grade :: ");
                    String grade = sc.next();
                    grade=grade.toUpperCase();
                    System.out.println("Enter student Age :: ");
                    int age = sc.nextInt();

                    displayMsg("Department details");
                    System.out.println("Enter department name :: ");
                    String department = sc.next();
                    department = department.toUpperCase();

                    Department dept = new Department(id, name, grade, age, department);
                    displayMsg("Validating input details");
                    Thread.sleep(2500);

                    boolean flag = valid.validateId(dept.getId()) && valid.validateAge(dept.getAge()) && valid.validateGrade(dept.getGrade()) && valid.validateDepartment(dept.getDepartmentName());
                    
                    if(flag){
                        displayMsg("Input has been validated successfully");
                        displayMsg("Adding your information into the database");
                        Thread.sleep(1000);
                        operations.addStudent(dept.getId(),dept.getName(),dept.getGrade(),dept.getAge(),dept.getDepartmentName());
                        displayMsg("Your information has been added successfully into the database");
                    }

                    break;
                }

                case 2:{
                    System.out.println("Enter student id  that wanted to be deleted :: ");
                    int id = sc.nextInt();
                    displayMsg("Validating input details");
                    Thread.sleep(2500);

                    //validating the user inputs
                    boolean flag = valid.validateDUId(id);
                    if(flag){
                        displayMsg("Input has been validated successfully");
                        displayMsg("Deleting information from the database");
                        Thread.sleep(1000);
                        operations.removeStudent(id);
                        displayMsg("Your information has been deleted successfully from the database");
                        Thread.sleep(3000);
                    }
                    
                    break;
                }

                case 3:{
                    System.out.println("Enter student id that wanted to be Updated :: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter student name :: ");
                    String name = sc.nextLine();
                    name = name.toUpperCase();
                    System.out.println("Enter student Grade :: ");
                    String grade = sc.next();
                    grade=grade.toUpperCase();
                    System.out.println("Enter student Age :: ");
                    int age = sc.nextInt();
                    displayMsg("Validating input details");
                    Thread.sleep(2500);

                    //validating the user inputs
                    boolean flag = valid.validateDUId(id) && valid.validateGrade(grade) && valid.validateAge(age);
                    if(flag){
                        displayMsg("Input has been validated successfully");
                        Thread.sleep(2500);
                        displayMsg("Updating your information in the database");
                        operations.updateStudent(id, name, grade, age);
                        displayMsg("Your information has been Updated successfully in the database");
                        Thread.sleep(2500);
                    }

                    break;
                }

                case 4:{
                    System.out.println("Enter student id that wanted to be Updated :: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter department name :: ");
                    String dept = sc.nextLine();
                    dept = dept.toUpperCase();
                    displayMsg("Validating your input details");
                    Thread.sleep(2500);

                    boolean flag = valid.validateDUId(id) && valid.validateDepartment(dept);
                    if(flag){
                        displayMsg("Input has been validated successfully");
                        Thread.sleep(2500);
                        displayMsg("Updating your information into the database");
                        operations.updateDepartment(id, dept);
                        displayMsg(".Your information has been Updated successfully into the database.");
                        Thread.sleep(3000);
                    }
                    
                    break;
                }

                case 5:{

                    System.out.println("Enter student id that wanted to be Search :: ");
                    int id = sc.nextInt();
                    displayMsg("Validating input details");

                    //validating user input
                    boolean flag = valid.validateDUId(id);
                    if(flag){
                        displayMsg("Input has been validated successfully");
                        Thread.sleep(2500);
                        System.out.println("display student details for id = "+ id);
                        operations.searchId(id);
                    }
                    
                    break;
                }

                case 6:{
                    System.out.println("Display of all student and department details");
                    operations.displayAll();

                    break;
                }
            }
        }while(option!=10); 
        sc.close();
    }
}