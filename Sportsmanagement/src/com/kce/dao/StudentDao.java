package com.kce.dao;

public class StudentDao {
	
		private int student_id;

		private String name;

		private int age;

		private String gender;

		private String contact_number;

		

		public StudentDao() {

		}

		public StudentDao(int student_id, String name, int age, String gender, String contact_number) {

		super();

		this.student_id = student_id;

		this.name = name;

		this.age = age;

		this.gender = gender;

		this.contact_number = contact_number;

		

		}

		public int getstudent_id() {

		return student_id;

		}

		public void setstudent_id(int student_id) {

		this.student_id = student_id;

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

		
		public int getStudent_id() {
			return student_id;
		}

		public void setStudent_id(int student_id) {
			this.student_id = student_id;
		}

		

		}

