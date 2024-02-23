package com.kce.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Remove {
public void dis(String un,String ps)
{
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fitnessclub","root","dilip");
	PreparedStatement p=con.prepareStatement("delete from members where musername=? and mpassword=?");
	p.setString(1, un);
	p.setString(2, ps);
	int c=p.executeUpdate();
	if(c==1)
	{
		System.out.println("Successfully removed");
	}
	}
	catch(Exception e)
	{
		System.out.println(e+" error occur in remove class");
	}
}
}
