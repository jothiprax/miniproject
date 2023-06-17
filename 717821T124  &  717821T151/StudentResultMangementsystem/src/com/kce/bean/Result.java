package com.kce.bean;

public class Result {
    private int resultId;
    private int studentId;
    private String subjectName;
    private double marks;

    public Result(int resultId, int studentId, String subjectName, double marks) {
        this.resultId = resultId;
        this.studentId = studentId;
        this.subjectName = subjectName;
        this.marks = marks;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}
