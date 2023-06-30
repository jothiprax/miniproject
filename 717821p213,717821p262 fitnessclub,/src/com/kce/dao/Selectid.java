package com.kce.dao;
import java.sql.*;
import java.util.Scanner;
public class Selectid {
	public int gettid()
	{
		int c =0;
	try
	{
	Scanner sc=new Scanner(System.in);
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fitnessclub","root","dilip");
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from members");
	while(rs.next())
	{
		c++;
	}
	}
	catch(Exception e)
	{
		System.out.println(e+"selectid error");
	}
	return c ;
	}
}
