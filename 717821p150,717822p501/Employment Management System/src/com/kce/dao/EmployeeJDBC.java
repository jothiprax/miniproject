package com.kce.dao;

import com.kce.bean.EmployeeDB;
import java.sql.*;
public class EmployeeJDBC {
	private PreparedStatement create;
	private PreparedStatement select;
	private PreparedStatement update;
	private PreparedStatement delete;
	public EmployeeJDBC() throws ClassNotFoundException {
	try{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="717821p150";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,user,password);
		create=con.prepareStatement("insert into employees values(?,?,?,?)");
		select=con.prepareStatement("Select * from employees where eid=?");
		update=con.prepareStatement("update employees set ename=?,degree=?,salary=? where id=?");
		delete=con.prepareStatement("delete from employees where id=?");
	}
	catch (SQLException e) {
		System.out.println("SQL Exception occurred.....");
	}
	}
	public void createEmployee(EmployeeDB employee) {
		try {
			create.setInt(1,employee.getEid());
			create.setString(2,employee.getEname());
			create.setString(3,employee.getDegree());
			create.setDouble(4,employee.getSalary());
			create.executeUpdate();
			System.out.println("Employee created successfully");
		}
		catch(SQLException e) {
			System.out.println("SQL Exception....");
		}
	}
	public EmployeeDB readEmployee(int eid) {
		try {
			select.setInt(1,eid);
			ResultSet rs=select.executeQuery();
			if(rs.next()){
				String ename=rs.getString("ename");
				String degree=rs.getString("degree");
				double salary=rs.getDouble("salary");
				return new EmployeeDB(eid,ename,degree,salary);
			}
		}
		catch(SQLException e) {
			System.out.println("SQL Exception....");
		}
		return null;
		
	}
	public void updateEmployee(EmployeeDB employee) {
		try {
			update.setInt(1,employee.getEid());
			update.setString(2,employee.getEname());
			update.setString(3,employee.getDegree());
			update.setDouble(4,employee.getSalary());
			int rowsaffected=update.executeUpdate();
			if(rowsaffected>0) {
				System.out.println("Employee updated successfully");
			}
			else {
				System.out.println("Sorry,Not Found....Please Try again later!!!");
			}
		}
		catch(SQLException e) {
			System.out.println("SQL Exception....");
		}
	}
	public void deleteEmployee(int eid){
		try {
			delete.setInt(1, eid);
			int rowsdeleted=delete.executeUpdate();
			if(rowsdeleted>0) {
				System.out.println("Employee deleted successfully");
			}
			else {
				System.out.println("Sorry,Not Found....Please Try again later!!!");
			}
		}
		catch(SQLException e) {
			System.out.println("SQL Exception....");
		}
		
	}
	
	
	
}

