package com.Fitness.service;
import com.Fitness.util.DBUtil;

import java.sql.*;
import com.Fitness.bean.Member;
public class AddMember {
	int k=0;
   public int add(Member m) {
	   Connection con = null;
	  try {
		  con = DBUtil.getConnection();
		  PreparedStatement ps = con.prepareStatement("INSERT INTO Members VALUES(?,?,?,?)");
		  ps.setString(1, m.getName());
		  ps.setInt(2,m.getAge());
		  ps.setString(3,m.getGender());
		  ps.setString(4, m.getPhone_no());
		  k=ps.executeUpdate();
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	return k;
   }
}
