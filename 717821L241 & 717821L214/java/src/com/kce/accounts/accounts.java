package com.kce.accounts;
public class accounts {
	static String username;
	static String password;
	static String name;
	static Long phno;
	static int age;
	static String gender;
	static String place;
	public accounts(String username, String password, String name, Long phno, int age, String gender, String place) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.phno = phno;
		this.age = age;
		this.gender = gender;
		this.place = place;
	}
	public static String getUsername() {
		return username;
	}
	public static String getPassword() {
		return password;
	}
	public static String getName() {
		return name;
	}
	public static Long getPhno() {
		return phno;
	}
	public static int getAge() {
		return age;
	}
	public static String getGender() {
		return gender;
	}
	public static String getPlace() {
		return place;
	}
}
