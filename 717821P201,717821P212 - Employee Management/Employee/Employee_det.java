package Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
class Employee {
    private int empId;
    private String name;
    private String designation;

    public Employee(int empId, String name, String designation) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
    }
    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String toString() {
        return "Employee ID: " + empId + "\nName: " + name + "\nDesignation: " + designation;
    }
}

class EmployeeManagementSystem {
    private Connection connection;
    private PreparedStatement addEmployeeStatement;
    private PreparedStatement removeEmployeeStatement;
    private PreparedStatement findEmployeeByIdStatement;
    private PreparedStatement getAllEmployeesStatement;

    public EmployeeManagementSystem() {
        try {
            String url = "jdbc:mysql://localhost:3306/mouli";
            String username = "root";
            String password = "1234";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database.");
            String addEmployeeQuery = "INSERT INTO employee (emp_id, name, designation) VALUES (?, ?, ?)";
            addEmployeeStatement = connection.prepareStatement(addEmployeeQuery);

            String removeEmployeeQuery = "DELETE FROM employee WHERE emp_id = ?";
            removeEmployeeStatement = connection.prepareStatement(removeEmployeeQuery);

            String findEmployeeByIdQuery = "SELECT * FROM employee WHERE emp_id = ?";
            findEmployeeByIdStatement = connection.prepareStatement(findEmployeeByIdQuery);

            String getAllEmployeesQuery = "SELECT * FROM employee";
            getAllEmployeesStatement = connection.prepareStatement(getAllEmployeesQuery);
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    public void addEmployee(Employee employee) {
        try {
            addEmployeeStatement.setInt(1, employee.getEmpId());
            addEmployeeStatement.setString(2, employee.getName());
            addEmployeeStatement.setString(3, employee.getDesignation());

            int rowsAffected = addEmployeeStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee added successfully.");
            } else {
                System.out.println("Failed to add employee.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeEmployee(int empId) {
        try {
            removeEmployeeStatement.setInt(1, empId);

            int rowsAffected = removeEmployeeStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee removed successfully.");
            } else {
                System.out.println("Failed to remove employee.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee findEmployeeById(int empId) {
        try {
            findEmployeeByIdStatement.setInt(1, empId);

            ResultSet resultSet = findEmployeeByIdStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String designation = resultSet.getString("designation");
                return new Employee(empId, name, designation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try {
            ResultSet resultSet = getAllEmployeesStatement.executeQuery();
            while (resultSet.next()) {
                int empId = resultSet.getInt("emp_id");
                String name = resultSet.getString("name");
                String designation = resultSet.getString("designation");
                Employee employee = new Employee(empId, name, designation);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
