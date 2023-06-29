package com.kce.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Scanner;

import com.kce.bean.Employee;
import com.kce.util.DBUtil;





public class EmployeeDAO{
static Scanner sc = new Scanner(System.in);







public static void insert(int a) {
try {
	Employee[] arr = new Employee[a];
for (int i = 0; i < a; i++) {
System.out.println("Enter employee id: ");
int id = sc.nextInt();
System.out.println("Enter the employee name: ");
String name = sc.next();
System.out.println("Enter the department: ");
String department = sc.next();
System.out.println("Enter the joindate (DD/MM/YYYY): ");
String joindate = sc.next();
System.out.println("Enter the gender:");
String gender=sc.next();
System.out.println("Enter the contact number:");
String contact=sc.next();
System.out.println("Enter the salary: ");
int salary = sc.nextInt();
System.out.println("Enter the email id:");
String email=sc.next();


 arr[i] = new Employee(id, name,department,joindate,gender,contact,salary,email);
}

Connection con = DBUtil.getConnection();
PreparedStatement stmt = con.prepareStatement("insert into Employee2 values(?,?,?,?,?,?,?,?)");
for (int i = 0; i < a; i++) {
stmt.setInt(1, arr[i].getId());
stmt.setString(2, arr[i].getName());
stmt.setString(3, arr[i].getDepartment());
stmt.setString(4, arr[i].getJoindate());
stmt.setString(5, arr[i].getGender());
stmt.setString(6, arr[i].getContact());
stmt.setInt(7, arr[i].getSalary());
stmt.setString(8,arr[i].getEmail());
stmt.executeUpdate();
}

System.out.println("Data collected successfully");
} catch (SQLException e) {
System.out.println(e);
} 
}



public static void update() {
try {
Connection con = DBUtil.getConnection();
PreparedStatement stmt = con.prepareStatement("UPDATE Employee2 SET salary = ? WHERE Id = ?");
System.out.println("Enter Employee id: ");
int id = sc.nextInt();
System.out.println("Enter the department: ");
int salary = sc.nextInt();
stmt.setInt(1, salary);
stmt.setInt(2, id);
int rowsAffected = stmt.executeUpdate();

if (rowsAffected > 0) {
System.out.println("Update successful");
} else {
System.out.println("No records found for the given bus id");
}
} catch (SQLException e) {
System.out.println("Error: " + e.getMessage());
}
}

public static void delete() {
try {
Connection con = DBUtil.getConnection();
PreparedStatement stmt = con.prepareStatement("DELETE FROM Employee2 WHERE name = ?");
System.out.println("Enter Employee name: ");
String name = sc.next();
stmt.setString(1, name);
int rowsAffected = stmt.executeUpdate();

if (rowsAffected > 0) {
System.out.println("Delete successful");
} else {
System.out.println("No records found for the given employee id");
}
} catch (SQLException e) {
System.out.println("Error: " + e.getMessage());
}
}
public static void displayTable() {
try {
Connection con = DBUtil.getConnection();
PreparedStatement stmt = con.prepareStatement("SELECT * FROM Employee2");
ResultSet rs = stmt.executeQuery();

System.out.println("Employee Details:");
System.out.println("---------------------------------------------------------------------------------------------------------------------------");
System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "id", "name", "department","joindate","gender","contact","salary","email");

while (rs.next()) {

System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8));
}
//rs.close();
} catch (SQLException e) {
System.out.println("Error: " + e.getMessage());
}
}
public static double getSeatPrice(int id) {
try {
Connection con = DBUtil.getConnection();
PreparedStatement stmt = con.prepareStatement("SELECT * FROM Employee2 WHERE id = ?");
stmt.setInt(1, id);
ResultSet rs = stmt.executeQuery();

if (rs.next()) {
double seatPrice = rs.getDouble("priceOfSingleSeat");
return seatPrice;
} else {
throw new IllegalArgumentException("No records found for the given bus id");
}
} catch (SQLException e) {
throw new IllegalArgumentException("Error: " + e.getMessage(), e);
}
}


}
