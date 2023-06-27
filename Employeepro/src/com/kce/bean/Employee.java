package com.kce.bean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Employee
{
	public static void main(String args[]) throws Exception
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inforation","root","Varshaa@2004");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from employee");
			while(rs.next())
			{
				String name = rs.getString(1);
				int id = rs.getInt(2);
				String dob = rs.getString(3);
				String doj = rs.getString(4);
				String gender = rs.getString(5);
				
				System.out.println("Name: "+name);
				System.out.println("Id: "+id);
				System.out.println("Dob: "+dob);
				System.out.println("Doj: "+doj);
				System.out.println("Gender: "+gender);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
