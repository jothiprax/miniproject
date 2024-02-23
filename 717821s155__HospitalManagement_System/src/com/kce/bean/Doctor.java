package com.kce.bean;

public class Doctor extends Hospital {
	
	private String DName;
	private int DoctorID;
	private String Specialist;
	private String Qualification;
	private int RoomNo;
	
	public Doctor(String name, String address, String dName, int iD, String specialist, String qualification,
			int roomNo) {
		super(name, address);
		DName = dName;
		DoctorID = iD;
		Specialist = specialist;
		Qualification = qualification;
		RoomNo = roomNo;
	}

	public String getDName() {
		return DName;
	}

	public void setDName(String dName) {
		DName = dName;
	}

	public int getID() {
		return DoctorID;
	}

	public void setID(int iD) {
		DoctorID = iD;
	}

	public String getSpecialist() {
		return Specialist;
	}

	public void setSpecialist(String specialist) {
		Specialist = specialist;
	}

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		Qualification = qualification;
	}

	public int getRoomNo() {
		return RoomNo;
	}

	public void setRoomNo(int roomNo) {
		RoomNo = roomNo;
	}

	@Override
	public String toString() {
		return "Doctor [DName=" + DName + ", DoctorID=" + DoctorID + ", Specialist=" + Specialist + ", Qualification="
				+ Qualification + ", RoomNo=" + RoomNo + "]";
	}
	
	
	
	
	
}
