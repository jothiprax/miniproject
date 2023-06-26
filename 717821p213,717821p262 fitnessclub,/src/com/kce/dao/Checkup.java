package com.kce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Checkup {
public int cc(String un,String pw)
{
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fitnessclub","root","dilip");
	PreparedStatement ps=con.prepareStatement("select * from members");
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		if((rs.getString(9).equals(un)) && (rs.getString(10).equals(pw)))
		{
			return 0;
		}
	}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return 1;
	
}
}
