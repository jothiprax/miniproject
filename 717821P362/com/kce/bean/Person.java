package com.kce.bean;

public class Person {
	protected String name; // a person will have a name , age and gender as general attributes 
	protected int age;
	protected String gender;
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
	public Person(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Person() {
	}
	/* getters and setters for all attributes are added 
	 * inorder to add parametric constructors it is added
	 */
}
