package projectadmission;

import java.util.Scanner;

public class teacher extends choices {
	public void information1(int choice)
	{
		if(choice==1)
		{
		
		try {
			
				Scanner sc = new Scanner(System.in);
				System.out.println("enter the details fo the Teacher : ");
				System.out.println("enter the teacher name :");
				teacher_name=sc.next();
				System.out.println("enter the age of teacher :");
				teacher_age=sc.nextInt();
				System.out.println("enter the year of experiance");
				year_of_experiance=sc.nextInt();
				System.out.println("enter the course of intrest");
				course_intrest=sc.next();
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
}
