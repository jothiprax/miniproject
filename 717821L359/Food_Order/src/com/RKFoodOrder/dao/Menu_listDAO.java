package com.RKFoodOrder.dao;

import java.sql.*;

import com.RKFoodOrder.util.DBUtil;

public class Menu_listDAO {
	Connection con = null;
	Statement st = null;
	public void Menu() {
	 try {
		  
			con = DBUtil.getConnection();
			st = con.createStatement();
			String query = "SELECT * FROM Food_items";
			ResultSet rs = st.executeQuery(query);
			 System.out.format("%-5s %-17s %-9s %-5s\n","Id","Food_Name","Quantity","Price");
		     while(rs.next()) {
		    	 System.out.format("%-5s %-17s %-9s %-5s\n",rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
		     }
		     rs.close();
	 }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
	}
}

