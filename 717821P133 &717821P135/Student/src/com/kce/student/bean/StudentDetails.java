package com.kce.student.bean;

public class StudentDetails extends Student{
	private int year;
    private String department;
    private int attendance;
    private char grade;
	public StudentDetails(String name, String rollNo, String dateOfBirth, String contactNumber, int year,
			String department, int attendance, char grade) {
		super(name, rollNo, dateOfBirth, contactNumber);
		this.year = year;
		this.department = department;
		this.attendance = attendance;
		this.grade = grade;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public String toString() {
		return "StudentDetails [ Name = " + getName() + ", RollNo = " + getRollNo() + ", DateOfBirth = "
				+ getDateOfBirth() + ", ContactNumber = " + getContactNumber() + ",year = " + year + ", department = " + department + ", attendance =" + attendance + ", grade ="
						+ grade +"]";
	}
	    
}
