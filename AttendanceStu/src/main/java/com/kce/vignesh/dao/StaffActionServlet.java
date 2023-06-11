package com.kce.vignesh.dao;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StaffActionServlet
 */
public class StaffActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("act");
		if(action.equals("Take Attendance")) {
	            response.sendRedirect("takeattendance.jsp");
		}else if(action.equals("View Students")) {
			response.sendRedirect("viewstudents.jsp");
		}else {
			response.sendRedirect("viewReport.jsp");
		}
	}

}
