package com.kce.student.bean;

public class Student {

 private int studentId;
 private String name;
 private int age;

 public Student(int studentId, String name, int age) {
     this.studentId = studentId;
     this.name = name;
     this.age = age;
 }

 public int getStudentId() {
     return studentId;
 }

 public String getName() {
     return name;
 }

 public int getAge() {
     return age;
 }
}
