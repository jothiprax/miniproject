package com.kce.employee.util;

import java.sql.*;
//import java.util.*;
//class MismatchException extends Exception
//{
//
//
//public MismatchException(String s)
//{
//	super(s);
//}
//}

public class Employeeconnection {

	public static Connection getDBConnection() {
		Connection con=null;
		try
		{
			
//			Scanner in=new Scanner(System.in);
//			Class.forName("com.mysql.jdbc.Driver.class");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee" ,"root","12345");
			//Statement st=con.createStatement();
			//System.out.println("choose a number for the table");
			//int n=in.nextInt();
//			if(n==1)
//			{
//			ResultSet rs=st.executeQuery("select * from employee");
//		   
//			//System.out.println("EmployeeId"+"  "+"firstName"+"  "+"lastName"+"  "+"PhoneNumber"+"  "+"Employeecol");
//			while(rs.next())
//			{   
//				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"  "+rs.getString(5));
//				//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
//			}
//			}
//			else if(n==2)
//			{
//			ResultSet r=st.executeQuery("select * from Departments");
//			while(r.next())
//			{
//				System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getInt(3)+" "+r.getString(4));
//			}
//			}
//			else if(n==3)
//			{
//				ResultSet m=st.executeQuery("select * from jobhistory");
//				while(m.next())
//				{
//					System.out.println(m.getInt(1)+" "+m.getString(2)+" "+m.getString(3)+" "+m.getInt(4));
//				}
//			}
//			else if(n==4)
//			{
//
//				ResultSet p=st.executeQuery("select * from jobs");
//				while(p.next())
//				{
//					System.out.println(p.getInt(1)+" "+p.getString(2)+" "+p.getInt(3)+" "+p.getInt(4));
//				}
//			}
//			
//			throw new MismatchException("value");
		}
         catch(Exception e)
		{
        	 e.printStackTrace();
		}
		return con;
	}

}
