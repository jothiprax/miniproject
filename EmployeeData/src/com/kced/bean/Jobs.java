package com.kced.bean;

public class Jobs
{
	private int jobId;
	private String jobtitle;
	private int max_salary;
	private int min_salary;
	public Jobs(int jobId,String jobtitle,int max_salary,int min_salary)
	{
		this.jobId=jobId;
		this.jobtitle=jobtitle;
		this.max_salary=max_salary;
		this.min_salary=min_salary;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public int getMax_salary() {
		return max_salary;
	}
	public void setMax_salary(int max_salary) {
		this.max_salary = max_salary;
	}
	public int getMin_salary() {
		return min_salary;
	}
	public void setMin_salary(int min_salary) {
		this.min_salary = min_salary;
	}
	public String toString()
	{
		return "Jobs[id="+jobId+",jobtitlee="+jobtitle+",max_salary ="+max_salary+",min_salary=+"+min_salary+"]";
	}
	public void JobsDetails()
	{
		System.out.println(toString());
	}
}

