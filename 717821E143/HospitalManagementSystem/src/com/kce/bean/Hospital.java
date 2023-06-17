package com.kce.bean;

public class Hospital {
	public int admissionNo;
	public String name;
public String bloodGroup;
public String disease;
public String dateOfJoin;
	public static int noOfBed=10;
	public static int occupiedBed=0;
	//CONSTRUCTOR
	public Hospital() {
		super();
	}
	//GETTER AND SETTER
	public static int getnoOfBed() {
		return noOfBed;
	}
	public static void setnoOfBed(int noOfBed) {
		Hospital.noOfBed = noOfBed;
	}
	

public static int getOccupiedBed() {
		return occupiedBed;
	}
	public static void setOccupiedBed(int occupiedBed) {
		Hospital.occupiedBed = occupiedBed;
	}
//CONSTRUCTOR
public Hospital(int admission_no, String name, String blood_group, String disease, String date_of_join) {
	super();
	this.admissionNo = admissionNo;
	this.name = name;
	this.bloodGroup = bloodGroup;
	this.disease = disease;
	this.dateOfJoin = dateOfJoin;
}
//GETTER AND SETTER

public int getAdmissionNo() {
	return admissionNo;
}
public void setAddmissionNo(int admissionNo) {
	this.admissionNo = admissionNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getBloodGroup() {
	return bloodGroup;
}
public void setBloodGroup(String bloodGroup) {
	this.bloodGroup = bloodGroup;
}
public String getDisease() {
	return disease;
}
public void setDisease(String disease) {
	this.disease = disease;
}
public String getDateOfJoin() {
	return dateOfJoin;
}
public void setDateOfJoin(String dateOfJoin) {
	this.dateOfJoin = dateOfJoin;
}

}
