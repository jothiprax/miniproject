package com.Fitness.bean;

public class BMI extends Member{
double height;
double weight;


public BMI() {
	super();
	// TODO Auto-generated constructor stub
}
public BMI(String name, String phone_no) {
	
	super(name ,phone_no);
}
public double getHeight() {
	return height;
}
public void setHeight(double height) {
	this.height = height;
}
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	this.weight = weight;
}


}
