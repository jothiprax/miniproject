package com.javaproject;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main
{

	public static  void main(String[] args) 
	{
		try 
		{

			Scanner sc=new Scanner (System.in);
			Input in=new Input();
			System.out.println("ENTER YOU ARE A CUSYTOMER OR A MANAGER");
			System.out.println("  Press 1 FOR CUSTOMER");
			System.out.println("  Press 2 FOR MANAGER");
			int ch=sc.nextInt();
			
			if(ch==1)
				{
				System.out.println("WELCOME TO MUTHU'S ATM");
				System.out.println("ENTER YOUR PIN");
				in.setPin(sc.nextInt());
				Connection con=DbUtil.getConnection();
				Statement stat=con.createStatement();
				ResultSet rs=stat.executeQuery("select * from atm where atm_pin="+in.getPin());
					
		
				while(rs.next())
					{
						String name=rs.getString(3);
						float balance=rs.getFloat(5);
						int phone_number=rs.getInt(4);
						int pin=rs.getInt(2);
						int acc_no=rs.getInt(1);
					    
						if(in.getPin()==pin)
							{
								System.out.println("  Welcome "+name);
								
								while(true)
									{
										System.out.println("\n  Press 1 TO CHECK BALANCE");
										System.out.println("  Press 2 TO DEPOSIT AMMOUNT");
										System.out.println("  Press 3 TO WITHRAW AMMOUNT");
										System.out.println("  Press 4 TO YOUR DETAILS");
										System.out.println("  Press 5 TO CHANGE PIN");
										System.out.println("  Press 6 TO EXIT ");
										
										System.out.println("\n PRESS YOUR CHOICE");
										int choice=sc.nextInt();
										float balance1;
										
										
										switch(choice)
											{
												case 1:
												{
													System.out.println("YOUR BALANCE: "+balance);
													System.out.println("------------------------------------------------");
													break;
												}
												case 2:
												{
													System.out.println("\nENTER MONEY TO BE DEPOSITED...... ");
													int money_deposited=sc.nextInt();
													balance1=balance+money_deposited;
													int bal=stat.executeUpdate("update atm set balance="+balance1+ " where atm_pin="+in.getPin());
													System.out.println("MONEY IS DEPOSITED SUCCESSFULLY...... ");
													System.out.println("YOUR BALANCE: "+balance1);
													System.out.println("------------------------------------------------");
													break;
												}
												case 3:
												{
													System.out.println("\nENTER MONEY TO BE WITHDRAWN....... ");
													int withdraw_ammount1=sc.nextInt();
													if(withdraw_ammount1 <= balance)
														{
														float balance2=balance-withdraw_ammount1;
														int mon=stat.executeUpdate("update atm set balance="+balance2+ " where atm_pin="+in.getPin());
														System.out.println("MONEY IS WITHDRAWN SUCCESSFULLY...... ");
														System.out.println("YOUR BALANCE: "+balance2);
														System.out.println("------------------------------------------------");
														}
													else
														{
															System.out.println("INSUFFICIENT BALANCE........");
															System.out.println("YOUR BALANCE: "+balance);
															System.out.println("------------------------------------------------");
														}
													break;
												}
												case 4:
												{
													System.out.println("\n********YOUR DETAILS**********");
													System.out.println("BALANCE        : "+balance);
													System.out.println("ACCOUNT_NUMBER : "+ acc_no);
													System.out.println("ATM PIN        : "+ pin);
													System.out.println("PHONE_NUMBER   : "+ phone_number);
													System.out.println("THANK YOU      : "+name);
													System.out.println();
													System.out.println("***********VISIT US AGAIN************");
													System.out.println("------------------------------------------------");
													break;
												}
												case 5:
												{
													System.out.println("\nENTER YOUR PIN..................");
													int pinn=sc.nextInt();
													System.out.println("ENTER YOUR ACCOUNT NUMBER.........");
													int account_number=sc.nextInt();
													System.out.println("ENTER YOUR ACCOUNT NUMBER.........");
													int PH_number=sc.nextInt();
										
													if(pinn==pin && account_number==acc_no &&phone_number==PH_number )
														{
														System.out.println("ENTER YOUR NEW PIN............");
														int p=sc.nextInt();
														int pii=stat.executeUpdate("update atm set atm_pin="+p+" where atm_pin="+in.getPin());
														System.out.println("YOUR PIN IS UPDATED...........");
														System.out.println("------------------------------------------------");
														}
													else
														{
															System.out.println("^^^^^^^^^YOUR GIVEN DETAILS DOES NOT MATCH WITH OUR DATABASE^^^^^^^^");
															System.out.println("                   ^^^^^TRY AGAIN^^^^^                              ");
															System.out.println("------------------------------------------------");
														}
													break;
												}
						
											}
											if(choice==6)
												{
													break;
												}
									}
							}
					}
				
			}
		
	   if(ch==2)
	   {
		   System.out.println("``````````HELLO MANAGER``````````````");
		   System.out.println("PRESS 1 TO ADD A CUSTOMER................");
		   System.out.println("PRESS 2 TO DELETE A CUSTOMER.............");
		   System.out.println("PRESS 3 TO GET CUSTOMERS LIST............");
		   
		   int cho=sc.nextInt();
		   Connection con=DbUtil.getConnection();
		   Statement stat=con.createStatement();
		
		   switch(cho)
		   {
			   case 1:
			   {
				   System.out.println("ENTER CUSTOMER ACCOUNT_NUMBER");
				   int ac=sc.nextInt();
				   System.out.println("ENTER CUSTOMER ATM_PIN");
				   int ap=sc.nextInt();
				   System.out.println("ENTER CUSTOMER NAME");
				   String na=sc.next();
				   System.out.println("ENTER CUSTOMER PHONE_NUMBER");
				   int pn=sc.nextInt();
				   System.out.println("ENTER CUSTOMER BALANCE");
				   int ba=sc.nextInt();
				   
				   PreparedStatement pstat=con.prepareStatement("INSERT INTO atm (account_number , atm_pin, name, phone_number,balance) VALUES (?,?,?,?,?)");
				   pstat.setInt(1, ac);
				   pstat.setInt(2, ap);
				   pstat.setString(3, na);
				   pstat.setInt(4, pn);
				   pstat.setInt(5, ba);
				   pstat.executeUpdate();
				   System.out.println("CUSTOMER ADDED SUCCESSFULLY................");
				   break;
			   }
			   case 2:
			   {
				   System.out.println("ENTER CUSTOMER ACCOUNT_NUMBER..............");
				   int ac=sc.nextInt();
				   int mon=stat.executeUpdate("DELETE FROM ATM WHERE ACCOUNT_NUMBER="+ac);
				   System.out.println("CUSTOMER ACCOUNT IS DELETED SUCCESSFULLY..............");
				   break;
			   }
			   case 3:
			   {
				   ResultSet rs=stat.executeQuery("select * from atm");
				   while(rs.next())
				   {
					   
						System.out.println("ACCOUNT_NUMBER : "+rs.getInt(1));
						System.out.println("ATM PIN        : "+rs.getInt(2));
						System.out.println("NAME           : "+rs.getString(3));
						System.out.println("PHONE_NUMBER   : "+rs.getInt(4));
						System.out.println("BALANCE        : "+rs.getInt(5));
						System.out.println("------------------------------------------------");
				   }
			   }
		   }
		   
	   	}
	}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}