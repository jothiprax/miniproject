package com.kce.hotel.dao;
import com.kce.hotel.bean.Customer;
import com.kce.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerDetails {
//method to insert customer details into the table
public void insertDetails() {
try {   
	
	int num,i;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of customers: ");
		 num=sc.nextInt();
		sc.nextLine();
	   Customer customer[]= new Customer [num];
	   for(i=0;i<num;i++) {
	 System.out.println("Enter Id : ");
	 String id=sc.nextLine();
	 System.out.println("Enter Name : ");
	 String name=sc.nextLine();
	 System.out.println("Enter ContactNo : ");
	 String contact=sc.nextLine();
	 System.out.println("Enter Gender : ");
	 String gender=sc.nextLine();
	   customer[i]=new Customer(id,name,contact,gender);
	   }
	  //Establishing connection
	   Connection con=DBUtil.getConnection();
	   PreparedStatement stmt=con.prepareStatement("insert into Customer values(?,?,?,?)");
	   for(i=0;i<num;i++) {
		   stmt.setString(1, customer[i].getCustomerId());
		   stmt.setString(2, customer[i].getCustomerName());
		   stmt.setString(3, customer[i].getContactNo());
		   stmt.setString(4, customer[i].getGender());
		   stmt.executeUpdate();
	   }
	   System.out.println("Details Inserted");
	   con.close();
}
catch(SQLException e) {
	e.printStackTrace();
}

}
	 //end of insert method

public void deleteDetails() {
	System.out.println("Enter the Id of the customer to be deleted:");
	try {
	Scanner sc=new Scanner(System.in);
    int no=sc.nextInt();	
	//Establishing connection
	   Connection con=DBUtil.getConnection();
 	   PreparedStatement stmt=con.prepareStatement("delete from Customer where CustomerId='"+no+"'");
	   stmt.executeUpdate();
	   System.out.println("Details Deleted Successfully");
	   displayCustomerDetails();
	   con.close();
}
	catch(SQLException e) {
		e.printStackTrace();
	}
	
}
//to display
public void displayCustomerDetails() {
	try {
		Connection con = DBUtil.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM Customer");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
		System.out.print(rs.getString(1) + " "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
	     System.out.println();		
	    }
		rs.close();
		con.close();
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
}
