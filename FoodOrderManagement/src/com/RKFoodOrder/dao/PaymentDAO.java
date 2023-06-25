package com.RKFoodOrder.dao;
import java.sql.Time;
import java.util.UUID;
import java.sql.Date;
public class PaymentDAO {
public Date pay_day() {
	
 Date d = new Date(System.currentTimeMillis());
 return d;
}
public Time pay_time() {
	Time t = new Time(System.currentTimeMillis());
	return t;
}
public String transact_id() {
	UUID uid=UUID.randomUUID();
	 String tid = uid.toString().replaceAll("-","").substring(0,18);
	 return tid;
}
}
