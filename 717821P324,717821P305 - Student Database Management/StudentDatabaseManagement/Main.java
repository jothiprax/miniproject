package StudentDatabaseManagement;

import java.sql.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws SQLException, StudentNotFoundException {
		try (Scanner sc = new Scanner(System.in)) {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDatabase","root","Pari@123");
			while(true) {
				System.out.println("Student Management System");
			    System.out.println("1. Add Student");
			    System.out.println("2. Remove Student");
			    System.out.println("3. Display Student");
			    System.out.println("4. Update Student");
			    System.out.println("5. Display All Students");
			    System.out.println("6. Exit");
			    System.out.print("Enter your choice: ");
			    int id=0;
			    int n=sc.nextInt();
			    switch(n) {
			    case 1:
			    	System.out.println("Enter the Number of Students to be Added");
			    	int choice=sc.nextInt();
			    	while(choice>0) {
			    		System.out.println("Enter the Student_ID:");
			    		id=sc.nextInt();
			    		sc.nextLine();
			    		System.out.println("Enter the Student_Name:");
			    		String name=sc.nextLine(); 
			    		System.out.println("Enter the Student_Age:");
			    		int age=sc.nextInt();
			    		sc.nextLine();
			    		System.out.println("Enter the Student_Gender:");
			    		String gender=sc.nextLine();
			    		System.out.println("Enter the Student_Grade:");
			    		String grade=sc.nextLine();
			    		Add_student as=new Add_student(id,name,age,gender,grade);
			    		as.add_student(con);
			    		choice--;
			    		System.out.println("---------------Added Successfully--------------");
			    	}
			    	break;
			    case 2:
			    	System.out.println("Enter the Id of the Student to be Removed");
			    	id=sc.nextInt();
			    	Remove_student rs=new Remove_student(id);
			    	rs.remove_student(con);
			    	break;
			    case 3:
			    	System.out.println("Enter the Id of the Student to be Displayed");
			    	id=sc.nextInt();
			    	display_student ds=new display_student(id);
			    	ds.display(con);
			    	break;
			    case 4:
			    	System.out.println("Enter the Id of the Student to be Updated");
			    	id=sc.nextInt();
			    	Statement st=con.createStatement();
			    	ResultSet rt=st.executeQuery("select * from student where id="+id);
			    	if(rt.next()) {
			    	update_student us=new update_student();
			    	us.update(con, id);
			    	}
			    	else {
						throw new StudentNotFoundException("Student ID is Not Found");

			    	}
			    	break;
			    case 5:
			    	System.out.println("The Students Details:");
			    	String query="select * from student";
			    	PreparedStatement ps=con.prepareStatement(query);
			    	ResultSet r=ps.executeQuery();
			    	System.out.printf("%-20s%-20s%-20s%-20s%-20s\n","Student_ID","Student_Name","Student_Age","Student_Gender","Student_Grade");
			    	while(r.next()) {
			    		System.out.printf("%-20s%-20s%-20s%-20s%-20s\n",r.getInt(1),r.getString(2),r.getInt(3),r.getString(4),r.getString(5));
			    	}
			    	break;
			    case 6:
			    	System.out.println("-----------------Thank You-------------");
			    	return ;
			    }
			}
		}
	}
}
