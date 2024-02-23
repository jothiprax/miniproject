package com.kce.bean;

public class Savings_Account extends Account{
	String type="Savings";
	public Savings_Account(User user, float balance, int TransactionLimit) {
		super(user, balance);
	}
}
