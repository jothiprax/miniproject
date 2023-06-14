package com.kce.bean;
import  com.kce.bean.Book;

public class Borrower extends Book {
	 public int borrowerId;
	    public String name;
	    public String phoneNumber;
	    public String email;
	    public String borrowerbookname;
	    
	    public int getBorrowerId() {
	        return borrowerId;
	    }

	    public void setBorrowerId(int borrowerId) {
	        this.borrowerId = borrowerId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	   

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }
	    public String getborrowerbookname() {
	        return borrowerbookname;
	    }

	    public void setborrowerbookname(String borrowerbookname) {
	        this.borrowerbookname = borrowerbookname;
	    }
	  
	   
	    }


