package com.kce.bean;

public class Nurse extends Hospital{
	
	private String Name;
	private int NurseID;
	public Nurse(String name, String address, String name2, int iD) {
		super(name, address);
		Name = name2;
		NurseID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getID() {
		return NurseID;
	}
	public void setID(int iD) {
		NurseID = iD;
	}
	@Override
	public String toString() {
		return "Nurse [Name=" + Name + ", ID=" + NurseID + "]";
	}
	
	
   

}
