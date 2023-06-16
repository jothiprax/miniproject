package com.kce.Main;
import com.kce.accounts.accounts;
import com.kce.accountsdao.accountsdao;
import com.kce.bookings.bookings;
import com.kce.bookingsdao.bookingsdao;
import com.kce.connection.connection;
import com.kce.checkaccounts.checkaccounts;
import com.kce.display_bookings.display_bookings;
import com.kce.delete_bookings.delete_bookings;
import com.kce.checkpasswords.*;
import com.kce.update.update;
import java.text.SimpleDateFormat;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception
	{
		connection.createConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.print("\n\tWELCOME TO HR CINEMAS\n");
		while(true)
		{
            System.out.println("\t------------------------------------------");
            System.out.println("\t--WELCOME TO MOVIE TICKET BOOKING SYSTEM--");
            System.out.println("\t------------------------------------------");
            System.out.println("\t1. Customer Panal");
            System.out.println("\t0. Exit");
            System.out.println("\t------------------------------------------");
            System.out.print("\tEnter your Choice...:");
			int ch=sc.nextInt();
			if(ch==1)
			{
				checkaccounts c=new checkaccounts();
				boolean res=c.checkaccount();
				if(res)
				{
					System.out.println("\t****ACCOUNT EXISTS!!****");
					checkpasswords c1=new checkpasswords();
					boolean result=c1.checkpassword();
					if(result)
					{
						while(true)
						{
							System.out.print("");
		                    System.out.println("\t------------------------------------------");
		                    System.out.println("\t--WELCOME TO MOVIE TICKET BOOKING SYSTEM--");
		                    System.out.println("\t------------------------------------------");
		                    System.out.println("\t....MENU....");
		                    System.out.println("\t1. Book Ticket");
		                    System.out.println("\t2. Show my Ticket");
		                    System.out.println("\t3. Update Ticket");
		                    System.out.println("\t4. Cancel Ticket");
		                    System.out.println("\t0. Exit");
		                    System.out.println("\t------------------------------------------");
		                    System.out.print("\tEnter your Choice...: ");
		                    int ch1=sc.nextInt();
		                    if(ch1==1)
		                    {
		                    	int totalnoofseats=250;
		                    	System.out.print("\tEnter the UserName: ");
		            			String username=sc.next();
		            			System.out.print("\tEnter the Name: ");
		    					String name=sc.next();
		    					System.out.print("\tEnter the Number of Persons: ");
								int no_of_persons=sc.nextInt();
								int remainingseats=totalnoofseats-no_of_persons;
								if(remainingseats>0)
								{
									System.out.print("\tEnter the Date(DD/MM/YYYY): ");
									String d1=sc.next();
									Date d2=new SimpleDateFormat("dd/MM/yyyy").parse(d1);  
									SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
									String date1=formatter.format(d2);
									System.out.println("\tEnter 1 for 10:00am - 1:00 pm"); 
									System.out.println("\tEnter 2 for 1:30pm - 4:30 pm");
									System.out.println("\tEnter 3 for 4:30pm - 7:30 pm");
									System.out.println("\tEnter 4 for 7:30pm - 10:30 pm");
									System.out.print("\tEnter the choice: ");
									int ch2=sc.nextInt();
									String time="";
									if(ch2==1)
									{
										time="10:00am";
									}
									else if(ch2==2)
									{
										time="1:30pm";
									}
									else if(ch2==3)
									{
										time="4:30pm";
									}
									else if(ch2==4)
									{
										time="7:30pm";
									}
									else
									{
										System.out.println("\t--------------------------------------");
						                System.out.println("\tSorry...!!!");
						                System.out.println("\tThere is no show going on.....!!!!!!");
						                System.out.println("\t--------------------------------------");
									}
									String moviename="";
									System.out.println("\t*****List of Movies*****");
									System.out.println("\t1.TRANSFORMERS-RISE OF THE BEAST");
									System.out.println("\t2.SPIDERMAN-ACROSS THE SPIDER VERSE");
									System.out.println("\t3.EVIL DEAD RISE");
									System.out.println("\t4.FAST X");
									System.out.print("\tEnter the choice: ");
									int ch3=sc.nextInt();
									if(ch3==1) {
										moviename="TRANSFORMERS-RISE OF THE BEAST";
									}
									else if(ch3==2) {
										moviename="SPIDERMAN-ACROSS THE SPIDER VERSE";
									}
									else if(ch3==3) {
										moviename="EVIL DEAD RISE";
									}
									else if(ch3==4)
									{
										moviename="FAST X";
									}
									else
									{
										System.out.println("\t--------------------------------------");
						                System.out.println("\tSorry...!!!");
						                System.out.println("\tThere is no show going on.....!!!!!!");
						                System.out.println("\t--------------------------------------");
									}
									bookings b=new bookings(username,name,no_of_persons,date1,time,moviename);
									bookingsdao bdao=new bookingsdao();
									boolean res1=bdao.book(b);
									if(res1)
									{
										System.out.println("\t-------------------------------");
										System.out.println("\t*******TICKET BOOKED*******\t");
										System.out.println("\t-------------------------------");
									}
									else
									{
										System.out.println("\t------------------------------------------------");
										System.out.println("\tSomething went wrong!!Please try again Later\t");
										System.out.println("\t------------------------------------------------");
									}
								}
								else
								{
									System.out.println("\t----------------------------");
									System.out.println("\tINSUFFICIENT SEATS...!!!\t");
									System.out.println("\tBooking is cancelled...!!!");
									System.out.println("\t----------------------------");
								}
		                    }
		                    else if(ch1==2)
		                    {
		                    	display_bookings d=new display_bookings();
		                    	d.display_book();
		                    }
		                    else if(ch1==3)
		                    {
		                    	System.out.println("-\t---------------------------------------");
		                    	System.out.println("\t--What do you want to Update?--\t");
		                    	System.out.println("\t----------------------------------------");
		                    	System.out.println("\tPress 1 to Update the No of Persons\t");
		                    	System.out.println("\tPress 2 to Update the Movie Name\t");
		                    	System.out.println("\tPress 3 to Update the Date\t");
		                    	System.out.println("\tPress 4 to Update the Time\t");
		                    	System.out.println("\t----------------------------------------");
		                        System.out.print("\tEnter your Choice...: ");
		                        int ch4=sc.nextInt();
		                        if(ch4==1)
		                        {
		                        	System.out.print("\tPlease enter the no of persons to be updated: ");
		                        	int no_of_persons1=sc.nextInt();
		                        	update u=new update();
		                        	u.updatenoofpersons(no_of_persons1);
		                        }
		                        else if(ch4==2)
		                        {
		                        	System.out.print("\tPlease enter the Movie name to be updated: ");
		                        	System.out.println("\t*****List of Movies*****");
									System.out.println("\t1.TRANSFORMERS-RISE OF THE BEAST");
									System.out.println("\t2.SPIDERMAN-ACROSS THE SPIDER VERSE");
									System.out.println("\t3.EVIL DEAD RISE");
									System.out.println("\t4.FAST X");
									System.out.print("\tEnter the choice: ");
									int ch5=sc.nextInt();
									String moviename1="";
									if(ch5==1) {
										moviename1="TRANSFORMERS-RISE OF THE BEAST";
									}
									else if(ch5==2) {
										moviename1="SPIDERMAN-ACROSS THE SPIDER VERSE";
									}
									else if(ch5==3) {
										moviename1="EVIL DEAD RISE";
									}
									else if(ch5==4)
									{
										moviename1="FAST X";
									}
									else
									{
										System.out.println("\t--------------------------------------");
						                System.out.println("\tSorry...!!!");
						                System.out.println("\tThere is no show going on.....!!!!!!");
						                System.out.println("\t--------------------------------------");
									}
									update u=new update();
									u.updatemoviename(moviename1);
		                        }
		                        else if(ch4==3)
		                        {
		                        	System.out.print("\tPlease enter the Date to be updated: ");
		                        	String d3=sc.next();
									Date d4=new SimpleDateFormat("dd/MM/yyyy").parse(d3);
									SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
									String date3=formatter.format(d4);
		                        	update u=new update();
									u.updatedate(date3);
		                        }
		                        else if(ch4==4)
		                        {
		                        	System.out.print("\tPlease enter the Time to be updated: ");
		                        	System.out.println("\tEnter 1 for 10:00am - 1:00 pm"); 
									System.out.println("\tEnter 2 for 1:30pm - 4:30 pm");
									System.out.println("\tEnter 3 for 4:30pm - 7:30 pm");
									System.out.println("\tEnter 4 for 7:30pm - 10:30 pm");
									System.out.print("\tEnter the choice: ");
									int ch2=sc.nextInt();
									String time1="";
									if(ch2==1)
									{
										time1="10:00am";
									}
									else if(ch2==2)
									{
										time1="1:30pm";
									}
									else if(ch2==3)
									{
										time1="4:30pm";
									}
									else if(ch2==4)
									{
										time1="7:30pm";
									}
									else
									{
										System.out.println("\t--------------------------------------");
						                System.out.println("\tSorry...!!!");
						                System.out.println("\tThere is no show going on.....!!!!!!");
						                System.out.println("\t--------------------------------------");
									}
									update u=new update();
									u.updatetime(time1);
		                        }
		                        else
								{
		                        	System.out.println("\t--------------------------------------");
					                System.out.println("\tSorry...!!!");
					                System.out.println("\tThere is no choice.....!!!!!!");
					                System.out.println("\t--------------------------------------");
								}
		                    }
		                    else if(ch1==4)
		                    {
		                    	delete_bookings db=new delete_bookings();
		                    	boolean res2=db.delete_book();
		                    	if(res2)
		                    	{
		                    		System.out.println("\t----------------------------");
									System.out.println("\tTicket is cancelled...!!!");
									System.out.println("\t----------------------------");
		                    	}
		                    	else
		                    	{
		                    		System.out.println("\t------------------------------------------------");
									System.out.println("\tSomething went wrong!!Please try again Later\t");
									System.out.println("\t------------------------------------------------");
		                    	}
		                    }
		                    else if(ch1==0)
		                    {
		                    	System.out.println("\t------------------------------------");
		                    	System.out.println("\tTHANK YOU!!!HAVE A GREAT TIME!!!\t");
		                    	System.out.println("\t------------------------------------");
		                    	break;
		                    }
		                    else
		                    {
		                    	System.out.println("\t--------------------------------------");
				                System.out.println("\tSorry...!!!");
				                System.out.println("\tThere is no choice.....!!!!!!");
				                System.out.println("\t--------------------------------------");
		                    }
						}
					}
					else
					{
						System.out.println("\t--------------------");
						System.out.println("\tINVALID PASSWORD");
						System.out.println("\t--------------------");
					}
				}
				else
				{
					System.out.println("\t****ACCOUNT DOES NOT EXISTS!!****");
					System.out.println("\t****CREATE ACCOUNT****");
					System.out.print("\tEnter the User Name: ");
					String username=sc.next();
					System.out.print("\tEnter the Password: ");
					String password=sc.next();
					System.out.print("\tEnter the Name: ");
					String name=sc.next();
					System.out.print("\tEnter the Phone Number: ");
					Long phno=sc.nextLong();
					System.out.print("\tEnter the Age: ");
					int age=sc.nextInt();
					System.out.print("\tEnter the Gender: ");
					String gender=sc.next();
					System.out.print("\tEnter the Place: ");
					String place=sc.next();
					accounts a=new accounts(username,password,name,phno,age,gender,place);
					accountsdao adao=new accountsdao();
					boolean res1=adao.createaccount(a);
					if(res1)
					{
						System.out.println("\t-------------------------");
						System.out.println("\t***ACCOUNT CREATED***\t");
						System.out.println("\t-------------------------");
					}
					while(true)
					{
						System.out.print("");
	                    System.out.println("\t------------------------------------------");
	                    System.out.println("\t--WELCOME TO MOVIE TICKET BOOKING SYSTEM--");
	                    System.out.println("\t------------------------------------------");
	                    System.out.println("\t....MENU....");
	                    System.out.println("\t1. Book Ticket");
	                    System.out.println("\t2. Show my Ticket");
	                    System.out.println("\t3. Update Ticket");
	                    System.out.println("\t4. Cancel Ticket");
	                    System.out.println("\t0. Exit");
	                    System.out.println("\t------------------------------------------");
	                    System.out.print("\tEnter your Choice...: ");
	                    int ch1=sc.nextInt();
	                    if(ch1==1)
	                    {
	                    	int totalnoofseats=250;
	                    	System.out.print("\tEnter the UserName: ");
	            			String username2=sc.next();
	            			System.out.print("\tEnter the Name: ");
	    					String name2=sc.next();
	    					System.out.print("\tEnter the Number of Persons: ");
							int no_of_persons=sc.nextInt();
							int remainingseats=totalnoofseats-no_of_persons;
							if(remainingseats>0)
							{
								System.out.print("\tEnter the Date(DD/MM/YYYY): ");
								String d5=sc.next();
								Date d6=new SimpleDateFormat("dd/MM/yyyy").parse(d5);
								SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
								String date5=formatter.format(d6);
								String time="";
								System.out.println("\tEnter 1 for 10:00am - 1:00 pm"); 
								System.out.println("\tEnter 2 for 1:30pm - 4:30 pm");
								System.out.println("\tEnter 3 for 4:30pm - 7:30 pm");
								System.out.println("\tEnter 4 for 7:30pm - 10:30 pm");
								System.out.print("\tEnter the choice: ");
								int ch2=sc.nextInt();
								if(ch2==1)
								{
									time="10:00am";
								}
								else if(ch2==2)
								{
									time="1:30pm";
								}
								else if(ch2==3)
								{
									time="4:30pm";
								}
								else if(ch2==4)
								{
									time="7:30pm";
								}
								else
								{
									System.out.println("\t--------------------------------------");
					                System.out.println("\tSorry...!!!");
					                System.out.println("\tThere is no show going on.....!!!!!!");
					                System.out.println("\t--------------------------------------");
								}
								String moviename="";
								System.out.println("\t*****List of Movies*****");
								System.out.println("\t1.TRANSFORMERS-RISE OF THE BEAST");
								System.out.println("\t2.SPIDERMAN-ACROSS THE SPIDER VERSE");
								System.out.println("\t3.EVIL DEAD RISE");
								System.out.println("\t4.FAST X");
								System.out.print("\tEnter the choice: ");
								int ch3=sc.nextInt();
								if(ch3==1) {
									moviename="TRANSFORMERS-RISE OF THE BEAST";
								}
								else if(ch3==2) {
									moviename="SPIDERMAN-ACROSS THE SPIDER VERSE";
								}
								else if(ch3==3) {
									moviename="EVIL DEAD RISE";
								}
								else if(ch3==4)
								{
									moviename="FAST X";
								}
								else
								{
									System.out.println("\t--------------------------------------");
					                System.out.println("\tSorry...!!!");
					                System.out.println("\tThere is no show going on.....!!!!!!");
					                System.out.println("\t--------------------------------------");
								}
								bookings b=new bookings(username2,name2,no_of_persons,date5,time,moviename);
								bookingsdao bdao=new bookingsdao();
								boolean res3=bdao.book(b);
								if(res3)
								{
									System.out.println("\t-------------------------------");
									System.out.println("\t*******TICKET BOOKED*******\t");
									System.out.println("\t-------------------------------");
								}
								else
								{
									System.out.println("\t------------------------------------------------");
									System.out.println("\tSomething went wrong!!Please try again Later\t");
									System.out.println("\t------------------------------------------------");
								}
							}
							else
							{
								System.out.println("\t----------------------------");
								System.out.println("\tINSUFFICIENT SEATS...!!!\t");
								System.out.println("\tBooking is cancelled...!!!");
								System.out.println("\t----------------------------");
							}
	                    }
	                    else if(ch1==2)
	                    {
	                    	display_bookings d=new display_bookings();
	                    	d.display_book();
	                    }
	                    else if(ch1==3)
	                    {
	                    	System.out.println();
	                    	System.out.println("\t----------------------------------------");
	                    	System.out.println("\t--What do you want to Update?--\t");
	                    	System.out.println("\t----------------------------------------");
	                    	System.out.println("\tPress 1 to Update the No of Persons\t");
	                    	System.out.println("\tPress 2 to Update the Movie Name\t");
	                    	System.out.println("\tPress 3 to Update the Date\t");
	                    	System.out.println("\tPress 4 to Update the Time\t");
	                    	System.out.println("\t----------------------------------------");
	                        System.out.print("\tEnter your Choice...: ");
	                        int ch4=sc.nextInt();
	                        if(ch4==1)
	                        {
	                        	System.out.print("\tPlease enter the no of persons to be updated: ");
	                        	int no_of_persons1=sc.nextInt();
	                        	update u=new update();
	                        	u.updatenoofpersons(no_of_persons1);
	                        }
	                        else if(ch4==2)
	                        {
	                        	System.out.print("\tPlease enter the Movie name to be updated: ");
	                        	System.out.println("\t*****List of Movies*****");
								System.out.println("\t1.TRANSFORMERS-RISE OF THE BEAST");
								System.out.println("\t2.SPIDERMAN-ACROSS THE SPIDER VERSE");
								System.out.println("\t3.EVIL DEAD RISE");
								System.out.println("\t4.FAST X");
								System.out.print("\tEnter the choice: ");
								int ch5=sc.nextInt();
								String moviename1="";
								if(ch5==1) {
									moviename1="TRANSFORMERS-RISE OF THE BEAST";
								}
								else if(ch5==2) {
									moviename1="SPIDERMAN-ACROSS THE SPIDER VERSE";
								}
								else if(ch5==3) {
									moviename1="EVIL DEAD RISE";
								}
								else if(ch5==4)
								{
									moviename1="FAST X";
								}
								else
								{
									System.out.println("\t--------------------------------------");
					                System.out.println("\tSorry...!!!");
					                System.out.println("\tThere is no show going on.....!!!!!!");
					                System.out.println("\t--------------------------------------");
								}
								update u=new update();
								u.updatemoviename(moviename1);
	                        }
	                        else if(ch4==3)
	                        {
	                        	System.out.print("\t+Please enter the Date to be updated: ");
	                        	String d7=sc.next();
								Date d8=new SimpleDateFormat("dd/MM/yyyy").parse(d7);
								SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
								String date7=formatter.format(d8);
	                        	update u=new update();
								u.updatedate(date7);
	                        }
	                        else if(ch4==4)
	                        {
	                        	System.out.print("\tPlease enter the Time to be updated: ");
	                        	System.out.println("\tEnter 1 for 10:00am - 1:00 pm"); 
								System.out.println("\tEnter 2 for 1:30pm - 4:30 pm");
								System.out.println("\tEnter 3 for 4:30pm - 7:30 pm");
								System.out.println("\tEnter 4 for 7:30pm - 10:30 pm");
								System.out.print("\tEnter the choice: ");
								int ch2=sc.nextInt();
								String time1="";
								if(ch2==1)
								{
									time1="10:00am";
								}
								else if(ch2==2)
								{
									time1="1:30pm";
								}
								else if(ch2==3)
								{
									time1="4:30pm";
								}
								else if(ch2==4)
								{
									time1="7:30pm";
								}
								else
								{
									System.out.println("\t--------------------------------------");
					                System.out.println("\tSorry...!!!");
					                System.out.println("\tThere is no show going on.....!!!!!!");
					                System.out.println("\t--------------------------------------");
								}
								update u=new update();
								u.updatetime(time1);
	                        }
	                        else
							{
	                        	System.out.println("\t--------------------------------------");
				                System.out.println("\tSorry...!!!");
				                System.out.println("\tThere is no choice.....!!!!!!");
				                System.out.println("\t--------------------------------------");
							}
	                    }
	                    else if(ch1==4)
	                    {
	                    	delete_bookings db=new delete_bookings();
	                    	boolean res2=db.delete_book();
	                    	if(res2)
	                    	{
	                    		System.out.println("\t----------------------------");
								System.out.println("\tTicket is cancelled...!!!");
								System.out.println("\t----------------------------");
	                    	}
	                    	else
	                    	{
	                    		System.out.println("\t------------------------------------------------");
								System.out.println("\tSomething went wrong!!Please try again Later\t");
								System.out.println("\t------------------------------------------------");
	                    	}
	                    }
	                    else if(ch1==0)
	                    {
	                    	System.out.println("\t------------------------------------");
	                    	System.out.println("\tTHANK YOU!!!HAVE A GREAT TIME!!!\t");
	                    	System.out.println("\t------------------------------------");
	                    	break;
	                    }
	                    else
	                    {
	                    	System.out.println("\t--------------------------------------");
			                System.out.println("\tSorry...!!!");
			                System.out.println("\tThere is no choice.....!!!!!!");
			                System.out.println("\t--------------------------------------");
	                    }
					}
				}
			}
			else if(ch==0)
			{
					System.out.println("\t------------------------------------");
					System.out.println("\tTHANK YOU!!!HAVE A GREAT TIME!!!\t");
					System.out.println("\t------------------------------------");
					break;
					
			}
			else
            {
            	System.out.println("\tInvalid Option");
            }
		}
	}
}
