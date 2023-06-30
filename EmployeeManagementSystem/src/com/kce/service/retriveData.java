package com.kce.service;


import java.util.List;

import com.kce.Dao.Empdao;
import com.kce.bean.Emp;
import com.kce.util.DBConnect;

public class retriveData {
	public static void main(String[] args) {
		Empdao dao = new Empdao(DBConnect.getConn());
		/*
		 * Emp em = dao.getInfo(4);
		 * 
		 * if (em==null) { System.out.println("User Not Available.."); } else {
		 * System.out.println("Name=" + em.getName()); System.out.println("Address=" +
		 * em.getAddress()); System.out.println("Salary=" + em.getSalary()); }
		 */

		List<Emp> list = dao.getAllData();

		for (Emp e : list) 
		{
			System.out.println("Name=" + e.getName());
			System.out.println("Address=" + e.getAddress());
			System.out.println("Salary=" + e.getSalary());
			System.out.println("------------------------------");
		}

	}

}
