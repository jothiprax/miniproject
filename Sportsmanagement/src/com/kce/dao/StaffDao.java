package com.kce.dao;

public class StaffDao {
	private int staff_id;

	private String name;

	private int age;

	private String gender;

	private String contact_number;


	public StaffDao() {

	}

	public  StaffDao(int staff_id, String name, int age, String gender, String contact_number) {

super();
	this.staff_id = staff_id;

	this.name = name;

	this.age = age;

	this.gender = gender;

	this.contact_number = contact_number;


	}

	public int getstaff_id() {

	return staff_id;

	}

	public void setstaff_id(int staff_id) {

	this.staff_id = staff_id;

	}

	public String getName() {

	return name;

	}

	public void setName(String name) {

	this.name = name;

	}

	public int getAge() {

	return age;

	}

	public void setAge(int age) {

	this.age = age;

	}

	public String getGender() {

	return gender;

	}

	public void setGender(String gender) {

	this.gender = gender;

	}

	public String getContact_number() {

	return contact_number;
	}
	

	public void setContact_number(String contact_number) {

	this.contact_number = contact_number;

	}

	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	

	}
