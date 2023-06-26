package StudentDatabaseManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class update_student {
public void update(Connection con,int id) throws SQLException {
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter 1 to Update Age of the student");
		System.out.println("Enter 2 to Update Grade of the student");
		int choice=sc.nextInt();
		sc.nextLine();
		String query=null;
		switch(choice) {
		case 1:
			query="update student set age=? where id=?";
			System.out.println("Enter the Age: ");
			int age=sc.nextInt();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, age);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("--------------Age Updated Successfully----------");
			break;
		case 2:
			query="update student set grade=? where id=?";
			System.out.println("Enter the Grade: ");
			String grade=sc.nextLine();
			PreparedStatement p=con.prepareStatement(query);
			p.setString(1, grade);
			p.setInt(2, id);
			p.executeUpdate();
			System.out.println("--------------Grade Updated Successfully----------");
			break;
		}
	}
}

}
