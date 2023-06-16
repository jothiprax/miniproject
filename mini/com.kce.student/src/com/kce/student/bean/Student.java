package com.kce.student.bean;

public class Student {
	String name;
	int rollNumber;
	int age;
	Grade grade;
	public Student(String name, int rollNumber, int age, Grade grade) {
		super();
		this.name = name;
		this.rollNumber = rollNumber;
		this.age = age;
		this.grade=grade;
		
	}

	public  String getGrade() {
		
		return grade.toString();
	
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		// TODO Auto-generated method stub
		return age;
	}
	/**
	 * @param name
	 * @param rollNumber
	 * @param age
	 */
	public Student(String name, int rollNumber, int age) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.age = age;
	}
}
