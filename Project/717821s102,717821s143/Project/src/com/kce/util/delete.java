package com.kce.util;

import java.sql.*;
import java.util.Scanner;

public class delete {
 public void deletemethod(int n) {
	 try {
		 Scanner sc=new Scanner(System.in);
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project\",\"root\",\"Aish942004*");
		 PreparedStatement st=con.prepareStatement();
		if(n==1) {
			st.updateQuery("delete from student where id=?;");
			int id=sc.nextInt();
			st.setInt(1,id);
		}else if(n==2) {
			st.updateQuery("delete from student where name=?;");
			String name=sc.nextLine();
			st.setString(1,name);
		}else(n==3) {
			st.upadateQuery("delete from student where course=?;");
			String course=sc.nextLine();
			st.setString(1course);
		}
	 }catch(Exception e) {
		 System.out.println(e);
	 }
 }
}
