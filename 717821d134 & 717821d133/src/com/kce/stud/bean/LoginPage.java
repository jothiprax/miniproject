package com.kce.stud.bean;

public class LoginPage {
	private String Username;
	private String Password;
	private String StaffId;

	public LoginPage(String username, String password, String staffId) {
		super();
		Username = username;
		Password = password;
		StaffId = staffId;
	}
	public LoginPage(String username, String password) {
		super();
		Username = username;
		Password = password;
	}
	public LoginPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStaffId() {
		return StaffId;
	}
	public void setStaffId(String staffId) {
		StaffId = staffId;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "LoginPage [Username=" + Username + ", Password=" + Password + ", StaffId=" + StaffId + "]";
	}
}
