package com.kce.employee.bean;

public class Salary {
	private int empID;
	private double salary;
	private String accountNumber;

	public Salary(int empID, double salary, String accountNumber) {
		super();
		this.empID = empID;
		this.salary = salary;
		this.accountNumber = accountNumber;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Salary [empID=" + empID + ", salary=" + salary + ", accountNumber=" + accountNumber + "]";
	}

}
