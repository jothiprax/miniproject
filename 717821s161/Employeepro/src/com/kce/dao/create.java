package com.kce.dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class create {
private static Connection con;
private static Statement st;
private static ResultSet rs;
public static void createEmp()throws Exception
{
	con = Employee.getConnection();
	st = con.createStatement();
	st.execute("create table employee(name varchar(20),id int,dob date,doj date,gender varchar(20)");
}
}
