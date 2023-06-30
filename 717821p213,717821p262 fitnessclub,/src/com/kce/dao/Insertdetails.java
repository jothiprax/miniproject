package com.kce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Insertdetails {
public void insertd(int mid, String mname, int mage, String mgender, long mnumber, long mwnumber, String mjoindate,
		String tname, String username, String password, String city, String address) {
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fitnessclub","root","dilip");
	PreparedStatement ps=con.prepareStatement("insert into members values(?,?,?,?,?,?,?,?,?,?,?,?)");
	ps.setInt(1,mid);
	ps.setString(2,mname);
	ps.setInt(3,mage);
	ps.setString(4,mgender);
	ps.setLong(5,mnumber);
	ps.setLong(6,mwnumber);
	ps.setString(7,mjoindate);
	ps.setString(8,tname);
	ps.setString(9,username);
	ps.setString(10,password);
	ps.setString(11,city);
	ps.setString(12,address);
	ps.executeUpdate();
	System.out.println("Successfully inserted");
	}
	catch(Exception e)
	{
		System.out.println(e+"error in insert");
	}
	
}
}
