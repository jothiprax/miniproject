package com.kce.vignesh.bean;

public class Subject {
	private String subId;
	private String subName;
	private int requiredHours;
	public Subject() {
		
	}
	public Subject(String subId, String subName, int requiredHours) {
		this.subId = subId;
		this.subName = subName;
		this.requiredHours = requiredHours;
	}
	public String getSubId() {
		return subId;
	}
	public void setSubId(String subId) {
		this.subId = subId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public int getRequiredHours() {
		return requiredHours;
	}
	public void setRequiredHours(int requiredHours) {
		this.requiredHours = requiredHours;
	}
}
