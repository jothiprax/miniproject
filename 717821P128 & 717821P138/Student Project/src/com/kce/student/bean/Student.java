package com.kce.student.bean;

public class Student {
    private int id;
    private String name;
    private String grade;
    private int age;
    

    public Student() {
        this.id=0;
        this.name=null;    
        this.grade=null;
        this.age=0;        
    }

    public Student(int id, String name, String grade, int age) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.age = age;
    }

    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", grade=" + grade + ", age=" + age + "]";
    }
    
    
    
}

