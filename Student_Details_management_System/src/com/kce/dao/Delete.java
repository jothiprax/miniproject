package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kce.bean.User;
import com.kce.util.SQLConnection;

public class Delete {
	public static PreparedStatement delete(User user) throws SQLException {
		 Connection connection=SQLConnection.connect();
		 String query="Delete from user where id=?;";
		 PreparedStatement pt=connection.prepareStatement(query);
		 pt.setInt(1, user.getId());
		 pt.execute();
		 return pt;
	 }
}
