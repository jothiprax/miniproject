package com.kce.service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.kce.dao.DBUtil;
public class Admission {
       
public void select() throws ClassNotFoundException,SQLException 
{
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter the Department Name: ");
		String deptname=sc.nextLine();
		System.out.println("Enter the Name: ");
		   String name = sc.nextLine();
		   System.out.println("Enter the DOB: ");
		   String DOB = sc.nextLine();
		   System.out.println("Department Name: ");
		   String dept = sc.nextLine();
		   System.out.println("FatherName: ");
		   String a = sc.nextLine();
		   System.out.println("MotherName: ");
		   String b = sc.nextLine();
		   System.out.println("Phonenumber: ");
		   String c = sc.nextLine();
		   System.out.println("Address: ");
		   String d = sc.nextLine();
		   System.out.println("AadharcardNumber: ");
		   String e = sc.nextLine();
		   System.out.println("SSLCMark: ");
		   int f = sc.nextInt();
		   System.out.println("HSCmark: ");
		   int g = sc.nextInt();
		   System.out.println("Cutoffmark: ");    	   
		   int h = sc.nextInt();
		   System.out.println("Emailid: ");
		   String i = sc.next();
		if(deptname.equals("CSE")) {
			Connection con = DBUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into CSE values(?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,name);
			stmt.setString(2, DOB);
			stmt.setString(3, dept);
			stmt.setString(4, a);
			stmt.setString(5, b);
			stmt.setString(6, c);
			stmt.setString(7, d);
			stmt.setString(8, e);
			stmt.setInt(9, f);
			stmt.setInt(10, g);
			stmt.setInt(11, h);
			stmt.setString(12, i);
			stmt.executeUpdate();
		}
		else if(deptname.equals("IT")) {
			Connection con = DBUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into IT values(?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,name);
			stmt.setString(2, DOB);
			stmt.setString(3, dept);
			stmt.setString(4, a);
			stmt.setString(5, b);
			stmt.setString(6, c);
			stmt.setString(7, d);
			stmt.setString(8, e);
			stmt.setInt(9, f);
			stmt.setInt(10, g);
			stmt.setInt(11, h);
			stmt.setString(12, i);
			stmt.executeUpdate();
		}
		else if(deptname.equals("ECE")) {
			Connection con = DBUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into ECE values(?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,name);
			stmt.setString(2, DOB);
			stmt.setString(3, dept);
			stmt.setString(4, a);
			stmt.setString(5, b);
			stmt.setString(6, c);
			stmt.setString(7, d);
			stmt.setString(8, e);
			stmt.setInt(9, f);
			stmt.setInt(10, g);
			stmt.setInt(11, h);
			stmt.setString(12, i);
			stmt.executeUpdate();
		}
		else if(deptname.equals("EEE")) {
			Connection con = DBUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into EEE values(?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,name);
			stmt.setString(2, DOB);
			stmt.setString(3, dept);
			stmt.setString(4, a);
			stmt.setString(5, b);
			stmt.setString(6, c);
			stmt.setString(7, d);
			stmt.setString(8, e);
			stmt.setInt(9, f);
			stmt.setInt(10, g);
			stmt.setInt(11, h);
			stmt.setString(12, i);
			stmt.executeUpdate();
		}
		else if(deptname.equals("MECH")) {
			Connection con = DBUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into MECH values(?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,name);
			stmt.setString(2, DOB);
			stmt.setString(3, dept);
			stmt.setString(4, a);
			stmt.setString(5, b);
			stmt.setString(6, c);
			stmt.setString(7, d);
			stmt.setString(8, e);
			stmt.setInt(9, f);
			stmt.setInt(10, g);
			stmt.setInt(11, h);
			stmt.setString(12, i);
			stmt.executeUpdate();
			}
			else {
				System.out.println("Invalid");
			}
	}
	catch(Exception e) {
		System.out.println(e);
	}
	
}
public void insert() {
	 try(Scanner sc = new Scanner(System.in))
	 {
		       System.out.println("Enter the Department Name to insert: ");
			   String deptname=sc.nextLine();
			   System.out.println("Enter the Name: ");
			   String name = sc.nextLine();
			   System.out.println("Enter the DOB: ");
			   String DOB = sc.nextLine();
			   System.out.println("Department Name: ");
			   String dept = sc.nextLine();
			   System.out.println("FatherName: ");
			   String a = sc.nextLine();
			   System.out.println("MotherName: ");
			   String b = sc.nextLine();
			   System.out.println("Phonenumber: ");
			   String c = sc.nextLine();
			   System.out.println("Address: ");
			   String d = sc.nextLine();
			   System.out.println("AadharcardNumber: ");
			   String e = sc.nextLine();
			   System.out.println("SSLCMark: ");
			   int f = sc.nextInt();
			   System.out.println("HSCmark: ");
			   int g = sc.nextInt();
			   System.out.println("Cutoffmark: ");    	   
			   int h = sc.nextInt();
			   System.out.println("Emailid: ");
			   String i = sc.next();
			   if(deptname.equals("CSE")) {
					Connection con = DBUtil.getConnection();
					PreparedStatement stmt = con.prepareStatement("insert into CSE values(?,?,?,?,?,?,?,?,?,?,?,?)");
					stmt.setString(1,name);
					stmt.setString(2, DOB);
					stmt.setString(3, dept);
					stmt.setString(4, a);
					stmt.setString(5, b);
					stmt.setString(6, c);
					stmt.setString(7, d);
					stmt.setString(8, e);
					stmt.setInt(9, f);
					stmt.setInt(10, g);
					stmt.setInt(11, h);
					stmt.setString(12, i);
					stmt.executeUpdate();
					Connection con1=DBUtil.getConnection();
					Statement stat = con1.createStatement();
					ResultSet rs = stat.executeQuery("Select * from cse");
					while(rs.next()) {
						System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
	 }
}
			   else if(deptname.equals("IT")) {
					Connection con = DBUtil.getConnection();
					PreparedStatement stmt = con.prepareStatement("insert into IT values(?,?,?,?,?,?,?,?,?,?,?,?)");
					stmt.setString(1,name);
					stmt.setString(2, DOB);
					stmt.setString(3, dept);
					stmt.setString(4, a);
					stmt.setString(5, b);
					stmt.setString(6, c);
					stmt.setString(7, d);
					stmt.setString(8, e);
					stmt.setInt(9, f);
					stmt.setInt(10, g);
					stmt.setInt(11, h);
					stmt.setString(12, i);
					stmt.executeUpdate();
					Connection con1=DBUtil.getConnection();
					Statement stat = con1.createStatement();
					ResultSet rs =stat.executeQuery("select *from IT");
					while(rs.next()) {
						System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
	 }
}
			   else if(deptname.equals("ECE")) {
					Connection con = DBUtil.getConnection();
					PreparedStatement stmt = con.prepareStatement("insert into ECE values(?,?,?,?,?,?,?,?,?,?,?,?)");
					stmt.setString(1,name);
					stmt.setString(2, DOB);
					stmt.setString(3, dept);
					stmt.setString(4, a);
					stmt.setString(5, b);
					stmt.setString(6, c);
					stmt.setString(7, d);
					stmt.setString(8, e);
					stmt.setInt(9, f);
					stmt.setInt(10, g);
					stmt.setInt(11, h);
					stmt.setString(12, i);
					stmt.executeUpdate();
					Connection con1=DBUtil.getConnection();
					Statement stat = con1.createStatement();
					ResultSet rs =stat.executeQuery("select *from ECE");
					while(rs.next()) {
						System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
	 }
}
			   else if(deptname.equals("EEE")) {
					Connection con = DBUtil.getConnection();
					PreparedStatement stmt = con.prepareStatement("insert into EEE values(?,?,?,?,?,?,?,?,?,?,?,?)");
					stmt.setString(1,name);
					stmt.setString(2, DOB);
					stmt.setString(3, dept);
					stmt.setString(4, a);
					stmt.setString(5, b);
					stmt.setString(6, c);
					stmt.setString(7, d);
					stmt.setString(8, e);
					stmt.setInt(9, f);
					stmt.setInt(10, g);
					stmt.setInt(11, h);
					stmt.setString(12, i);
					stmt.executeUpdate();
					Connection con1=DBUtil.getConnection();
					Statement stat = con1.createStatement();
					ResultSet rs =stat.executeQuery("select *from EEE");
					while(rs.next()) {
						System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
	 }
}
			   else if(deptname.equals("MECH")) {
					Connection con = DBUtil.getConnection();
					PreparedStatement stmt = con.prepareStatement("insert into MECH values(?,?,?,?,?,?,?,?,?,?,?,?)");
					stmt.setString(1,name);
					stmt.setString(2, DOB);
					stmt.setString(3, dept);
					stmt.setString(4, a);
					stmt.setString(5, b);
					stmt.setString(6, c);
					stmt.setString(7, d);
					stmt.setString(8, e);
					stmt.setInt(9, f);
					stmt.setInt(10, g);
					stmt.setInt(11, h);
					stmt.setString(12, i);
					stmt.executeUpdate();
					Connection con1=DBUtil.getConnection();
					Statement stat = con1.createStatement();
					ResultSet rs =stat.executeQuery("select *from MECH");
					while(rs.next()) {
						System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
	 }
 }
}
			   catch(Exception e) {
				   System.out.println(e);
			   }
	 }


