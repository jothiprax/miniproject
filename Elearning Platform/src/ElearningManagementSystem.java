import java.sql.*;

public class ElearningManagementSystem {

    private static final String DB_URL = "jdbc:oracle://@localhost:1521:xe";
    private static final String DB_USER = "elearning";
    private static final String DB_PASSWORD = "18092003";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish database connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Create a statement object
            statement = connection.createStatement();

            // Create tables (if not exist)
            String createCourseTable = "CREATE TABLE IF NOT EXISTS course (id INT AUTO_INCREMENT, name VARCHAR(255), description VARCHAR(255), PRIMARY KEY (id))";
            String createStudentTable = "CREATE TABLE IF NOT EXISTS student (id INT AUTO_INCREMENT, name VARCHAR(255), email VARCHAR(255), PRIMARY KEY (id))";
            String createEnrollmentTable = "CREATE TABLE IF NOT EXISTS enrollment (course_id INT, student_id INT, PRIMARY KEY (course_id, student_id), FOREIGN KEY (course_id) REFERENCES course(id), FOREIGN KEY (student_id) REFERENCES student(id))";

            statement.executeUpdate(createCourseTable);
            statement.executeUpdate(createStudentTable);
            statement.executeUpdate(createEnrollmentTable);

            // Add sample data
            String insertCourse1 = "INSERT INTO course (name, description) VALUES ('Java Programming', 'Learn Java programming language')";
            String insertCourse2 = "INSERT INTO course (name, description) VALUES ('Web Development', 'Learn web development with HTML, CSS, and JavaScript')";

            statement.executeUpdate(insertCourse1);
            statement.executeUpdate(insertCourse2);

            String insertStudent1 = "INSERT INTO student (name, email) VALUES ('John Doe', 'john.doe@example.com')";
            String insertStudent2 = "INSERT INTO student (name, email) VALUES ('Jane Smith', 'jane.smith@example.com')";

            statement.executeUpdate(insertStudent1);
            statement.executeUpdate(insertStudent2);

            String enrollStudent1 = "INSERT INTO enrollment (course_id, student_id) VALUES (1, 1)";
            String enrollStudent2 = "INSERT INTO enrollment (course_id, student_id) VALUES (2, 2)";

            statement.executeUpdate(enrollStudent1);
            statement.executeUpdate(enrollStudent2);

            // Retrieve and display course information
            String query = "SELECT c.name, c.description, s.name, s.email " +
                    "FROM course c " +
                    "JOIN enrollment e ON c.id = e.course_id " +
                    "JOIN student s ON e.student_id = s.id";

            resultSet = statement.executeQuery(query);

            System.out.println("Course Information:");
            System.out.println("------------------------------");
            while (resultSet.next()) {
                String courseName = resultSet.getString(1);
                String courseDescription = resultSet.getString(2);
                String studentName = resultSet.getString(3);
                String studentEmail = resultSet.getString(4);
                System.out.println("Course Name: " + courseName);
                System.out.println("Description: " + courseDescription);
                System.out.println("Enrolled Student: " + studentName);
                System.out.println("Student Email: " + studentEmail);
                System.out.println("------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close result set, statement, and connection
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}