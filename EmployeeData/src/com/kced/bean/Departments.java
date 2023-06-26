package com.kced.bean;

public class Departments {
private int departmentId;
private String departmentName;
private int ManagerId;
private String locationId;

public Departments(int departmentId,String departmentName,int ManagerId,String locationId)
{
	this.departmentId=departmentId;
	this.departmentName=departmentName;
	this.ManagerId=ManagerId;
	this.locationId=locationId;
	
	
}
public int getdepartmentId()
{
	return departmentId;
}
public String getdepartmentName()
{
	return departmentName;
}
public int getManagerId()
{
	return ManagerId;
}
public String getlocationId()
{
	return locationId;
}
public void setDepartmentId(int departmentId) {
	this.departmentId = departmentId;
}
public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}
public void setManagerId(int ManagerId) {
	this.ManagerId = ManagerId;
}
public void setLocationId(String locationId) {
	this.locationId = locationId;
}
public String toString()
{
	return "Departments[id="+departmentId+",Name="+departmentName+",managerId ="+ManagerId+",locationId="+locationId+"]";
}
public void DepartmentsDetails()
{
	System.out.println(toString());
}	

}
