package StudentDatabaseManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class display_student {
	private int id;
	 
	public display_student(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void display(Connection con) throws SQLException, StudentNotFoundException {
		String query="select * from student where id=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
		int id = rs.getInt(1);
        String name = rs.getString(2);
        int age = rs.getInt(3);
        String gender=rs.getString(4);
        String grade = rs.getString(5);

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: "+gender);
        System.out.println("Grade: " + grade);
		}
		else {
			throw new StudentNotFoundException("Student ID is Not Found");
		}
		
	}
}
