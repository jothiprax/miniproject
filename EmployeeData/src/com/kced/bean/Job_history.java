package com.kced.bean;

public class Job_history {
private int employeeId;
private String startDate;
private String endDate;
private int jobId;

public Job_history(int employeeId,String startDate,String endDate,int jobId)
{
	this.employeeId=employeeId;
	this.startDate=startDate;
	this.endDate=endDate;
	this.jobId=jobId;
	
	
}
public int getemployeeId()
{
	return employeeId;
}
public String getstartDate()
{
	return startDate;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
public void setJobId(int jobId) {
	this.jobId = jobId;
}
public String getendDate()
{
	return endDate;
}
public int getjobId()
{
	return jobId;
}
public String toString()
{
	return "Job_history[id="+employeeId+",startDate="+startDate+",endDate ="+endDate+",jobId=+"+jobId+"]";
}
public void Job_historyDetails()
{
	System.out.println(toString());
}	


}
