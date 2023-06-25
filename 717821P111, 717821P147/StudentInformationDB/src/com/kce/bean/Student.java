package com.kce.bean;

public class Student {
	private String name;
	private int studentID;
	private String grade;

	public Student(String name, int studentID, String grade) {
		this.name = name;
		this.studentID = studentID;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
