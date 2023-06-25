package com.kce.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;

import com.kce.bean.Student;
import com.kce.util.JDBCConnection;

public class DataBase {
	JDBCConnection jdbc = null;
	public void insert(Student student) throws SQLException {
		if(student==null) return;
		String name = student.getName();
		String gender = student.getGender();
		int age = student.getAge();
		String rollNo = student.getRollNo();
		int grades = student.getGrades();
		PreparedStatement ps = jdbc.getPreparedStatement("insert students values(?,?,?,?,?)");
		/* PreaparedStatement for the data base is getter from JDBCConnection class thats 
		 has the steps for establishing connection*/
		ps.setString(1,name);
		ps.setInt(2,age);
		ps.setString(3,gender);
		ps.setInt(4,grades);
		ps.setString(5,rollNo);
		int status = ps.executeUpdate();
		/* data is inserted in order respective type on database*/
		int print = 0;
		while(print<25) {
			print++;
			System.out.print("-");
		}
		if(status>0){
			System.out.println("\n\ndata inserted\n\n");
		}
		else {
			System.out.println("\n\ndata is not inserted\n");
		}
		print = 0;
		while(print<25) {
			print++;
			System.out.print("-");
		}
		System.out.println();
	}
	public void deleteByRollNo(String rollNo) throws SQLException {
		PreparedStatement ps = jdbc.getPreparedStatement("DELETE from students where rollNo = ?");
		ps.setString(1, rollNo);
		int status = ps.executeUpdate();
		int print = 0;
		while(print<25) {
			print++;
			System.out.print("-");
		}
		if(status>0){
			System.out.println("\n\ndeletion successfull\n\n");
		}
		else {
			System.out.println("\n\ndeletion is not successfull\n");
		}
		print = 0;
		while(print<25) {
			print++;
			System.out.print("-");
		}
		System.out.println();
	}
	public void deleteByName(String name) throws SQLException {
		PreparedStatement ps = jdbc.getPreparedStatement("DELETE from students where name = ?");
		ps.setString(1, name);
		int status = ps.executeUpdate();
		int print = 0;
		while(print<25) {
			print++;
			System.out.print("-");
		}
		if(status>0){
			System.out.println("\n\ndeletion successfull\n\n");
		}
		else {
			System.out.println("\n\ndeletion is not successfull\n");
		}
		print = 0;
		while(print<25) {
			print++;
			System.out.print("-");
		}
		System.out.println();
	}
	public void display() throws SQLException {
		PreparedStatement ps = jdbc.getPreparedStatement("SELECT * from Students");
		ResultSet rs = ps.executeQuery();
		@SuppressWarnings("resource")
		Formatter frmt = new Formatter();
		/*
		 * Formatter is used to get the output in the specified format
		 * as similar to a table
		 */
		frmt.format("%-35s| %-20s| %-20s| %-20s| %-20s\n", 
				"Name","Age","Gender","Grades","RollNo");
		/*
		 * Formatter is used to format the output string as we required
		 */
		while(rs.next()) {
			frmt.format("%-35s| %-20s| %-20s| %-20s| %-20s\n", 
					rs.getString(1),rs.getInt(2),rs.getString(3)
					,rs.getInt(4),rs.getString(5));
		}
		int print = 0;
		while(print<25) {
			print++;
			System.out.print("-");
		}
		System.out.println("\n\n");
		System.out.println(frmt.toString());
		System.out.println();
		print = 0;
		while(print<25) {
			print++;
			System.out.print("-");
		}
		System.out.println();
		/*
		 * Formatter has the all executed results and store that on
		 * Formatter object
		 */
	}
	public void updateByRollNo(String rollNo,int grades) throws Exception{
		PreparedStatement ps = jdbc.getPreparedStatement("update Students set grades = ? where rollNo = ?");
		ps.setInt(1,grades);
		ps.setString(2, rollNo);
		int update = ps.executeUpdate();
		int print = 0;
		while(print<25) {
			print++;
			System.out.print("-");
		}
		if(update>0){
			System.out.println("\n\nupdation successfull\n\n");
		}
		else {
			System.out.print("\n\nupdation is not successfull\n\n");
		}
		print = 0;
		while(print<25) {
			print++;
			System.out.print("-");
		}
		System.out.println();
		ps.close();
	}
	public void updateByName(String name,int grades) throws Exception {
		PreparedStatement ps = jdbc.getPreparedStatement("update Students set grades = ? where name = ?");
		ps.setInt(1,grades);
		ps.setString(2, name);
		/*
		 * update query on PreparedStatement to grade with name
		 */
		int print = 0;
		while(print<25) {
			print++;
			System.out.print("-");
		}
		int update = ps.executeUpdate(); // to execute statement
		if(update>0){
			System.out.println("\n\nupdation successfull\n\n");
		}
		else {
			System.out.print("\n\nupdation is not successfull\n\n");
		}
		print = 0;
		while(print<25) {
			print++;
			System.out.print("-");
		}
		System.out.println();
		ps.close();
	}
	public void updateName(String oldName,String newName) throws Exception {
		PreparedStatement ps = jdbc.getPreparedStatement("update Students set name = ? where name = ?");
		ps.setString(1,newName); 
		ps.setString(2, oldName);
		/*
		 * update old Name of user with new Name
		 */
		int update = ps.executeUpdate(); // execute the query
		int print = 0;
		while(print<25) {
			print++;
			System.out.print("-");
		}
		if(update>0){
			System.out.println("\n\nupdation successfull\n\n");
		}
		else {
			System.out.print("\n\nupdation is not successfull\n\n");
		}
		print = 0;
		while(print<25) {
			print++;
			System.out.print("-");
		}
		System.out.println();
		ps.close();
	}
	public void updateRollNo(String oldRollNo,String newRollNo) throws Exception {
		PreparedStatement ps = jdbc.getPreparedStatement("update Students set rollNo = ? where rollNo = ?");
		ps.setString(1,newRollNo);
		ps.setString(2, oldRollNo);
		int update = ps.executeUpdate();
		int print = 0;
		while(print<25) {
			print++;
			System.out.print("-");
		}
		if(update>0){
			System.out.println("\n\nupdation successfull\n\n");
		}
		else {
			System.out.println("\n\nupdation is not successfull\n");
		}
		print = 0;
		while(print<25) {
			print++;
			System.out.print("-");
		}
		System.out.println();
		ps.close();
	}
	public DataBase()throws SQLException{
		jdbc = new JDBCConnection();
	}
}
