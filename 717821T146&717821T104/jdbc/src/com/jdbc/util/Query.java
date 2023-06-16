package com.jdbc.util;

public class Query {
	//queries for the CRUD operations
	public static String insertEmployeeQuery()
	{
		return "insert into employee (employee_name,employee_address,employee_salary) values(?,?,?)";
	}
	public static  String selectAllEmployeeQuery()
	{
		return "select * from employee";
	}
	public static String selectEmployeeById(int emp_id)
	{
		return "select * from employee where  employee_id = "+emp_id;
	}
	public static String deleteEmployeeById(int emp_id)
	{
		return "delete from employee where employee_id = "+emp_id ;
	}
	public static String updateEmployeeQuery(int emp_id)
	{
		return "update employee set employee_name = ? , employee_address = ? , employee_salary = ? where employee_id = "+emp_id;
	}
}
