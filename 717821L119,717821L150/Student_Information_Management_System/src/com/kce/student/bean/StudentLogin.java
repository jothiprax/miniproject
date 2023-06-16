package com.kce.student.bean;

import java.sql.SQLException;
import java.util.Scanner;
import com.kce.student.dao.DAOclass;

public class StudentLogin extends Teacher_login
{
	public StudentLogin(int studentid, String name, String department, int year, int pRPmark, int mPMCmark, int dSmark,
			double totalpercentage)
	{
		super(studentid, name, department, year, pRPmark, mPMCmark, dSmark, totalpercentage);

	}
	public StudentLogin() {}
	public StudentLogin(int studentid, String dob, int prpmark, int mpmcmark, int dssmark)
	{
		super();
		this.studentid = studentid;
		this.dob = dob;
		this.prpmark = prpmark;
		this.mpmcmark = mpmcmark;
		this.dssmark = dssmark;
	}

	private int studentid;
	private String dob;
	private int prpmark;
	private int mpmcmark;
	private int dssmark;
	
	public int checkpassword() throws SQLException, NumberFormatException
	{
		Scanner S = new Scanner(System.in);
		DAOclass d = new DAOclass();
		System.out.println("Enter Student id :");
		int sid = Integer.parseInt(S.nextLine());
		if (d.StudentExist(sid))
		{
			System.out.println("Enter password: ");
			String pass = S.nextLine();
			if (d.check(sid,pass))
				return sid;
			else
			{
				System.out.println("Wrong password.");
				return 0;
			}
		}
		else
		{
			System.out.println("Student not found");
			return 0;
		}
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getPrpmark() {
		return prpmark;
	}

	public void setPrpmark(int prpmark) {
		this.prpmark = prpmark;
	}

	public int getMpmcmark() {
		return mpmcmark;
	}

	public void setMpmcmark(int mpmcmark) {
		this.mpmcmark = mpmcmark;
	}

	public int getDssmark() {
		return dssmark;
	}

	public void setDssmark(int dssmark) {
		this.dssmark = dssmark;
	}
}