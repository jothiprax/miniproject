package com.classess;
import java.util.*;

class Details{
	protected static int id;
	protected static String fname;	
	protected static String lname;
	protected static int age;
	protected static long phone_no;
	protected static long aadhar;
	protected static String address;
	protected static int no_persons;
	protected static int no_rooms;
	protected static String room;
	public Details(int id,String fname,String lname,int age,long phone_no,long aadhar,String address,int no_persons,int no_rooms,String room) {
        this.id=id;
        this.fname=fname;
        this.lname=lname;
        this.age=age;
        this.phone_no=phone_no;
        this.aadhar=aadhar;
        this.address=address;
        this.no_persons=no_persons;
        this.no_rooms=no_rooms;
        this.room=room;
	}
}