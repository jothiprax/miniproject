package com.kce.bean;

public class EmployeeDB {
	private int eid;
	private String ename;
	private String degree;
	private double salary;
	public EmployeeDB(int eid,String ename,String degree,double salary) {
		this.eid=eid;
		this.ename=ename;
		this.degree=degree;
		this.salary=salary;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
