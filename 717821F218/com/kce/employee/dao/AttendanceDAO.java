package com.kce.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kce.employee.bean.Attendance;
import com.kce.employee.util.DBUtil;
import com.kce.employee.util.InvalidAttendanceException;
import com.kce.employee.util.InvalidEmployeeIDException;

public class AttendanceDAO {
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
	public void displayAttendance(int id) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from Attendance where empId = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getDouble(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void addAttendance(Attendance atten) {
		try {
			if (containsId(atten.getEmpID())) {
				if (atten.getAttendancePercent() < 0.0) {
					throw new InvalidAttendanceException();
				} else {
					PreparedStatement ps = con.prepareStatement("insert into attendance values(?,?,?,?)");
					ps.setInt(1, atten.getEmpID());
					ps.setDouble(2, atten.getAttendancePercent());
					ps.setInt(3, atten.getNoOfDaysLeaveTaken());
					ps.setInt(4, atten.getNoOfDaysLeaveLeft());
					ps.executeUpdate();
				}
			} else {
				throw new InvalidEmployeeIDException();
			}
		} catch (InvalidEmployeeIDException | InvalidAttendanceException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateAttendance(double atten, int id) {
		try {
			if (containsId(id)) {
				if (atten < 0.0) {
					throw new InvalidAttendanceException();
				} else {
					PreparedStatement ps = con
							.prepareStatement("update Attendance set attendancepercent = ?  where empID = ? ");
					ps.setDouble(1, atten);
					ps.setInt(2, id);
					ps.execute();
				}
			} else {
				throw new InvalidEmployeeIDException();
			}
		} catch (InvalidEmployeeIDException | InvalidAttendanceException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAttendance(int id) {
		try {
			if (containsId(id)) {
				PreparedStatement ps = con.prepareStatement("delete from Attendance  where empID = ? ");
				ps.setInt(1, id);
				ps.execute();
			} else {
				throw new InvalidEmployeeIDException();
			}
		} catch (InvalidEmployeeIDException | SQLException e) {
			e.printStackTrace();
		}
	}
}
