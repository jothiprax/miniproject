package com.kce.student.dao;
import com.kce.student.util.JDBCconnection;
import java.sql.*;
public class StudentDAOview {
	Connection con=JDBCconnection.getConnection();
     public void display() {
    	 try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from student");
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery("select * from studentdetails");
			while(rs.next()&&rs1.next()) {
				System.out.println("Name: "+rs.getString(1));
				System.out.println("RollNo: "+rs.getString(2));
				System.out.println("DateOfBirth: "+rs.getString(3));
				System.out.println("ContactNumber: "+rs.getString(4));
				
				System.out.println("Year: "+rs1.getInt(2));
				System.out.println("Department: "+rs1.getString(3));
				System.out.println("Attendance: "+rs1.getInt(4));
				System.out.println("Grade: "+rs1.getString(5));
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	 
     }
}
