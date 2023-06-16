package com.kce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kce.Bean.Details;
import com.kce.Bean.Reservation;
import com.kce.Util.DBUtil;


public class DAO {
	private static Connection con;
	private static PreparedStatement st;
	private static Statement stm;
	private static ResultSet rs;
	
	
	public static void insert(Reservation[] a) throws ClassNotFoundException,SQLException{
		con=DBUtil.getConnection();
		st=con.prepareStatement("INSERT INTO Reservation VALUES (?, ?, ?, ?)");
		for(int i=1;i<3;i++) {
			st.setInt(1,a[i].getId());
			st.setString(2,a[i].getName());
			st.setInt(3,a[i].getAge());
			st.setString(4,a[i].getGender());
			st.executeUpdate();
			}}
		
		public static void insert1(Details[] a) throws ClassNotFoundException,SQLException{
			
			for(int i=1;i<3;i++) {
			con=DBUtil.getConnection();
			st=con.prepareStatement("INSERT INTO details (seat,movie,type,rate) VALUES (?, ?, ?,?)");
		
				st.setInt(1,a[i].getSeat());
				st.setString(2,a[i].getMovie());
				st.setString(3,a[i].getType());
				st.setInt(4,a[i].getRate());
				st.executeUpdate();
				
			}}
			public static void display() throws ClassNotFoundException,SQLException{
				con=DBUtil.getConnection();
				stm=con.createStatement();
				System.out.println("    The reservation details are given below:");
				//Character.toString(128_512)
				System.out.println("----------------------------------------");
				System.out.println(" ID     NAME       AGE   GENDER ");
				rs=stm.executeQuery("select * from Reservation");
				
				while(rs.next()) {
					System.out.println(rs.getInt(1)+"     "+rs.getString(2)+"        "+rs.getInt(3)+"    "+rs.getString(4));
				}
				System.out.println("-----------------------------------------");
				System.out.println(" ");
				System.out.print("    Smoking n Drinking are prohibited inside the theatre,\n   ENJOY THE MOVIE ");
				System.out.println(Character.toString(128_512));
				System.out.println(" ");
				System.out.println("-----------------------------------------");
				System.out.println("SEATS    MOVIE   CLASS   RATE ");
				rs=stm.executeQuery("select * from details");
				while(rs.next()) {
					System.out.println(rs.getInt(1)+"       "+rs.getString(2)+"    "+rs.getString(3)+"     Rs/-"+rs.getInt(4));
				}
				System.out.println("------------------------------------------");
				
			}
			public static void delete() throws ClassNotFoundException,SQLException{
				con=DBUtil.getConnection();
				stm=con.createStatement();
				stm.executeUpdate("DELETE from reservation;");
				stm.executeUpdate("DELETE from details;");
				
			}

	
		}
	
	
