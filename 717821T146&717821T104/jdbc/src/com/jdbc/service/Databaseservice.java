package com.jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.project.employee;
import com.jdbc.util.Database;
import com.jdbc.util.Query;

public class Databaseservice extends Database{
	Database database=new Database();
	//for insert an record
	public void insertEmployee(employee employee)throws SQLException
	{	
		try(Connection connection = database.getConnection();)
		{
			PreparedStatement preparedStatement = connection.prepareStatement(Query.insertEmployeeQuery());
			preparedStatement.setString(1, employee.getEmp_name());
			preparedStatement.setString(2,employee.getEmp_address());
			preparedStatement.setDouble((int) 3.,employee.getEmp_salary());
			int rows = preparedStatement.executeUpdate();
			if(rows > 0)
			{
				System.out.println("Record created successfully");
				System.out.println("---------------------------------------------");
			}
			else
			{
				System.out.println("Insert record failed");
				System.out.println("-----------------------------------------------");

			}
			
		}
	}
	//to get all the records in table
	public void getAllEmployee() throws SQLException
	{
		try(Connection connection = database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs= statement.executeQuery(Query.selectAllEmployeeQuery());)
		{
			while(rs.next())
			{
				printEmployee(new employee(rs.getInt("employee_id"),
						rs.getString("employee_name"),
						rs.getString("employee_address"),
						rs.getDouble("employee_salary")	
						));
			}
		}
	}
	//to print all the records in table
	public void printEmployee(com.jdbc.project.employee employee)
	{
		System.out.println("----------------------------------------------------");
		System.out.println("Employee id : "+employee.getEmp_id());
		System.out.println("Employee name : "+employee.getEmp_name());
		System.out.println("Employee Address : "+employee.getEmp_address());
		System.out.println("Employee Salary : "+employee.getEmp_salary());
		System.out.println("-----------------------------------------------------");
	}
	//get details by using id
	public boolean getEmployeeById(int id) throws SQLException
	{
		boolean i=false;
		try(Connection connection =  database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs=statement.executeQuery(Query.selectEmployeeById(id));
				)
		
		{
			if(rs.next()) {
				i=true;
				printEmployee(new employee(rs.getInt("employee_id"),rs.getString("employee_name"),rs.getString("employee_address"),rs.getDouble("employee_salary")));
				System.out.println("-----------------------------------------------");

			}
			else
			{
				System.out.println("rocord has been not found");
				System.out.println("-----------------------------------------------");

			}
		}
		return i;
	}
	//delete an record
	public void deleteEmployeeById(int emp_id) throws SQLException
	{
		try(Connection connection = database.getConnection();
				Statement statement=connection.createStatement();
				)
		{
			int rows = statement.executeUpdate(Query.deleteEmployeeById(emp_id));
			if(rows>0)
			{
				System.out.println("recrod deleted successfully..!");
				System.out.println("-----------------------------------------------");

			}
			else
			{
				throw new invalidinputExcepiton("you have entered an invalid id in table to delete....!");
			}
		}
		catch(invalidinputExcepiton e)
		{
			System.out.println(e+""+e.getMessage());
			System.out.println("-----------------------------------------------");
		}
	}
	//to update an record
	public void updateEmployee(employee employee) throws SQLException
	{
		try(Connection connection = database.getConnection();
			PreparedStatement prepareStatement =	connection.prepareStatement(Query.updateEmployeeQuery(employee.getEmp_id())))
		{
				prepareStatement.setString(1,employee.getEmp_name());
				prepareStatement.setString(2,employee.getEmp_address());
				prepareStatement.setDouble(3,employee.getEmp_salary());
				int rows=prepareStatement.executeUpdate();
				if(rows>0)
				{
					System.out.println("record updated successfully...!");
					System.out.println("------------------------------------------------");
				}
				else
				{
					System.out.println("failed to update the record..!");
				}
				
		}
		
	}
}
