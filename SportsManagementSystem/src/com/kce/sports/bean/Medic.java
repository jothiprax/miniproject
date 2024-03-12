package com.kce.sports.bean;

public class Medic {
	private String pname;
	private String condition;
	private String availability;
	private int age;
	private String trainer;
	public Medic(String pname,String condition,String availability,int age,String trainer) {
		this.pname = pname;
		this.condition = condition;
		this.availability = availability;
		this.age = age;
		this.trainer = trainer;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	@Override
	public String toString() {
		return "MedicDetails [player = "+pname+", condition = "+condition+", availability = "+availability+", age = "+age+", Trainer = "+trainer+"]";
	}
	public void medicDetails(){
		System.out.println(toString());
	}
}
