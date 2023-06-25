package com.kce.quiz.Dao;
import com.kce.quiz.Dao.*;
import com.kce.quiz.util.*;
import java.sql.*;


public class ParticipentUpdation {
	DataBaseConnection db = new DataBaseConnection();
	
	//INSERTING PARTICIPENT DETAILS INT TABLE 
	public void getDetails(String roll_no, String name, int quiz_id, int score) {
		Connection connection = db.createConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("insert into Participent_Details values(?,?,?,?)");
			ps.setString(1, roll_no);
			ps.setString(2, name);
			ps.setInt(3, quiz_id);
			ps.setInt(4, score);			
			int result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
	//UPDATING SCORE IN TABLE
	public void update(String roll_no,int quiz_id) {
	Connection connection = db.createConnection();
	DataBaseOperation dbo = new DataBaseOperation();
	
 	   try {
 		   int score = dbo.getScore();
		PreparedStatement ps = connection.prepareStatement("update Participent_Details set score = ? where Participent_Id = ? and Quiz_ID = ? ");
		ps.setInt(1, score);
		ps.setString(2,roll_no);
		ps.setInt(3,quiz_id);
		ps.executeUpdate();
		System.err.println("You Score is "+score );
	
	} catch (SQLException e) {
		System.out.println(e);
	}
	}
	
	//DISPLAYING DETAILS
public void Display() {
    	
    	Connection cnx = db.createConnection();
    	try {
			PreparedStatement ps = cnx.prepareStatement("select * from Participent_Details order by quiz_id");
			ResultSet rs = ps.executeQuery();
			System.out.printf("          %10s%20s%20s%10s\n","Quiz_ID","Participent_Id","Participent_Name","Score");
			while(rs.next()) {
				System.out.printf("          %10s%2s0s%20s%10s\n",rs.getInt(3),rs.getString(1),rs.getString(2),rs.getInt(4));
			}
		} catch (SQLException e) {
			System.out.print(e);
		}	
    }
}
