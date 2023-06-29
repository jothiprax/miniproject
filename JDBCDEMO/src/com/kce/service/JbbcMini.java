package com.kce.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import com.kce.bean.Student;
import com.kce.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.kce.dao.Dao;

public class JbbcMini {
	private static Connection con;
	private static PreparedStatement st;
	private static ResultSet rs;
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)) {
            System.out.println("Enter ID:");
            int id = sc.nextInt();
            System.out.println("Enter Grade");
            int gra = sc.nextInt();
            System.out.println("Enter ID:");
            int id1 = sc.nextInt();
            System.out.println("Enter Grade");
            int gra1 = sc.nextInt();
			Student s=new Student(id,gra);
			Student s1=new Student(id1,gra1);
			System.out.println("Enter deteleting ID:");
            int deleteid = sc.nextInt();
            Student s2=new Student(deleteid);
			Dao.Updatetable(s);
			Dao.Updatetable(s1);
			Dao.delete(s2);
		    Dao.display();
		    //Dao.createtable();
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
