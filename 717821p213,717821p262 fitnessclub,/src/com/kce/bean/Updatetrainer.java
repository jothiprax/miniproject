package com.kce.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Updatetrainer {
public void upd(String tn)
{
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fitnessclub","root","dilip");
	PreparedStatement p=con.prepareStatement("update trainers set mid=mid-1 where tname=?");
	p.setString(1, tn);
	int c=p.executeUpdate();
	if(c==1)
	{
		System.out.println("Successfully updated in trainers table");
	}
	}
	catch(Exception e)
	{
		System.out.println(e+" error occur in update");
	}
}
}
