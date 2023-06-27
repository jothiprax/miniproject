package com.kce.bean;

public class Student{
          public int id;
          public int age;
      	  public int Dob;
      	  public String address;
      	  public String name;
      	  
		public Student(int id, int age, int dob, String address, String name) {
			super();
			this.id = id;
			this.age = age;
			Dob = dob;
			this.address = address;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getDob() {
			return Dob;
		}

		public void setDob(int dob) {
			Dob = dob;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		
		@Override
		public String toString() {
			return "Student [id=" + id + ", age=" + age + ", Dob=" + Dob + ", address=" + address + ", name=" + name
					+ "]";
		}


		public void PersonalDetails() {
			System.out.println(toString());
			
		}

          
}
