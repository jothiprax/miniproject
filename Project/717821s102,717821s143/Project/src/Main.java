import package com.kce.util;
import package com.kce.util;
import package com.kce.bean;
import java.util.*;
public class Main {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	student s=new student();
	delete d=new delete();
	insert i=new insert();
	System.out.println("For display press 1");
	System.out.println("For insert press 2");
	System.out.println("For delete press 3");
	int a=sc.nextInt();
	if(a==1) {
		s.print();
	}else if(a==2) {
		i.insertmethod();
	}
	else if(a==3) {
		d.deletemethod();
		System.out.println("For id enter 1");
		System.out.println("For name enter 2");
		System.out.println("For course enter 3");
	  int b=sc.nextInt();
	  
	}
	
	
	
	
	
}
}
