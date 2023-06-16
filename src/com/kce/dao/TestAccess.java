package com.kce.dao;
import com.kce.bean.BookDetails;
import com.kce.util.DButil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.io.*;
import com.kce.service.*;
class InvalidStudentIdException extends Exception{
	public InvalidStudentIdException(String str) {
		super(str);
	}
}
class InvalidAdminIdException extends Exception{
	public InvalidAdminIdException(String str) {
		super(str);
	}
}
public class TestAccess {
       
	public static void main(String[] args)throws ClassNotFoundException,SQLException {
		try {
		   System.out.println("Student => Enter 1");
		   System.out.println("Admin => Enter 2");
		   BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
			int number=Integer.parseInt(sc.readLine());
			if(number==1) {
				//BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("StudentId: ");
				String studentId=sc.readLine();
				if(studentId.matches("\\d{2}[a-zA-Z]{1}\\d{3}")) {
				StudentAccess studentaccess=new StudentAccess();
				studentaccess.Student();
				String option="Purchase";
				System.out.println("enter option as Purchase if you want to purchase");
				String str=sc.readLine();
				if(str.equals(option)) {
				studentaccess.StudentPurchase();
				studentaccess.UpdateQuantity();
				}
			}
				else {
					throw new InvalidStudentIdException("StudentId is not valid");
				}
			}
			else if(number==2) {
				System.out.println("AdminId: ");
				String AdminId=sc.readLine();
				if(AdminId.matches("[a-zA-Z]{1}\\d{4}")) {
				System.out.println("Password: ");
				String Password=sc.readLine();
				String AdminPassword="#123";
				if(Password.equals(AdminPassword)) {
				Refer refer=new Refer();
				CalculateDueDate calculatedue=new CalculateDueDate();
				System.out.println("Enter option");
				System.out.println("Option 1 => InsertBooks"+"\n"+"Option 2 => DeleteBooks");
				System.out.println("Option 3 => UpdateBooks"+"\n"+"Option 4 => ReturnBooksAndCaluculateDueDate");
				int option=Integer.parseInt(sc.readLine());
				if(option== 1) {
					refer.addBookDetails();
				}
				else if(option==2){
					refer.DeleteBookDetails();
				}
				else if(option==3) {
					refer.UpdateBookDetails();
				}
				else if(option==4) {
				//	refer.ReturnBook();
					refer.UpdateQuantity();
					calculatedue.DueDate();
				}
				else {
					System.out.println("Enter correct option");
				}
				
				}
				else {
					System.out.println("Invalid Password");
				}
			}
			else {
				throw new InvalidAdminIdException("Invalid AdminId");
			}
		}
		}catch(InvalidStudentIdException e) {
			System.out.println(e);
		}
		catch(InvalidAdminIdException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
