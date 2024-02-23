package Employee;

import java.sql.*;

class Employee {
    private int id;
    private String name;
    private String designation;
    private double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary;
    }
}

class EmployeeDAO {
    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public void addEmployee(Employee employee) throws SQLException {
        String query = "INSERT INTO employees (id, name, designation, salary) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getDesignation());
            statement.setDouble(4, employee.getSalary());
            statement.executeUpdate();
        }
    }

    public Employee getEmployeeById(int id) throws SQLException {
        String query = "SELECT * FROM employees WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String designation = resultSet.getString("designation");
                double salary = resultSet.getDouble("salary");
                return new Employee(id, name, designation, salary);
            }
        }
        return null;
    }

    public void updateEmployee(Employee employee) throws SQLException {
        String query = "UPDATE employees SET name = ?, designation = ?, salary = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getDesignation());
            statement.setDouble(3, employee.getSalary());
            statement.setInt(4, employee.getId());
            statement.executeUpdate();
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        String query = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}

public class EmployeeManagementSystem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/employeedb";
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Establish the database connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Create EmployeeDAO instance
            EmployeeDAO employeeDAO = new EmployeeDAO(connection);

            // Add employee
            Employee newEmployee = new Employee(1, "John Doe", "Manager", 5000.0);
            employeeDAO.addEmployee(newEmployee);
            System.out.println("Employee added successfully!");

            // Get employee by ID
            Employee retrievedEmployee = employeeDAO.getEmployeeById(1);
            if (retrievedEmployee != null) {
                System.out.println("Retrieved Employee: " + retrievedEmployee);
            } else {
                System.out.println("Employee not found!");
            }

            // Update employee
            if (retrievedEmployee != null) {
                retrievedEmployee.setDesignation("Senior Manager");
                retrievedEmployee.setSalary(6000.0);
                employeeDAO.updateEmployee(retrievedEmployee);
                System.out.println("Employee updated successfully!");
            }

            // Delete employee
            employeeDAO.deleteEmployee(1);
            System.out.println("Employee deleted successfully!");

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
