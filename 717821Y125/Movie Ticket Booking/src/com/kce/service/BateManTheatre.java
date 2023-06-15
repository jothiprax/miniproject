package com.kce.service;
import com.kce.bean.*;
import com.kce.util.*;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.regex.*;
public class BateManTheatre {
	
	public static void main(String[] args) throws ClassNotFoundException{
		
    	int loop=1;
    	while(loop==1) {
    		Sqldata d=new Sqldata();
    	Connection con=d.getconnection();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("\n\t\t\t\t\t\tWelcome You to BateMan Cinemas");
		System.out.println("\n\t\t\t AVAILABLE OPTIONS:\n\t\t\t-------------------\n\t\t1-BateMan Admin\n\t\t2-Audience\n\t\t3-Exit from Cinemas\n\t\tEnter your Option:");
		Movieadmin admin=new Movieadmin();
		Audience audience;
	     
		int category=sc.nextInt();
		if(category==1) {
			
			
			System.out.print("\t\t\t\t\t\tHello!! BateMan Cinemas Admin\n\t\t\tPlease enter the password to continue...\n\t\t\tPASSWORD:");
			
			String pw=sc.next();
			if(pw.equals("bateman7")) {
				int ad=1;
				while(ad==1) {
				System.out.println("\n\t\t\t AVAILABLE OPTIONS:\n\t\t\t-------------------\n\t\t1-Add Movies\n\t\t2-Remove Movies\n\t\t3-Bookings & Income\n\t\t4-FoodCounter\n\t\t5-Exit\n\t\tEnter the Choice:");
				int choice=sc.nextInt();
				switch(choice) {
				case 1:
					
					admin.addmovie(con);
					break;
				case 2:
					
					admin.removemovie(con);
					break;
				case 3:
					
					admin.bookingsincome(con);
					break;
				case 4:
					
					admin.foodcounter(con);
					break;
				case 5:
					
					break;
				default:
					System.out.println("\t\t\tInvalid choice!!\n\t\t\tPlease Try again correctly.");
					break;
			}
				 System.out.println("\n\t\t\t\t\t\tDo you want to continue from Admin entry(enter 1(yes) or other than 1(no):");
				    ad=sc.nextInt();
			}
			}
				
			else {
				System.out.println("Password Incorrect");
			}
		
	}
		else if(category==2) {
			try {
			int au=1;
			while(au==1) {
			System.out.println("\t\t\t\t\t\tBateMan Cinemas Welcomes You!!");
			System.out.println("\t\t\t AVAILABLE OPTIONS:\n\t\t\t--------------------\n\t\t1-Book Tickets\n\t\t2-Cancel Tickets\n\t\t3-View Your Ticket\n\t\t4-Order Snacks\n\t\t5-View Ordered Foods\n\t\t6-Location of our Theatre\n\t\t7-Exit\n\t\tEnter Your Choice:");
			int option=sc.nextInt();
			switch(option) {
			case 1:
				
	            System.out.println("\t\t\t\t BOOKING SESSION\n\t\t\t\t------------------");
	            System.out.println("\t\t\tEnter Your Name:");
	            String cname=sc.next();
	            String name=cname.substring(0,1).toUpperCase()+cname.substring(1);
	            System.out.println("\t\t\tEnter Your Email address:");
	            String emailp="^[A-Za-z0-9+_.-]+@(.+)$";
	            Pattern pattern=Pattern.compile(emailp);
	            String email=sc.next();
	            Matcher match=pattern.matcher(email);
	            if(!match.matches()) {
	            	System.out.println("\t\t\t\tInvalid Email address!!");
	            	
	            }
	            else {
	            System.out.println("\t\t\tEnter Your Phone number:+91-");
	            String number=sc.next();
	            String numberp="^[6-9][0-9]{9}$";
	            Pattern npattern=Pattern.compile(numberp);
	            Matcher nmatch=npattern.matcher(number);
	            if(!nmatch.matches()) {
	            	System.out.println("\t\t\t\tInvalid Phone number!!\nEnter Valid Phone number:");
	            	
	            }
	            else {
	       
	            audience=new Audience(name,email,number);
	            
	            audience.booktickets(con);
	            }
	            }
				break;
			case 2:
				
				audience=new Audience();
				
				audience.canceltickets(con);
				break;
			case 3:
				audience=new Audience();
				
				audience.viewtickets(con);
				break;
			case 4:
				audience=new Audience();
				audience.orderfoods(con);
				break;
			case 5:
				audience=new Audience();
				audience.viewfoodorder(con);
				break;
			case 6:
				System.out.println("\n\t\t\t\tBateMan Cinemas\nLocated at\t:4th Floor,\n\t\tBrookefields Mall,\n\t\tKrishnaswamy Road,\n\t\tCoimbatore,\n\t\tTamil Nadu 641001,\n\t\tIndia.");
				break;
			case 7:

				break;
			default:
				System.out.println("\n\t\t\t\tInvalid choice!!\n Please Try again correctly..");
				break;
			}
			System.out.println("\n\t\t\t\t\t\tDo you want to continue from Audience entry(enter 1(yes) or Other than one(no):");
			au=sc.nextInt();
			
			}
			
		}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(category==3) {
			System.out.println("\n\t\t---------------------Thank You For Visiting---------------------");
			return;
		}
		else {
			System.out.println("\n\t\t\t\tInvalid Category!!");
		    System.out.println("\n\t\t\t\t\t\tDo you want to continue from Category entry(enter 1(yes) or 2(no):");
		    loop=sc.nextInt();
		    if(loop==2) {
		    	System.out.println("\n---------------------Thank You For Visiting---------------------");
		    }
		    else if(loop!=1) {
		    	System.out.println("\nError Comeback Again!!");
		    }
		}
    	
		
    	}

	}
	
}