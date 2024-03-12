package com.kce.student.dao;
import com.kce.student.util.*;
import java.sql.*;
public class StudentDAOdelete {
	Connection con=JDBCconnection.getConnection();
   public void delete(String rollno) {
	   try {
		   if(rollno.length()!=10) {
				throw new StudentException("Invalid RollNo");
			}
		PreparedStatement p=con.prepareStatement("delete from student where rollNo=?");
		PreparedStatement p1=con.prepareStatement("delete from studentdetails where rollNo=?");
		p.setString(1, rollno);
		p1.setString(1, rollno);
		p.executeUpdate();
		p1.executeUpdate();
		System.out.println("Student deleted successfully.");
		
	} 
	  catch (StudentException e) {
			System.out.println(e);
	} 
	  catch (SQLException e) {
		e.printStackTrace();
	}
	   
   }
}
