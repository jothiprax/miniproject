package com.kce.bean;

public class studentdetails {
	private String name;
	private int id;
	private int year;
	private String gender;
	private String phno;
	private String emailid;
	
	
public studentdetails(String name,int id,int year,String gender,String phno,String emailid) {
	super();
	this.name=name;
	this.id=id;
	this.year=year;
	this.gender=gender;
	this.phno=phno;
	this.emailid=emailid;
	
}
public String getname() {
	return name;
}
public void setname(String name) {
	this.name=name;
}
public int getid() {
	return id;
}
public void setid(int id) {
	this.id=id;
}
public int getyear() {
	return year;
}
public void setyear(int year) {
	this.year=year;
}
public String getgender() {
	return gender;
}
public void setgender(String gender) {
	this.gender=gender;
}  
public String getphno() {
	return phno;
}
public void setphno(String phno) {
	this.phno=phno;
}
public String getemailid() {
	return emailid;
}
public void setemailid(String emailid) {
	this.emailid=emailid;
}

@Override
 public String toString() {
	return "StudentDetails [name= "+name+",id= "+id+",year "+year+",gender= "+gender+",phno= "+phno+",emailid= "+emailid+"]";
}
}
