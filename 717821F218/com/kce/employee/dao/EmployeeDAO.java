package com.kce.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kce.employee.bean.Employee;
import com.kce.employee.util.DBUtil;
import com.kce.employee.util.InvalidEmployeeIDException;

public class EmployeeDAO {
	static Connection con = DBUtil.getDBConnection();

	public static boolean containsId(int id) throws InvalidEmployeeIDException {
		if (id < 0)
			throw new InvalidEmployeeIDException();
		ResultSet rs;
		try {
			rs = con.prepareStatement("select * from employee").executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == id) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void addEmployee(Employee emp) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?,?)");
			if (emp.getEmpID() < 0)
				throw new InvalidEmployeeIDException();
			ps.setInt(1, emp.getEmpID());
			ps.setString(2, emp.getEmpName());
			ps.setString(3, emp.getEmpEmail());
			ps.setString(4, emp.getMobileNumber());
			ps.setString(5, emp.getEmpCity());
			ps.executeUpdate();
			System.out.println("Employee Record Inserted Succesfully.");
		} catch (SQLException | InvalidEmployeeIDException e) {
			e.printStackTrace();
		}
	}

	public void deleteEmployee(int empID) {
		try {
			if (empID < 0)
				throw new InvalidEmployeeIDException();
			if (!(containsId(empID)))
				throw new InvalidEmployeeIDException();
			PreparedStatement ps = con.prepareStatement("delete from employee where empID = ?");
			ps.setInt(1, empID);
			ps.executeUpdate();
			System.out.println("Employee Deleted Succecfully");
		} catch (InvalidEmployeeIDException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void displayEmployee(int empID) {
		try {
			if (containsId(empID)) {
				ResultSet rs = con.prepareStatement("select * from employee").executeQuery();
				boolean flag = true;
				while (rs.next()) {
					if (rs.getInt(1) == empID) {
						flag = false;
						Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5));
						System.out.println(emp);
					}
				}
				if (flag)
					System.out.println("Employee Not Found.");
			} else {
				throw new InvalidEmployeeIDException();
			}
		} catch (InvalidEmployeeIDException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void displayAllEmployees() {
		List<Employee> emp = new ArrayList<>();
		try {
			ResultSet rs = con.prepareStatement("select * from employee").executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				emp.add(employee);
			}
			System.out.println("Employees Details:");
			for (Employee e : emp) {
				System.out.println(e);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployee(int empID, int choice, Object value) {
		PreparedStatement ps;
		try {
			if (containsId(empID)) {
				switch (choice) {
				case 1:
					ps = con.prepareStatement("update employee set empID = ? where empID = ?");
					ps.setInt(1, (int) value);
					ps.setInt(2, empID);
					ps.executeUpdate();
					System.out.println("Table Updated Successfully.");
					break;
				case 2:
					ps = con.prepareStatement("update employee set empName = ? where empID = ?");
					ps.setString(1, (String) value);
					ps.setInt(2, empID);
					ps.executeUpdate();
					System.out.println("Table Updated Successfully.");
					break;
				case 3:
					ps = con.prepareStatement("update employee set empEmail = ? where empID = ?");
					ps.setString(1, (String) value);
					ps.setInt(2, empID);
					ps.executeUpdate();
					System.out.println("Table Updated Successfully.");
					break;
				case 4:
					ps = con.prepareStatement("update employee set mobileNumber = ? where empID = ?");
					ps.setString(1, (String) value);
					ps.setInt(2, empID);
					ps.executeUpdate();
					System.out.println("Table Updated Successfully.");
					break;
				case 5:
					ps = con.prepareStatement("update employee set empCity = ? where empID = ?");
					ps.setString(1, (String) value);
					ps.setInt(2, empID);
					ps.executeUpdate();
					System.out.println("Table Updated Successfully.");
					break;
				default:
					System.out.println("Invalid Choice");
				}
			} else {
				throw new InvalidEmployeeIDException();
			}
		} catch (InvalidEmployeeIDException | SQLException e) {
			e.printStackTrace();
		}
	}
}
