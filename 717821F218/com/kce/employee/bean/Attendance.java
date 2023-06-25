package com.kce.employee.bean;

public class Attendance {
	private int empID;
	private double attendancePercent;
	private int noOfDaysLeaveTaken;
	private int noOfDaysLeaveLeft;

	public Attendance(int empID, double attendancePercent, int noOfDaysLeaveTaken, int noOfDaysLeaveLeft) {
		super();
		this.empID = empID;
		this.attendancePercent = attendancePercent;
		this.noOfDaysLeaveTaken = noOfDaysLeaveTaken;
		this.noOfDaysLeaveLeft = noOfDaysLeaveLeft;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public double getAttendancePercent() {
		return attendancePercent;
	}

	public void setAttendancePercent(double attendancePercent) {
		this.attendancePercent = attendancePercent;
	}

	public int getNoOfDaysLeaveTaken() {
		return noOfDaysLeaveTaken;
	}

	public void setNoOfDaysLeaveTaken(int noOfDaysLeaveTaken) {
		this.noOfDaysLeaveTaken = noOfDaysLeaveTaken;
	}

	public int getNoOfDaysLeaveLeft() {
		return noOfDaysLeaveLeft;
	}

	public void setNoOfDaysLeaveLeft(int noOfDaysLeaveLeft) {
		this.noOfDaysLeaveLeft = noOfDaysLeaveLeft;
	}

	@Override
	public String toString() {
		return "Attendance [empID=" + empID + ", attendancePercent=" + attendancePercent + ", noOfDaysLeaveTaken="
				+ noOfDaysLeaveTaken + ", noOfDaysLeaveLeft=" + noOfDaysLeaveLeft + "]";
	}

}
