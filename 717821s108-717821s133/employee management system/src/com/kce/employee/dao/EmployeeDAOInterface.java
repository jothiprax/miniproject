package com.kce.employee.dao;


public interface EmployeeDAOInterface{

    //create employee
    public void createEmployee();

    //Search for an employee
    public void searchForEmployee();

    //show all employee
    public void showAllEmployee();

    //update the employee
    public void updateEmployee();

    //delete the employee 
    public void deleteEmployee();

    //delete all the employees
    public void deleteAllEmployee();
}