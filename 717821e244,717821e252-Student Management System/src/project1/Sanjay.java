package project1;
import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Sanjay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/School","root","sanjay#244");
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery("Select * from students");
		while(rs.next()) 
		{
		System.out.println(rs.getString(1)+ rs.getInt(2));
		}}
	catch(Exception e) {
		System.out.println(e);
	}
	}
}