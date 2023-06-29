package com.kce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.kce.bean.Student;
import com.kce.util.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Dao {
	private static Connection con=DBConnection.createconnection();
	private static Statement st;
	private static ResultSet rs;
	private static PreparedStatement p;
    public static void createtable()
    {
    	try {
    	st=con.createStatement();
		st.execute("CREATE TABLE student(name varchar(20),studentID int,grade int)");
		System.out.println("table created");
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    }
    public static void display()
    {
    	try {
    	st=con.createStatement();
    	rs=st.executeQuery("select * from student");
    	//rs.executeUpdate();
    	while(rs.next())
    	{
    		System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getInt(3));
    	}
    	System.out.println("Successfully displayed");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
        }
   }
  public static void Updatetable(Student s)
  {
	    try {
		  st=con.createStatement();
	            String sql
	                ="update student set grade=? where studentID=?";
	            p = con.prepareStatement(sql);
	            p.setInt(1,s.getGrade());
	            p.setInt(2,s.getStudentID());
	            p.executeUpdate();
	        }
	        catch (SQLException e) {
	            System.out.println(e);
	        }
	  }
  public static void delete(Student s)
  {
	  try {
		  st=con.createStatement();
		  String query="delete from student where studentID=?";
		  p = con.prepareStatement(query);
		  p.setInt(1,s.getStudentID());
		  p.executeUpdate();
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
  }
  }
