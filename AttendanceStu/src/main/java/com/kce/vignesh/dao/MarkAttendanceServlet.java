package com.kce.vignesh.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import com.kce.vignesh.util.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MarkAttendanceServlet
 */
public class MarkAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] action = request.getParameterValues("pastatus");
		PrintWriter e = response.getWriter();
		int b=0;
		try {
			Connection con=DBUtil.getDBConnection();
			Statement st=con.createStatement();
			for(String s:action) {
				String query = "update student set hoursAttended = hoursAttended + 1 where name like \'"+s+"\'";
				b+=st.executeUpdate(query);
			}
			if(b>0) {
				e.print("Marked Attendance Successfully");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
