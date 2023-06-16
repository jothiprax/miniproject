package COLAB;

import java.sql.*;
public class Main {
	private static final String url = "jdbc:mysql://localhost:3306/FLIGHTRESERVATION";
	private static final String userName = "root";
	private static final String passWord = "Lalidhesh24@";
	
	public static Connection getConnection() throws SQLException{
		return  DriverManager.getConnection(url,userName,passWord);
	}
}