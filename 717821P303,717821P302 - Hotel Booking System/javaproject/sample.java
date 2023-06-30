package javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class sample {
	private static final String URL = "jdbc:mysql://localhost:3306/hotel_reservation";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "aravindhan1272004";
    public static void main(String[] args) throws SQLException {
    	Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		Statement st=con.createStatement();
		for(int i=0;i<4;i++) {
			String name=sc.nextLine();
			int guests=sc.nextInt();
			sc.nextLine();
			String in=sc.nextLine();
			String out=sc.nextLine();
			int id=sc.nextInt();
			sc.nextLine();
			st.execute("INSERT INTO reservations (guest_name, num_of_guests, check_in_date, check_out_date, room_id) VALUES ('"+name+"',"+guests+",'"+in+"','"+out+"',"+id+")");
		}
	}
}
