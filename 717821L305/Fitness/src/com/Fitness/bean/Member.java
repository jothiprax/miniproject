package com.Fitness.bean;

public class Member {
String name;
int age;
String gender;
String phone_no;
public Member(String name, int age,String gender, String phone_no) {
	super();
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.phone_no = phone_no;
}
public Member() {
}
public Member(String name, String phone_no) {
	// TODO Auto-generated constructor stub
	this.name = name;
	this.phone_no=phone_no;
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
public String getPhone_no() {
	return phone_no;
}
public void setPhone_no(String phone_no) {
	this.phone_no = phone_no;
}


}
