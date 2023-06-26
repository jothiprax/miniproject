package com.kce.util;
import java.sql.*;
import java.util.*;

import com.kce.service.Main;
public class Welcome {
public  void Login() throws Exception
{
	String url="jdbc:mysql://localhost:3306/welcome";
	String user="root";
	String password="Royalenfield9442.";
	Connection con= DriverManager.getConnection(url,user,password);
	
	Scanner sc= new Scanner(System.in);xx
	System.out.println("HAI WELCOME TO RESTAURANT\n\n");
	System.out.println("ENTER YOUR NAME");
	String name=sc.nextLine();
	System.out.println("ENTER YOUR ROLL NUMBER");
	String rollnum=sc.nextLine();
	if(rollnum.length()!=10)
	{
		throw new UserException("INVALID ROLL NUMBER RETURNING TO HOME...");
	}
	System.out.println("Enter you email");
	String email=sc.nextLine();
	if(email.length()!=20)
	{
		throw new UserException("INVALID EMAILID RETURNING TO HOME...");
		
	}
//	PreparedStatement stmt1= con.prepareStatement("create if not exists table ?(name varchar(20),rollnum varchar(20),email varchar(20))");
//	stmt1.setString(1,name);
//	stmt1.execute();
	PreparedStatement stmt2= con.prepareStatement("insert into welcome values(?,?,?)");
	stmt2.setString(1, name);
	stmt2.setString(2, rollnum);
	stmt2.setString(3, email);
	stmt2.execute();
	System.out.println("ACCOUNT CREATED SUCCESSFULLY RETURNING TO HOME...");
	Main.main(null);
	return;
	
}
public void Sigup() throws Exception
{
	Scanner sc= new Scanner(System.in);
	String url="jdbc:mysql://localhost:3306/welcome";
	String user="root";
	String password="Royalenfield9442.";
	Connection con= DriverManager.getConnection(url,user,password);
	PreparedStatement stmt=con.prepareStatement("select * from welcome where rollnum=?");
	System.out.println("ENTER YOUR ROLL NUMBER");
	String rollnum=sc.nextLine();
	stmt.setString(1,rollnum);
	ResultSet rs=stmt.executeQuery();
	int valid=0;
	while(rs.next())
	{
		valid++;
	}
	if(valid==0)
	{
		throw new UserException("USER NOT FOUND RETURNING TO HOME.....");
	}
	else
	{
		System.out.println("WELCOME TO OUR RESTAURANT");
	}
	
}
}
