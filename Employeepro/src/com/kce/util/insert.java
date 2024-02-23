package com.kce.util;
public class insert {
public static void insertEmp()throws ClassNotFoundException
{
	con = Employee.getConnection();
	st = con.createStatement();
	st.executeUpdate("insert into employee values('Shan',109,05.01.2004,09.08.2023,'male')");
}
}
