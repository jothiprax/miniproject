package com.Fitness.Dao;
import com.Fitness.bean.*;
import com.Fitness.service.*;
import com.Fitness.util.DBUtil;
import java.util.*;
import java.sql.*;
public class update {
  public void updation(String contact) throws SQLException {
	  Connection con = null;
	  Scanner sc=new Scanner(System.in);
	   int k=0;
	  
		  Bmicalculation c=new Bmicalculation();
		  con = DBUtil.getConnection();
		  PreparedStatement ps = con.prepareStatement("UPDATE bmi SET Weight = ?,Height = ? ,BMI = ? WHERE phone_no = ?");
		System.out.println("Enter weight:");
		double weight=sc.nextDouble();
		System.out.println("Enter height:");
		double height=sc.nextDouble();
		double bmi=c.bmi(height, weight);
		 ps.setDouble(1, weight);
		  ps.setDouble(2,height);
		  ps.setDouble(3,bmi);
		  ps.setString(4,contact);
		  k=ps.executeUpdate();
		  
}
}