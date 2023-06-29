package com.kce.bean;

public class Student implements Comparable<Student>{
 String name;
 int studentID;
 int grade;
public Student() {
	
}
public Student(String name, int studentID, int grade) {
	this.name = name;
	this.studentID = studentID;
	this.grade = grade;
}
public Student(int studentID, int grade) {
	this.studentID = studentID;
	this.grade = grade;
}
public Student(int studentID) {
	super();
	this.studentID = studentID;
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
public int getGrade() {
	return grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}
}

