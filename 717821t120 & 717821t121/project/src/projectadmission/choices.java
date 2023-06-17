package projectadmission;

import java.util.Scanner;

public class choices extends input{
	Scanner sc = new Scanner(System.in);
	public void choice()
	{
		try  {
			System.out.println("Enter the choice :");
			System.out.println("1 - teachers");
			System.out.println("2 - students");
			choice =sc.nextInt();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	}
