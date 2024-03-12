package com.kce.bean;

public class Patient extends Hospital{

	private String PName;
	private int PatientID;
	private String Age;
	private String Gender;
	private String State_diseaseType;
	
	public Patient(String name, String address, String pName, int iD, String age, String gender, String state) {
		super(name, address);
		PName = pName;
		PatientID = iD;
		Age = age;
		Gender = gender;
		State_diseaseType = state;
	}

	public String getPName() {
		return PName;
	}

	public void setPName(String pName) {
		PName = pName;
	}

	public int getID() {
		return PatientID;
	}

	public void setID(int iD) {
		PatientID = iD;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}


	public String getState() {
		return State_diseaseType;
	}

	public void setState(String state) {
		State_diseaseType = state;
	}
	
	

	@Override
	public String toString() {
		return "Patient [PName=" + PName + ", ID=" + PatientID+ ", Age=" + Age + ", Gender=" + Gender + ", State=" + State_diseaseType
				+ "]";
	}

	
	
}
