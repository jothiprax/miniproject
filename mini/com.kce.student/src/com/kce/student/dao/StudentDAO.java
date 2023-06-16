package com.kce.student.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import com.kce.student.bean.Grade;
import com.kce.student.bean.Student;
import com.kce.student.util.DBUtil;
import com.kce.student.util.DuplicateKeyException;


//Data Access Object class for student management
public class StudentDAO {
 private Connection connection;
 

 public StudentDAO() throws ClassNotFoundException {
     connection = DBUtil.getConnection();
 }
 
 public void addStudent(Student student) throws DuplicateKeyException, SQLException{
	 try {
	 PreparedStatement statement = connection.prepareStatement("INSERT INTO students (student_id, name, age) VALUES (?, ?, ?)");
     statement.setInt(1, student.getRollNumber());
     statement.setString(2, student.getName());
     statement.setInt(3, student.getAge());
     statement.executeUpdate();
     statement.close();
	 }
	 catch(SQLIntegrityConstraintViolationException e) {
		 System.out.println("!!!!!!....ID already Exit\n Try with new ID");
	 }
	 
 
 }

 
 public void updateStudent(Student student) throws SQLException{
     PreparedStatement statement = connection.prepareStatement(
             "UPDATE students SET name = ?, age = ? WHERE student_id = ?");
     statement.setString(1, student.getName());
     statement.setInt(2, student.getAge());
     statement.setInt(3, student.getRollNumber());
     int rowsAffected= statement.executeUpdate();
     if(rowsAffected!=0) {
     System.out.println("Student updated successfully!");
     }
 }

 public void deleteStudent(int studentId) throws SQLException {
     PreparedStatement statement = connection.prepareStatement(
             "DELETE FROM students WHERE student_id = ?");
     statement.setInt(1, studentId);
     int rowsAffected = statement.executeUpdate();
     if(rowsAffected!=0) {
    	 System.out.println("Student deleted successfully!"); 
     }  
 }

 public void displayAllStudents() throws SQLException {
     Statement statement = connection.createStatement();
     ResultSet resultSet = statement.executeQuery("SELECT students.student_id,students.name,students.age,grades.grade FROM students JOIN grades on students.student_id=grades.student_id;");
     while (resultSet.next()) {
         int studentId = resultSet.getInt("students.student_id");
         String name = resultSet.getString("students.name");
         int age = resultSet.getInt("students.age");
         String grade=resultSet.getString("grades.grade");
         System.out.println("Student ID: " + studentId);
         System.out.println("Name: " + name);
         System.out.println("Age: " + age);
         System.out.println("Grade: "+grade);
         System.out.println();
     }
 }
 public void searchStudent(int RollNo) throws SQLException {
	 
	 String query = "SELECT * FROM students WHERE student_id = ?";
	 PreparedStatement statement = connection.prepareStatement(query);
	 statement.setInt(1, RollNo);
	 ResultSet resultSet = statement.executeQuery();
     while (resultSet.next()) {
         int studentId = resultSet.getInt("student_id");
         String name = resultSet.getString("name");
         int age = resultSet.getInt("age");
         System.out.println("Student ID: " + studentId);
         System.out.println("Name: " + name);
         System.out.println("Age: " + age);
     }
     statement.close();
     
     statement=connection.prepareStatement("select grade from grades where student_id=?");
     statement.setInt(1, RollNo);
     ResultSet resultSet1 = statement.executeQuery();
     while (resultSet1.next()) {
         String grade = resultSet1.getString("grade");
         System.out.println("Grade: " + grade);
         
     }
    
 }
 
 public void addGrade(Student student) throws SQLException {
	 try {
	 PreparedStatement statement= connection.prepareStatement("INSERT INTO grades (student_id,grade) VALUES (?, ?)");
     statement.setInt(1, student.getRollNumber());
     statement.setString(2, student.getGrade());
     statement.executeUpdate();
     statement.close();
	 }
	 catch(Exception e) {
		 
	 }
 }
 public void updateGrade(Student student) throws SQLException{
     PreparedStatement statement = connection.prepareStatement(
             "UPDATE students SET Grade=? WHERE student_id = ?");
     
     statement.setString(1, student.getGrade());
     statement.setInt(2, student.getRollNumber());
     int rowsAffected= statement.executeUpdate();
     if(rowsAffected!=0) {
     System.out.println("Student updated successfully!");
     }
 }
 public void deleteGrade(int studentId) throws SQLException {
     PreparedStatement statement = connection.prepareStatement("DELETE FROM grades WHERE student_id = ?");
     statement.setInt(1, studentId);
     statement.executeUpdate();
     }
public void displayByGrade(String grade) throws SQLException {
	 
 String query = "SELECT students.student_id,students.name,students.age,grades.grade FROM students JOIN grades on students.student_id=grades.student_id where grades.grade= ?";
	 PreparedStatement statement = connection.prepareStatement(query);
	 statement.setString(1, grade);
	 ResultSet resultSet = statement.executeQuery();
     while (resultSet.next()) {
         int studentId = resultSet.getInt("students.student_id");
         String name = resultSet.getString("students.name");
         int age = resultSet.getInt("students.age");
         String grad=resultSet.getString("grades.grade");
         System.out.println("Student ID: " + studentId);
         System.out.println("Name: " + name);
         System.out.println("Age: " + age);
         System.out.println("Grade :"+grad);
         
         System.out.println();
     }
    
 }


 

 public Grade chooseGrade(int n) {
	 Grade g = null;
	 while(true) {
	 if(n==1) {
	   g= Grade.O;
	 }
	 else if(n==2) {
		   g=Grade.A;
		 }
	 else if(n==3) {
		   g=Grade.B;
		 }
	 else if(n==4) {
		   g=Grade.C;
		 }
	 else {
		 System.out.println("enter a valid choice");
	 }
	 
	 return g;
 }
 }
}