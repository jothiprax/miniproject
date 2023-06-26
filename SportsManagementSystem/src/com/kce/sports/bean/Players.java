package com.kce.sports.bean;

public class Players{
	private String pname;
	private String salary;
	private String position;
	private int age;
	private int jersey_no;
	private int goals;
	private String nationality;
	private String contract;
	public Players(String pname,String salary,String position,int age,int jersey_no,int goals,String nationality,String contract) {
		this.pname = pname;
		this.salary = salary;
		this.position = position;
		this.age = age;
		this.jersey_no = jersey_no;
		this.goals = goals;
		this.nationality = nationality;
		this.contract = contract;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getJersey_no() {
		return jersey_no;
	}
	public void setJersey_no(int jersey_no) {
		this.jersey_no = jersey_no;
	}
	public int getGoals() {
		return goals;
	}
	public void setGoals(int goals) {
		this.goals = goals;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}
	@Override
	public String toString() {
		return "Player [Player = "+pname+", Salary = "+salary+", Position = "+position+", Age = "+age+", Jersey no = "+jersey_no+", Goals scored = "+goals+", Nationality = "+nationality+", Contract = "+contract+"]";
	}
	public void playerDetails() {
		System.out.println(toString());
	}
}
