package com.kce.service;
import com.kce.bean.*;
import com.kce.Dao.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
 public static void main(String[] args)
 {
	 while(true) {
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 Scanner sc=new Scanner(System.in);
	 System.out.println("                                           -------------------------------------");
	 System.out.println("                                           WELCOME TO STUDENT MANAGEMENT SYSTEM");
	 System.out.println("                                           -------------------------------------");
	 System.out.println("                                                                                                                   by jebershon vetha singth J-[@jebxson]");
	 System.out.println("----------------------------------");
	 System.out.println("Enter the password:");
	 System.out.println("HINT[reverse of 1969]");
	 System.out.println("----------------------------------");
	 int a=sc.nextInt();
	 if(a==9691) {
		 System.out.println("Enter a choice:");
		 System.out.println("--------------------------------------------------------------------------");
		 System.out.println("Enter 1-insert the details--->Enter '1' for student and '2' for course");
		 System.out.println("Enter 2-to remove the details--->Enter 'a' for student and 'b' for course");
		 System.out.println("Enter 3-to display the details--->Enter 'a' for student and 'b' for course");
		 System.out.println("Enter 4-to display the student progress report");
		 System.out.println("Enter 5-to update the details--->Enter 'a' for student and 'b' for course");
		 System.out.println("Enter 6-to count of the details--->Enter 'a' for student and 'b' for course");
		 System.out.println("---------------------------------------------------------------------------");
		 int choice=sc.nextInt();
	 
	 int id;
	 String name;
     int age;
 	 int dob;
 	 String address;
 
 	 
 	 int fees;
     int admin;
     int course_id;
	 int attend;
	 int total_mark;
	 
	 int c_id;
	 String c_name;
     int c_duration;
     String c_staff;
     int mark;
     
	//can use if or switch case	
if(choice==1) {
	System.out.println("Enter the number of input:");
		 int n=sc.nextInt();
StudentExamDetails[] sed=new StudentExamDetails[n];
StudentCourseDetails[] scd=new StudentCourseDetails[n];
	System.out.println("To give personal details:Enter 1");
    System.out.println("To give course details:Enter 2");
	  int ch=sc.nextInt();
	  QueryCRUD q1=new QueryCRUD();
   try {	     
     for(int i=0;i<n;i++)
     {
    	 if(ch==1)
    	 {
    	 System.out.println("Enter Personal Details:id,name,age,dob,address:");
    	 id=sc.nextInt();
    	 name=br.readLine();
    	 age=sc.nextInt();
    	 dob=sc.nextInt();
    	 address=br.readLine();
    	
    	 System.out.println("Enter acedamic details:fees,admission_id,course_id,attendence,total_mark:");
    	 fees=sc.nextInt();
    	 admin=sc.nextInt();
    	 course_id=sc.nextInt();
    	 attend=sc.nextInt();
    	 total_mark=sc.nextInt(); 
    	 try 
    	 {
        	 if(total_mark>100)
        	 {
        		 throw new NotCorrectMarkException("Enter a valid mark of the student");
        	 }
         }
         catch(NotCorrectMarkException e)
         {
        	 System.out.println(e);
        	 total_mark=sc.nextInt(); 
         }
    	 sed[i]=new StudentExamDetails(id,name,age,dob,address,fees,admin,course_id,attend,total_mark); 
    	    System.out.println(sed[i]);
    	    q1.addStudentDetails(sed[i]);
    	 }
    	 else if(ch==2)
    	 {
    	 System.out.println("Enter the course deatils:course_id,course_name,course_duration,course_staff,mark of the suject:");
    	 c_id=sc.nextInt();
    	 c_name=br.readLine();
    	 c_duration=sc.nextInt();
    	 c_staff=br.readLine();
    	 mark=sc.nextInt();
    	 scd[i]=new StudentCourseDetails(c_id,c_name,c_duration,c_staff,mark);
    	 System.out.println(scd[i]);
    	 q1.addCourseDetails(scd[i]);
    	 }
    	 else
    	 {
    		 System.out.println("The choice is wrong!!!!");
    	 }
    }//end of for loop
    		 }
    		 catch(Exception e)
    		 {
    			 System.out.println(e);
    		 }
}//end of choice 1-insert
	else if(choice==2)
	{
		QueryCRUD q1=new QueryCRUD();
		System.out.println("Enter the choice 1-student or 2-course:");
		int ch=sc.nextInt();
		  if(ch==1) {
	      System.out.println("Enter student ID:");
	      int id1=sc.nextInt();
	      q1.removeStudentDetails(id1);
		  }
		  if(ch==2)
		  {
		  System.out.println("Enter course ID:");
		  int id2=sc.nextInt();
		  q1.removeCourseDetails(id2);
		  }
	}//end of choice 2-remove
	else if(choice==3)
	{
		System.out.println("Enter the choice 1-student or 2-course:");
		QueryCRUD q1=new QueryCRUD();
		int ch=sc.nextInt();
		  if(ch==1)
		  {
	         System.out.println("The details of student are:");
	         q1.displayStudentDetails();
		  }
		  if(ch==2)
		  {
			  System.out.println("The details of course are:");
			  q1.displayCourseDetails();
		  }
	}//end of choice 3-display
	else if(choice==4)
	{
		System.out.println("The report progress of the students are:");
		QueryCRUD q1=new QueryCRUD();
		q1.generateReport();
	}//end of choice 4-report
	else if(choice==5)
	{
		QueryCRUD q1=new QueryCRUD();
		System.out.println("Enter the choice 1-student or 2-course:");
		int ch=sc.nextInt();
		  if(ch==1)
		  {
	         System.out.println("n=0->id");
	         System.out.println("n=1->name");
	         System.out.println("n=2->age");
	         System.out.println("n=3->date of birth");
	         System.out.println("n=4->address");
	         System.out.println("n=5->fees");
	         System.out.println("n=6->admission no");
	         System.out.println("n=7->course id");
	         System.out.println("n=8->attendance");
	         System.out.println("n=9->total marks");
	         int n1=sc.nextInt();
	         try {
	         System.out.println("Enter the detail:");
	         String det= br.readLine();
	         System.out.println("Enter the ID:");
	         int id1=sc.nextInt();
	         q1.UpdateStudent(n1, id1, det);
		  } catch (IOException e) {
				e.printStackTrace();
			}
		  }
		  if(ch==2)
		  {
			  System.out.println("n=0->course id");
			  System.out.println("n=1->course name");
			  System.out.println("n=2->course duration");
			  System.out.println("n=3->course staff");
			  System.out.println("n=4->mark");
			  int n2=sc.nextInt();
			  try {
			  System.out.println("Enter the detail:");
			  String det=sc.nextLine();
			  System.out.println("Enter the ID:");
			  int id2=sc.nextInt();
			  q1.UpdateCourse(n2, det, id2);
			  }
			  catch(Exception e)
			  {
				  System.out.println(e);
			  }
		  }
		
	}//end of choice 5-update
	else if(choice==6)
	{
		QueryCRUD q1=new QueryCRUD();
		System.out.println("Enter the choice 1-student or 2-course:");
		int ch=sc.nextInt();
		  if(ch==1)
		  {
	          q1.StudentCount();
		  }
		  if(ch==2)
		  {
			  q1.CourseCount();
		  }
	}//end of choice 6-count
	else
	{
		System.out.println("Enter the valid number under the given choice");
	}
	 }//password
	 }
 }//method
}//class
