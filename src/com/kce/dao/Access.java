package com.kce.dao;
import com.kce.bean.*;
public class Access {
	private String StudentId;
	private String Department;
	private int Year;
	public String str;
	public Access(String StudentId,String Department,int Year) {
		this.StudentId=StudentId;
		this.Department=Department;
		this.Year=Year;
	}
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	@Override
	public String toString() {
		return "Access [StudentId=" + StudentId + ", Department=" + Department + ", Year=" + Year + "]";
	}
}