package com.kce.service;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import com.kce.bean.Students;
import com.kce.dao.Book_List;
import com.kce.dao.Entry;
import com.kce.dao.Login;
import com.kce.dao.Signup;
import com.kce.dao.bookReturn;
import com.kce.util.DateOfBirthInvalidException;
import com.kce.util.EmailInvalidException;
import com.kce.util.LoginCredentialMismatchException;
import com.kce.util.RollNumberInvalidException;
public class Main extends Exception{
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Prashath's Library Management System");
		System.out.println("MENU");
		System.out.println("1. Login");
		System.out.println("2. Sign-up");
		System.out.println("Enter choice: ");
		String email=null;
		String sroll=null;
		String dob=null;
		String roll=null;
		String passwd=null;
		int choice = sc.nextInt();
		int f=0;
		Main m = new Main();
		switch(choice) {
		case 1:
			sc.nextLine();
			System.out.println("Register number:");
			roll = sc.nextLine();
			System.out.println("Password: ");
			passwd = sc.nextLine();
			Login L = new Login();
			try {
				if(L.validateLogin(roll,passwd)) {
					while(true) {
						System.out.println("Prashath's Library Management System");
						System.out.println("MENU");
						System.out.println("1. Book Return");
						System.out.println("2. Book issue");
						System.out.println("3. Main menu");
						System.out.println("4. Exit");
						System.out.println("Enter choice: ");
						int ch = sc.nextInt();
						if(ch==1) {
							bookReturn r = new bookReturn();
							List<String> l = new ArrayList<>();
							Map<String,String> m1 = new HashMap<>();
							sc.nextLine();
							l=r.colletBook_id(roll);
							if(l.size()!=0) {
								System.out.println("return");							
								r.display(roll);
								System.out.println("Enter the book id:");
								String b_id = sc.nextLine();//
								
								if(l.contains(b_id)) {								
									m1=r.colletreturn_date(roll, b_id);
									LocalDate date1 = LocalDate.now();
									String d[] = m1.get(b_id).split("[/]");
							        LocalDate date2 = LocalDate.of(Integer.parseInt(d[2]), Integer.parseInt(d[1]), Integer.parseInt(d[0]));
							        long days = ChronoUnit.DAYS.between(date1, date2);
							        long amt;
							        if(days>0)
							        	amt=0;
							        amt = days*10;
									System.out.println("Book returned with fine amount of "+amt);
									r.removeBook(roll, b_id);
									r.display(roll);
								}
								else {
									System.out.println("There is no book id found!!");
									continue;
								}
								
							}
							else {
								System.out.println("There is no entry in this roll number\nGo to issue book section....");
								continue;
							}
							
							
						}
						else if(ch==2) {
							Book_List l = new Book_List();
							l.displayBook();
							System.out.println("1. Entry");
							System.out.println("2. Menu");
							System.out.println("3. Exit");
							System.out.println("Enter choice: ");
							ch = sc.nextInt();
							if(ch==1) {
								Entry e = new Entry();
								sc.nextLine();
								System.out.println("Enter the book id:");
								String book_id = sc.nextLine();
								System.out.println("Enter today's date:");
								String issue_date = sc.nextLine();
								System.out.println("Enter return date:");
								String return_date = sc.nextLine();
								e.addBook(roll, book_id, issue_date,return_date);
								System.out.println("Book issued");
							}
							else if(ch==2) {
								continue;
							}
							else
								break;
						}
						else if(ch==3)
							Main.main(args);
						else 
							break;						
					}
				}
				else {
					f=1;
					throw new LoginCredentialMismatchException();
				}
			}
			catch(LoginCredentialMismatchException e) {
				System.out.println(e);
			}
			finally {
				if(f==1)					
					Main.main(args);
			}
			break;
		case 2:			
			sc.nextLine();
			System.out.println("Name:");
			String name = sc.nextLine();
			System.out.println("Department:");
			String dept = sc.nextLine();
			try {
				System.out.println("Email:");
				email = sc.nextLine();
				if(!email.endsWith("@kce.ac.in") && !email.startsWith("7178")) {
					f=1;
					throw new EmailInvalidException();
				}					
			}
			catch(EmailInvalidException e) {
				System.out.println(e);
			}
			finally {
				if(f==1)					
					Main.main(args);
			}	
			try {
				System.out.println("Register number:");
				sroll = sc.nextLine();
				if(sroll.length()!=10 || !sroll.startsWith("7178")) {
					f=1;
					throw new RollNumberInvalidException();
				}
			}
			catch(RollNumberInvalidException e) {
				System.out.println(e);
			}
			finally {
				if(f==1)					
					Main.main(args);
			}
			try {
				System.out.println("Date of birth(dd/mm/yyyy)");
				dob = sc.nextLine();
				String[] dobsp = dob.split("/");
				int dd = Integer.valueOf(dobsp[0]);
				int mm = Integer.valueOf(dobsp[1]);
				int yyyy = Integer.valueOf(dobsp[2]);
				if(!(dd>0 && dd<32) || !(mm>0 && mm<13) || !(yyyy>2000 && yyyy<2030)) {
					f=1;
					throw new DateOfBirthInvalidException();
				}
					
			}
			catch(DateOfBirthInvalidException e) {
				System.out.println(e);
			}
			finally {
				if(f==1)					
					Main.main(args);
			}
			
			Students s = new Students(name, dept, email, sroll, dob);
			s.addStudent(name, dept, email, sroll, dob);
			Signup s1 = new Signup();
			s1.addUser(sroll, dob);
			System.out.println("Account created successfully!!!!!");
			System.out.println("Redirecting to Home page");
			Main.main(args);
			break;
		default:
			System.out.println("Invalid choice!!!\n Returning to menu");
			Main.main(args);
		}
		System.out.println("Thankyou");
	}
}
