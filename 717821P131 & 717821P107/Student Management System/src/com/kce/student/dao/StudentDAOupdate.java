package com.kce.student.dao;
import com.kce.student.util.JDBCconnection;
import java.sql.*;
public class StudentDAOupdate {
       Connection con=JDBCconnection.getConnection();
       public void update(String rollNo,int year,int attendance,char c) {
    	   try {
			PreparedStatement p=con.prepareStatement("update studentdetails set year=? where rollNo=?");
			p.setInt(1,year);
			p.setString(2,rollNo);
			p.executeUpdate();
			PreparedStatement p1=con.prepareStatement("update studentdetails set attendance=? where rollNo=?");
			p1.setInt(1,attendance);
			p1.setString(2,rollNo);
			p1.executeUpdate();
			PreparedStatement p2=con.prepareStatement("update studentdetails set grade=? where rollNo=?");
			p2.setString(1,String.valueOf(c));
			p2.setString(2,rollNo);
			p2.executeUpdate();
			System.out.println("Student detail updated.");
			} catch (SQLException e) {
			e.printStackTrace();
		}
       }
}
