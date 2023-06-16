package com.kce.bus.dao;
import com.kce.bus.util.*;
//package com.kce.bus.util;
import java.sql.*;
import java.util.*;
public class BusDAO 
{
	public static boolean createDetailTable()
	{
	try
	{
		//Class.forName("com.mysql.jdbc.Driver");
		Connection connect=DBUtil.createConnection();
				//DriverManager.getConnection("jdbc:mysql://localhost:3306/21l232","root","Blackpre15*");
				//DBUtil.createConnection();
	Statement s=connect.createStatement();
	String query="create table bus(BUS_NO varchar(20) PRIMARY KEY,Bus_id int,Date date,Bus_Name varchar(20) NULL,Passenger_Name varchar(20) NULL,Passenger_Address varchar(20) NULL,Board_Point varchar(20) NULL,Destination varchar(20) NULL,Mobile_number varchar(20) NULL,Amount double(9,2) NULL)";
	int row=s.executeUpdate(query);
	System.out.println(row);
	if(row==0)
	return false;
	else
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	}
	return false;
	}

	public static boolean insert()
	{
	try
	{
	Connection connect=DBUtil.createConnection();
	Statement s=connect.createStatement();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter bus no");
	String s1=sc.nextLine();
	System.out.println("Enter the id");
	int n=sc.nextInt();
	sc.nextLine();
	System.out.println("Date");
	String s2=sc.nextLine();
	System.out.println("Bus name");
	String s3=sc.nextLine();
	System.out.println("passanger name");
	String s4=sc.nextLine();
	System.out.println("passanger address");
	String s5=sc.nextLine();
	System.out.println("Board point");
	String s6=sc.nextLine();
	System.out.println("Destination");
	String s7=sc.nextLine();
	System.out.println("Mobile number");
	String s8=sc.nextLine();
	System.out.println("Amount");
	double d=sc.nextDouble();
	String ss="insert into bus values('"+s1+"',"+n+",'"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"',"+d+")";
	s.execute(ss);
	System.out.println("Successfully inserted");
	}
	
	catch(Exception e)
	{
		System.out.println(e);
	}
	return true;
	}

	public static boolean display()
	{
	try
	{
	Connection connect=DBUtil.createConnection();
	Statement s=connect.createStatement();
	Scanner sc=new Scanner(System.in);
	ResultSet r=s.executeQuery("select * from bus");
	System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n","Bus_no","Bus_id","Date","Bus_name","Passenger_name","passenger-Address","Board_point","Destination","Mobile_number","Amount");
	while(r.next())
	{
		System.out.printf("%-10s %-10d %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10.2f\\n",r.getString(1),r.getInt(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getString(8),r.getString(9),r.getDouble(10));
	}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return true;
	}
}
