package com.kce.student.bean;

public class UndergraduateStudent extends Student {
	 private String major;

	 public UndergraduateStudent(int studentId, String name, int age, String major) {
	     super(studentId, name, age);
	     this.major = major;
	 }

	 public String getMajor() {
	     return major;
	 }
	}
