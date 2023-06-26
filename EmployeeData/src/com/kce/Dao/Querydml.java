package com.kce.Dao;
import com.kced.bean.*;
import com.kce.employee.util.*;
import java.sql.*;
import java.util.*;
public class Querydml {
private Connection con=Employeeconnection.getDBConnection();
public void addEmployeeDetails(Employees e)
{
	try
	{
		PreparedStatement st=con.prepareStatement("insert into employee.employee values(?,?,?,?);");
		st.setInt(1,e.getEmployeeId());
		st.setString(2,e.getFirstName());
		st.setString(3, e.getLastName());
		st.setString(4,e.getPhoneNumber());
		st.executeUpdate();
		System.out.println("SucessFully inserted");
		
	}
	catch(SQLException p)
	{
		p.printStackTrace();
	}
}
public void addDepartmentsDetails(Departments b)
{
	try
	{
		PreparedStatement st=con.prepareStatement("insert into employee.departments values(?,?,?,?);");
		st.setInt(1,b.getdepartmentId());
		st.setString(2,b.getdepartmentName());
		st.setInt(3, b.getManagerId());
		st.setString(4,b.getlocationId());
		st.executeUpdate();
		System.out.println("SucessFully inserted");
		
	}
	catch(SQLException s)
	{
		s.printStackTrace();
	}
}
public void addJobHistoryDetails(Job_history c)
{
	try
	{
		PreparedStatement st=con.prepareStatement("insert into employee.jobhistory values(?,?,?,?);");
		st.setInt(1,c.getemployeeId());
		st.setString(2,c.getstartDate());
		st.setInt(3, c.getjobId());
		st.setString(4,c.getendDate());
		st.executeUpdate();
		System.out.println("SucessFully inserted");
		
	}
	catch(SQLException n)
	{
		n.printStackTrace();
	}
}
public void addjobsDetails(Jobs d)
{
	try
	{
		PreparedStatement st=con.prepareStatement("insert into employee.jobs values(?,?,?,?);");
		st.setInt(1,d.getJobId());
		st.setString(2,d.getJobtitle());
		st.setInt(3, d.getMax_salary());
		st.setInt(4,d.getMin_salary());
		st.executeUpdate();
		System.out.println("SucessFully inserted");
		
	}
	catch(SQLException o)
	{
		o.printStackTrace();
	}
}
public void removeEmployeeeDetails(int employeeId)
{
	 PreparedStatement st;
		try {
			st = con.prepareStatement("delete from employee.employee where employeeId=?");
		 st.setInt(1,employeeId);
		 st.executeUpdate();
		 System.out.println("Successfully Removed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
public void removeDepartmentDetails(int departmentId)
{
	 PreparedStatement st;
		try {
			st = con.prepareStatement("delete from employee.departments where departmentId=?");
		 st.setInt(1,departmentId);
		 st.executeUpdate();
		 System.out.println("Successfully Removed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
public void removeJobHistoryDetails(int jobId)
{
	 PreparedStatement st;
		try {
			st = con.prepareStatement("delete from employee.jobhistory where jobId=?");
		 st.setInt(1,jobId);
		 st.executeUpdate();
		 System.out.println("Successfully Removed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
public void removeJobsDetails(String Jobtitle)
{
	 PreparedStatement st;
		try {
			st = con.prepareStatement("delete from employee.jobs where jobtitle=?");
		 st.setString(1,Jobtitle);
		 st.executeUpdate();
		 System.out.println("Successfully Removed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
public void displayEmployeeDetails()
{
	 try {
	 Statement st=con.createStatement();
	 ResultSet rs=st.executeQuery("Select * from employee.employee");
	 while(rs.next())
	 {
		 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
	 } 
	 }
	 catch (SQLException e) {
			e.printStackTrace();
		}
}
public void displaydepartmentDetails()
{
	 try {
	 Statement st=con.createStatement();
	 ResultSet rs=st.executeQuery("Select * from employee.departments");
	 while(rs.next())
	 {
		 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
	 } 
	 }
	 catch (SQLException e) {
			e.printStackTrace();
		}
}
public void displayJobhistoryDetails()
{
	 try {
	 Statement st=con.createStatement();
	 ResultSet rs=st.executeQuery("Select * from employee.jobhistory");
	 while(rs.next())
	 {
		 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
	 } 
	 }
	 catch (SQLException e) {
			e.printStackTrace();
		}
}
public void displayJobDetails()
{
	 try {
	 Statement st=con.createStatement();
	 ResultSet rs=st.executeQuery("Select * from employee.jobs");
	 while(rs.next())
	 {
		 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
	 } 
	 }
	 catch (SQLException e) {
			e.printStackTrace();
		}
}
public void EmployeeCount()
{
	 try {
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("Select count(employeeid) from employee.employee");
		 while(rs.next())
		 {
			 System.out.println("Number of students:"+rs.getInt(1));
		 } 
		 }
		 catch (SQLException e) {
				e.printStackTrace();
			}
}
public void DepartmentCount()
{
	 try {
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("Select count(departmentid) from employee.departments");
		 while(rs.next())
		 {
			 System.out.println("Number of students:"+rs.getInt(1));
		 } 
		 }
		 catch (SQLException e) {
				e.printStackTrace();
			}
}
public void JobhistoryCount()
{
	 try {
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("Select count(jobId) from employee.jobhistory");
		 while(rs.next())
		 {
			 System.out.println("Number of students:"+rs.getInt(1));
		 } 
		 }
		 catch (SQLException e) {
				e.printStackTrace();
			}
}
public void JobCount()
{
	 try {
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("Select count(jobtitle) from employee.jobs");
		 while(rs.next())
		 {
			 System.out.println("Number of students:"+rs.getString(1));
		 } 
		 }
		 catch (SQLException e) {
				e.printStackTrace();
			}
}
public void updateEmployeeDetails(int n, int employeeId, String detail) {
	PreparedStatement st;
	try {
		switch(n) {
			case 1:
				String PhoneNumber = detail;
				st = con.prepareStatement("update employee set salary = ? where employeeId = ?");
				st.setString(1,PhoneNumber);
				st.setInt(2,employeeId);
				st.executeUpdate();
			case 2:
				String FirstName  = detail;
				st = con.prepareStatement("update employee set firstName = ? where employeeId = ?");
				st.setString(1, FirstName);
				st.setInt(2, employeeId);
				st.executeUpdate();
			case 3:
				String lastName=detail;
				st = con.prepareStatement("update employee set lastName = ? where employeeId = ?");
				st.setString(1, lastName);
				st.setInt(2, employeeId);
				st.executeUpdate();
			
			default:
				System.out.println("INVALID OPTION !!!");
		}
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
public void updateDepartmentDetails(int n, int departmentId, String detail) {
	PreparedStatement st;
	try {
		switch(n) {
			case 1:
				String departmentName = detail;
				st = con.prepareStatement("update departments set departmentName = ? where departmentId = ?");
				st.setString(1,departmentName);
				st.setInt(2,departmentId);
				st.executeUpdate();
			case 2:
				int managerId = Integer.parseInt(detail);
				st = con.prepareStatement("update departments set managerId = ? where departmentId = ?");
				st.setInt(1, managerId);
				st.setInt(2, departmentId);
				st.executeUpdate();
			case 3:
				String locationId=detail;
				st = con.prepareStatement("update departments set locationId = ? where departmentId = ?");
				st.setString(1, locationId);
				st.setInt(2, departmentId);
				st.executeUpdate();
		
			default:
				System.out.println("INVALID OPTION !!!");
		}
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
public void updateJobhistoryDetails(int n, int jobId, String detail) {
	PreparedStatement st;
	try {
		switch(n) {
			case 1:
			  int employeeId = Integer.parseInt(detail);
				st = con.prepareStatement("update jobhistory set employeeId = ? where jobId = ?");
				st.setInt(1,employeeId);
				st.setInt(2,jobId);
				st.executeUpdate();
			case 2:
				String startDate=detail;
				st = con.prepareStatement("update jobhistory set startDate = ? where jobId = ?");
				st.setString(1, startDate);
				st.setInt(2, jobId);
				st.executeUpdate();
			case 3:
				String endDate=detail;
				st = con.prepareStatement("update jobhistory set endDate = ? where jobId = ?");
				st.setString(1, endDate);
				st.setInt(2, jobId);
				st.executeUpdate();
		
			default:
				System.out.println("INVALID OPTION !!!");
		}
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
public void updateJobDetails(int n, String jobtitle, String detail) {
	PreparedStatement st;
	try {
		switch(n) {
			case 1:
			  int jobId = Integer.parseInt(detail);
				st = con.prepareStatement("update jobs set jobId = ? where jobtitle = ?");
				st.setInt(1,jobId);
				st.setString(2,jobtitle);
				st.executeUpdate();
			case 2:
				int Max_salary = Integer.parseInt(detail);
				st = con.prepareStatement("update jobs set jobId = ? where jobtitle = ?");
				st.setInt(1,  Max_salary);
				st.setString(2, jobtitle);
				st.executeUpdate();
			case 3:
				int Min_salary=Integer.parseInt(detail);
				st = con.prepareStatement("update jobs set jobId = ? where jobtitle = ?");
				st.setInt(1, Min_salary);
				st.setString(2, jobtitle);
				st.executeUpdate();
		
			default:
				System.out.println("INVALID OPTION !!!");
		}
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
public void generateReport()
{
	 try {
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("Select * from employee.employee");
		 int m=0;
		 
		 while(rs.next())
		 {
			 m=rs.getInt(110);
			

	 if(m<103)
	 {
		 System.out.println("Employees with average Salary");
		 System.out.println("Must increment their amount by giving bonus");
	 }
	 else 
	 {
		 System.out.println("Employees with high Salary");
		 System.out.println("Salary should be maintained");
	 }
	 
	 
		 }
	 }
	 catch (SQLException e) {
			e.printStackTrace();
		}
}
}
