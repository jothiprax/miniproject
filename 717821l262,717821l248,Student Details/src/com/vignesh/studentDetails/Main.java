package com.vignesh.studentDetails;
import java.util.Scanner;
    public class Main {
        public static void main(String[] args) {
            String name;
            int id;
            StudentDaoInt daao = new StudentDaoImpl();
            System.out.println("Welcome to student details");
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("1.Add student\n" +
                        "2 .show all student\n" +
                        "3. show student based on id\n" +
                        "4. update student\n " +
                        "5. delete student");
                System.out.println("Enter choice ");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        Student std = new Student();
                        System.out.println("enter id");
                        id = sc.nextInt();
                        System.out.println("enter name");
                        name=sc.next();
                        System.out.println("enter department");
                        String  department= sc.next();
                        System.out.println("enter age");
                        int age = sc.nextInt();
                        std.setId(id);
                        std.setName(name);
                        std.setDepartment(department);
                        std.setAge(age);
                        daao.createStudent(std);
                        break;
                    case 2:
                        daao.showAllStudent();
                        break;
                    case 3:
                        System.out.println("enter id to show details");
                        int stdid = sc.nextInt();
                        daao.showStudentBasedOnID(stdid);
                        break;
                    case 4:
                        System.out.println("Enter id to update the details");
                        int stdid1 = sc.nextInt();
                        System.out.println("enter the new name");
                        name = sc.next();
                        daao.updateStudent(stdid1, name);
                        break;
                    case 5:
                        System.out.println("enter the id to delete");
                        id = sc.nextInt();
                        daao.deleteStudent(id);
                        break;
                    case 6:
                        System.out.println("thank you");
                        System.exit(0);
                    default:
                        System.out.println("Enter valid choice ");
                        break;
                }
            } while (true);
        }
    }
