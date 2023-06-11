package com.kce.vignesh.dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.kce.vignesh.bean.Subject;
import com.kce.vignesh.service.AddSubject;

/**
 * Servlet implementation class SubjectServlet
 */
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Subject sub=new Subject();
		sub.setSubId(request.getParameter("subId"));
		sub.setSubName(request.getParameter("subname"));
		sub.setRequiredHours(Integer.parseInt(request.getParameter("hoursRequired")));
		PrintWriter pr=response.getWriter();
		
		if(new AddSubject().add(sub)==1) {
			pr.write("Subject Added Successfully");
		}
	}

}
