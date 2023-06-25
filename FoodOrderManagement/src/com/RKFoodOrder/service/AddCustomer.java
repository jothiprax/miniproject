package com.RKFoodOrder.service;
import java.sql.*;
import com.RKFoodOrder.bean.Customer;
import com.RKFoodOrder.util.*;
public class AddCustomer {
   Connection con = null;
   int k =0;
   public int add(Customer c) {
	   try {
		   con = DBUtil.getConnection();
		   PreparedStatement ps = con.prepareStatement("INSERT INTO Customers values(?,?,?,?)");
		   ps.setString(1,c.getCustomer_name());
		   ps.setString(2,c.getCustomer_phonenum());
		   ps.setString(3,c.getCustomer_address());
		   ps.setString(4,c.getCustomer_mail());
		   k=ps.executeUpdate(); 
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	return k;
   }
}
