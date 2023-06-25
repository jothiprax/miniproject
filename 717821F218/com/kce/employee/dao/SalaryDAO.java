package com.kce.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kce.employee.bean.Salary;
import com.kce.employee.util.DBUtil;
import com.kce.employee.util.InvalidEmployeeIDException;
import com.kce.employee.util.InvalidSalaryException;

public class SalaryDAO {
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
			System.out.println(e);
		}

		return false;
	}

	public void addSalary(Salary sal) {
		try {
			if (containsId(sal.getEmpID())) {
				if (sal.getSalary() < 0.0) {
					throw new InvalidSalaryException();
				} else {
					PreparedStatement ps = con.prepareStatement("insert into salary values(?,?,?)");
					ps.setInt(1, sal.getEmpID());
					ps.setDouble(2, sal.getSalary());
					ps.setString(3, sal.getAccountNumber());
					ps.executeUpdate();
				}
			} else {
				throw new InvalidEmployeeIDException();
			}
		} catch (InvalidEmployeeIDException | InvalidSalaryException | SQLException e) {
			e.printStackTrace();
		}
	}
	public void displaySalary( int id) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from salary where empId = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getDouble(2)+" "+rs.getString(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateSalary(double salary, int id) {
		try {
			if (containsId(id)) {
				if (salary < 0.0) {
					throw new InvalidSalaryException();
				} else {
					PreparedStatement ps = con.prepareStatement("update salary set salary = ?  where empID = ? ");
					ps.setInt(2, id);
					ps.setDouble(1, salary);
					ps.executeUpdate();
				}
			} else {
				throw new InvalidEmployeeIDException();
			}
		} catch (InvalidEmployeeIDException | InvalidSalaryException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteSalary(int id) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from salary where empID = ? ");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
