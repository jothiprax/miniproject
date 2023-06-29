package com.kce.hotel.dao;
import com.kce.hotel.bean.Payment;
import com.kce.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class PaymentDetails {
	
	public void insertDetails() {
		PaymentDetails p1=new PaymentDetails();
		try {   
			int i=0;
				Scanner sc=new Scanner(System.in);
				System.out.println("Payment Details: ");
			   Payment payment[]= new Payment [10];
			 System.out.println("Enter Name : ");
			 String name=sc.nextLine();
			 System.out.println("Enter Payment Type : ");
			 String paymentType=sc.nextLine();
			 System.out.println("Enter PaymentStatus : ");
			 String status=sc.nextLine();
			 System.out.println("Enter Roomtype : ");
			 String Roomtype=sc.nextLine();
			   payment[i]=new Payment(name,paymentType,status,Roomtype);
			 
			  //Establishing connection
			   Connection con=DBUtil.getConnection();
			   PreparedStatement stmt=con.prepareStatement("insert into Payment values(?,?,?,?)");
				   stmt.setString(1, payment[i].getCustomerName());
				   stmt.setString(2, payment[i].getPaymentType());
				   stmt.setString(3, payment[i].getPaymentStatus());
				   stmt.setString(4, payment[i].getRoomtype());
				   stmt.executeUpdate();
				   stmt.close();
			   System.out.println("Details Inserted");
			   p1.displayPaymentDetails();
			   con.close();
			   
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		}
	//to delete
public void deleteDetails() {
		System.out.println("Enter the Customer name to be deleted:");
		try {
		Scanner sc=new Scanner(System.in);
	    String no=sc.nextLine();	
		//Establishing connection
		   Connection con=DBUtil.getConnection();
	 	   PreparedStatement stmt=con.prepareStatement("delete from Room where CustomerName='"+no+"'");
		   stmt.executeUpdate();
		   System.out.println("Details Deleted Successfully");
		   displayPaymentDetails();
		   stmt.close();
		   con.close();
	}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	//to display
public void displayPaymentDetails() {
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Payment");
			ResultSet rs = stmt.executeQuery();
			System.out.printf("%-15s%-15s%-15s%-15s","Customer Name","Payment Type","Payment Status","Room Type");
            System.out.println();
			while (rs.next()) {
			System.out.printf("%-15s%-15s%-15s%-15s",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
		     System.out.println();		
		    }
			rs.close();
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
