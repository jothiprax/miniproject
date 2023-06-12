package com.kce.bean;

public class Hospital {
	private int id;
	private String name;
	private String location;
	private int capacity;
	private String phoneNumber;
	private String email;
	private String directorName;
	private String emergencyContact;
	private String website;
	private String establishedDate;

	public Hospital() {

	}

	public Hospital(int id, String name, String location, int capacity, String phoneNumber, String email,
			String directorName, String emergencyContact, String website, String establishedDate) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.capacity = capacity;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.directorName = directorName;
		this.emergencyContact = emergencyContact;
		this.website = website;
		this.establishedDate = establishedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEstablishedDate() {
		return establishedDate;
	}

	public void setEstablishedDate(String establishedDate) {
		this.establishedDate = establishedDate;
	}
}

