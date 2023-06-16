package com.kce.restaurant.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuMain {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/restaurant", "root", "Sujithra@53");
			Statement st = con.createStatement();
			ResultSet rs =st.executeQuery("SELECT * FROM restaurant.menuitem");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
			}
			con.close();
		}catch(SQLException e) {
			System.out.println(e);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
