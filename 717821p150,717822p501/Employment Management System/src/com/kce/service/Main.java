package com.kce.service;
import java.util.*;
import com.kce.bean.EmployeeDB;
import com.kce.dao.EmployeeJDBC;
class Main {
	public static void main(String[] args) throws ClassNotFoundException {
		try (Scanner sc = new Scanner(System.in)) {
			EmployeeJDBC emp=new EmployeeJDBC();
			while(true) {
				System.out.println("==================================================");
				System.out.println("Welcome to R.R.K LAL Employee Management System");
				System.out.println("==================================================");
				System.out.println("1. Create Employee");
				System.out.println("2. Select Employee");
				System.out.println("3. Update Employee");
				System.out.println("4. Delete Employee");
				System.out.println("5. Exit");
				System.out.print("Enter your choice");
				int choice=sc.nextInt();
				if(choice==1) {
					System.out.println("Enter Employee's ID:");
					int eid=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Employee's name:");
					String ename=sc.nextLine();
					System.out.println("Enter Employee's Degree:");
					String degree=sc.nextLine();
			
					System.out.println("Enter Employee's Salary:");
					double salary=sc.nextDouble();
					EmployeeDB employee=new EmployeeDB(eid, ename, degree, salary);
					emp.createEmployee(employee);
				}
				else if(choice==2) {
					System.out.println("Enter Employee's ID:");
					int eid=sc.nextInt();
					EmployeeDB employee=emp.readEmployee(eid);
					if(employee!=null) {
						System.out.println("Employee Details: ");
						System.out.println("Employee's ID: "+employee.getEid());
						System.out.println("Employee's name: "+employee.getEname());
						System.out.println("Employee's degree: "+employee.getDegree());
						System.out.println("Employee's salary: "+employee.getSalary());
					}
				}
				else if(choice==3) {
					System.out.println("Enter Employee's ID:");
					int eid=sc.nextInt();
					System.out.println("Enter Employee's name:");
					String ename=sc.next();
					System.out.println("Enter Employee's Degree");
					String degree=sc.next();
					System.out.println("Enter Employee's name:");
					double salary=sc.nextDouble();
					EmployeeDB employee=new EmployeeDB(eid, ename, degree, salary);
					emp.updateEmployee(employee);
				}
				else if(choice==4) {
					System.out.println("Enter Employee's ID");
					int eid=sc.nextInt();
					emp.deleteEmployee(eid);
				}
				else if(choice==5) {
					break;
				}
				
			}
		}
	}
	

}
