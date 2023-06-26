package shopManagement;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Random;

public class Customer_Details
{ 
	
	String customer_name;
	String phone_number;
	String med_name; 
	double purchased_amount;
	int bill_no;
	public Customer_Details (int bill_no,String customer_name, String phone_number,String med_name, double purchased_amount)
		{  
			super ();
			this.bill_no=bill_no;
			this.customer_name = customer_name;
			this.phone_number = phone_number;
			this.med_name = med_name; 
			this.purchased_amount = purchased_amount;
		} 
	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getMed_name() {
		return med_name;
	}

	public void setMed_name(String med_name) {
		this.med_name = med_name;
	}

	public double getPurchased_amount() {
		return purchased_amount;
	}

	public void setPurchased_amount(double purchased_amount) {
		this.purchased_amount = purchased_amount;
	}

	public void update_details () throws SQLException
		{
			Connection con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/javaproject","root", "Manick@14"); 
			Statement st = con.createStatement ();  
			String query ="insert into Customer_details values(" + bill_no + ",'" +customer_name + "','" + phone_number + "','" + med_name + "'," +purchased_amount + ")";
			st.execute (query);
		} 
} 
