package com.Fitness.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Fitness.Dao.Bmicalculation;
import com.Fitness.bean.BMI;
import com.Fitness.util.DBUtil;

public class trainer {
	ResultSet rs=null;
	Connection con=null;
public void trainerselection(double bmi,String contact) throws SQLException {
	con = DBUtil.getConnection();
	if(bmi<=0.00184) {//weight gain
		String query ="SELECT Gender from members WHERE phone_no='"+contact+"'";
		 Statement st1=con.createStatement();
	     rs=st1.executeQuery(query);
	     while(rs.next()) {
	    	 String gender=rs.getString(1); 
	     if(gender=="F") {
	     
		String query1="SELECT trainee,fee from trainer where training='WEIGHT GAIN' AND trainer_gender='F'";
		rs=st1.executeQuery(query);
		while(rs.next()) {
			feecalculation f=new feecalculation();
			System.out.println("YOU ARE UNDER WEIGHT SO WE ARE SUGGESTING THE TRAINER...");
			System.out.println("Trainer: "+rs.getString(1));
			System.out.println("Fee: "+f.feecal(rs.getDouble(2)));
		}
	     }
	     else {
	    	 String query1="SELECT trainee,fee from trainer WHERE training='WEIGHT GAIN' AND trainer_gender='M'";
	    	 rs=st1.executeQuery(query);
	 		while(rs.next()) {
	 			feecalculation f=new feecalculation();
	 			System.out.println("YOU ARE UNDER WEIGHT SO WE ARE SUGGESTING THE TRAINER...");
	 			System.out.println("Trainer: "+rs.getString(1));
	 			System.out.println("Fee: "+f.feecal(rs.getDouble(2)));
	 		}
	     }
	     }
	     }else if(bmi>0.00184&&bmi<0.0025) {//muscel gain
	    	 String query ="SELECT Gender FROM members WHERE phone_no='"+contact+"'";
			 Statement st1=con.createStatement();
		     rs=st1.executeQuery(query);
		     while(rs.next()) {
		    	 String gender=rs.getString(1); 
		     if(gender=="F") {
		     
			String query1="SELECT trainee,fee from trainer where training='MUSCLE GAIN' AND trainer_gender='F'";
			rs=st1.executeQuery(query1);
			while(rs.next()) {
				feecalculation f=new feecalculation();
				System.out.println("YOU ARE NORMAL SO WE ARE SUGGESTING THE TRAINER...");
				System.out.println("Trainer: "+rs.getString(1));
				System.out.println("Fee: "+f.feecal(rs.getDouble(2)));
			}
		     }
		     else {
		    	 String query1="SELECT trainee,fee from trainer where training='MUSCLE GAIN' AND trainer_gender='M'";
		    	 rs=st1.executeQuery(query1);
		 		while(rs.next()) {
		 			feecalculation f=new feecalculation();
		 			System.out.println("YOU ARE NORMAL SO WE ARE SUGGESTING THE TRAINER...");
		 			System.out.println("Trainer: "+rs.getString(1));
		 			System.out.println("Fee: "+f.feecal(rs.getDouble(2)));
		 		}
		     }
		     }
	}else {String query ="SELECT Gender FROM members WHERE phone_no='"+contact+"'";
	 Statement st1=con.createStatement();
     rs=st1.executeQuery(query);
     while(rs.next()) {
    	 String gender=rs.getString(1); 
     if(gender=="F") {
     
	String query1="SELECT trainee,fee from trainer where training='WEIGHT LOSS' AND trainer_gender='F'";
	rs=st1.executeQuery(query1);
	while(rs.next()) {
		
		feecalculation f=new feecalculation();
		System.out.println("YOU ARE OVER WEIGHT SO WE ARE SUGGESTING THE TRAINER...");
		System.out.println("Trainer: "+rs.getString(1));
		System.out.println("Fee: "+f.feecal(rs.getDouble(2)));
	}
     }
     else {
    	 String query1="SELECT trainee,fee from trainer where training='WEIGHT LOSS' AND trainer_gender='M'";
    	 rs=st1.executeQuery(query1);
 		while(rs.next()) {
 			feecalculation f=new feecalculation();
 			System.out.println("YOU ARE OVER WEIGHT SO WE ARE SUGGESTING THE TRAINER...");
 			System.out.println("Trainer: "+rs.getString(1));
 			System.out.println("Fee: "+f.feecal(rs.getDouble(2)));
 		}
     }
     }
		
	}
	
}
}
