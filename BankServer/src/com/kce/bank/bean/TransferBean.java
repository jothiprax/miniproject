package com.kce.bank.bean;

import java.util.Date;

public class TransferBean {
	private int transactionID;
	private String fromAccountNumber;
	private String toAccountNumber;
	private Date dateOfTransaction;
	private float amount;
	public TransferBean(int transactionID, String fromAccountNumber, String toAccountNumber, Date dateOfTransaction,
			float amount) {
		super();
		this.transactionID = transactionID;
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.dateOfTransaction = dateOfTransaction;
		this.amount = amount;
	}
	public TransferBean() {
		
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public String getFromAccountNumber() {
		return fromAccountNumber;
	}
	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}
	public String getToAccountNumber() {
		return toAccountNumber;
	}
	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
}
