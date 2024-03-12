package com.kce.dao;

public class AccountNumberGenerator {
	public String getAccountNumber()
	{
		String account_no = ""+(Math.random()*100000)+10000;
		account_no = account_no.split("\\.")[1];
		return account_no.substring(0,12);
	}
}

