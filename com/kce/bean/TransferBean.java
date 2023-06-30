package com.kce.bean;

public class TransferBean {
private String traid;
private String fromacno;
private String toacno;
private String dateoftra;
private String amt;
public TransferBean(){}
public TransferBean(String traid,String fromacno,String toacno,String dateoftra,String amt)
{
	this.traid=traid;
	this.fromacno=fromacno;
	this.toacno=toacno;
	this.dateoftra=dateoftra;
	this.amt=amt;
}
public String getTraid()
{
	return traid;
}
public String getFromacno()
{
	return fromacno;
}
public String getToacno()
{
	return toacno;
}
public String getDate()
{
	return dateoftra;
}
public String getAmt()
{
	return amt;
}
}