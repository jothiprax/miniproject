package com.kce.vignesh.bean;

public class Student extends Login{
	private String studId;
    private String name;
    private String deptId;
    private int hoursAttended;
    
    public Student(){
        super();
    }

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Student(String studId, String name, String deptId) {
        this.studId = studId;
        this.name = name;
        this.deptId = deptId;
    }

    public Student(String studId, String name, String deptId, String username, String password,int hoursAttended) {
        super(username, password,"student");
        this.studId = studId;
        this.name = name;
        this.deptId = deptId;
        this.setHoursAttended(hoursAttended);
    }

	public int getHoursAttended() {
		return hoursAttended;
	}

	public void setHoursAttended(int hoursAttended) {
		this.hoursAttended = hoursAttended;
	}

}
