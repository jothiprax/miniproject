package com.kce.dao;
import java.sql.*;
import java.util.*;
public class Selecttrainer {
	public String gettname(String gender)
	{
	String name="";
	try
	{
	Scanner sc=new Scanner(System.in);
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fitnessclub","root","dilip");
	PreparedStatement ps=con.prepareStatement("select tid,tname from trainers where tsex=?");
	ps.setString(1, gender);
	ResultSet rs=ps.executeQuery();
	System.out.println("trainers name with trainer id");
	while(rs.next())
	{
		System.out.println(rs.getInt(1)+" "+rs.getString(2));
	}
	System.out.println("select your trainer id");
	PreparedStatement ps2=con.prepareStatement("select tname from trainers where tid=?");
	int o=sc.nextInt();
	ps2.setInt(1, o);
	ResultSet rs2=ps2.executeQuery();
	while(rs2.next())
	{
			name+=rs2.getString(1);
	}
	}
	catch(Exception e)
	{
		System.out.println(e+"error in selecttrainer");
	}
	return name;
	}
}


