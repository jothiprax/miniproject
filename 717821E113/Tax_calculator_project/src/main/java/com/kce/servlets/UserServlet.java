package com.kce.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("oldreg") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("oldreg");
			dispatcher.forward(request, response);
		} else if (request.getParameter("newreg") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("newreg");
			dispatcher.forward(request, response);
		}
		
	}
	
}



