package com.kce.student.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.kce.student.util.*;
public class Validation {
    //validating id
    public boolean validateId(int id) throws InterruptedException{
        boolean flag = true;
        try{
            Connection con = DBUtil.getConnection();
            List<Integer> presentID = new ArrayList<Integer>();
            PreparedStatement ps = con.prepareStatement("select id from student_details");
            ResultSet res = ps.executeQuery();
            while(res.next()){
                presentID.add(res.getInt(1));
            }
            if(id==0){
                throw new IDException("IDException: you entered id has 0 hence it is not valid\nPlease enter positive value");
            }else if(id<0){
                throw new IDException("IDException: you entered id has negative hence it is not valid\nPlease enter positive value");
            }else if(presentID.contains(id)){
                throw new IDException("IDException: you entered id has been already used\nPlease try another value");
            }
        }catch(IDException ide){
            flag = false;
            System.out.println(ide.getMessage());
            Thread.sleep(4000);
        }catch(SQLException sq){
            System.out.println("Database connecting error restart the program to overcome this issue");
            Thread.sleep(4000);
        }
        return flag;
    }

    //validating id to delete
    public boolean validateDUId(int id) throws InterruptedException{
        boolean flag = true;
        try{
            Connection con = DBUtil.getConnection();
            List<Integer> presentID = new ArrayList<Integer>();
            PreparedStatement ps = con.prepareStatement("select id from student_details");
            ResultSet res = ps.executeQuery();
            while(res.next()){
                presentID.add(res.getInt(1));
            }
            if(!presentID.contains(id)){
                throw new IDException("IDException: you entered id has not yet in database\nso please enter valid id");
            }
        }catch(IDException ide){
            flag = false;
            System.out.println(ide.getMessage());
            Thread.sleep(4000);
        }catch(SQLException sq){
            System.out.println("Database connecting error restart the program to overcome this issue");
            Thread.sleep(4000);
        }
        return flag;
    }

    public boolean validateAge(int age) throws InterruptedException{
        boolean flag = true;
        try{
            if(age<=0){
                throw new AgeException("AgeException: age should not be in negative or zero");
            }else if(age>25){
                throw new AgeException("AgeException: your age is Higher");
            }else if(age<18){
                throw new AgeException("AgeException: your age is lesser");
            }
        }catch(AgeException ag){
            flag = false;
            System.out.println(ag.getMessage());
            Thread.sleep(4000);
        }
        return flag;
    }

    public boolean validateGrade(String grade) throws InterruptedException{
        boolean flag = true;
        List<String> gradeList = Arrays.asList("A+","A","O","B","B+","C","U");
        try{
            if(!gradeList.contains(grade)){
                throw new GradeException("GradeException: you entered grade has been not valid\nEnter correct grade value");
            }
        }catch(GradeException g){
            flag = false;
            System.out.println(g.getMessage());
            Thread.sleep(4000);
        }
        return flag;
    }

    public boolean validateDepartment(String department) throws InterruptedException{
        boolean flag = true;
        List<String> departmentList = Arrays.asList("CSE","ECE","CSD","MECH","EEE","IT","CST","CIVIL");
        try{
            if(!departmentList.contains(department)){
                throw new DepartmentException("DepartmentException: you entered wrong department name or enter your department name in short form");
            }
        }catch(DepartmentException de){
            flag = false;
            System.out.println(de.getMessage());
            Thread.sleep(4000);
        }
        return flag;
    }
}
