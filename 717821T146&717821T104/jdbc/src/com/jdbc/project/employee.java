package com.jdbc.project;

public class employee {
	private int emp_id;
	private String emp_name;
	private String emp_address;
	private double emp_salary;
	//constructor1
	public employee(int emp_id, String emp_name, String emp_address, double emp_salary) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_address = emp_address;
		this.emp_salary = emp_salary;
	}
	//constructor 2
	public employee(String emp_name, String emp_address, double emp_salary) {
		super();
		this.emp_name = emp_name;
		this.emp_address = emp_address;
		this.emp_salary = emp_salary;
	}
	//getter and  setter
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
	public double getEmp_salary() {
		return emp_salary;
	}
	public void setEmp_salary(double emp_salary) {
		this.emp_salary = emp_salary;
	}
	
	
}
