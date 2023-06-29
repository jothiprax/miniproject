package com.kce.student.bean;

public class Student {
    //Instance variables
    private int id;
    private String name;
    private String grade;
    private int age;
    

    //Default Constructor
    public Student() {
        this.id=0;
        this.name=null;    
        this.grade=null;
        this.age=0;        
    }

    //Parameterized Constructor
    public Student(int id, String name, String grade, int age) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.age = age;
    }

    
    //Setter Methods
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    //Getter Methods
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

    //ToString() method
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", grade=" + grade + ", age=" + age + "]";
    }
    
    
    
}

