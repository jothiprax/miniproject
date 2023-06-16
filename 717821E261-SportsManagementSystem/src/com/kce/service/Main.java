package com.kce.service;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.kce.bean.SportsDetails;
import com.kce.dao.DButil;
import com.kce.util.User;
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	try (Scanner sc = new Scanner(System.in)) {
	    System.out.println("Admin -> Enter 1");
	     System.out.println("User -> Enter 2");
	     int a = sc.nextInt();
		String password = "vishal";
		if(a==1) {
			System.out.println("Enter your password:");
			String pass = sc.next();
			if(pass.equals(password)) {
			System.out.println("Admin login is sucessfull!");
			System.out.println("Enter 1 -> Insert");
			System.out.println("Enter 2-> Update");
			System.out.println("Enter 3-> Delete");
			System.out.println("Enter 4-> To view Registeration Details");
			int i = sc.nextInt();
			switch(i) {
			case 1:{
			SportsDetails sd = new SportsDetails();
			sd.Insert();
			System.out.println("Values is Inserted!");
			break;
			}
			case 2:{
				SportsDetails sd1 = new SportsDetails();
				 sd1.Update();
				 System.out.println("values is Updated!");
				 break;
			}
			case 3:{
				SportsDetails sd2 = new SportsDetails();
				 sd2.Delete();
				 System.out.println("value is Deleted!");
				 break;
			}
			case 4: {
				Connection con = DButil.getConnections();
				Statement stat = con.createStatement();
				ResultSet rs =  stat.executeQuery("select * from RegisterationDetails");
				while(rs.next()) {
					System.out.println("TeamName:"+rs.getString(1)+"--> "+"CaptainName:"+rs.getString(2)+"--> "+"CoachName:"
							+rs.getString(3)+"--> "+"ContactNumber:"+rs.getString(4)+"--> "+"Email:"+rs.getString(5)+"-->"
							+"Address:"+rs.getString(6));
				}
				break;
			}
			default:{
				System.out.println("Enter a valid Number!");
			}
			}
			}
			else {
				throw new InvalidPasswordException();
			}
			}
		else if(a==2) {
				System.out.println("Enter your emailId:");
				String email = sc.next();
				System.out.println("Enter your Password:");
				String password1 = sc.next();
			System.out.println("Login is Sucessfull!");
			User us = new User();
			us.Registeration();
		}
			
	else {
		System.out.println("Please enter a valid Number!");
	}
	}
		 catch(Exception e) {
			 System.out.println(e);
		 }
	}
}
