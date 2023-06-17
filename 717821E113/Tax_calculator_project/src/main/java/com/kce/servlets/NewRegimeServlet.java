package com.kce.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kce.bean.NewRegimeTaxCalculator;
import com.kce.dao.NewRegimeDao;
import com.kce.dao.TaxCalculatorDao;

@WebServlet("/newreg")
public class NewRegimeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		String username =(String) session.getAttribute("username");
		String assessment_year = request.getParameter("assessment-year");
		String taxpayer = request.getParameter("taxpayer");
		String mfs=request.getParameter("male/female/seniorcitizen");
		String residential_status=request.getParameter("residential-status");
		String taxable_income=request.getParameter("taxable-income");
		NewRegimeTaxCalculator tc=new NewRegimeTaxCalculator(username,assessment_year,taxpayer,mfs,residential_status,taxable_income);
		TaxCalculatorDao.insertData(tc);
		NewRegimeDao.calculateNewRegimeTax(tc);
		response.sendRedirect("newregime.jsp");
	}
	
}



