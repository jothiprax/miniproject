package com.kce.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kce.bean.LoginAccess;
import com.kce.dao.SignupDao;
import com.kce.exceptions.*;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");

			if (username == null || username.isEmpty()) {
				throw new InvalidUsernameException("Invalid username");
			}

			if (password == null || password.isEmpty()) {
				throw new InvalidPasswordException("Invalid password");
			}
			if (password.equals(username)) {
				throw new UsernameInvalidPasswordException("User name cannot be your password!");
			}
			if (!(password.length()>8)) {
				throw new WeakPasswordException("Weak password. Password must contain at least 8 characters.");
			}

			if (email == null || email.isEmpty() || !email.contains("@")) {
				throw new InvalidEmailException("Invalid email");
			}
			LoginAccess user = new LoginAccess(username, email, password);
			SignupDao.insertData(user);
			response.sendRedirect("login.html");
		} catch (InvalidUsernameException | InvalidPasswordException | InvalidEmailException | WeakPasswordException | UsernameInvalidPasswordException e) {
			response.getWriter().println("Error: " + e.getMessage());
		}
		
	}

}

