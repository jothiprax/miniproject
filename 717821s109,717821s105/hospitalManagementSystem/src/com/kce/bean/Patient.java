package com.kce.bean;

public class Patient {
        private String name;
        private int id;
        private int age;
        private String gender;
        public Patient(){
        	
        }
		public Patient(String name, int id, int age, String gender) {
			super();
			this.name = name;
			this.id = id;
			this.age = age;
			this.gender = gender;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
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
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		@Override
		public String toString() {
			return "Patient [name=" + name + ", id=" + id + ", age=" + age + ", gender=" + gender + ", getName()="
					+ getName() + ", getId()=" + getId() + ", getAge()=" + getAge() + ", getGender()=" + getGender()
					+ "]";
		}
       
        
}
