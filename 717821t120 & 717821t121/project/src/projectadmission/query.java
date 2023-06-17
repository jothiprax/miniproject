package projectadmission;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class query extends input{
	public void studentconnection() 
	{
		try {
		String url = "jdbc:mysql://localhost:3306/database";
		String username = "root";
		String password = "password@123";
		String query = "insert into student"+"(STUDENT_NAME, STUDENT_AGE, MOBILE_NUMBER, PLACE, MARK, COURSE_JOINING)"+"values(?,?,?,?,?,?)";
		Connection con =DriverManager.getConnection(url,username,password);
		PreparedStatement ps= con.prepareStatement(query);
		ps.setString(1,student_name);
		ps.setInt(2,student_age);
		ps.setInt(3,mobile_number);
		ps.setString(4,place);
		ps.setInt(5, mark);
		ps.setString(6,course_joinning);
		ps.executeUpdate();
	}
		catch(Exception e)
		{
			System.out.println(e);;
		}
}
	public void teacherconnection()
	{
		String url = "jdbc:mysql://localhost:3306/database";
		String username = "root";
		String password = "password@123";
		String query = "insert into teacher"+"(TEACHER_NAME, TEACHER_AGE, YEAR_OF_EXPERIENCE, COURSE_INTEREST)" +"values(?,?,?,?)";
		Connection con;
		try {
			con = DriverManager.getConnection(url,username,password);
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1,teacher_name);
			ps.setInt(2,teacher_age);
			ps.setInt(3,year_of_experiance);
			ps.setString(4,course_intrest);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