public void update() {
	try(Scanner sc = new Scanner(System.in)){
	      System.out.println("Enter the Department Name to update: ");
				   String deptname=sc.nextLine();
				   System.out.println("Enter the Name: ");
				   String name = sc.nextLine();
				   System.out.println("Enter the DOB: ");
				   String DOB = sc.nextLine();
				   System.out.println("Department Name: ");
				   String dept = sc.nextLine();
				   System.out.println("FatherName: ");
				   String a = sc.nextLine();
				   System.out.println("MotherName: ");
				   String b = sc.nextLine();
				   System.out.println("Phonenumber: ");
				   String c = sc.nextLine();
				   System.out.println("Address: ");
				   String d = sc.nextLine();
				   System.out.println("AadharcardNumber: ");
				   String e = sc.nextLine();
				   System.out.println("SSLCMark: ");
				   int f = sc.nextInt();
				   System.out.println("HSCmark: ");
				   int g = sc.nextInt();
				   System.out.println("Cutoffmark: ");    	   
				   int h = sc.nextInt();
				   System.out.println("Emailid: ");
				   String i = sc.next();
				   if(deptname.equals("CSE")) {
						Connection con = DBUtil.getConnection();
						PreparedStatement stmt = con.prepareStatement("update CSE set DOB= ?,DepartmentName=?,FatherName=?,MotherName=?,Phonenumber=?,Address=?,AatharcardNumber=?,SSLCmark=?,HSCMark=?,CutOffMark=?,Emailid=? where Name=?");
						stmt.setString(1,DOB);
						stmt.setString(2, dept);
						stmt.setString(3, a);
						stmt.setString(4, b);
						stmt.setString(5, c);
						stmt.setString(6, d);
						stmt.setString(7, e);
						stmt.setInt(8, f);
						stmt.setInt(9, g);
						stmt.setInt(10,h);
						stmt.setString(11,i);
						stmt.setString(12, name);
						stmt.executeUpdate();
						Connection con1=DBUtil.getConnection();
						Statement stat = con1.createStatement();
						ResultSet rs = stat.executeQuery("Select * from CSE");
						while(rs.next()) {
							System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
		 }
	}
				   else if(deptname.equals("IT")) {
						Connection con = DBUtil.getConnection();
						PreparedStatement stmt = con.prepareStatement("update IT set DOB= ?,DepartmentName=?,FatherName=?,MotherName=?,Phonenumber=?,Address=?,AatharcardNumber=?,SSLCmark=?,HSCMark=?,CutOffMark=?,Emailid=? where Name=?");
						stmt.setString(1,DOB);
						stmt.setString(2, dept);
						stmt.setString(3, a);
						stmt.setString(4, b);
						stmt.setString(5, c);
						stmt.setString(6, d);
						stmt.setString(7, e);
						stmt.setInt(8, f);
						stmt.setInt(9, g);
						stmt.setInt(10,h);
						stmt.setString(11,i);
						stmt.setString(12, name);
						stmt.executeUpdate();
						Connection con1=DBUtil.getConnection();
						Statement stat = con1.createStatement();
						ResultSet rs = stat.executeQuery("Select * from IT");
						while(rs.next()) {
							System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
		 }
	}
				   else if(deptname.equals("ECE")) {
						Connection con = DBUtil.getConnection();
						PreparedStatement stmt = con.prepareStatement("update ECE set DOB= ?,DepartmentName=?,FatherName=?,MotherName=?,Phonenumber=?,Address=?,AatharcardNumber=?,SSLCmark=?,HSCMark=?,CutOffMark=?,Emailid=? where Name=?");
						stmt.setString(1,DOB);
						stmt.setString(2, dept);
						stmt.setString(3, a);
						stmt.setString(4, b);
						stmt.setString(5, c);
						stmt.setString(6, d);
						stmt.setString(7, e);
						stmt.setInt(8, f);
						stmt.setInt(9, g);
						stmt.setInt(10,h);
						stmt.setString(11,i);
						stmt.setString(12, name);
						stmt.executeUpdate();
						Connection con1=DBUtil.getConnection();
						Statement stat = con1.createStatement();
						ResultSet rs = stat.executeQuery("Select * from ECE");
						while(rs.next()) {
							System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
		 }
	}
				   else if(deptname.equals("EEE")) {
						Connection con = DBUtil.getConnection();
						PreparedStatement stmt = con.prepareStatement("update EEE set DOB= ?,Department name=?,FatherName=?,MotherName=?,Phonenumber=?,Address=?,AatharcardNumber=?,SSLCmark=?,HSCMark=?,CutoffMark=?,Email=? where Name=?");
						stmt.setString(1,DOB);
						stmt.setString(2, dept);
						stmt.setString(3, a);
						stmt.setString(4, b);
						stmt.setString(5, c);
						stmt.setString(6, d);
						stmt.setString(7, e);
						stmt.setInt(8, f);
						stmt.setInt(9, g);
						stmt.setInt(10,h);
						stmt.setString(11,i);
						stmt.setString(12, name);
						stmt.executeUpdate();
						Connection con1=DBUtil.getConnection();
						Statement stat = con1.createStatement();
						ResultSet rs = stat.executeQuery("Select * from EEE");
						while(rs.next()) {
							System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
		 }
	}
				   else if(deptname.equals("MECH")) {
						Connection con = DBUtil.getConnection();
						PreparedStatement stmt = con.prepareStatement("update MECH set DOB= ?,Department name=?,FatherName=?,MotherName=?,Phonenumber=?,Address=?,AatharcardNumber=?,SSLCmark=?,HSCMark=?,CutoffMark=?,Email=? where Name=?");
						stmt.setString(1,DOB);
						stmt.setString(2, dept);
						stmt.setString(3, a);
						stmt.setString(4, b);
						stmt.setString(5, c);
						stmt.setString(6, d);
						stmt.setString(7, e);
						stmt.setInt(8, f);
						stmt.setInt(9, g);
						stmt.setInt(10,h);
						stmt.setString(11,i);
						stmt.setString(12, name);
						stmt.executeUpdate();
						Connection con1=DBUtil.getConnection();
						Statement stat = con1.createStatement();
						ResultSet rs = stat.executeQuery("Select * from MECH");
						while(rs.next()) {
							System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
		 }
	}
				   else {
					   System.out.println("Invalid");
				   }
	}catch(Exception e) {
		System.out.println(e);
	}
}
	public void delete() {
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Enter the Department Name to delete: ");
			   String deptname=sc.nextLine();
			   System.out.println("Enter the Name: ");
			   String name = sc.nextLine();
			   if(deptname.equals("CSE")) {
					Connection con = DBUtil.getConnection();
					PreparedStatement stmt = con.prepareStatement("delete from CSE where name=?");
					stmt.setString(1,name);
					stmt.executeUpdate();
					Connection con1=DBUtil.getConnection();
					Statement stat = con1.createStatement();
					ResultSet rs = stat.executeQuery("Select * from CSE");
					while(rs.next()) {
						System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
	 }
}
			   else if(deptname.equals("IT")) {
					Connection con = DBUtil.getConnection();
					PreparedStatement stmt = con.prepareStatement("delete from IT where name=?");
					stmt.setString(1,name);
					stmt.executeUpdate();
					Connection con1=DBUtil.getConnection();
					Statement stat = con1.createStatement();
					ResultSet rs = stat.executeQuery("Select * from IT");
					while(rs.next()) {
						System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
	 }
}
			   else   if(deptname.equals("ECE")) {
					Connection con = DBUtil.getConnection();
					PreparedStatement stmt = con.prepareStatement("delete from ECE where name=?");
					stmt.setString(1,name);
					stmt.executeUpdate();
					Connection con1=DBUtil.getConnection();
					Statement stat = con1.createStatement();
					ResultSet rs = stat.executeQuery("Select * from ECE");
					while(rs.next()) {
						System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
	 }
	}
			   else   if(deptname.equals("EEE")) {
					Connection con = DBUtil.getConnection();
					PreparedStatement stmt = con.prepareStatement("delete from EEE where name=?");
					stmt.setString(1,name);
					stmt.executeUpdate();
					Connection con1=DBUtil.getConnection();
					Statement stat = con1.createStatement();
					ResultSet rs = stat.executeQuery("Select * from EEE");
					while(rs.next()) {
						System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
	 }
}
			   else   if(deptname.equals("MECH")) {
					Connection con = DBUtil.getConnection();
					PreparedStatement stmt = con.prepareStatement("delete from MECH where name=?");
					stmt.setString(1,name);
					stmt.executeUpdate();
					Connection con1=DBUtil.getConnection();
					Statement stat = con1.createStatement();
					ResultSet rs = stat.executeQuery("Select * from MECH");
					while(rs.next()) {
						System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
	 }
}
			   else {
				   System.out.println("INVALID");
			   }
		}
			   catch(Exception e) {
				   System.out.println(e);
			   }
		}
	public void view(){
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Enter the department name to view: ");
			   String deptname=sc.nextLine();
			   if(deptname.equals("CSE")) {
				   Connection con1=DBUtil.getConnection();
					Statement stat = con1.createStatement();
					ResultSet rs = stat.executeQuery("Select * from CSE");
					while(rs.next()) {
						System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
		}
			   }		else if(deptname.equals("IT")) {
				   Connection con1=DBUtil.getConnection();
					Statement stat = con1.createStatement();
					ResultSet rs = stat.executeQuery("Select * from IT");
					while(rs.next()) {
						System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
}}
			   else if(deptname.equals("ECE")) {
	   Connection con1=DBUtil.getConnection();
		Statement stat = con1.createStatement();
		ResultSet rs = stat.executeQuery("Select * from ECE");
		while(rs.next()) {
			System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
}
 }else if(deptname.equals("EEE")) {
	   Connection con1=DBUtil.getConnection();
		Statement stat = con1.createStatement();
		ResultSet rs = stat.executeQuery("Select * from EEE");
		while(rs.next()) {
			System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
}
 }else if(deptname.equals("MECH")) {
	   Connection con1=DBUtil.getConnection();
		Statement stat = con1.createStatement();
		ResultSet rs = stat.executeQuery("Select * from MECH");
		while(rs.next()) {
			System.out.println("Name"+rs.getString(1)+"--> "+"DOB"+rs.getString(2)+"--> "+"Department name"+rs.getString(3)+"--> "+"Fathername"+rs.getString(4)+"-->" +"Mothername"+rs.getString(5)+"--> "+"Phonenumber"+rs.getString(6)+"--> "+"Address"+rs.getString(7)+"--> "+"Aatharcardnumber:"+rs.getString(8)+"--> "+"SSLC Mark"+rs.getInt(9)+"--> "+"HSC Mark"+rs.getInt(10)+"--> "+"Cutoff Mark"+rs.getInt(11)+"--> "+"Email id"+rs.getString(12));
}}
 else {
	 System.out.println("Invalid");
 }
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	
}




