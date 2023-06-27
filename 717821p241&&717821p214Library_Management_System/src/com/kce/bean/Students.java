package com.kce.bean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Students {
	private String name;
	private String dept;
	private String email;
	private String rollno;
	private String dob;
	public Students(String name, String dept, String email, String rollno, String dob) {
		super();
		this.name = name;
		this.dept = dept;
		this.email = email;
		this.rollno = rollno;
		this.dob = dob;
	}
	public Students() {	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void addStudent(String name, String dept, String email, String rollno, String dob) throws SQLException {
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagement","root","");
		PreparedStatement smt = c.prepareStatement("create table if not exists Students_data (Name varchar(200),Department varchar(200),Email varchar(200),Roll_No varchar(200),DateOfBirth varchar(200));");
		smt.execute();
		PreparedStatement smt1 = c.prepareStatement("insert into Students_data values(?,?,?,?,?)");
		smt1.setString(1, name);
		smt1.setString(2, dept);
		smt1.setString(3, email);
		smt1.setString(4, rollno);
		smt1.setString(5, dob);
		smt1.execute();
	}
	
}
