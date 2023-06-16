package com.kce.student.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.kce.student.bean.*;
import com.kce.student.dao.DAOclass;
import com.kce.student.util.*;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			System.out.println("\n\n\t\t\t\t\t\t\t***WELCOME TO STUDENT APPLICATION***\n"
							 +     "\t\t\t\t\t\t\t   ------------------------------");
			Scanner S = new Scanner(System.in);
			DAOclass dao = new DAOclass();
			boolean flag = true;
			int login = 0;
			while(flag)
			{
				if (login != 1 && login != 2)
				{
				System.out.println("\nEnter Login : ");
				System.out.println("0) Exit\n1) Teacher\n2) Student");
				login = Integer.parseInt(S.nextLine());
				}
				if (login == 0)
				{
					System.out.println("\t\t\t\t\t\t\t---THANK YOU---");
					System.exit(0);
				}
				if (!(login == 1 || login == 2))
				{
					System.out.println("Enter correct Login .");
					continue;
				}
				if (login == 1)
				{
					System.out.println("\t\t\t\t\t\t\tLogined as Teacher");
					System.out.println("\nEnter choice:");
					System.out.println("0) log out\n1) Display all student's information\n2) Display particular student's information\n"
					+"3) Insert new student information\n4) Update student information\n5) Delete all student informaation\n"
					+"6) Delete particular student information ");
					int choice = Integer.parseInt(S.nextLine());
					
					switch (choice)
					{
					case 0:
						login = 0;
						System.out.println("\t\t\t\t\t\t\t Log out successfully");
						break;
					case 1:
						DAOclass.DispalyAll();	
						break;
					case 2:
						dao.DisplayParticular();
						break;
					case 3:
						dao.insertdetail();
						break;
					case 4:
						dao.updatedetail();
						break;
					case 5:
						dao.deleteAll();
						break;
					case 6:
						dao.deleteparticular();
						break;
					default:
						System.out.println("Enter valid choice.");
					}
					System.out.println("\n");
				}
				else if (login == 2)
				{
					System.out.println("\t\t\t\t\t\t\tLogined as Student");
					StudentLogin stu = new StudentLogin ();
					int sid = stu.checkpassword();
					if (sid != 0)
						dao.displayMark(sid);
					boolean flag1 = true;
					while (flag1)
					{
						System.out.println("Enter Login\n0) logout\n1) continue with Student login\n");
						int studentchoice = Integer.parseInt(S.nextLine());
						if (studentchoice == 0)
						{
							flag1 = false;
							System.out.println("\t\t\t\t\t\t\tLog out successfully");
							login = 0;
							break;
						}
						else if (studentchoice == 1)
						{
							flag1 = false;
							break;
						}
						else
						{
							flag1 = true;
							System.out.println("Enter correct number\n");
						}
					}
				}
			System.out.println();
			}
			
			S.close();
		}
		catch(InvalidmarkException e  )
		{
			e.printStackTrace();
		}
		catch (InvalidyearException e1)
		{
			e1.printStackTrace();
		}
		catch (InvalidDepartmentException e2)
		{
			e2.printStackTrace();
		}
		catch (InvalidPercentageException e3)
		{
			e3.printStackTrace();
		}
		catch(SQLException e4)
		{
			e4.printStackTrace();
		}
		catch(Exception e5)
		{
			e5.printStackTrace();
		}
	}
}
