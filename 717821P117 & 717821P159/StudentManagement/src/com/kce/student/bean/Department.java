package com.kce.student.bean;

public class Department extends Student{
    private String departmentName;

    //Default Constructor
    public Department() {
        super();
        this.departmentName=null;
    }


    //Parameterized Constructor 
    public Department(int id, String name, String grade, int age, String departmentName) {
        super(id, name, grade, age);
        this.departmentName = departmentName;
    }

    //Setter method
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    //Getter method
    public String getDepartmentName() {
        return departmentName;
    }

    //ToString() Method
    @Override
    public String toString() {
        return "Department [departmentName=" + departmentName + "]";
    }

}
