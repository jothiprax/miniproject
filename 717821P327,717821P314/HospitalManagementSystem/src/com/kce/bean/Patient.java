package com.kce.bean;

//Patient class
public class Patient {
 private int patientId;
 private String name;
 private int age;

 public Patient(int patientId, String name, int age) {
     this.patientId = patientId;
     this.name = name;
     this.age = age;
 }

 public int getPatientId() {
     return patientId;
 }

 public String getName() {
     return name;
 }

 public int getAge() {
     return age;
 }
}
