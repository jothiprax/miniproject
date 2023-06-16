package com.kce.service;

import com.kce.bean.OrderDetails;

public class Customer extends OrderDetails {
	public Customer(String name, long phnno, int pid, int quantity) {
		super(name,phnno,pid,quantity);
	}

}
