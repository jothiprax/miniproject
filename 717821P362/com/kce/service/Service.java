package com.kce.service;

import java.io.IOException;

import com.kce.bean.Student;
import com.kce.util.StudentException;

public class Service {
	private static MyReader in;
	public void deleteOptions() {
			System.out.println("1.By RollNo");
			System.out.println("2.By Name");
	}
	public void updateOptions() {
		System.out.println("1.Update Grade With Roll No");
		System.out.println("2.Update Grade With Name");
		System.out.println("3.Update Name");
		System.out.println("4.Update Roll No");
	}
	public Student getStudent() throws IOException {
		MyReader in = new MyReader();
		String name , gender , rollNo;
		int age , grades;
		name = gender = rollNo = "";
		age = grades = 0;
		try {
			try {
				System.out.print("Enter Name : ");
				name = in.nextLine();
				if(name.length()<1) throw new Exception();
				/*
				 * If a newLine is the given name then it is not valid one
				 */
			}catch(Exception e) {
				throw new StudentException("Invalid name");
			}
			try {
				System.out.print("Enter age : ");
				age = in.nextInt();
				}catch(Exception e) {
					throw new StudentException("Invalid age");
				}
			try {
				System.out.print("Enter gender : ");
				gender = in.nextLine();
				if(name.length()<1) throw new Exception();
				}catch(Exception e) {
					throw new StudentException("Invalid gender");
				}
			try {
				System.out.print("Enter grades : ");
				grades = in.nextInt();
				}catch(Exception e) {
					throw new StudentException("Invalid grades");
				}
			try {
				System.out.print("Enter rollNo : ");
				rollNo = in.nextLine();
				if(name.length()<1) throw new Exception();
				}catch(Exception e) {
					throw new StudentException("Invalid rollNo");
				}
			/*
			 * code is written in this manner to get different exception message for
			 * different errors done by user
			 */
			return new Student(name,age,gender,grades,rollNo);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	public int getGrade() throws Exception{
		int grade = 0;
		System.out.print("Enter Grade : ");
		try {
			grade = in.nextInt();
		}catch(Exception e) {
			throw new Exception("Invalid Grades");
		}
		return grade;
	}
	public String getRollNo() throws StudentException {
		String rollNo = "";
		System.out.print("Enter RollNo : ");
		try {
			rollNo = in.nextLine(); // if rollNo is not a valid one then exception is throwed
			if(rollNo.length()<1) throw new Exception();
		}catch(Exception e) {
			throw new StudentException("Invalid RollNo");
		}
		return rollNo;
	}
	public String getName() throws StudentException {
		String name = "";
		System.out.print("Enter Name : ");
		try {
			name = in.nextLine();
			if(name.length()<1) throw new Exception();
		}catch(Exception e) {
			throw new StudentException("Invalid Name");
		}
		return name;
	}
	public Service() throws Exception {
		in = new MyReader();
	}
}
