package com.kce.student.dao;

import java.sql.*;
import java.util.Scanner;
import com.kce.student.util.*;

public class DAOclass
{
	static Scanner S = new Scanner(System.in);
	static Connection con = null;
	public static void DispalyAll()
	{
		try
		{
			con = Database_connection.createConnection();//getting the connection of database.
			String disallquery  = "select * from Teacher_login;";
			PreparedStatement disall = con.prepareStatement(disallquery);
			ResultSet rs1 = disall.executeQuery();//retriving the table
			if(rs1.next())
			{
				System.out.println("Displaying details\n"
								 + "------------------");
				ResultSetMetaData rsmd = (ResultSetMetaData) rs1.getMetaData();//retriving column names.
				System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n\n",rsmd.getColumnName(1),rsmd.getColumnName(2),rsmd.getColumnName(3),rsmd.getColumnName(4)
						,rsmd.getColumnName(5),rsmd.getColumnName(6),rsmd.getColumnName(7),rsmd.getColumnName(8));
				do 
				{
					System.out.printf("%-20d %-20s %-20s %-20d %-20d %-20d %-20d %-20f\n",rs1.getInt("Studentid"),rs1.getString("Name"),rs1.getString("Department"),rs1.getInt("Year")
							,rs1.getInt("PRPmark"),rs1.getInt("MPMCmark"),rs1.getInt("DSmark"),rs1.getDouble("TotalPercentage"));
				}while (rs1.next());
				System.out.println();
			}
			else
			{
				System.out.println("No student found");
			}
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void DisplayParticular() throws InvalidmarkException, InvalidyearException, InvalidDepartmentException, InvalidPercentageException
	{
		con = Database_connection.createConnection();
		String DisParQuery = "";
		System.out.println("Choose options to filter students:");
		System.out.println("1)Student id \n2)Name\n3)Year\n4)Department\n5)Above certain mark\n6)Below certain mark\n"
				+ "7)above certain Percentage\n8)Below certain Percentage");
		switch(Integer.parseInt(S.nextLine()))
		{
		case 1://Information based on student Id.
			System.out.println("Enter Student id");int id = Integer.parseInt(S.nextLine()); 
			DisParQuery = "select * from Teacher_login where Studentid = "+id;
			break;
		case 2://Information based on Student name.
			System.out.println("Enter Name :");
			String NAME = S.nextLine();
			DisParQuery = "select * from Teacher_login where Name = '"+NAME+"'";
			break;
		case 3://Information based on Student's Studying year. 
			System.out.println("Enter Year :");
			int YEAR = Integer.parseInt(S.nextLine());
			if(YEAR > 4 || YEAR < 1)
			{
				throw new InvalidyearException("Year must be between 1 and 4 ");
			}
			DisParQuery = "select * from Teacher_login where Year = "+YEAR;
			break;
		case 4://Information based on Student Department.
			System.out.println("Enter Department [ECE,CSE,EEE,IT,MECH] :");
			String DEP = S.nextLine();
			if (!(DEP.equalsIgnoreCase("ECE") || DEP.equalsIgnoreCase("CSE") || DEP.equalsIgnoreCase("EEE") || DEP.equalsIgnoreCase("IT") || DEP.equalsIgnoreCase("MECH")))
			{
				throw new InvalidDepartmentException("Invalid Department . Enter only ECE,CSE,EEE,IT,MECH ");
			}
			DisParQuery = "select * from Teacher_login where Department like '"+DEP+"'";
			break;
		case 5://Information Based on Mark
			{
			System.out.println("Choose Subject:");System.out.println("1)Propability and Random Process\n2)Micro Processer and Micro Controller \n3)Data Stuctures");
			boolean flag = true;
			while (flag)
			{
				try
				{
					int c = Integer.parseInt(S.nextLine());int minmark = 0;
					if (c == 1) {flag = false;System.out.println("Enter Minimum mark:");minmark = Integer.parseInt(S.nextLine());
						DisParQuery = "select * from Teacher_login where PRPmark >= "+minmark;}
					else if (c == 2) {flag = false;System.out.println("Enter Minimum mark:"); minmark = Integer.parseInt(S.nextLine());
						DisParQuery = "select * from Teacher_login where MPMCmark >= "+minmark;}
					else if (c == 3) {flag = false;System.out.println("Enter Minimum mark:");minmark = Integer.parseInt(S.nextLine());
						DisParQuery = "select * from Teacher_login where DSmark >= "+minmark;}
					else  
					{
						flag = true;
						System.out.println("Enter numbers between 1 - 3");
					}
					if (minmark < 0 || minmark >100)
					{
						throw new InvalidmarkException("Invalid Mark : Mark should be between 0 and 100");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			break;
			}
		case 6://Information based on Mark.
		{
			System.out.println("Choose Subject:");
			boolean flag = true;
			int maxmark = 0;
			while (flag)
				{
				System.out.println("1)Propability and Random Process\n2)Micro Processer and Micro Controller \n3)Data Stuctures");
				int c = Integer.parseInt(S.nextLine());
				if (c == 1) {flag = false;System.out.println("Enter Maximun mark:");maxmark = Integer.parseInt(S.nextLine());
					DisParQuery = "select * from Teacher_login where PRPmark <= "+maxmark;}
				else if (c == 2) {flag = false;System.out.println("Enter Maximum mark:");maxmark = Integer.parseInt(S.nextLine());
					DisParQuery = "select * from Teacher_login where MPMCmark <= "+maxmark;}
				else if (c == 3) {flag = false;System.out.println("Enter Maximum mark:");maxmark = Integer.parseInt(S.nextLine());
					DisParQuery = "select * from Teacher_login where DSmark <= "+maxmark;}
				else  
				{
					flag = true;
					System.out.println("Enter numbers between 1 - 3");
				}
				if (maxmark < 0 || maxmark >100)
				{
					throw new InvalidmarkException("Invalid Mark : Mark should be between 0 and 100");
				}
			}
			break;
		}
		case 7://Information based on Percentage
			{
			System.out.println("Enter Minimum percentage :");
			double PER = Double.parseDouble(S.nextLine());
			if (PER < 0.0 || PER > 100.0)
			{
				throw new InvalidPercentageException("Invalid Percentage . Percentage should be between 0.0 and 100.0");
			}
			DisParQuery = "select * from Teacher_login where TotalPercentage > "+PER;
			break;
			}
		case 8://Information based on Percentage.
			{
				System.out.println("Enter Maximum percentage :");
				double PER = Double.parseDouble(S.nextLine());
				if (PER < 0.0 || PER > 100.0)
				{
					throw new InvalidPercentageException("Invalid Percentage . Percentage should be between 0.0 and 100.0");
				}
				DisParQuery = "select * from Teacher_login where TotalPercentage <"+PER;
				break;
			}
		}
		try
		{
			PreparedStatement DisPar = con.prepareStatement(DisParQuery);
			ResultSet rs2 = DisPar.executeQuery();//Retriving Information.
			if(rs2.next())
			{
				ResultSetMetaData rsmd = (ResultSetMetaData) rs2.getMetaData();//Retriving column name.
				System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",rsmd.getColumnName(1),rsmd.getColumnName(2),rsmd.getColumnName(3),rsmd.getColumnName(4)
						,rsmd.getColumnName(5),rsmd.getColumnName(6),rsmd.getColumnName(7),rsmd.getColumnName(8));
				do 
				{
					System.out.printf("%-20d %-20s %-20s %-20d %-20d %-20d %-20d %-20f\n",rs2.getInt("Studentid"),rs2.getString("Name"),rs2.getString("Department"),rs2.getInt("Year")
							,rs2.getInt("PRPmark"),rs2.getInt("MPMCmark"),rs2.getInt("DSmark"),rs2.getDouble("TotalPercentage"));
					}while (rs2.next());
			}
			else
			{
				System.out.println("No student found");
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
	public void insertdetail() throws InvalidmarkException, InvalidDepartmentException, InvalidyearException, InvalidPercentageException
	{
		con = Database_connection.createConnection();//connection created
		System.out.println("Enter Student id: ");
		int id = Integer.parseInt(S.nextLine());
		System.out.println("Enter Student Name: ");
		String name = S.nextLine();
		System.out.println("Enter Department[ECE,CSE,EEE,IT,MECH] : ");
		String dept = S.nextLine().toUpperCase();
		if (!(dept.equalsIgnoreCase("ECE") || dept.equalsIgnoreCase("CSE") || dept.equalsIgnoreCase("EEE") || dept.equalsIgnoreCase("IT") || dept.equalsIgnoreCase("MECH")))
		{
			throw new InvalidDepartmentException("Invalid Department . Enter only ECE,CSE,EEE,IT,MECH ");
		}
		System.out.println("Enter year :");
		int year = Integer.parseInt(S.nextLine());
		if(year > 4 || year < 1)
		{
			throw new InvalidyearException("Year must be between 1 and 4 ");
		}
		System.out.println("Enter PRP mark : ");int prp = Integer.parseInt(S.nextLine());
		System.out.println("Enter MPMC mark : ");int mpmc = Integer.parseInt(S.nextLine());
		System.out.println("Enter DS mark : ");int ds = Integer.parseInt(S.nextLine());
		if ((prp < 0 || prp > 100) ||( mpmc < 0 ||  mpmc > 100) ||( ds < 0 || ds > 100 ))
		{
			throw new InvalidmarkException("Invalid mark The mark should be between 0 and 100");
		}
		System.out.println("Enter total percentage : ");double per = Double.parseDouble(S.nextLine());
		String insertquery = "insert into Teacher_login values (?,?,?,?,?,?,?,?)";
		if (per < 0.0 || per > 100.0)
		{
			throw new InvalidPercentageException("Invalid Percentage . Percentage should be between 0.0 and 100.0");
		}

		PreparedStatement insert;
		try 
		{
			insert = con.prepareStatement(insertquery);
			insert.setInt(1,id);insert.setString(2, name);insert.setString(3, dept);insert.setInt(4, year);insert.setInt(5, prp);insert.setInt(6, mpmc);insert.setInt(7, ds);
			insert.setDouble(8, per);
			int i = insert.executeUpdate();
			if (i > 0)
			{
				System.out.println("Inserted Succesfully :)\nData Base after insertion:");
				DAOclass.DispalyAll();
			}
			PreparedStatement ps = con.prepareStatement("insert into Student_login(StudentId,PRPmark,MPMCmark,DSmark) values (?,?,?,?)");
			ps.setInt(1, id);ps.setInt(2, prp);ps.setInt(3, mpmc);ps.setInt(4, ds);
			ps.executeUpdate();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	public void updatedetail () throws InvalidmarkException , InvalidDepartmentException, InvalidyearException, InvalidPercentageException, SQLException
	{
		con = Database_connection.createConnection();
		String updatequery = "";
		System.out.println("Enter detail to be updated :");
		System.out.println("1)Studentid\n2)Student Name\n3)Student Department\n4)Student Year\n5)PRPmark\n6)MPMCmark\n7)DSmark\n8)Totalpercentage");
		boolean flag = true;
		while (flag)
		{
			int choice = Integer.parseInt(S.nextLine());
			if (!(choice >= 1 && choice <= 8))
			{
				System.out.println("Enter between 1 - 8");
				continue;
			}
			else
			{
				System.out.println("Which student should be updated ?(Enter student id)");
				int id = Integer.parseInt(S.nextLine());
				try 
				{
				flag = false;
				  switch(choice)
				  {
				  case 1:
				  {
					  updatequery = "update Teacher_login set Studentid = ? where Studentid = "+id;
					  PreparedStatement update = con.prepareStatement(updatequery);
					  System.out.println("Enter the correct studentid :");
					  int id1 = Integer.parseInt(S.nextLine());
					  update.setInt(1,id1);
					  int i = update.executeUpdate();
					  if(i > 0)
					  {
						  DAOclass.DispalyAll();
						  PreparedStatement updatestu = con.prepareStatement("update Student_login set Studentid = "+id1+" where studentId = "+id);
						  updatestu.executeUpdate();
					  }
					  else
						  System.out.println("No student with Student id : "+id1);
					  break;
				  }
				  case 2:
				  {
					  updatequery = "update Teacher_login set Name = ? where Studentid = "+id;
					  PreparedStatement update = con.prepareStatement(updatequery);
					  System.out.println("Enter the correct Name :");
					  update.setString(1, (S.nextLine()));
					  int i = update.executeUpdate();
					  if(i > 0) 
						  DAOclass.DispalyAll();
					  else
						  System.out.println("No student with Student id : "+id);
					  break;
				  }
				  case 3:
				  {
					  updatequery = "update Teacher_login set Department = ? where Studentid = "+id;
					  PreparedStatement update = con.prepareStatement(updatequery);
					  System.out.println("Enter the correct Department [ECE,CSE,EEE,IT,MECH] :");
					  String dep = S.nextLine();
					  if (!(dep.equalsIgnoreCase("ECE") || dep.equalsIgnoreCase("CSE") || dep.equalsIgnoreCase("EEE") || dep.equalsIgnoreCase("IT") || dep.equalsIgnoreCase("MECH")))
					  {
						  throw new InvalidDepartmentException("Invalid Department . Enter only ECE,CSE,EEE,IT,MECH ");
					  }
					  update.setString(1,dep);
					  int i = update.executeUpdate();
					  if(i > 0)
						  DAOclass.DispalyAll();
					  else
						  System.out.println("No student with Student id : "+id);
					  break;
				  }
				  case 4:
				  {
					  updatequery = "update Teacher_login set Year = ? where Studentid = "+id;
					  PreparedStatement update = con.prepareStatement(updatequery);
					  System.out.println("Enter the correct Year :");
					  int year = Integer.parseInt(S.nextLine());
					  if(year > 4 || year < 1)
					  {
						throw new InvalidyearException("Year must be between 1 and 4 ");
					  }
					  update.setInt(1, year);
					  int i = update.executeUpdate();
					  if(i > 0)
						  DAOclass.DispalyAll();
					  else
						  System.out.println("No student with Student id : "+id);
					  break;
				  }
				  case 5:
				  {
					  updatequery = "update Teacher_login set PRPmark = ? where Studentid = "+id;
					  PreparedStatement update = con.prepareStatement(updatequery);
					  System.out.println("Enter the correct PRP mark :");
					  int prpmark =  Integer.parseInt(S.nextLine());
					  if (prpmark < 0 || prpmark > 100)
					  {
						  throw new InvalidmarkException("Invalidmark . Mark should be between 0 and 100.");
					  }
					  update.setInt(1,prpmark);
					  int i = update.executeUpdate();
					  if(i > 0)
					  {
						  DAOclass.DispalyAll();
						  PreparedStatement updatestu = con.prepareStatement("update Student_login set PRPmark = "+prpmark+" where studentId = "+id);
						  updatestu.executeUpdate();
					  }
					  else
						  System.out.println("No student with Student id : "+id);
					  break;
				  }
				  case 6:
				  {
					  updatequery = "update Teacher_login set MPMCmark = ? where Studentid = "+id;
					  PreparedStatement update = con.prepareStatement(updatequery);
					  System.out.println("Enter the correct MPMC mark :");
					  int mpmcmark = Integer.parseInt(S.nextLine());
					  if (mpmcmark < 0 || mpmcmark > 100)
					  {
						  throw new InvalidmarkException("Invalidmark . Mark should be between 0 and 100.");
					  }
					  update.setInt(1, mpmcmark);
					  int i = update.executeUpdate();
					  if(i > 0)
					  {
						  DAOclass.DispalyAll();
						  PreparedStatement updatestu = con.prepareStatement("update Student_login set MPMCmark = "+mpmcmark+" where studentId = "+id);
						  updatestu.executeUpdate();
					  }
					  else
						  System.out.println("No student with Student id : "+id);
					  break;
				  }
				  case 7:
				  {
					  updatequery = "update Teacher_login set DSmark = ? where Studentid = "+id;
					  PreparedStatement update = con.prepareStatement(updatequery);
					  System.out.println("Enter the correct DS mark :");
					  int dsmark = Integer.parseInt(S.nextLine());
					  if (dsmark < 0 || dsmark > 100)
					  {
						  throw new InvalidmarkException("Invalidmark . Mark should be between 0 and 100.");
					  }
					  update.setInt(1, dsmark);
					  int i = update.executeUpdate();
					  if(i > 0)
					  {
						  DAOclass.DispalyAll();
						  PreparedStatement updatestu = con.prepareStatement("update Student_login set DSmark = "+dsmark+" where studentId = "+id);
						  updatestu.executeUpdate();
					  }
					  else
						  System.out.println("No student with Student id : "+id);
					  break;
				  }
				  case 8:
				  {
					  updatequery = "update Teacher_login set TotalPercentage = ? where Studentid = "+id;
					  PreparedStatement update = con.prepareStatement(updatequery);
					  System.out.println("Enter the correct Percentage :");
					  double per = Double.parseDouble(S.nextLine());
					  if (per < 0.0 || per > 100.0)
					  {
						  throw new InvalidPercentageException("Invalid Percentage . Percentage should be between 0.0 and 100.0");
					  }
					  update.setDouble(1, per);
					  int i = update.executeUpdate();
					  if(i > 0)
						  DAOclass.DispalyAll();
					  else
							  System.out.println("No student with Student id : "+id);
					  break;
				  }
				  }
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
		}
	}
	public void deleteAll()
	{
		try
		{
			con = Database_connection.createConnection();
			PreparedStatement deleteall = con.prepareStatement("delete from Teacher_login;");
			boolean i = deleteall.execute();
			if (!i)
				System.out.println("Successfully deleted !!!");
			PreparedStatement ps = con.prepareStatement("delete from Student_login");
			ps.execute();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		con = null;
	}
	public void deleteparticular() throws InvalidyearException, InvalidDepartmentException, InvalidmarkException, InvalidPercentageException
	{
		try
		{
			con = Database_connection.createConnection();
			String DelParQuery = "";String ps = "";
			System.out.println("Choose options to delete students:");
			System.out.println("1)Student id \n2)Name\n3)Year\n4)Department\n5)Above certain mark\n6)Below certain mark\n"
					+ "7)above certain Percentage\n8)Below certain Percentage");
			int ch = Integer.parseInt(S.nextLine());
			switch(ch)
			{
				case 1:
				{
					System.out.println("Enter Student id");int id = Integer.parseInt(S.nextLine()); 
					String querytocheck = "select * from Teacher_login where Studentid = "+id;
					PreparedStatement check = con.prepareStatement(querytocheck);
					ResultSet rs = check.executeQuery();
					if (rs.next())
					{
						DelParQuery = "delete from Teacher_login where Studentid = "+id;
						ps = "delete  from Student_login where StudentId = "+id;
					}
					else 
					{
						System.out.println("No student with Student id "+id);
						return ;
					}
					break;
				}
				case 2:
				{
					System.out.println("Enter Name :");
					String NAME = S.nextLine();
					String querytocheck = "select * from Teacher_login where Name = '"+NAME+"'";
					PreparedStatement check = con.prepareStatement(querytocheck);
					ResultSet rs = check.executeQuery();
					if (rs.next())
						DelParQuery = "delete from Teacher_login where Name = '"+NAME+"'";
					else
					{
						System.out.println("No student with Name "+NAME);
						return ;
					}
					break;
				}
				case 3:
				{
					System.out.println("Enter Year :");
					int YEAR = Integer.parseInt(S.nextLine());
					String querytocheck = "select * from Teacher_login where Year = "+YEAR;
					PreparedStatement check = con.prepareStatement(querytocheck);
					ResultSet rs = check.executeQuery();
					if (rs.next())
					{
						if(YEAR > 4 || YEAR < 1)
						{
							throw new InvalidyearException("Year must be between 1 and 4 ");
						}
						DelParQuery = "delete from Teacher_login where Year = "+YEAR;
					}
					else
					{
						System.out.println("No student found with year "+YEAR);
						return;
					}
					break;
				}
				case 4:
				{
					System.out.println("Enter Department :");
					String DEP = S.nextLine();
					if (!(DEP.equalsIgnoreCase("ECE") || DEP.equalsIgnoreCase("CSE") || DEP.equalsIgnoreCase("EEE") || DEP.equalsIgnoreCase("IT") || DEP.equalsIgnoreCase("MECH")))
					{
						throw new InvalidDepartmentException("Invalid Department . Enter only ECE,CSE,EEE,IT,MECH ");
					}
					String querytocheck = "select * from Teacher_login where Department = '"+DEP+"'";
					PreparedStatement check = con.prepareStatement(querytocheck);
					ResultSet rs = check.executeQuery();
					if (rs.next())
						DelParQuery = "delete from Teacher_login where Department like '"+DEP+"'";
					else
					{
						System.out.println("No student found with Department "+DEP);
						return;
					}
					break;
				}
				case 5:
				{
					System.out.println("Choose Subject:");System.out.println("1)Propability and Random Process\n2)Micro Processer and Micro Controller \n3)Data Stuctures");
					boolean flag = true;
					while (flag)
					{
						int c = Integer.parseInt(S.nextLine());
						int minmark = 0;
						if (c == 1)
						{
							flag = false;System.out.println("Enter Minimum mark:");minmark = Integer.parseInt(S.nextLine());
							String querytocheck = "select * from Teacher_login where PRPmark >= "+minmark;
							PreparedStatement check = con.prepareStatement(querytocheck);
							ResultSet rs = check.executeQuery();
							if (rs.next())
							{
								ps = "delete from Student_login where PRPmark >="+minmark;
								DelParQuery = "delete from Teacher_login where PRPmark >= "+minmark;
							}
								else
							{
								System.out.println("No student found with maximum mark of "+minmark);
								return;
							}
						}
						else if (c == 2)
						{
							flag = false;System.out.println("Enter Minimum mark:");minmark = Integer.parseInt(S.nextLine());
							String querytocheck = "select * from Teacher_login where PRPmark >= "+minmark;
							PreparedStatement check = con.prepareStatement(querytocheck);
							ResultSet rs = check.executeQuery();
							if (rs.next())
							{
								ps = "delete from Student_login where MPMCmark >="+minmark;
								DelParQuery = "delete from Teacher_login where MPMCmark >= "+minmark;
							}
							else
							{
								System.out.println("No student found with maximum mark of "+minmark);
								return;
							}
						}
						else if (c == 3)
						{
							flag = false;System.out.println("Enter Minimum mark:");minmark = Integer.parseInt(S.nextLine());
							String querytocheck = "select * from Teacher_login where PRPmark >= "+minmark;
							PreparedStatement check = con.prepareStatement(querytocheck);
							ResultSet rs = check.executeQuery();
							if (rs.next())
							{
								ps          = "delete from Student_login where DSmark >="+minmark;
								DelParQuery = "delete from Teacher_login where DSmark >= "+minmark;
							}
							else
							{
								System.out.println("No student found with maximum mark of "+minmark);
								return;
							}
						}
						else  
						{
							flag = true;
							System.out.println("Enter numbers between 1 - 3");
						}
						if (minmark < 0 || minmark >100)
						{
							throw new InvalidmarkException("Invalid Mark : Mark should be between 0 and 100");
						}
					}
					break;
				}
				case 6:
				{
					System.out.println("Choose Subject:");System.out.println("1)Propability and Random Process\n2)Micro Processer and Micro Controller \n3)Data Stuctures");
					boolean flag = true;
					while (flag)
					{
						int c = Integer.parseInt(S.nextLine());
						int maxmark = 0;
						if (c == 1)
						{
							flag = false;System.out.println("Enter Maximun mark:");maxmark = Integer.parseInt(S.nextLine());
							String querytocheck = "select * from Teacher_login where PRPmark <= "+maxmark;
							PreparedStatement check = con.prepareStatement(querytocheck);
							ResultSet rs = check.executeQuery();
							if (rs.next())
							{
								ps          = "delete from Student_login where PRPmark <="+maxmark;
								DelParQuery = "delete from Teacher_login where PRPmark <= "+maxmark;
							}
							else
							{
								System.out.println("No student found with maximum mark of "+maxmark);
								return;
							}
						}
						else if (c == 2) 
						{
							flag = false;System.out.println("Enter Maximum mark:");maxmark = Integer.parseInt(S.nextLine());
							String querytocheck = "select * from Teacher_login where MPMCmark <= "+maxmark;
							PreparedStatement check = con.prepareStatement(querytocheck);
							ResultSet rs = check.executeQuery();
							if (rs.next())
							{
								ps          = "delete from Student_login where MPMCmark <=" +maxmark;
								DelParQuery = "delete from Teacher_login where MPMCmark <= "+maxmark;
							}
							else
							{
								System.out.println("No student found with maximum mark of "+maxmark);
								return;
							}
						}
						else if (c == 3)
						{
							flag = false;System.out.println("Enter Maximum mark:");maxmark = Integer.parseInt(S.nextLine());
							String querytocheck = "select * from Teacher_login where DSmark = "+maxmark;
							PreparedStatement check = con.prepareStatement(querytocheck);
							ResultSet rs = check.executeQuery();
							if (rs.next())
							{
								ps = "delete from Student_login where DSmark <="+maxmark;
								DelParQuery = "delete from Teacher_login where DSmark <= "+maxmark;
							}
							else
							{
								System.out.println("No student found with maximum mark of "+maxmark);
								return;
							}
						}
						else  
						{
							flag = true;
							System.out.println("Enter numbers between 1 - 3");
						}
						if (maxmark < 0 || maxmark >100)
						{
							throw new InvalidmarkException("Invalid Mark : Mark should be between 0 and 100");
						}
					}
					break;
				}
				case 7:
					{
					System.out.println("Enter Minimum percentage :");
					double PER = Double.parseDouble(S.nextLine());
					if (PER < 0.0 || PER > 100.0)
					{
						throw new InvalidPercentageException("Invalid Percentage . Percentage should be between 0.0 and 100.0");
					}
					String querytocheck = "select * from Teacher_login where TotalPercentage = "+PER;
					PreparedStatement check = con.prepareStatement(querytocheck);
					ResultSet rs = check.executeQuery();
					if (rs.next())
						DelParQuery = "delete from Teacher_login where TotalPercentage > "+PER;
					else
					{
						System.out.println("No student found with minimum percentage "+PER);
						return;
					}
					break;
					}
				case 8:
					{
						System.out.println("Enter Maximum percentage :");
						double PER = Double.parseDouble(S.nextLine());
						if (PER < 0.0 || PER > 100.0)
						{
							throw new InvalidPercentageException("Invalid Percentage . Percentage should be between 0.0 and 100.0");
						}
						String querytocheck = "select * from Teacher_login where TotalPercentage = "+PER;
						PreparedStatement check = con.prepareStatement(querytocheck);
						ResultSet rs = check.executeQuery();
						if (rs.next())
							DelParQuery = "delete  from Teacher_login where TotalPercentage <"+PER;
						else
						{
							System.out.println("No student found with Maximum percentage "+PER);
							return;
						}
						break;
					}
			}
		
			PreparedStatement DisPar = con.prepareStatement(DelParQuery);
			boolean i = DisPar.execute();
			if (!i)
			{
				System.out.println("Deleted successfully");
				if( ch == 1||ch == 5 || ch == 6 )
				{
					PreparedStatement Di = con.prepareStatement(ps);
					Di.execute();
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return;
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
			return;
		}
	}
	public boolean StudentExist(int sid) throws SQLException

	{
		con = Database_connection.createConnection();
		String exitquery = "select * from Student_login where StudentId = "+sid;
		PreparedStatement exist = con.prepareStatement(exitquery);
		ResultSet rs = exist.executeQuery();
		if (rs.next())
			return true;
		else
			return false;
	}
	public boolean check(int sid,String pas)

	{
		con = Database_connection.createConnection();
		String pwdquery = "Select Password from Student_login where Studentid = "+sid;
		try {
			PreparedStatement query = con.prepareStatement(pwdquery);
			ResultSet rs = query.executeQuery();
			if (rs.next())
			{
				String dbpwd = rs.getString("Password");
				if (dbpwd.equals(pas))
					return true;
				else
					return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return true;
	}
	public void displayMark(int sid) throws SQLException
	{
		con = Database_connection.createConnection();
		String query = "select PRPmark,MPMCmark,DSmark from Student_login where StudentId = "+sid;
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.printf("\t\t\t\t %-10s %-10s %-10s\n",rsmd.getColumnName(1),rsmd.getColumnName(2),rsmd.getColumnName(3));
		System.out.println("\t\t\t\t ------------------------------\n");
		while(rs.next())
		{
			System.out.printf("\t\t\t\t %-10d %-10d %-10d\n",rs.getInt("PRPmark"),rs.getInt("MPMCmark"),rs.getInt("DSmark"));
		}
		System.out.println();
	}
}