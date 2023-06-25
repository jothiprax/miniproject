package com.kce1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.kce1.bean.Employee;
import com.kce1.util.DBUtil;

public class EmployeeDAO {
    Connection con;

public void createEmployee(Employee emp){
    con=DBUtil.getConnection();
    String query="insert into employee2 values(?,?,?,?)";
    try{
        PreparedStatement pstm=con.prepareStatement(query);
        pstm.setInt(1,emp.getId());
        pstm.setString(2,emp.getName());
        pstm.setDouble(3,emp.getSalary());
        pstm.setInt(4,emp.getAge());
       int cnt= pstm.executeUpdate();
       if(cnt!=0)
           System.out.println("Success");
    }catch(Exception ex){
        ex.printStackTrace();
    }
}

    
    public void showAllEmployee() {
    	 con=DBUtil.getConnection();
    String query="select*from employee2";
    System.out.println("Employee details :");
    System.out.println("....................................................");
    System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Salary","Age");
    System.out.println("....................................................");
    try{
        Statement stmt=con.createStatement();
        ResultSet result=stmt.executeQuery(query);
        while(result.next()){
            System.out.format("| %d | %s | %f | %d |",
                    result.getInt(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getInt(4));
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }

    }

    
    public void showEmployeeBasedOnID(int id) {
    	 con=DBUtil.getConnection();
     String query="select*from employee2 where id="+id;
     try{
         Statement stmt=con.createStatement();
         ResultSet result=stmt.executeQuery(query);
         while(result.next()){
             System.out.format("%d\t%s\t%f\t%d\n",
                     result.getInt(1),
                     result.getString(2),
                     result.getDouble(3),
                     result.getInt(4));
         }
     }catch(Exception ex){
         ex.printStackTrace();
     }
    }

   
    public void updateEmployee(int id, String name) {
    	 con=DBUtil.getConnection();
    String query="update employee2 set name=? where id=?";
    try{
        PreparedStatement pstm=con.prepareStatement(query);
        pstm.setString(1,name);
        pstm.setInt(2,id);
        int cnt=pstm.executeUpdate();
        if(cnt!=0)
            System.out.println("Employee Details updated successfully");

    }catch(Exception ex){
        ex.printStackTrace();
    }

    }

    
    public void deleteEmployee(int id) {
    	 con=DBUtil.getConnection();
   String query="delete from employee2 where id=?";
   try{
       PreparedStatement pstm=con.prepareStatement(query);
       pstm.setInt(1,id);
       int cnt=pstm.executeUpdate();
       if(cnt!=0)
           System.out.println("Employee deleted successfully" +id);

   }catch(Exception ex){
       ex.printStackTrace();
   }
    }
}