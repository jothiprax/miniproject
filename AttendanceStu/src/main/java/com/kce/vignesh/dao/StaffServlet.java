package com.kce.vignesh.dao;

import java.io.IOException;
import java.io.PrintWriter;

import com.kce.vignesh.bean.Staff;
import com.kce.vignesh.service.AddStaff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StaffServlet
 */
@WebServlet("/StaffServlet")
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Staff stud=new Staff();
		stud.setStaffId(request.getParameter("staffID"));
		stud.setName(request.getParameter("name"));
		stud.setDomain(request.getParameter("staffdomain"));
		stud.setUsername(request.getParameter("staffusername"));
		stud.setPassword(request.getParameter("staffpassword"));
		stud.setType("staff");
		PrintWriter pr=response.getWriter();
		
		if(new AddStaff().add(stud)==1) {
			pr.write("Staff Added Successfully");
		}else {
			pr.write("Couldn't Add Staff...");
		}
	}

}
