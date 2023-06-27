package Employee;

import java.util.List;

public class Main {
        public static void main(String[] args) {
        EmployeeManagementSystem empManagementSystem = new EmployeeManagementSystem();
        Employee emp1 = new Employee(1, "John Doe", "Manager");
        empManagementSystem.addEmployee(emp1);

        Employee emp2 = new Employee(2, "Jane Smith", "Developer");
        empManagementSystem.addEmployee(emp2);
        int empIdToFind = 2;
        Employee foundEmployee = empManagementSystem.findEmployeeById(empIdToFind);
        if (foundEmployee != null) {
            System.out.println("Employee found:\n" + foundEmployee);
        } else {
            System.out.println("Employee with ID " + empIdToFind + " not found.");
        }
        Employee empToUpdate = empManagementSystem.findEmployeeById(1);
        if (empToUpdate != null) {
            empToUpdate.setDesignation("Senior Manager");
            System.out.println("Employee designation updated successfully.");
        }
        int empIdToRemove = 2;
        empManagementSystem.removeEmployee(empIdToRemove);
        List<Employee> allEmployees = empManagementSystem.getAllEmployees();
        System.out.println("All Employees:");
        for (Employee employee : allEmployees) {
            System.out.println(employee);
        }
    }
}
