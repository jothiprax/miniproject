package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kce.util.SQLConnection;

public class Display {
	public static PreparedStatement display() throws SQLException {
		Connection connection = SQLConnection.connect();
		String query = "Select * from user";
		PreparedStatement pt = connection.prepareStatement(query);
		return pt;
	}

	public static PreparedStatement displayStudents() throws SQLException {
		Connection connection = SQLConnection.connect();
		String query = "Select * from students";
		PreparedStatement pt = connection.prepareStatement(query);
		return pt;
	}

	public static PreparedStatement displayStudents(String uname) throws SQLException {
		Connection connection = SQLConnection.connect();
		String query = "Select * from students where roll_no=?";
		PreparedStatement pt = connection.prepareStatement(query);
		pt.setString(1, uname);
		pt.execute();
		return pt;
	}
	public static boolean Check(String name, String pass) throws SQLException {
		Statement st = SQLConnection.connect().createStatement();
		ResultSet rs = st.executeQuery("select * from Students_login where id='" + name + "' and password='" + pass + "'");
		int flag=0;
		while(rs.next()) {
			if ((rs.getString(1).equalsIgnoreCase(name) && ((rs.getString(2))+"").trim().equalsIgnoreCase(pass))) {
				flag=1;
			}
		}
		if(flag>=1) {
			return true;
		}
		else
			return false;
}
}
