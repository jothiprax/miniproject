package com.kce.student.service;
import com.kce.student.dao.*;
import com.kce.student.bean.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
  public static void main(String[] args) {
	  try {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int n=0;
	while(n!=5) {
		System.out.println("Student database details:");
		System.out.println("Enter your choice:");
		System.out.println("1.To view existed details");
		System.out.println("2.To search student detail");
		System.out.println("3.To insert student detail");
		System.out.println("4.To delete student detail");
		System.out.println("5.To see student eligibility for exam");
		System.out.println("6.To update student details");
		System.out.println("7.To Quit");
		System.out.print("Choice = ");
		n=Integer.parseInt(br.readLine());
		if(n==1) {
			StudentDAOview s=new StudentDAOview();
			s.display();
			System.out.println();
		}
		else if(n==2) {
			System.out.println("Enter RollNo:");
			String str=br.readLine();
			StudentDAOSearch s=new StudentDAOSearch();
			s.display(str);
			System.out.println();
		}
		else if(n==3) {
			try {
			System.out.println("Enter Name:");
			String str=br.readLine();
			System.out.println("Enter RollNo:");
			String rollno=br.readLine();	
			System.out.println("Enter Date Of Birth:");
			String dob=br.readLine();
			System.out.println("Enter Contact Number:");
			String no=br.readLine();
			System.out.println("Enter Year:");
			int year=Integer.parseInt(br.readLine());
			System.out.println("Enter Department:");
			String dept=br.readLine();
			System.out.println("Enter Attendance:");
			int attend=Integer.parseInt(br.readLine());
			System.out.println("Enter Grade:");
			char grade=(char) br.read();
			StudentDetails st=new StudentDetails(str,rollno,dob,no,year,dept,attend,grade);
			StudentDAOinsert s=new StudentDAOinsert();
			s.insert(st);
			System.out.println();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(n==4) {
			System.out.println("Enter RollNo to delete:");
			String rollno=br.readLine();
			StudentDAOdelete s=new StudentDAOdelete();
			s.delete(rollno);
			System.out.println();
		}
		else if(n==5) {
			System.out.print("Enter the rollNo:");
			String rollNo=br.readLine();
			StudentDAOeligiblity s=new StudentDAOeligiblity();
			s.eligible(rollNo);
			System.out.println();
		}
		else if(n==6) {
			StudentDAOupdate s=new StudentDAOupdate();
			System.out.print("Enter RollNo:");
			String rollNo=br.readLine();
			System.out.print("Enter Year:");
			int year=Integer.parseInt(br.readLine());
			System.out.print("Enter Attendance:");
			int attend=Integer.parseInt(br.readLine());
			System.out.print("Enter Grade:");
			char g=(char) br.read();
			s.update(rollNo, year, attend,g);
			System.out.println();
		}
		else if(n==7){
			System.out.println("Completed.");
			break;
		}
		else {
			System.out.println("Please enter a valid choice:\n");
		}
	}
	  }
	  catch(Exception e) {
		  System.out.println(e);
	  }
	
}
}
