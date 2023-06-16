package com.vignesh.studentDetails;

public interface StudentDaoInt {
        //create student
        public void createStudent(Student std);
        //show all student
        public void showAllStudent();
        //show student based on id
        public void showStudentBasedOnID(int id);
        //update student
        public void updateStudent(int id,String name);
        //delete student
        public void deleteStudent(int id);
    }
