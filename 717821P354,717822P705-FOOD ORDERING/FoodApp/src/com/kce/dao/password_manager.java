package com.kce.dao;
import com.kce.util.*;
import java.util.*;
import java.sql.*;
public class password_manager  {
	public static boolean ManagerPasswordCheck(int password) throws Exception {
	
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/pasword","root","Royalenfield9442.");
PreparedStatement stmt=  con.prepareStatement("select * from manager");
ResultSet rs= stmt.executeQuery();
while(rs.next()) {
if(password!=rs.getInt(1))
{
	throw new PasswordException();
}
}
return true;
}
}
