package projectadmission;

import java.util.Scanner;

public class student extends choices
{
	public void information2(int choice)
	{

		if(choice==2)
	
	try
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the details fo the Student : ");
		System.out.println("enter the student name :");
		student_name=sc.nextLine();
		System.out.println("enter the student age :");
		student_age=sc.nextInt();
		System.out.println("enter the student mobile number :");
		mobile_number=sc.nextInt();
		System.out.println("enter the place :");
		place=sc.next();
		System.out.println("enter the marks imn 12th standard :");
		mark=sc.nextInt();
		System.out.println("enter the course of joinning :");
		course_joinning=sc.next();
		System.out.println("");
		System.out.println("the detasils has been added to the Mysql Table... ");
		sc.close();
	}
catch(Exception e)
{
	System.out.println(e);
}

}

}
