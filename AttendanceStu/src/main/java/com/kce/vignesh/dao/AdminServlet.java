package com.kce.vignesh.dao;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("Act");
		if(action.equals("Add Student")) {
			response.sendRedirect("addStudent.jsp");
		}else if(action.equals("Add Staff")) {
			response.sendRedirect("addStaff.jsp");
		}else {
			response.sendRedirect("addSubject.jsp");
		}
	}

}
