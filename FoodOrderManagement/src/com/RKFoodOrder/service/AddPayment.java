package com.RKFoodOrder.service;
import java.sql.*;

import com.RKFoodOrder.bean.Payment;
import com.RKFoodOrder.util.*;
public class AddPayment {
		   Connection con = null;
		   int k =0;
		   public int add(Payment p) {
			   try {
				   con = DBUtil.getConnection();
				   PreparedStatement ps = con.prepareStatement("INSERT INTO Payment values(?,?,?,?,?)");
				   ps.setString(1,p.getCustomer_name());
				   ps.setDouble(2,p.getPaid_amount());
				   ps.setString(3,p.getTransaction_id());
				   ps.setDate(4,p.getPaid_date());
				   ps.setTime(5,p.getPaid_time());
				   k=ps.executeUpdate(); 
			   }
			   catch(Exception e) {
				   e.printStackTrace();
			   }
			return k;
		   }
}
