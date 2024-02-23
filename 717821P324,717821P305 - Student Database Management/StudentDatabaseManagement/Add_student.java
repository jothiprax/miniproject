package StudentDatabaseManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add_student {
 private int id;
 private String name;
 private int age;
 private String gender;
 private String grade;
public Add_student(int id, String name, int age, String gender, String grade) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.grade = grade;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
 public void add_student(Connection con) throws SQLException {
	 String query="insert into student values(?,?,?,?,?)";
	 PreparedStatement ps=con.prepareStatement(query);
	 ps.setInt(1, id);
	 ps.setString(2, name);
	 ps.setInt(3, age);
	 ps.setString(4, gender);
	 ps.setString(5, grade);
	 ps.executeUpdate();
 }
}
