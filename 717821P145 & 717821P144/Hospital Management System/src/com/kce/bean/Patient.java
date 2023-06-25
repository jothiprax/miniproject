package com.kce.bean;
public class Patient {
private int id;
private static String name;
private static String disease;
public Patient(int id, String name, String disease) {
super();
this.id = id;
this.name = name;
this.disease = disease;
}
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public static  String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public static String getdisease() {
return disease;
}
public void setdisease(String disease) {
this.disease = disease;
}
}