package com.kce.employee.bean;

public class EmployeePersonalDetails extends EmployeeOfficialDetails{

    private int id;
    private String address;
    private long contact_number;
    private String email;

    public EmployeePersonalDetails(){

    }
    public EmployeePersonalDetails(int id ,String address , long contact_number , String email){
        this.id = id;
        this.address = address;
        this.contact_number = contact_number;
        this.email = email;
    }

    public int getId(){
        return id;
    }
    
    public String getAddress(){
        return address;
    }

    public long getContact_number(){
        return contact_number;
    }
    public String getEmail(){
        return email;
    }
}