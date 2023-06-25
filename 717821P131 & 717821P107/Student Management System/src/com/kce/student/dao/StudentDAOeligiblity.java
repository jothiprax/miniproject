package com.kce.student.dao;
import com.kce.student.util.JDBCconnection;
import java.sql.*;
public class StudentDAOeligiblity {
        Connection con=JDBCconnection.getConnection();
        public void eligible(String s) {
        	PreparedStatement st;
			try {
				st = con.prepareStatement("select attendance from studentdetails where rollNo=?");
        	st.setString(1,s);
        	ResultSet rs=st.executeQuery();
        	if(rs.next()) {
        		if(rs.getInt(1)>80){
        			System.out.println("Eligible for Exam.");
        		}else {
        			System.out.println("Not Eligible for Exam.");
        		}
        	}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	
        }
}
