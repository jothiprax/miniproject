package com.Fitness.service;
import java.sql.*;
 import com.Fitness.Dao.Bmicalculation;
import java.lang.Math.*;
import com.Fitness.bean.BMI;
import com.Fitness.util.DBUtil;
public class AddBMI {
	 public int add(BMI b) {
		   Connection con = null;
		   int k=0;
		  try {
			  Bmicalculation c=new Bmicalculation();
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
