package com.RKFoodOrder.dao;
import com.RKFoodOrder.util.CustomerNotFoundException;
import com.RKFoodOrder.util.DBUtil;

import java.sql.*;
public class CustomerDAO {
	Connection con = null;
    Statement st = null;
  public void find_customer(String num) {
	  int k=0;
	  try {
		  
		con = DBUtil.getConnection();
		st = con.createStatement();
		String query = "SELECT * FROM Customers";
		ResultSet rs = st.executeQuery(query);
		String name = null;
		while(rs.next()) {
			if(rs.getString(2).equals(num)) {
				k=1;
				name ="Welcome Mr/Mrs "+rs.getString(1);
				System.out.print(name);
			}
			
		}
		if(name==null) 
		{
			  throw new CustomerNotFoundException("Customer not found");
			 }
	  }
		catch(CustomerNotFoundException e) {
			   System.out.println(e.getMessage());
		 }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  
		
	  
  }
}



