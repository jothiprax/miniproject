 package com.kce.vignesh.dao;
import com.kce.vignesh.bean.Login;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;
import com.kce.vignesh.util.*;
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String type=request.getParameter("usertype");
		Login log=new Login();
		Connection con=null;
		try {
			con = DBUtil.getDBConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(con==null) {
			System.out.println("error");
		}
		Statement st;
		ResultSet rs;
		try {
			 st = con.createStatement();
			 rs=st.executeQuery("Select * from Login where username like \'"+username+"\'");
			 if(!rs.next()) {
				 response.sendRedirect("Login.jsp");
			 }else {
				 log.setUsername(rs.getString(1));
				 log.setPassword(rs.getString(2));
				 log.setType(rs.getString(3));
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
		if(username.equals(log.getUsername()) && password.equals(log.getPassword()) && type.equals(log.getType())) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			if(type.equals("staff")) {
				response.sendRedirect("StaffMain.jsp");
			}else if(type.equals("student")){
				response.sendRedirect("StudentMain.jsp");
			}else if(type.equals("admin")){
				response.sendRedirect("Admin.jsp");
			}else {
				throw new IllegalLoginException("Illegal Login");
			}
		}}
		catch(Exception e) {
			response.sendRedirect("Login.jsp");
		}
			
		
	}

}
