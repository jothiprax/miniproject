package com.kce.employee.bean;

public class EmployeeOfficialDetails{
    private int id;
    private String name;
    private int age;
    private String gender;
    private String designation;
    private double salary;
    private long contact_number;
    private String email;

    public EmployeeOfficialDetails(){

    }
    public EmployeeOfficialDetails(int id , String name , int age , String gender ,  String designation , double salary , long contact_number , String email){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.designation = designation;
        this.salary = salary;
        this.contact_number = contact_number;
        this.email = email;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return gender;
    }

    public void setDesignation(String designation){
        this.designation = designation;
    }
    public String getDesignation(){
        return designation;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }
    public double getSalary(){
        return salary;
    }

    public void setContact_number(long contact_number){
        this.contact_number = contact_number;
    }
    public long getContact_number(){
        return contact_number;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
}