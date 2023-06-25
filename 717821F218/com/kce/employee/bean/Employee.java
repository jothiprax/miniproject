package com.kce.employee.bean;

public class Employee {
	private int empID;
	private String empName;
	private String empEmail;
	private String mobileNumber;
	private String empCity;

	public Employee(int empID, String empName, String empEmail, String mobileNumber, String empCity) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empEmail = empEmail;
		this.mobileNumber = mobileNumber;
		this.empCity = empCity;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmpCity() {
		return empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", empEmail=" + empEmail + ", mobileNumber="
				+ mobileNumber + ", empCity=" + empCity + "]";
	}

}
