package com.kce.stud.bean;

public class Attendance {
	private int studId;
	private String studname;
	private String dept;
	private String PA;
	private String date;
	public Attendance(int studId, String studname, String dept, String pA,String date) {
		super();
		this.studId = studId;
		this.studname = studname;
		this.dept = dept;
		PA = pA;
		this.date=date;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudname() {
		return studname;
	}
	public void setStudname(String studname) {
		this.studname = studname;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPA() {
		return PA;
	}
	public void setPA(String pA) {
		PA = pA;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Attendance [studId=" + studId + ", studname=" + studname + ", dept=" + dept + ", PA=" + PA + "]";
	}
}
