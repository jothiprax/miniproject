package com.kce.service;

import com.kce.Dao.Empdao;
import com.kce.bean.Emp;
import com.kce.util.DBConnect;

public class editDataMain {

	public static void main(String[] args) {

		Emp em = new Emp();
		em.setId(101);
		em.setName("Jageswar");
		em.setAddress("Jharkhand");

		Empdao dao = new Empdao(DBConnect.getConn());
		boolean f = dao.editData(em);

		if (f) {
			System.out.println("Data Edit Sucessfully..");
		} else {
			System.out.println("Something wrong on server..");
		}

	}

}
