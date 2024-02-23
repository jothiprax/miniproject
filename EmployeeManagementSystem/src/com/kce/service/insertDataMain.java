package com.kce.service;


import java.util.Scanner;

import com.kce.Dao.Empdao;
import com.kce.bean.Emp;
import com.kce.util.DBConnect;

public class insertDataMain {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter EMP id");
            int id = sc.nextInt();
            System.out.println("Enter Name");
            String name = sc.next();
            System.out.println("Enter Address");
            String add = sc.next();

            System.out.println("Enter Salary");
            int sal = sc.nextInt();

            Emp em = new Emp();
            em.setId(id);
            em.setName(name);
            em.setAddress(add);
            em.setSalary(sal);

            Empdao dao = new Empdao(DBConnect.getConn());
            boolean f = dao.dataInsert(em);

            if (f) {
            	System.out.println("Data Insert Sucessfully..");
            } else {
            	System.out.println("Something went wrong on server..");
            }
        }

	}

}
