package com.kce.student.dao;
import com.kce.student.bean.StudentDetails;
import com.kce.student.util.JDBCconnection;
import com.kce.student.util.*;
import java.sql.*;
public class StudentDAOinsert {
     Connection con=JDBCconnection.getConnection();
     public void insert(StudentDetails s) {
    	 try {
    		Statement pt=con.createStatement();
    	    int c=0;
    	    ResultSet count=pt.executeQuery("select * from student");
    	    while(count.next()) {
    	    	if(count.getString(2).equals(s.getRollNo())) {
    	    		c++;
    	    		break;
    	    	}
    	    }
    	    if(c==1) {
    	    	System.out.println("Student details already exists.");
    	    }
    	    else {
			PreparedStatement p=con.prepareStatement("insert into student values(?,?,?,?)");
			PreparedStatement p1=con.prepareStatement("insert into studentdetails values(?,?,?,?,?)");
			p.setString(1,s.getName());
			if(s.getRollNo().length()!=10) {
				throw new StudentException("Invalid RollNo");
			}
			p.setString(2, s.getRollNo());
			p.setString(3, s.getDateOfBirth());
			if(s.getContactNumber().length()!=10) {
				throw new StudentException("Invalid Number");
			}
			p.setString(4, s.getContactNumber());
			if(s.getYear()>4||s.getYear()<=0) {
				throw new StudentException("Invalid Year");
			}
			p1.setString(1, s.getName());
			p1.setInt(2, s.getYear());
			p1.setString(3, s.getDepartment());
			p1.setInt(4, s.getAttendance());
			p1.setString(5, String.valueOf(s.getGrade()));
			p.executeUpdate();
			p1.executeUpdate();
			System.out.println("Student details updated successfully");
    	    }
		}catch (StudentException e) {
			System.out.println(e);
		} 
    	 catch (SQLException e) {
			e.printStackTrace();
		}
    	 
     }
}
