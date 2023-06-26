package com.kce.service;

import com.kce.Dao.Empdao;
import com.kce.util.DBConnect;

public class deleteMain {
	public static void main(String[] args) {
		Empdao dao = new Empdao(DBConnect.getConn());
		boolean f = dao.deleteData(101);
		if (f) {
			System.out.println("Data Delete Sucessfully..");
		} else {
			System.out.println("Something wrong on server..");
		}
	}

}
