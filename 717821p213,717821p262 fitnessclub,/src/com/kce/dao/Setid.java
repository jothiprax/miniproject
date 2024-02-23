package com.kce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Setid {
	public void setd(int mid,String tname)
	{
		try
		{
			System.out.println(mid);
			System.out.println(tname);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fitnessclub","root","dilip");
		PreparedStatement ps=con.prepareStatement("update trainers set mid=? where tname=?");
		ps.setInt(1,mid+1);
		ps.setString(2,tname);
		ps.executeUpdate();
		System.out.println("success");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
