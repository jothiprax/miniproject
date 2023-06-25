package com.kce.student.bean;

public class Student {
    private String name;
    private String rollNo;
    private String dateOfBirth;
    private String contactNumber;
	public Student(String name, String rollNo, String dateOfBirth, String contactNumber) {
		this.name = name;
		this.rollNo = rollNo;
		this.dateOfBirth = dateOfBirth;
		this.contactNumber = contactNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + ", dateOfBirth=" + dateOfBirth + ", contactNumber="
				+ contactNumber + "]";
	}
	
    
}
