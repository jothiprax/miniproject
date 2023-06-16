package com.kce.bean;

public class Course {
    private String courseName;
    private String courseCode;
    private String startDate;
    private String endDate;

    public Course(String courseName, String courseCode, String startDate, String endDate) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Course Name: " + courseName + "\n"
                + "Course Code: " + courseCode + "\n"
                + "Start Date: " + startDate + "\n"
                + "End Date: " + endDate;
    }
}

