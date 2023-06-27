package com.kce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.kce.bean.User;
import com.kce.util.SQLConnection;

public class Insertvalues {
 public static PreparedStatement insert(User user) throws SQLException {
	 Connection connection=SQLConnection.connect();
	 String query="insert into user values(?,?,?)";
	 PreparedStatement pt=connection.prepareStatement(query);
	 pt.setInt(1, user.getId());
	 pt.setString(2,user.getUname() );
	 pt.setString(3, user.getPassword());
	 pt.execute();
	 return pt;
 }
}
