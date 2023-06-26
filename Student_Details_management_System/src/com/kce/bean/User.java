package com.kce.bean;

public class User {
   private int Id;
   private String Uname;
   private String Password;
public User() {
	super();
}

public User(int id) {
	super();
	Id = id;
}

public User(int id, String uname, String password) {
	super();
	Id = id;
	Uname = uname;
	Password = password;
}

public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getUname() {
	return Uname;
}
public void setUname(String uname) {
	Uname = uname;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
@Override
public String toString() {
	return "User [Id=" + Id + ", Uname=" + Uname + ", Password=" + Password + "]";
}
   
}
