package com.kce.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
public void loginmethod(String un,String ps)
{
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fitnessclub","root","dilip");
	PreparedStatement p=con.prepareStatement("select * from members where musername=? and mpassword=?");
	p.setString(1, un);
	p.setString(2, ps);
	ResultSet rs=p.executeQuery();
	while(rs.next())
	{
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getLong(5)+" "+rs.getLong(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9)+" "+rs.getString(10)+" "+rs.getString(11)+" "+rs.getString(12));
	}
	}
	catch(Exception e)
	{
		System.out.println(e+"login error");
	}
}
}
