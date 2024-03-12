package com.kce.bean;

//Doctor class
public class Doctor {
 private int doctorId;
 private String name;
 private String specialization;

 public Doctor(int doctorId, String name, String specialization) {
     this.doctorId = doctorId;
     this.name = name;
     this.specialization = specialization;
 }

 public int getDoctorId() {
     return doctorId;
 }

 public String getName() {
     return name;
 }

 public String getSpecialization() {
     return specialization;
 }
}
