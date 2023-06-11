package com.kce.vignesh.bean;

public class Staff extends Login{
	private String staffId;
    private String Name;
    private String Domain;
    public Staff() {
    	
    }
	public Staff(String username,String password,String staffId, String name, String domain) {
		super(username,password,"staff");
		this.staffId = staffId;
		this.Name = name;
		this.Domain = domain;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDomain() {
		return Domain;
	}
	public void setDomain(String domain) {
		Domain = domain;
	}
	
    
}
