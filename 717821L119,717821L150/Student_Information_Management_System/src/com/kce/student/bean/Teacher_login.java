package com.kce.student.bean;

import java.util.Scanner;

public class Teacher_login
{
	public Teacher_login() {}
	public Teacher_login(int studentid, String name, String department, int year, int pRPmark, int mPMCmark, int dSmark,double totalpercentage) 
	{
		super();
		Studentid = studentid;
		Name = name;
		Department = department;
		this.year = year;
		PRPmark = pRPmark;
		MPMCmark = mPMCmark;
		DSmark = dSmark;
		Totalpercentage = totalpercentage;
	}
	static Scanner S = new Scanner(System.in);
	private int Studentid;	
	private String Name;
	private String Department;
	private int year;
	private int PRPmark;
	private int MPMCmark;
	private int DSmark;
	private double Totalpercentage;

	public int getStudentid() {
		return Studentid;
	}
	public void setStudentid(int studentid) {
		Studentid = studentid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPRPmark() {
		return PRPmark;
	}
	public void setPRPmark(int pRPmark) {
		PRPmark = pRPmark;
	}
	public int getMPMCmark() {
		return MPMCmark;
	}
	public void setMPMCmark(int mPMCmark) {
		MPMCmark = mPMCmark;
	}
	public int getDSmark() {
		return DSmark;
	}
	public void setDSmark(int dSmark) {
		DSmark = dSmark;
	}
	public double getTotalpercentage() {
		return Totalpercentage;
	}
	public void setTotalpercentage(double totalpercentage) {
		Totalpercentage = totalpercentage;
	}
}
