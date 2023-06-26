package com.kce.bean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ClassDemo {
	public int id;
	public String name;
	public int weight;
	public int age;
	public String doctor;
	public String comments;
	public ClassDemo(int id,String name,int weight,int age,String doctor,String comments)
	{
		this.id=id;
		this.name=name;
		this.weight=weight;
		this.age=age;
		this.doctor=doctor;
		this.comments=comments;
	}
	public ClassDemo() {};
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) 
	{
		this.weight = weight;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	public String getDoctor() 
	{
		return doctor;
	}
	public void setDoctor(String doctor) 
	{
		this.doctor = doctor;
	}
	public String getComments() 
	{
		return comments;
	}
	public void setComments(String comments) 
	{
		this.comments = comments;
	}
	public void insert() throws SQLException 
	{
		try
		{
			 Connection con = null;
			 String DB_URL = "jdbc:mysql://localhost:3306/hospital_management";
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(DB_URL, "root", "#Nesamani5");
			 String insertQuery = "INSERT INTO hospital_management(id,name,weight,age,consultantdoctor,medicalcomments) VALUES (?,?, ?, ?, ?, ?)";
			 PreparedStatement insertStmt = con.prepareStatement(insertQuery);
			 insertStmt.setInt(1,id);
			 insertStmt.setString(2, name);
			 insertStmt.setInt(3, weight);
			 insertStmt.setInt(4, age);
			 insertStmt.setString(5, doctor);
			 insertStmt.setString(6, comments);
			 insertStmt.executeUpdate();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
	}
	public void show() throws SQLException
	{
		try
		{
		 Connection con = null;
		 String DB_URL = "jdbc:mysql://localhost:3306/hospital_management";
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection(DB_URL, "root", "#Nesamani5");
		 Statement stmt=con.createStatement();
		 String selectQuery = "SELECT * FROM hospital_management";
		 ResultSet resultSet = stmt.executeQuery(selectQuery);
		 if (!resultSet.isBeforeFirst()) {
		 System.out.println("No Patient record found!");
		 }
		 else
		 {
		 System.out.print(" ----- PATIENT DETAILS ----- ");
		 System.out.println();
		 System.out.print("\n--------------------------------------------------------------------------------------------------------------------------------------------\n");
		 String output = String.format("%-20s%-20s%-20s%-20s%-20s%s", "ID",
		"Name","Weight","Age","Consultantdoctor","Medicalcomments");
		 System.out.print(output);
		 System.out.print("\n--------------------------------------------------------------------------------------------------------------------------------------------\n");
		 System.out.println();
		 while (resultSet.next())
		 {
		 String output1 = String.format("%-20s%-20s%-20s%-20s%-20s%s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
		 System.out.print(output1);
		 System.out.println();
		 }
		 System.out.print("\n--------------------------------------------------------------------------------------------------------------------------------------------\n");
		 }
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
	}
}