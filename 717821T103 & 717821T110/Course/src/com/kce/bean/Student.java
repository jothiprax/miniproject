package com.kce.bean;

public class Student {
    private String name;
    private String collegeName;
    private String rollNo;
    private String course;
    private String email;

    public Student(String name, String collegeName, String rollNo, String course, String email) {
        this.name = name;
        this.collegeName = collegeName;
        this.rollNo = rollNo;
        this.course = course;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n"
                + "College Name: " + collegeName + "\n"
                + "Roll No: " + rollNo + "\n"
                + "Course: " + course + "\n"
                + "Email: " + email;
    }
}

