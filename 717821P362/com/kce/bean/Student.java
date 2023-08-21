package com.kce.bean;
public class Student extends Person {
	private int grades; // as per given data rollNo and grades are added
	private String rollNo;
	public int getGrades() {
		return grades;
	}
	public void setGrades(int grades) {
		this.grades = grades;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public Student(String name, int age, String gender, int grades, String rollNo) {
		super(name, age, gender);
		this.grades = grades;
		this.rollNo = rollNo;
	}
	/* getters and setters for all attributes are added 
	 * inorder to add parametric constructors it is added
	 */
}
