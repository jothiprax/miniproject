package com.kce.service;

import java.util.Scanner;

import com.kce.dao.StudentDao;

public class Main {
public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);
	int a=sc.nextInt();
	StudentDao s = new StudentDao();
	s.insert(a);
	s.update();
	s.delete();
	s.displayTable();
	sc.close();
}
}
