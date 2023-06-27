package com.kce.sports.service;
import com.kce.sports.bean.*;
import com.kce.sports.dao.*;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class SportsMain {
	public static void main(String[] args) throws IOException {
		int age;
		int jersey_no;
		int goals;
		int phone_no;
		String score;
		String result;
		String pname;
		String salary;
		String position;
		String nationality;
		String contract;
		String condition;
		String availability;
		String trainer;
		String name;
		String role;
		String match;
		String date;
		String time;
		String venue;
		while(true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Scanner sc = new Scanner(System.in);
			System.out.println("                                                                                                            ");
			System.out.println("                                                                                                            ");
			System.out.println("                          |--------Sports Team Management System---------|                                  ");
			System.out.println("                                                                                                            ");
			System.out.println("                                                                                     -by VIGNESH M          ");
			System.out.println("                                                                                                            ");
			System.out.println("Enter any choice:");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			System.out.println("1: To add details ");
			System.out.println("2: To remove details");
			System.out.println("3: To display details");
			System.out.println("4: To update details");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			int choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("Number of details to be entered: ");
				int n = sc.nextInt();
				Players[] p = new Players[n];
				Medic[] m = new Medic[n];
				Staffs[] s = new Staffs[n];
				Fixtures[] f = new Fixtures[n];
				System.out.println("------------------------------------------------------------------------------------------------------------");
				System.out.println("   1. New player details");
				System.out.println("   2. New medic details");
				System.out.println("   3. New staff details");
				System.out.println("   4. New fixtures");
				System.out.println("------------------------------------------------------------------------------------------------------------");
				int option = sc.nextInt();
				SportsQuery sq = new SportsQuery();
				try {
					for(int i=0;i<n;i++) {
						if(option == 1) {
							System.out.println("Enter (Name - Salary - Position - Age - Jersey number - Goals scored - Nationality - Contract duration) for the player");
							pname = br.readLine();
							salary = br.readLine();
							position = br.readLine();
							age = sc.nextInt();
							jersey_no = sc.nextInt();
							goals = sc.nextInt();
							nationality = br.readLine();
							contract = br.readLine();
							try {
								if(pname == null) {
									throw new NameNotFoundException("Must enter a name for the player");
								}
							}
							catch(NameNotFoundException e) {
								System.out.println(e);
							}
							p[i] = new Players(pname,salary,position,age,jersey_no,goals,nationality,contract);
							System.out.println(p[i]);
							sq.addPlayerDetails(p[i]);
						}
						else if(option == 2) {
							System.out.println("Enter (Pname - Condition - Availability - Age - Trainer) for the players");
							pname = br.readLine();
							condition = br.readLine();
							availability = br.readLine();
							age = sc.nextInt();
							trainer = br.readLine();
							try {
								if(pname == null) {
									throw new NameNotFoundException("Must enter a name for the player");
								}
							}
							catch(NameNotFoundException e) {
								System.out.println(e);
							}
							m[i] = new Medic(pname,condition,availability,age,trainer);
							System.out.println(m[i]);
							sq.addMedicDetails(m[i]);
						}
						else if(option == 3) {
							System.out.println("Enter (Name - Role - Salary - Age - phone number - Contract duration) of the staffs");
							name = br.readLine();
							role = br.readLine();
							salary = br.readLine();
							age = sc.nextInt();
							phone_no = sc.nextInt();
							contract = br.readLine();
							s[i] = new Staffs(name,role,salary,age,phone_no,contract);
							System.out.println(s[i]);
							sq.addStaffDetails(s[i]);
						}
						else if(option == 4) {
							System.out.println("Enter (Match - Date - Time - Venue - Score - Result)");
							match = br.readLine();
							date = br.readLine();
							time = br.readLine();
							venue = br.readLine();
							score = br.readLine();
							result = br.readLine();
							f[i] = new Fixtures(match,date,time,venue,score,result);
							System.out.println(f[i]);
							sq.addFixtures(f[i]);
						}
						else {
							System.out.println("Enter a valid choice!!!");
						}
					}
				}
				catch(InputMismatchException e) {
					e.printStackTrace();
				}
			}
			else if(choice == 2) {
				SportsQuery sq = new SportsQuery();
				System.out.println("------------------------------------------------------------------------------------------------------------");
				System.out.println("1. remove a player");
				System.out.println("2. remove a medic");
				System.out.println("3. remove a staff");
				System.out.println("4. remove a fixture");
				System.out.println("------------------------------------------------------------------------------------------------------------");
				int option = sc.nextInt();
				if(option == 1) {
					System.out.println("Enter the player name");
					String name_p = br.readLine();
					sq.removePlayerDetails(name_p);
				}
				else if(option == 2) {
					System.out.println("Enter the player name");
					String name_p = br.readLine();
					sq.removeMedicDetails(name_p);
				}
				else if(option == 3) {
					System.out.println("Enter the staff name");
					String name_s = br.readLine();
					sq.removeStaffDetails(name_s);
				}
				else if(option == 4) {
					System.out.println("Enter the fixture");
					String mat = br.readLine();
					sq.removeFixtureDetails(mat);
				}
				else {
					System.out.println("Invalid choice!!!");
				}
			}
			else if(choice == 3) {
				SportsQuery sq = new SportsQuery();
				System.out.println("------------------------------------------------------------------------------------------------------------");
				System.out.println("1. show the squad details");
				System.out.println("2. show all medic details");
				System.out.println("3. show all staffs details");
				System.out.println("4. show all fixtures");
				System.out.println("5. show the individual stats");
				System.out.println("6. show only specific details");
				System.out.println("------------------------------------------------------------------------------------------------------------");
				int option = sc.nextInt();
				try {
				if(option == 1) {
					System.out.println("The players are: ");
					sq.displayPlayerDetails();
				}
				else if(option == 2) {
					System.out.println("The medic details are: ");
					sq.displayMedicDetails();
				}
				else if(option == 3) {
					System.out.println("The staffs are: ");
					sq.displayStaffDetails();
				}
				else if(option == 4) {
					System.out.println("The fixtures are: ");
					sq.displayFixtures();
				}
				else if(option == 5) {
					System.out.println("------------------------------------------------------------------------------------------------------------");
					System.out.println("1. individual player details");
					System.out.println("2. individual medic details");
					System.out.println("3. individual staff details");
					System.out.println("4. individual fixture details");
					System.out.println("------------------------------------------------------------------------------------------------------------");
					int as = sc.nextInt();
					if(as == 1) {
						System.out.println("Enter the detail to be printed: ");
						String detail = br.readLine();
						System.out.println("Enter the player name: ");
						pname = br.readLine();
						sq.individualPlayerDetails(detail, pname);
					}
					else if(as == 2) {
						System.out.println("Enter the detail to be printed: ");
						String detail = br.readLine();
						System.out.println("Enter the player name: ");
						pname = br.readLine();
						sq.individualMedicDetails(detail, pname);
					}
					else if(as == 3) {
						System.out.println("Enter the detail to be printed: ");
						String detail = br.readLine();
						System.out.println("Enter the staff name: ");
						name = br.readLine();
						sq.individualStaffDetails(detail, name);
					}
					else if(as == 4) {
						System.out.println("Enter the detail to be printed: ");
						String detail = br.readLine();
						System.out.println("Enter the fixture: ");
						match = br.readLine();
						sq.individualFixtures(detail, match);
					}
					else {
						System.out.println("Invalid choice!!!");
					}
				}
				else if(option == 6) {
					System.out.println("------------------------------------------------------------------------------------------------------------");
					System.out.println("1. player values");
					System.out.println("2. medic values");
					System.out.println("3. staff values");
					System.out.println("4. fixture values");
					System.out.println("------------------------------------------------------------------------------------------------------------");
					int as = sc.nextInt();
					if(as == 1) {
						System.out.println("Enter the detail to be printed: ");
						String detail = br.readLine();
						System.out.println("Enter the colum name to be displayed: ");
						String s = br.readLine();
						sq.PlayerValue(detail,s );
					}
					else if(as == 2) {
						System.out.println("Enter the detail to be printed: ");
						String detail = br.readLine();
						System.out.println("Enter the colum name to be displayed: ");
						String s = br.readLine();
						sq.MedicValue(detail,s );
					}
					else if(as == 3) {
						System.out.println("Enter the detail to be printed: ");
						String detail = br.readLine();
						System.out.println("Enter the colum name to be displayed: ");
						String s = br.readLine();
						sq.StaffValue(detail,s );
					}
					else if(as == 4) {
						System.out.println("Enter the detail to be printed: ");
						String detail = br.readLine();
						System.out.println("Enter the colum name to be displayed: ");
						String s = br.readLine();
						sq.FixtureValue(detail,s );
					}
					else {
						System.out.println("Invalid choice!!!");
					}
				}
				else {
					System.out.println("Invalid choice!!!");
				}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			else if(choice == 4) {
				System.out.println("------------------------------------------------------------------------------------------------------------");
				System.out.println("1. Update the squad details");
				System.out.println("2. Update medic details");
				System.out.println("3. Update staffs details");
				System.out.println("4. Update fixtures");
				System.out.println("------------------------------------------------------------------------------------------------------------");
				SportsQuery sq = new SportsQuery();
				int option = sc.nextInt();
				if(option == 1) {
					System.out.println("------------------------------------------------------------------------------------------------------------");
					System.out.println("1.Salary");
					System.out.println("2.Position");
					System.out.println("3.Age");
					System.out.println("4.Jersey number");
					System.out.println("5.Goals scored");
					System.out.println("6.Nationality");
					System.out.println("7.Contract duration");
					System.out.println("------------------------------------------------------------------------------------------------------------");
					int l = sc.nextInt();
					try {
						System.out.println("Enter the detail");
						String detail = sc.nextLine();
						System.out.println("Enter the player name");
						String name_p = sc.nextLine();
						sq.updatePlayerDetails(l, name_p, detail);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
				else if(option == 2) {
					System.out.println("------------------------------------------------------------------------------------------------------------");
					System.out.println("1.Condition");
					System.out.println("2.Availability");
					System.out.println("3.Age");
					System.out.println("4.Trainer");
					System.out.println("------------------------------------------------------------------------------------------------------------");
					int l = sc.nextInt();
					try {
						System.out.println("Enter the detail");
						String detail = br.readLine();
						System.out.println("Enter the player name");
						String name_p = br.readLine();
						sq.updatePlayerDetails(l, name_p, detail);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
				else if(option == 3) {
					System.out.println("------------------------------------------------------------------------------------------------------------");
					System.out.println("1.Role");
					System.out.println("2.Salary");
					System.out.println("3.Age");
					System.out.println("4.Phone number");
					System.out.println("5.Contract duration");
					System.out.println("------------------------------------------------------------------------------------------------------------");
					int l = sc.nextInt();
					try {
						System.out.println("Enter the detail");
						String detail = br.readLine();
						System.out.println("Enter the staff name");
						String name_s = br.readLine();
						sq.updatePlayerDetails(l, name_s, detail);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
				else if(option == 4) {
					System.out.println("------------------------------------------------------------------------------------------------------------");
					System.out.println("1.Match");
					System.out.println("2.Date");
					System.out.println("3.Time");
					System.out.println("4.Venue");
					System.out.println("5.Score");
					System.out.println("6.Result");
					System.out.println("------------------------------------------------------------------------------------------------------------");
					int l = sc.nextInt();
					try {
						System.out.println("Enter the detail");
						String detail = br.readLine();
						System.out.println("Enter the fixture");
						String name_s = br.readLine();
						sq.updatePlayerDetails(l, name_s, detail);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
				else {
					System.out.println("Invalid choice !!!");
				}
			}
		}
	}
}