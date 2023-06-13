package com.kce.vignesh.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kce.vignesh.bean.Student;
import com.kce.vignesh.util.DBUtil;
public class AddStudent {
	Connection con=null;
	int b=0;
	public int add(Student stud) {
		try {
			con = DBUtil.getDBConnection();
			PreparedStatement pslog = con.prepareStatement("insert into Login values (?,?,?)");
			PreparedStatement psstud=con.prepareStatement("insert into Student values (?,?,?,?)");
			System.out.println("Inside AddStudent");
			psstud.setString(1, stud.getStudId());
			psstud.setString(2, stud.getName());
			psstud.setString(3, stud.getDeptId());
			psstud.setInt(4, 0);
			pslog.setString(1, stud.getUsername());
			pslog.setString(2, stud.getPassword());
			pslog.setString(3,stud.getType());
			pslog.executeUpdate();
			b=psstud.executeUpdate();
			System.out.println(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}
