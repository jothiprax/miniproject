package com.kce.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username="Deepak";
		String password="Deepak@8077";
		
		if(username.equals(request.getParameter("username"))&&password.equals(request.getParameter("password"))){
			response.sendRedirect("adminoptions.html"); 
		}else {
			response.sendRedirect("admin_login.html?error=1"); 
		}
		
	}
	
}
