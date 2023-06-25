package com.kce.bean;

public class Employee {
	public int id;
	public String name;
	public String department;
	public String joindate;
	public String gender;
	public String contact;
	public int salary;
	public String email;
	public Employee(int id,String name,String department,String joindate,String gender,String contact,int salary,String email)
			{
				this.id=id;
				this.name=name;
				this.department=department;
				this.joindate=joindate;
				this.gender=gender;
				this.contact=contact;
				this.salary=salary;
				this.email=email;
			}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setNumber(String contact) {
		this.contact = contact;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
