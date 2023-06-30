package com.kce.sports.bean;

public class Staffs {
	private String name;
	private String role;
	private String salary;
	private int age;
	private int phone_no;
	private String contract;
	public Staffs(String name,String role,String salary,int age,int phone_no,String contract) {
		this.name = name;
		this.role = role;
		this.salary = salary;
		this.age = age;
		this.phone_no = phone_no;
		this.contract = contract;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
	}
	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}
	@Override
	public String toString() {
		return "staffDetails [Name = "+name+", Role = "+role+", Salary = "+salary+", Age = "+age+", Phone number = "+phone_no+", Contract = "+contract+"]";
	}
	public void staffDetails() {
		System.out.println(toString());
	}
}
