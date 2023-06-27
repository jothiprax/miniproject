package com.kce.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.kce.bean.Student;
import com.kce.bean.User;
import com.kce.dao.Delete;
import com.kce.dao.Display;
import com.kce.dao.Insertvalues;
import com.kce.service.Admin_Exception;
import com.kce.service.Login_Test;
import com.kce.service.User_Exception;
import com.kce.util.SQLConnection;
import com.kce.service.Student_Exception;

public class Main {
	@SuppressWarnings("null")
	public static void main(String arr[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("---------   ---------   --------   --------   -------  -------   -----");
		System.out.println("\t\tWelcome To Kce Student DataBase");
		System.out.println("---------   ---------   --------   --------   -------  -------   -----\n");
		System.out.print("Enter the Role(Student/admin):");

		PreparedStatement pt = null;
		ResultSet rs = null;
		int id;
		User user;
		Student student;// declaration of prepared statement
		String role = scan.next().trim();
		String Uname, Password;
		String Email;
		scan.nextLine();
		if (role.equalsIgnoreCase("Admin")) {
				System.out.print("Admin Email:");
				Email = scan.next();
		
		if (!(Email.equalsIgnoreCase("admin@kce.ac.in"))) {
			try {
					throw new Admin_Exception(Email);
			}
			catch(Admin_Exception A) {
				A.getMessage();
			}
			}
		}
		while (true) {
			int Choice = 0;
			if (role.equalsIgnoreCase("Admin")) {
				System.out.println("\nList Of Operation:");
				System.out.println("1.Insert value in user Table");
				System.out.println("2.Update value in user Table");
				System.out.println("3.Delect user");
				System.out.println("4.Display All User");
				System.out.println("5.Modify");
				System.out.println("6.exit");
				System.out.println("\nEnter the Choice : ");
				Choice = scan.nextInt();
			} else if (role.equalsIgnoreCase("Student")) {
				try {
					System.out.println("User Name:");
					Uname = scan.nextLine();
					System.out.println("Password:");
					Password = scan.nextLine();
					pt = Display.displayStudents(Uname);
					rs = pt.executeQuery();
					if (Display.Check(Uname, Password)) {
						System.out.println("Student Details:\n");
						System.out.println(
								"------- ------ ------ ------ -------- ------ ------ ------ -------- ------ ------");
						while (rs.next()) {
							System.out.format("%-20s%-30s%-20s%-20s\n", rs.getString(1), rs.getString(2),
									rs.getString(3), rs.getString(4));
						}
						System.out.println(
								"------- ------ ------ ------ -------- ------ ------ ------ -------- ------ ------");
						rs.close();
					} else {
						System.out.println(
								"------- ------ ------ ------ -------- ------ ------ \n\tEnter Valid User name or Password\n\t\t Access Denied.\n------- ------ ------ ------ -------- ------ ------ ");
					}
				} catch (Exception e) {
					e.getMessage();
				}
				break;
			} else {
				try {
					throw new User_Exception(role);
				} catch (User_Exception u) {
					u.getMessage();
				}
			}
			switch (Choice) {
			case 1:
				System.out.println("Enter the ID:");
				id = scan.nextInt();
				System.out.println("Enter the Name:");
				String name = scan.next();
				System.out.println("Enter the Password:");
				String password = scan.next();
				user = new User(id, name, password);
				try {
					pt = Insertvalues.insert(user);
				} catch (Exception e) {
					System.out.println(e);
				}
				System.out.println("Succsully Inserted....");
				break;
			case 3:
				try {
					System.out.print("Enter the Id:");
					id = scan.nextInt();
					user = new User(id);
					pt = Delete.delete(user);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Succsully Delete....");
				break;

			case 4:
				try {
					System.out.println("Display");
					pt = Display.displayStudents();
					rs = pt.executeQuery();
					while (rs.next()) {
						System.out.format("%-20s%-30s%-20s%-20s\n", rs.getString(1), rs.getString(2), rs.getString(3),
								rs.getString(4));
					}
				} catch (Exception e) {
					e.getMessage();
				}
				break;

			case 6:
				System.out.println(
						"\n********************************************************************************************************\n");
				System.out.println("\t\t\t\t\tHAVE A NICE DAY\t\t");
				System.out.println(
						"\n********************************************************************************************************\n");
				System.exit(0);
				break;
			default:
				System.out.println("Enter Valid Choice(1 to 6)");
			}
		}
	}

}
