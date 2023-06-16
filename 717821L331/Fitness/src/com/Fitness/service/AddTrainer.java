package com.Fitness.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.Fitness.Dao.Bmicalculation;
import com.Fitness.bean.BMI;
import com.Fitness.util.DBUtil;

public class AddTrainer {
	public int add(BMI b) {
		Bmicalculation c=new Bmicalculation();
		   Connection con = null;
		   int k=0;
		  try {
			  con = DBUtil.getConnection();
			  PreparedStatement ps = con.prepareStatement("INSERT INTO bmi( Member_name,phone_no,Height,Weight,BMI) VALUES(?,?,?,?,?)");
			  ps.setString(1, b.getName());
			  ps.setString(2,b.getPhone_no());
			  ps.setDouble(3,b.getHeight());
			  ps.setDouble(4, b.getWeight());
			  ps.setDouble(5,c.bmi(b.getHeight(), b.getWeight()));
			  k=ps.executeUpdate();
			  if(k!=0) {
				  System.out.println("INSERTED.....");
			  }
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		return k;
	   }
}
