package com.RKFoodOrder.service;
import java.sql.*;

import com.RKFoodOrder.bean.Ordered_list;
import com.RKFoodOrder.util.*;
public class AddOrder {
		   Connection con = null;
		   public void add(Ordered_list o) {
			   try { 
				   con = DBUtil.getConnection();
				   PreparedStatement ps = con.prepareStatement("INSERT INTO Menu values(?,?,?,?,?)");
				   ps.setInt(1,o.getSeraial_no());
				   ps.setInt(2,o.getId());
				   ps.setString(3,o.getDish_name());
				   ps.setInt(4,o.getQuantity());
				   ps.setDouble(5,o.getPrice());
				  ps.execute(); 
			   }
			   catch(Exception e) {
				   e.printStackTrace();
			   }
		   }
		   

}
