import java.sql.*;
import java.util.*;

public class StudentEnrollmentSystem {
    
    static final String DB_URL = "jdbc:mysql://localhost/university";
    static final String USER = "username";
    static final String PASS = "password";
    
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
Scanner scanner = new Scanner(System.in);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to database...");
            
            while(true) {
                System.out.println("1. Enroll Student");
                System.out.println("2. View Student Details");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch(choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.nextLine();
                    System.out.print("Enter semester: ");
                    String semester = scanner.nextLine();
                    
                    String sql = "INSERT INTO students (name, email) VALUES ('" + name + "', '" + email + "')";
                    stmt = conn.createStatement();
                    stmt.executeUpdate(sql);
                    System.out.println("Student enrolled successfully!");
                    sql = "SELECT student_id FROM students WHERE email = '" + email + "'";
                    ResultSet rs = stmt.executeQuery(sql);
                    rs.next();
                    int studentId = rs.getInt("student_id");
                    
                    sql = "SELECT * FROM courses WHERE course_code = '" + courseCode + "' AND semester = '" + semester + "'";
                    rs = stmt.executeQuery(sql);
                    if(rs.next()) {
                        int courseId = rs.getInt("course_id");
                        sql = "INSERT INTO enrollments (student_id, course_id) VALUES (" + studentId + ", " + courseId + ")";
                        stmt.executeUpdate(sql);
                        System.out.println("Enrollment successful!");
                    } else {
                        System.out.println("Course not found or not offered in this semester!");
                    }
                    break;
                case 2:
                    System.out.print("Enter student email: ");
                    email = scanner.nextLine();
                    sql = "SELECT * FROM students WHERE email = '" + email + "'";
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                    if(rs.next()) {
                        studentId = rs.getInt("student_id");
                        name = rs.getString("name");
                        System.out.println("Student ID: " + studentId);
                        System.out.println("Name: " + name);
                        System.out.println("Email: " + email);
                        sql = "SELECT courses.course_code, courses.course_name, enrollments.semester FROM enrollments JOIN courses ON enrollments.course_id = courses.course_id WHERE enrollments.student_id = " + studentId;
                        rs = stmt.executeQuery(sql);
                        System.out.println("Enrolled Courses:");
                        System.out.println("Course Code\tCourse Name\tSemester");
                        while(rs.next()) {
                            courseCode = rs.getString("course_code");
                            String courseName = rs.getString("course_name");
                            semester = rs.getString("semester");
                            System.out.println(courseCode + "\t" + courseName + "\t" + semester);
                        }
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    } catch(Exception e) {
        e.printStackTrace();
    } finally {
    	 try {
             if(stmt != null) {
                 stmt.close();
             }
             if(conn != null) {
                 conn.close();
             }
         } catch(Exception e) {
             e.printStackTrace();
         }
     }
 }
}
    }