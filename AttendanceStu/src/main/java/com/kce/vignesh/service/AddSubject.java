package com.kce.vignesh.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kce.vignesh.bean.Subject;
import com.kce.vignesh.util.DBUtil;


public class AddSubject {
	Connection con=null;
	int b=0;
	public int add(Subject sub) {
		try {
			con = DBUtil.getDBConnection();
			PreparedStatement ps = con.prepareStatement("insert into Subject values (?,?,?)");
			System.out.println("Inside AddSubject");
			ps.setString(1, sub.getSubId());
			ps.setString(2, sub.getSubName());
			ps.setInt(3, sub.getRequiredHours());
			b=ps.executeUpdate();
			System.out.println(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}
