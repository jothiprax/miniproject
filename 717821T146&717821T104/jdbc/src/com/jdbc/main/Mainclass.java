package com.jdbc.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.project.employee;
import com.jdbc.service.Databaseservice;
//main class
public class Mainclass {
	 static Databaseservice databaseservice= new Databaseservice();
	public static void main(String[] args) throws SQLException {
		try(Scanner sc = new Scanner(System.in);)
		{
			boolean b=true;
			while(b)
			{
				System.out.println("Enter The Choice :");
				System.out.println("1.INSERT");
				System.out.println("2.SELECT ALL");
				System.out.println("3.SELECT EMPLOYEE BY AN EMP_ID");	
				System.out.println("4.DELETE EMPLOYEE");
				System.out.println("5.UPDATE EMPLLOYEE");
				System.out.println("6.EXIT");
				int choice=	Integer.parseInt(sc.nextLine());
				switch(choice)
				{
				case 1:
					System.out.println("Enter name,place,salary");
					
					databaseservice.insertEmployee(new employee( sc.nextLine(),sc.nextLine(),Double.parseDouble(sc.nextLine())));
					break;
				case 2:
					databaseservice.getAllEmployee();
					break;
				case 3:
					System.out.println("Enter the ID :");
					databaseservice.getEmployeeById(Integer.parseInt(sc.nextLine()));
					break;
				case 4:
					System.out.println("enter the id :");
					databaseservice.deleteEmployeeById(Integer.parseInt(sc.nextLine()));
					break;
				case 5:
					System.out.println("enter the id of an employee : ");
					int updateid = Integer.parseInt(sc.nextLine());
					boolean i = databaseservice.getEmployeeById(updateid);
					if(i) {
					System.out.println("enter name ,address,salary");
					employee employee=new employee(updateid,sc.nextLine(),sc.nextLine(),Double.parseDouble(sc.nextLine()));
						databaseservice.updateEmployee(employee);
					}
					break;
				case 6:
					b=false;
					System.out.println("Thank You..! Visit Again..!");
					break;
				default:
					System.out.println("Incorrect");
					break;
					



			}

			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
}
