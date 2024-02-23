package com.kce.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Gettname {
	public String getname(String un,String pw)
	{
		String name="";
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fitnessclub","root","dilip");
		PreparedStatement p=con.prepareStatement("select tname from members where musername=? and mpassword=?");
		p.setString(1, un);
		p.setString(2, pw);
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			name=rs.getString(1);
		}
		}
		catch(Exception e)
		{
			System.out.println(e+" error occur in gettname");
		}
		return name;
		}
}
