package com.kce.student.dao;
import com.kce.student.util.*;
import com.kce.student.bean.StudentDetails;
import com.kce.student.util.JDBCconnection;
import java.sql.*;
public class StudentDAOSearch {
	Connection con=JDBCconnection.getConnection();
    public void display(String rollNo) {
        try {
        	if(rollNo.length()!=10) {
        		throw new StudentException("Invalid RollNo");
        	}
			PreparedStatement st=con.prepareStatement("select * from student where rollNo=?");
			st.setString(1, rollNo);
			ResultSet rs=st.executeQuery();
			String name=null;
			String rollno=null;
			String dob=null;
			String number=null;
			int count=0;
			if(rs.next()) {
				 name=rs.getString(1);
				 rollno=rs.getString(2);
				 dob=rs.getString(3);
				 number=rs.getString(4);
				 count++;
				
			}
			rs.close();
			PreparedStatement st1=con.prepareStatement("select * from studentdetails where rollNo=?");
			st1.setString(1, rollNo);
			ResultSet rs1=st1.executeQuery();
			int year=0;
			String dept=null;
			int attend=0;
			char grade='A';
			if(rs1.next()) {
				 year=rs1.getInt(2);
				 dept=rs1.getString(3);
				 attend=rs1.getInt(4);
				 grade=rs1.getString(5).charAt(0);
				
			}
			if(count>0) {
				StudentDetails s=new StudentDetails(name,rollno,dob,number,year,dept,attend,grade);
			    System.out.println(s);
			}
			if(count==0){
				System.out.println("Student does not exists.");
			}
		}
        catch (StudentException e) {
			System.out.println(e);
		}
        catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
