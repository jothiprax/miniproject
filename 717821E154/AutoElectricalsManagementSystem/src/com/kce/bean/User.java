package com.kce.bean;

public class User {
	private String username;
	private String password;
	private int age;
	private String gender;
	
	//CONSTRUCTOR
	
	public User() {
		super();
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(String username, String password, int age, String gender) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.gender = gender;
	}
	
	//GETTER AND SETTER
	
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
}
