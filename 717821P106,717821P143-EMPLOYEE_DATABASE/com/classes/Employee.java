package com.classes;

import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.util.Scanner;
public class Employee {
public static void main(String[] args)throws Exception {
try {
Scanner s=new Scanner(System.in);
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/vk_hotelbookings","root","Dream8");
Statement st=c.createStatement();
ResultSet r;
while(true) {
System.out.println("Enter 0 to exit ");
System.out.println("Enter 1 to display employee details ");
System.out.println("Enter 2 to insert a record ");
System.out.println("Enter 3 to delete a record ");
System.out.println("Enter 4 to update a record ");
String s1=s.nextLine();
if(s1.equals("0"))
break;
else if(s1.equals("1")) {
System.out.println("Enter 1 to display all records , 2 to display particular record");
String s0=s.nextLine();
if(s0.equals("1")) {
r=st.executeQuery("select * from employee ");
while(r.next()) {
System.out.println("ID : "+r.getInt(1)+" "+"NAME : "+r.getString(2)+" DESIGNATION : "+r.getString(3)+" SALARY : "+r.getInt(4)+" PHONE_NO : "+r.getString(5));
}
}
else if(s0.equals("2")) {
System.out.println("Enter employee id to display : ");
String s9=s.nextLine();
r=st.executeQuery("select * from employee where id="+s9);
while(r.next()) {
System.out.println("ID : "+r.getInt(1)+" "+"NAME : "+r.getString(2)+" DESIGNATION : "+r.getString(3)+" SALARY : "+r.getInt(4)+" PHONE_NO : "+r.getString(5));
}
}
else
System.out.println("Enter valid input");
}
else if(s1.equals("2")) {
System.out.println("Enter employee id : ");
String s2=s.nextLine();
System.out.println("Enter employee name : ");
String s3=s.nextLine();
System.out.println("Enter designation : ");
String s4=s.nextLine();
System.out.println("Enter salary : ");
String s5=s.nextLine();
System.out.println("Enter phone number : ");
String s6=s.nextLine();
st.executeUpdate("insert into employee values("+s2+",'"+s3+"','"+s4+"',"+s5+",'"+s6+"')");
System.out.println("Values inserted successfully !");
}
else if(s1.equals("3")) {
System.out.println("Enter the employee id to delete : ");
String s7=s.nextLine();
st.executeUpdate("delete from employee where id="+s7);
System.out.println("Record deleted successfully !");
}
else if(s1.equals("4")) {
System.out.println("Enter employee id to update ");
String s10=s.nextLine();
System.out.println("Enter column to update(id,name,designation,salary,phone_no)");
String s8=s.nextLine();
String s9=null;
if(s8.equals("id")) {
System.out.println("Enter new id :");
s9=s.nextLine();
st.executeUpdate("update employee set id="+s9+"where id="+s10);
}
else if(s8.equals("name")) {
System.out.println("Enter new name :");
s9=s.nextLine();
st.executeUpdate("update employee set name='"+s9+"' where id="+s10);
}
else if(s8.equals("designation")) {
System.out.println("Enter new designation :");
s9=s.nextLine();
st.executeUpdate("update employee set designation='"+s9+"' where id="+s10);
}
else if(s8.equals("salary")) {
System.out.println("Enter new salary :");
s9=s.nextLine();
st.executeUpdate("update employee set salary="+s9+"where id="+s10);
}
else if(s8.equals("phone_no")) {
System.out.println("Enter new phone no :");
s9=s.nextLine();
st.executeUpdate("update employee set phone_no+='"+s9+"' where id="+s10);
}
else
System.out.println("Enter valid input ");
}
else
System.out.println("Enter valid input");
}
s.close();
}catch(Exception e) {
System.out.println(e);
}
}
}
