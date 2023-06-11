package com.kce.vignesh.dao;

import java.io.IOException;
import java.io.PrintWriter;

import com.kce.vignesh.bean.Student;
import com.kce.vignesh.service.AddStudent;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student stud=new Student();
		stud.setStudId(request.getParameter("studID"));
		stud.setName(request.getParameter("name"));
		stud.setDeptId(request.getParameter("deptID"));
		stud.setUsername(request.getParameter("studusername"));
		stud.setPassword(request.getParameter("studpassword"));
		stud.setType("student");
		PrintWriter pr=response.getWriter();
		
		if(new AddStudent().add(stud)==1) {
			pr.write("Student Added Successfully");
		}
	}

}
