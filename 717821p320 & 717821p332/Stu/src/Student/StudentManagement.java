import java.sql.*;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

class StudentDAO {
    private Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }

    public void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO students (id, name, age, grade) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setInt(3, student.getAge());
            statement.setString(4, student.getGrade());
            statement.executeUpdate();
        }
    }

    public Student getStudentById(int id) throws SQLException {
        String query = "SELECT * FROM students WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String grade = resultSet.getString("grade");
                return new Student(id, name, age, grade);
            }
        }
        return null;
    }

    public void updateStudent(Student student) throws SQLException {
        String query = "UPDATE students SET name = ?, age = ?, grade = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getGrade());
            statement.setInt(4, student.getId());
            statement.executeUpdate();
        }
    }

    public void deleteStudent(int id) throws SQLException {
        String query = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}

public class StudentManagementSystem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Establish the database connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Create StudentDAO instance
            StudentDAO studentDAO = new StudentDAO(connection);

            // Create a Scanner object for user input
            Scanner scanner = new Scanner(System.in);

            // Display menu options
            while (true) {
                System.out.println("\n---- Student Management System ----");
                System.out.println("1. Add Student");
                System.out.println("2. Get Student by ID");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        System.out.print("Enter student grade: ");
                        String grade = scanner.nextLine();
                        Student newStudent = new Student(id, name, age, grade);
                        studentDAO.addStudent(newStudent);
                        System.out.println("Student added successfully!");
                        break;
                    case 2:
                        System.out.print("Enter student ID: ");
                        int searchId = scanner.nextInt();
                        Student retrievedStudent = studentDAO.getStudentById(searchId);
                        if (retrievedStudent != null) {
                            System.out.println("Retrieved Student: " + retrievedStudent);
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;
                    case 3:
                        System.out.print("Enter student ID: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        System.out.print("Enter updated student name: ");
                        String updatedName = scanner.nextLine();
                        System.out.print("Enter updated student age: ");
                        int updatedAge = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        System.out.print("Enter updated student grade: ");
                        String updatedGrade = scanner.nextLine();
                        Student updatedStudent = new Student(updateId, updatedName, updatedAge, updatedGrade);
                        studentDAO.updateStudent(updatedStudent);
                        System.out.println("Student updated successfully!");
                        break;
                    case 4:
                        System.out.print("Enter student ID: ");
                        int deleteId = scanner.nextInt();
                        studentDAO.deleteStudent(deleteId);
                        System.out.println("Student deleted successfully!");
                        break;
                    case 5:
                        System.out.println("Exiting the program...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
