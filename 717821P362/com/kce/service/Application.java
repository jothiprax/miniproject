package com.kce.service;

import com.kce.dao.DataBase;

public class Application {
	public static void main(String[] args) {
		try {
			MyReader in = new MyReader();	
			DataBase db = new DataBase();
			Service serve = new Service();
			while(true) {
				Application.options();
				int option = 0 ;
				try {
					System.out.println("Enter Option : ");
				option = in.nextInt();
				}catch(Exception e) {
					System.err.println("Invalid option");
				}
				switch(option) {
				case 1 : {
					db.display();
					break;
				}
				case 2 : {
					db.insert(serve.getStudent());
					break;
				}
				case 3 : {
					serve.deleteOptions();
					int delOption = 0;
					try {
						System.out.print("Enter Delete Option : ");
						delOption = in.nextInt();
						switch(delOption) {
						case 2 : {
							String name = serve.getName();
							db.deleteByName(name);
							break;
						}
						case 1 : {
							String rollNo = serve.getRollNo();
							db.deleteByRollNo(rollNo);
							break;
						}
						default : {
							throw new Exception("Invalid Delete Option");
						}
						}
					}catch(Exception e) {
						System.err.println(e.getMessage());
					}
					break;
				}
				case 4 : {
					serve.updateOptions();
					int upOption = 0;
					try {
						System.out.print("Enter Update Option : ");
						upOption = in.nextInt();
						switch(upOption) {
						case 2 : {
							try {
								String name = serve.getName();
								int grade = serve.getGrade();
								db.updateByName(name,grade);
							}catch(Exception e) {
								System.err.println(e.getMessage());
							}
							break;
						}
						case 1 : {
							try {
								String rollNo = serve.getRollNo();
								int grade = serve.getGrade();
								db.updateByRollNo(rollNo,grade);
							}catch(Exception e) {
								System.err.println(e.getMessage());
							}
							break;
						}
						case 4 : {
							try {
								System.out.println("Old Roll No : ");
								String oldRollNo = serve.getRollNo();
								System.out.println("New Roll No : ");
								String newRollNo = serve.getRollNo();
								db.updateRollNo(oldRollNo,newRollNo);
							}catch(Exception e) {
								System.err.println(e.getMessage());
							}
							break;
						}
						case 3 : {
							try {
								System.out.println("Old Name : ");
								String oldName = serve.getName();
								System.out.println("New Name : ");
								String newName = serve.getName();
								db.updateName(oldName,newName);
							}catch(Exception e) {
								System.err.println(e.getMessage());
							}
							break;
						}
						default : {
							throw new Exception("Invalid Updation Option");
						}
						}
					}catch(Exception e) {
						System.err.println(e.getMessage());
					}
					break;
				}
				case 5 : {
					int i =0;
					System.out.print("\n\n\n\n\nExiting.");
					while(i<5) {
						Thread.sleep(100);
						System.out.print(".");
						i++;
					}
					System.out.println("[Terminated.]");
					System.exit(0);
				}
				default : {
					System.err.print("Enter a valid option : ");
				}
				}
			}
		}catch(Exception e) {
			System.err.println(e);
		}
	}
	public static void options() {
		System.out.println("1.Display DataBase");
		System.out.println("2.Insert into DataBase");
		System.out.println("3.Delete in DataBase");
		System.out.println("4.Update in DataBase");
		System.out.println("5.Exit");
	}
}
