package com.kce.Dao;
import com.kce.bean.*;
import com.kce.student.util.*;
import java.sql.*;
import java.util.*;
public class QueryCRUD {
	private Connection con=DButil.getDBConnection();
	 public void addStudentDetails(StudentExamDetails sed)
	   { 
		 try {
			PreparedStatement st=con.prepareStatement("insert into studentmgt.student values(?,?,?,?,?,?,?,?,?,?);");
			st.setInt(1,sed.getId());
			st.setString(2, sed.getName());
			st.setInt(3, sed.getAge());
			st.setInt(4, sed.getDob());
			st.setString(5, sed.getAddress());
			st.setInt(6, sed.getFees());
			st.setInt(7, sed.getAdmission_no());
			st.setInt(8,sed.getCourse());
			st.setInt(9, sed.getAttendance());
			st.setInt(10, sed.getTotal_mark());
			st.executeUpdate();
			System.out.println("Successfully Inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	   }
	 public void addCourseDetails(StudentCourseDetails scd)
	   {
		 try {
				PreparedStatement st=con.prepareStatement("insert into studentmgt.course values(?,?,?,?,?);");
				st.setInt(1,scd.getCourse_id());
				st.setString(2, scd.getCourse_name());
				st.setInt(3, scd.getCourse_duration());
				st.setString(4, scd.getCourse_staff());
				st.setInt(5, scd.getMarks());
				st.executeUpdate();
				System.out.println("Successfully Inserted");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	   }
	 public void removeStudentDetails(int id)
	   {
		 PreparedStatement st;
		try {
			st = con.prepareStatement("delete from studentmgt.student where s_id=?");
		 st.setInt(1, id);
		 st.executeUpdate();
		 System.out.println("Successfully Removed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   }
	 public void removeCourseDetails(int id)
	   {
		 PreparedStatement st;
			try {
				st = con.prepareStatement("delete from studentmgt.course where course_id=?");
			 st.setInt(1, id);
			 st.executeUpdate();
			 System.out.println("Successfully Removed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	   }
	 public void displayStudentDetails()
	   {
		 try {
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("Select * from studentmgt.student");
		 while(rs.next())
		 {
			 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getInt(7)+" "+rs.getInt(8)+" "+rs.getInt(9)+" "+rs.getInt(10));
		 } 
		 }
		 catch (SQLException e) {
				e.printStackTrace();
			}
	   }
	 public void displayCourseDetails()
	   {
		 try {
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("Select * from studentmgt.course");
		 while(rs.next())
		 {
			 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getInt(5));
		 } 
		 }
		 catch (SQLException e) {
				e.printStackTrace();
			}
	   }
	 public void StudentCount()
	   {
		 try {
			 Statement st=con.createStatement();
			 ResultSet rs=st.executeQuery("Select count(s_id) from studentmgt.student");
			 while(rs.next())
			 {
				 System.out.println("Number of students:"+rs.getInt(1));
			 } 
			 }
			 catch (SQLException e) {
					e.printStackTrace();
				}
	   }
	 public void CourseCount()
	   {
		 try {
			 Statement st=con.createStatement();
			 ResultSet rs=st.executeQuery("Select count(course_id) from studentmgt.course");
			 while(rs.next())
			 {
				 System.out.println("Number of courses:"+rs.getInt(1));
			 } 
			 }
			 catch (SQLException e) {
					e.printStackTrace();
				}
   	   }
	public void UpdateStudent(int n,int stud_id,String det)//n-option id-to update which attribute name is the name of student;
	{
		PreparedStatement st;
		try {
			if(n==0)
			{
				int id=Integer.parseInt(det);
			st = con.prepareStatement("Update studentmgt.student set s_id=? where s_id=?");
			st.setInt(1,id );
			st.setInt(2,stud_id );
		 st.executeUpdate();
			}
			if(n==1)
			{
				String name=det;
				st = con.prepareStatement("Update studentmgt.student set name=? where s_id=?");
				st.setString(1,name );
				st.setInt(2,stud_id );
			 st.executeUpdate();
			}
			if(n==2)
			{
				int age=Integer.parseInt(det);
				st = con.prepareStatement("Update studentmgt.student set age=? where s_id=?");
				st.setInt(1,age );
				st.setInt(2,stud_id );
			 st.executeUpdate();
			}
			if(n==3)
			{
				int dob=Integer.parseInt(det);
				st = con.prepareStatement("Update studentmgt.student set dob=? where s_id=?");
				st.setInt(1,dob );
				st.setInt(2,stud_id );
			 st.executeUpdate();
			}
			if(n==4)
			{
				String add=det;
				st = con.prepareStatement("Update studentmgt.student set address=? where s_id=?");
				st.setString(1,add);
				st.setInt(2,stud_id );
			 st.executeUpdate();
			}
			if(n==5)
			{
				int fees=Integer.parseInt(det);
				st = con.prepareStatement("Update studentmgt.student set fees=? where s_id=?");
				st.setInt(1,fees );
				st.setInt(2,stud_id );
			 st.executeUpdate();
			}
			if(n==6)
			{
				int adm_no=Integer.parseInt(det);
				st = con.prepareStatement("Update studentmgt.student set admission_no=? where s_id=?");
				st.setInt(1,adm_no );
				st.setInt(2,stud_id );
			 st.executeUpdate();
			}
			if(n==7)
			{
				int id=Integer.parseInt(det);
				st = con.prepareStatement("Update studentmgt.student set course_id=? where s_id=?");
				st.setInt(1,id );
				st.setInt(2,stud_id );
			 st.executeUpdate();
			}
			if(n==8)
			{
				int a=Integer.parseInt(det);
				st = con.prepareStatement("Update studentmgt.student set attendance=? where s_id=?");
				st.setInt(1,a );
				st.setInt(2,stud_id );
			 st.executeUpdate();
			}
			if(n==9)
			{
				int mark=Integer.parseInt(det);
				st = con.prepareStatement("Update studentmgt.student set mark=? where s_id=?");
				st.setInt(1,mark );
				st.setInt(2,stud_id );
			 st.executeUpdate();
			}
			else
			{
				System.out.println("There is no such element:"+n);
			}
		 System.out.println("Successfully Removed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void UpdateCourse(int n,String det,int id)
	{
		try{//to choice the element to be updated;
		PreparedStatement st;
				if(n==0)
				{
					int iden=Integer.parseInt(det);	
				st = con.prepareStatement("Update studentmgt.course set course_id=? where course_id=?");
			 st.setInt(1,iden);
			 st.setInt(2,id);
			 st.executeUpdate();
				}
				if(n==1)
				{
				st = con.prepareStatement("Update studentmgt.course set course_name=?  where course_id=?");
			 st.setString(1,det);
			 st.setInt(2,id);
			 st.executeUpdate();
				}
				if(n==2)
				{
					int dur=Integer.parseInt(det);
				st = con.prepareStatement("Update studentmgt.course set course_dur=? where course_id=?");
			 st.setInt(1,dur);
			 st.setInt(2,id);
			 st.executeUpdate();
				}
				if(n==3)
				{
				st = con.prepareStatement("Update studentmgt.course set course_staff=? where course_id=?");
			 st.setString(1,det);
			 st.setInt(2,id);
			 st.executeUpdate();
				}
				if(n==4)
				{
					int mark=Integer.parseInt(det);
				st = con.prepareStatement("Update studentmgt.course set mark=? where course_id=?");
			 st.setInt(1,mark);
			 st.setInt(2,id);
			 st.executeUpdate();
				}
		 System.out.println("Successfully Removed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		public void generateReport()
		{
			 try {
				 Statement st=con.createStatement();
				 ResultSet rs=st.executeQuery("Select * from studentmgt.student");
				 int m=0;
				 String name=null;
				 int a=0;
				 while(rs.next())
				 {
					 m=rs.getInt(10);
					 name=rs.getString(2);
					 a=rs.getInt(9);
			 System.out.println(name);
			 if(a<50)
			 {
				 System.out.println("often taken leave");
				 System.out.println("Must provide bond and medical certificate");
			 }
			 else if(a>50)
			 {
				 System.out.println("Punctuality and Sincere at Work");
			 }
			 else
			 {
				 System.out.println("Not correct attendance percentage");
			 }
			if(m<50)
			{
				System.out.println("Below Average");
				System.out.println("Must improve!!!");
				System.out.println("*");
				System.out.println("Scholar:0%");
                System.out.println("------------------------------------");
			}
			else if(m==50)
			{
				System.out.println("Average");
				System.out.println("* *");
				System.out.println("Scholar:10%");
				 System.out.println("------------------------------------");
			}
			else if(m>50&&m<=70)
			{
				System.out.println("Good");
				System.out.println("* * *");
				System.out.println("Scholar:20%");
				 System.out.println("------------------------------------");
			}
			else if(m>70&&m<=90)
			{
				System.out.println("Best");
				System.out.println("* * * *");
				System.out.println("Scholar:25%");
				 System.out.println("------------------------------------");
			}
			else if(m>90&&m<=100)
			{
				System.out.println("OutStanding");
				System.out.println("* * * * *");
				System.out.println("Scholar:30%");
				 System.out.println("------------------------------------");
			}
			else
			{
				 System.out.println("------------------------------------");
				System.out.println("Enter valid Total mark!!!");
				 System.out.println("------------------------------------");
			}
				 }
			 }
			 catch (SQLException e) {
					e.printStackTrace();
				}
		}
	
	}
