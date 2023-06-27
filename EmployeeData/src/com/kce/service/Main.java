package com.kce.service;
import com.kced.bean.*;
import com.kce.Dao.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
public static void main(String []args)
{
	 int employeeId;
		String firstName;
		String LastName;
		String PhoneNumber;
		
		int departmentId;
		String departmentName;
		int managerId;
		String locationId;
		
		
		String startDate;
		String endDate;
		int jobId;
		
	
		String jobtitle;
		int Max_salary;
		int Min_salary;
	 while(true) {
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 Scanner sc=new Scanner(System.in);
		 System.out.println("                            ----------------------------------------------");
		 System.out.println("                            WELCOME TO EMPLOYEE DATABASE MANAGEMENT SYSTEM");
		 System.out.println("                            ----------------------------------------------");
		 System.out.println("                                                                 by S.SIVA");
		 
		 
	 
			 System.out.println("Enter a choice:");
			 System.out.println("--------------------------------------------------------------------------");
			 System.out.println("Enter 1-insert the details");
			 System.out.println("Enter 2-to remove the details");
			 System.out.println("Enter 3-to display the details");
			 System.out.println("Enter 4-to display the employee count");
			 System.out.println("Enter 5-to display the departments count");
			 System.out.println("Enter 6-to display the Job_history count");
			 System.out.println("Enter 7-to display the Jobs count");
//			
			 System.out.println("---------------------------------------------------------------------------");
			 System.out.println("Enter the no.of choices");
			 int choice=sc.nextInt();
			 
			
			if(choice==1) {
				System.out.println("Enter the number of times it will work:");
					 int n=sc.nextInt();
			Employees[] e=new Employees[n];
			Departments[] s=new Departments[n];
			Job_history[] p=new Job_history[n];
			Jobs[]q=new Jobs[n];
				System.out.println("To give Employee details:Enter 1");
			    
				  int ch=sc.nextInt();
				  Querydml q1=new Querydml();
				  try
				  {
					  for(int i=0;i<n;i++)
					  {
						  if(ch==1)
						  {
							  System.out.println("Enter Employee Details:employeeId,FirstName,LastName,PhoneNumber:");
						    	 employeeId=sc.nextInt();
						    	firstName=br.readLine();
						    	 LastName=br.readLine();
						    	 PhoneNumber=br.readLine();
//						    	 try 
//						    	 {
//						        	 if(employeeId>=100)
//						        	 {
//						        		 throw new CheckingException("Display the name of the employee");
//						        	 }
//						         }
//						         catch(CheckingException y)
//						         {
//						        	 System.out.println(y);
//						        	 employeeId=sc.nextInt(); 
//						         }
						    	 e[i]= new Employees(employeeId,firstName,LastName,PhoneNumber);
						    	 System.out.println(e[i]);
						    	 q1.addEmployeeDetails(e[i]);
						  }
						  else if(ch==2)
						  {
							  System.out.println("Enter Department Details:departmentId,departmentName,managerId,locationId:");
						    	 departmentId=sc.nextInt();
						    	 departmentName=br.readLine();
						    	 managerId=sc.nextInt();
						    	 locationId=br.readLine();
//						    	 try 
//						    	 {
//						        	 if(departmentId>=100)
//						        	 {
//						        		 throw new CheckingException("Display the name of the  deparetment");
//						        	 }
//						         }
//						         catch(CheckingException y)
//						         {
//						        	 System.out.println(y);
//						        	 employeeId=sc.nextInt(); 
//						         }
						    	 s[i]= new Departments(departmentId,departmentName, managerId,locationId);
						    	 System.out.println(s[i]);
						    	 q1.addDepartmentsDetails(s[i]);
						  }
						  else if(ch==3)
						  {
							  System.out.println("Enter JobHistory Details:employeeId,startDate,endDate,jobId:");
						    	 employeeId=sc.nextInt();
						    	 startDate=br.readLine();
						    	 jobId=sc.nextInt();
						    	 endDate=br.readLine();
//						    	 try 
//						    	 {
//						        	 if(employeeId>=100)
//						        	 {
//						        		 throw new CheckingException("Display the name of the  deparetment");
//						        	 }
//						         }
//						         catch(CheckingException y)
//						         {
//						        	 System.out.println(y);
//						        	 employeeId=sc.nextInt(); 
//						         }
						    	 p[i]= new Job_history(employeeId,startDate, endDate,jobId);
						    	 System.out.println(p[i]);
						    	 q1.addJobHistoryDetails(p[i]);;
						  }
						  else if(ch==4)
						  {
							  System.out.println("Enter Jobs Details:jobId,jobtitle,Max_salary,Min_salary:");
						    	 jobId=sc.nextInt();
						    	 jobtitle=br.readLine();
						    	 Max_salary=sc.nextInt();
						    	 Min_salary=sc.nextInt();
//						    	 try 
//						    	 {
//						        	 if(jobId>=100)
//						        	 {
//						        		 throw new CheckingException("Display the name of the  deparetment");
//						        	 }
//						         }
//						         catch(CheckingException y)
//						         {
//						        	 System.out.println(y);
//						        	 employeeId=sc.nextInt(); 
//						         }
						    	 q[i]= new Jobs(jobId,jobtitle,Max_salary,Min_salary);
						    	 System.out.println(q[i]);
						    	 q1.addjobsDetails(q[i]); 
						  }
						  else
						  {
							  System.out.println("Wrong choice!!!");
						  }
						  }
					  }
				  catch(Exception z)
				  {
					  System.out.println(e);
				  }
				  }
			else if(choice==2)
			{
				Querydml q1=new Querydml();
				System.out.println("Enter the choice 1 for employee or 2 for departments or 3 for Job_history or 4 for Jobs");
				int ch=sc.nextInt();
				if(ch==1)
				{
					System.out.println("Enter employee Id");
					int id1=sc.nextInt();
					q1.removeEmployeeeDetails(id1);
				}
				if(ch==2)
				{
					 System.out.println("Enter department ID:");
					  int id2=sc.nextInt();
					  q1.removeDepartmentDetails(id2);
				}
				if(ch==3)
				{
					 System.out.println("Enter job ID:");
					  int id3=sc.nextInt();
					  q1.removeJobHistoryDetails(id3);
				}
				if(ch==4)
				{
					 System.out.println("Enter job_title:");
					  String id4=sc.next();
					  q1.removeJobsDetails(id4);
				}
				
			}
			else if(choice==3)
			{
				System.out.println("Enter the choice 1 for employee or 2 for departments or 3 for Job_history or 4 for Jobs");
				Querydml q1=new Querydml();
				int ch=sc.nextInt();
				if(ch==1)
				{
					System.out.println("The details of Employee are:");
					q1.displayEmployeeDetails();
				}
				if(ch==2)
				{
					System.out.println("The details of departments are:");
					q1.displaydepartmentDetails();
				}
				if(ch==3)
				{
					System.out.println("The details of Job history are:");
					q1.displayJobhistoryDetails();;
				}
				if(ch==4)
				{
					System.out.println("The details of jobs are:");
					q1.displayJobDetails();;
				}
			}
			else if(choice==4)
			{
				System.out.println("The report progress  of the students are :");
				Querydml q1=new Querydml();
				
				q1.generateReport();
			}
			
			
		 
}
}
}
