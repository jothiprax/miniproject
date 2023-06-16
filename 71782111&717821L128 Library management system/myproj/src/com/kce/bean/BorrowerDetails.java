package com.kce.bean;



public class BorrowerDetails {
	private int Borrowerid;
	private String Borrowername;
	private String BorrowerphNo;
	private String due_date;
	
	public BorrowerDetails(int Borrowerid,String Borrowername,String borrowerphNo, String due_date) {
		this.Borrowerid=Borrowerid;
		this.Borrowername = Borrowername;
		this.BorrowerphNo = borrowerphNo;
		this.due_date = due_date;
		
	}

	public int getBorrowerid() {
		return Borrowerid;
	}

	public void setBorrowerid(int borrowerid) {
		Borrowerid = borrowerid;
	}

	public String getBorrowername() {
		return Borrowername;
	}

	public void setBorrowername(String Borrowername) {
		this.Borrowername = Borrowername;
	}

	public String getBorrowerphNo() {
		return BorrowerphNo;
	}

	public void setBorrowerphNo(String BorrowerphNo) {
		this.BorrowerphNo = BorrowerphNo;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	
	public String toString() {
		return "BorrowerDetails [Borrowerid=" + Borrowerid + ", Borrowername=" + Borrowername + ", BorrowerphNo="
				+ BorrowerphNo + ", due_date=" + due_date + "]";
	}
	
}
