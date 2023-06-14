package com.kce.bean;

public class Student {
	private int StudentId;
	private String StudentName;
	private int BookId;	   
	private String IssueDate;
	private String ReturnDate;
	public Student(int studentId, String studentName, int bookId, String issueDate, String returnDate) {
		super();
		StudentId = studentId;
		StudentName = studentName;
		BookId = bookId;
		IssueDate = issueDate;
		ReturnDate = returnDate;
	}
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public String getIssueDate() {
		return IssueDate;
	}
	public void setIssueDate(String issueDate) {
		IssueDate = issueDate;
	}

	public String getReturnDate() {
		return ReturnDate;
	}
	public void setReturnDate(String returnDate) {
		ReturnDate = returnDate;
	}
	@Override
	public String toString() {
		return "student [StudentId=" + StudentId + ", StudentName=" + StudentName + ", BookId=" + BookId
				+ ", IssueDate=" + IssueDate + ", ReturnDate=" + ReturnDate + "]";
	}

}
