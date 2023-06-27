package com.kced.bean;

 public class Employees {
private int employeeId;
private String firstName;
private String LastName;
private String PhoneNumber;

public Employees(int employeeId,String firstName,String LastName,String PhoneNumber)
{
	this.employeeId=employeeId;
	this.firstName=firstName;
	this.LastName=LastName;
	this.PhoneNumber=PhoneNumber;
	
	
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public void setLastName(String lastName) {
	this.LastName = lastName;
}
public void setPhoneNumber(String PhoneNumber) {
	this.PhoneNumber = PhoneNumber;
}
public int getEmployeeId()
{
	return employeeId;
}
public String getFirstName()
{
	return firstName;
}
public String getLastName()
{
	return LastName;
}
public String getPhoneNumber()
{
	return PhoneNumber;
}
	public String toString()
	{
		return "Employees[id="+employeeId+"FirstName="+firstName+"LastName ="+LastName+"PhoneNumber="+PhoneNumber+"]";
	}
	public void EmployeeDetails()
	{
		System.out.println(toString());
	}

}
//class Departments {
//private int departmentId;
//private String departmentName;
//private int ManagerId;
//private String locationId;
//
//public Departments(int departmentId,String departmentName,int ManagerId,String locationId)
//{
//	this.departmentId=departmentId;
//	this.departmentName=departmentName;
//	this.ManagerId=ManagerId;
//	this.locationId=locationId;
//	
//	
//}
//public int getdepartmentId()
//{
//	return departmentId;
//}
//public String getdepartmentName()
//{
//	return departmentName;
//}
//public int getManagerId()
//{
//	return ManagerId;
//}
//public String getlocationId()
//{
//	return locationId;
//}
//public void setDepartmentId(int departmentId) {
//	this.departmentId = departmentId;
//}
//public void setDepartmentName(String departmentName) {
//	this.departmentName = departmentName;
//}
//public void setManagerId(int ManagerId) {
//	this.ManagerId = ManagerId;
//}
//public void setLocationId(String locationId) {
//	this.locationId = locationId;
//}
//public String toString()
//{
//	return "Departments[id="+departmentId+",Name="+departmentName+",managerId ="+ManagerId+",locationId=+"+locationId+"]";
//}
//public void DepartmentsDetails()
//{
//	System.out.println(toString());
//}	
//
//}
//class Job_history {
//private int employeeId;
//private String startDate;
//private String endDate;
//private int jobId;
//
//public Job_history(int employeeId,String startDate,String endDate,int jobId)
//{
//	this.employeeId=employeeId;
//	this.startDate=startDate;
//	this.endDate=endDate;
//	this.jobId=jobId;
//	
//	
//}
//public int getemployeetId()
//{
//	return employeeId;
//}
//public String getstartDate()
//{
//	return startDate;
//}
//public void setEmployeeId(int employeeId) {
//	this.employeeId = employeeId;
//}
//public void setStartDate(String startDate) {
//	this.startDate = startDate;
//}
//public void setEndDate(String endDate) {
//	this.endDate = endDate;
//}
//public void setJobId(int jobId) {
//	this.jobId = jobId;
//}
//public String getendDate()
//{
//	return endDate;
//}
//public int getjobId()
//{
//	return jobId;
//}
//public String toString()
//{
//	return "Job_history[id="+employeeId+",startDate="+startDate+",endDate ="+endDate+",jobId=+"+jobId+"]";
//}
//public void Job_historyDetails()
//{
//	System.out.println(toString());
//}	
//
//
//}
//class Jobs
//{
//	private int jobId;
//	private String jobtitle;
//	private int max_salary;
//	private int min_salary;
//	public Jobs(int jobId,String jobtitle,int max_salary,int min_salary)
//	{
//		this.jobId=jobId;
//		this.jobtitle=jobtitle;
//		this.max_salary=max_salary;
//		this.min_salary=min_salary;
//	}
//	public int getJobId() {
//		return jobId;
//	}
//	public void setJobId(int jobId) {
//		this.jobId = jobId;
//	}
//	public String getJobtitle() {
//		return jobtitle;
//	}
//	public void setJobtitle(String jobtitle) {
//		this.jobtitle = jobtitle;
//	}
//	public int getMax_salary() {
//		return max_salary;
//	}
//	public void setMax_salary(int max_salary) {
//		this.max_salary = max_salary;
//	}
//	public int getMin_salary() {
//		return min_salary;
//	}
//	public void setMin_salary(int min_salary) {
//		this.min_salary = min_salary;
//	}
//	public String toString()
//	{
//		return "Jobs[id="+jobId+",jobtitlee="+jobtitle+",max_salary ="+max_salary+",min_salary=+"+min_salary+"]";
//	}
//	public void JobsDetails()
//	{
//		System.out.println(toString());
//	}
//}


