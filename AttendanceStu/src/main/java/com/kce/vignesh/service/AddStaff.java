package com.kce.vignesh.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kce.vignesh.bean.Staff;
import com.kce.vignesh.util.DBUtil;

public class AddStaff {
	Connection con=null;
	int b=0;
	public int add(Staff st) {
		try {
			con = DBUtil.getDBConnection();
			PreparedStatement pslog = con.prepareStatement("insert into Login values (?,?,?)");
			PreparedStatement psstud=con.prepareStatement("insert into Staff values (?,?,?)");
			System.out.println("Inside AddStaff");
			psstud.setString(1, st.getStaffId());
			psstud.setString(2, st.getName());
			psstud.setString(3, st.getDomain());
			pslog.setString(1, st.getUsername());
			pslog.setString(2, st.getPassword());
			pslog.setString(3,st.getType());
			pslog.executeUpdate();
			b=psstud.executeUpdate();
			System.out.println(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}
