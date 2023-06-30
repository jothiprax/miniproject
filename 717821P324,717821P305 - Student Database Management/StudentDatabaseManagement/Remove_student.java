package StudentDatabaseManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Remove_student {
private int id;

public Remove_student(int id) {
	super();
	this.id = id;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
public void remove_student(Connection con) throws SQLException, StudentNotFoundException {
	String query="delete from student where id=?";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setInt(1, id);
	 int delete = ps.executeUpdate();
     if (delete > 0) {
         System.out.println("Student removed successfully.");
     } else {
			throw new StudentNotFoundException("Student ID is Not Found");

     }
}
}
