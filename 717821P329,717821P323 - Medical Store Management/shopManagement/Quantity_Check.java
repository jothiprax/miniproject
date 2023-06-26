package shopManagement;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

public class Quantity_Check
{
  
	String med_name;
	int quantity;
  
	public Quantity_Check (String med_name, int quantity) 
		{
			this.med_name = med_name;
			this.quantity = quantity;  
		} 

	public String getMed_name ()
		{
			return med_name;
		}
  
	public void setMed_name (String med_name)
		{
			this.med_name = med_name; 
		} 

	public int getQuantity ()
		{
			return quantity;
		}
  
	public void setQuantity (int quantity)
		{
			this.quantity = quantity;
		} 

	public boolean check () 
		{
			String query ="select * from Available_stocks where product_name='" + med_name +"'&&Quantity>=" + quantity;
			Connection con;
			try
				{
					con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/javaproject", "root","Manick@14");
						Statement st = con.createStatement ();
						ResultSet rs = st.executeQuery (query);
						while (rs.next ())
							{  
								return true;
							}   
				}   
			catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace ();
				}  
			return false;
		}
}