package com.kce.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.kce.dao.studentdetailsCRUD;
import com.kce.util.DBUtil;

public class Main {
static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		    System.out.println("if you are staff press '1' ");
		    System.out.println("if you are student press '2' ");
		    int press=sc.nextInt();
		    while(true) {
		    	if(press ==1) {
		    		
		    		System.out.println("---------------------------------------------------------");
		    	System.out.println("Enter the process");
		    	System.out.println("1.create student details");
		    	System.out.println("2.Insert student details");
		    	System.out.println("3.Update student details");
		    	System.out.println("4.Delete student details");
		    	System.out.println("5.Display student details");
		    	int choice =sc.nextInt();
		    	sc.nextLine();
		    	switch(choice) {
		    	case 1:
		    		System.out.println("enter the student details:");
		    		studentdetailsCRUD.create();
		    		break;
		    		
		    	case 2:
		    		studentdetailsCRUD.insert(choice);
		    		break;
		    	
		    	case 3:
		    		studentdetailsCRUD.update();
		    		break;
		    	case 4:
		    		studentdetailsCRUD.delete();
		    		break;
		    	case 5:
			    		studentdetailsCRUD.display();
			    		break;
		    	case 6:
		    		System.out.println("THANK YOU!!!");
		    		System.exit(0);
		    		break;
		    		
		    	default:
		    		System.out.println("Invalid choice!!");
		    		break;
		    	}
		    	System.out.println("---------------------------------");
	
		    	}
		  
		    	
       else if(press==2) {
		    		System.out.println("---------------------------------------------------------");
		    		Connection con =DBUtil.getConnection();
		    		PreparedStatement stmt=con.prepareStatement("select * from BUSPASS_INFO WHERE id=?");
					System.out.println("Enter id: ");
					int id=sc.nextInt();
				   stmt.setInt(1,id);
		    	}
		    	
		    }
		    }
	}
