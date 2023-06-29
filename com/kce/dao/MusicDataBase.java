package com.kce.dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;
	import java.sql.SQLException;
	import java.sql.Statement;

import com.kce.service.MusicStore;
import com.kce.util.UtilConnection;
	
	 public class MusicDataBase {
		private static Connection con;
		private static Statement stmt;
		private static PreparedStatement pstmt;
		private static ResultSet rs;

		/*public static void Table() {
			try{
				con = UtilConnection.getConnection();
				stmt = con.createStatement();
				stmt.executeQuery("create table Music(productid number(5), genre varchar(50),artist varchar(25), language varchar2(25)),price number(5),quantity number(5),releaseDate varchar(20)");
				System.out.println("table created successfully!");
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();;
			}
		}*/

		public void insertData() {
			try {
				con = UtilConnection.getConnection();
				stmt = con.createStatement();
				stmt.executeUpdate("insert into Music  values(101,'Devotional','Chitra', 'Tamil',450.0,90,'11/10/2003')");
				stmt.executeUpdate("insert into Music  values(102,'Horror','RobZoombie', 'English',400.0,78,'11/9/2020')");
				stmt.executeUpdate("insert into Music  values(103,'Rock', 'English','DavidBowie',500.0,70,'15/1/2012')");
				stmt.executeUpdate("insert into Music  values(104,'Jpop', 'Japanese','FuziKaze',430.0,290,'3/8/2022')");
				stmt.executeUpdate("insert into Music  values(105,'Kpop', 'Korean','BTS Singers',360.0,200,'12/8/2016')");
				stmt.executeUpdate("insert into Music  values(106,'FolkMusic','Illayaraja','Tamil',350.0,40,'22/06/2007')");
				stmt.executeUpdate("insert into Music  values(107,'Jazz', 'German','TomGaebel',150.0,39,'28/07/2013')");
				stmt.executeUpdate("insert into Music  values(108,'ChildrenRhymes','MerryJohn', 'English',300.0,49,'6/11/2008')");
				stmt.executeUpdate("insert into Music  values(109,'Disco','English','BeeGees',750.0,88,'30/8/2006')");
				stmt.executeUpdate("insert into Music  values(110,'Hiphop', 'Tamil','Hiphop Aadhi',370.0,20,'22/2/2005')");
				stmt.executeUpdate("insert into Music  values(111,'ClassicalMusic','SPB', 'Tamil',300.0,50,'30/7/2023')");
				stmt.executeUpdate("insert into Music  values(112,'VocalMusic','Ed Sheeran' ,'English',490.0,60,'11/9/2003')");
				stmt.executeUpdate("insert into Music  values(113,'Melody','YuvanShankarRaja', 'Tamil',800.0,50,'21/06/2004')");
				stmt.executeUpdate("insert into Music  values(114,'Melody','AR.Rahman' ,'Tamil',650.0,50,'7/7/2003')");
				System.out.println("Values Inserted");
				display();
				//con.close();
			} catch (SQLException ae) {
				ae.printStackTrace();
			}
		}

		public  void insertNew(int productid, String genre, String artist,String language, double price,int quantity,String releasedDate){
			try {
				con = UtilConnection.getConnection();
				pstmt = con.prepareStatement("insert into Music values(?,?,?,?,?,?,?)");
				pstmt.setInt(1, productid);
				pstmt.setString(2, genre);
				pstmt.setString(3, artist);
				pstmt.setString(4, language);
				pstmt.setDouble(5, price);
				pstmt.setInt(6,quantity);
				pstmt.setString(7,releasedDate);
				pstmt.executeUpdate();
				
				//display();
				//con.close();
			} catch (SQLException re) {
				System.out.println(re);
			}
		}
public  void displayByArtist(MusicStore m) {
			try {
				con = UtilConnection.getConnection();
				pstmt = con.prepareStatement("select * from Music where artist=?");
				pstmt.setString(1, m.getArtist());
				rs=pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)+ " " + rs.getDouble(5) + " " + rs.getInt(6) + " " + rs.getString(7));
				}
				//con.close();
			} catch (SQLException le) {
				System.out.println(le);
			}
		}


		private String getArtist() {
	// TODO Auto-generated method stub
	return null;
}

		public  void display() {
			try {
				con = UtilConnection.getConnection();
				pstmt = con.prepareStatement("select * from Music");
				rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)+ " " + rs.getDouble(5) + " " + rs.getInt(6) + " " + rs.getString(7));
				}
				ResultSetMetaData rsmd =rs.getMetaData();
				//con.close();
			} catch (SQLException he) {
				System.out.println(he);
			}
		}

	}


