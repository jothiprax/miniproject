package com.kce.bean;

public class Student {
	private String RollNo;
	private String name;
	private String Community;
	private String Religion;
	private String Dob;

	public Student() {
		super();
	}

	public Student(String rollNo, String name, String community, String religion, String dob) {
		super();
		RollNo = rollNo;
		this.name = name;
		Community = community;
		Religion = religion;
		Dob = dob;
	}

	public String getRollNo() {
		return RollNo;
	}

	public void setRollNo(String rollNo) {
		RollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommunity() {
		return Community;
	}

	public void setCommunity(String community) {
		Community = community;
	}

	public String getReligion() {
		return Religion;
	}

	public void setReligion(String religion) {
		Religion = religion;
	}

	public String getDob() {
		return Dob;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	@Override
	public String toString() {
		return "Student [RollNo=" + RollNo + ", name=" + name + ", Community=" + Community + ", Religion=" + Religion
				+ ", Dob=" + Dob + "]";
	}

}
