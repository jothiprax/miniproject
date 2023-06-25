package com.kce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.kce.util.Connect;

public class Dao {
	public static void display() throws Exception
	{
		Connection con=Connect.getConnection();
		PreparedStatement pst=con.prepareStatement("select * from Album");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
		}
	}
	public static void sold(String str,int num) throws Exception
	{
		Connection con=Connect.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from Album");
		while(rs.next())
		{
			if(rs.getString(1).equalsIgnoreCase(str) && rs.getInt(4)==num)
			{
				System.out.println("Yes mam avaiable and it's price is"+rs.getInt(4));
				System.out.println("Thank you for your purchase");
			}
			else
			{
				System.out.println("Sorry the album is not available");
				System.out.println("We can inform you later if it avaiable");
			}
		}
	}
}