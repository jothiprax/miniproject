package com.kce.bean;

public class User {
	private String name;
	private String gender;
	private String dob;
	private String mobile_no;
	private String address;
	private String email;
	private String username;
	private String password;
	private String account_no;
	public User(String name, String gender, String dob, String mobile_no, String address, String email, String username, String password, String account_no) {
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.mobile_no = mobile_no;
		this.address = address;
		this.email = email;
		this.username = username;
		this.password = password;
		this.account_no = account_no;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
