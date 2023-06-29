package com.kce.student.bean;

public class Department extends Student{
    private String departmentName;

    public Department() {
        super();
        this.departmentName=null;
    }


    public Department(int id, String name, String grade, int age, String departmentName) {
        super(id, name, grade, age);
        this.departmentName = departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return "Department [departmentName=" + departmentName + "]";
    }

}
