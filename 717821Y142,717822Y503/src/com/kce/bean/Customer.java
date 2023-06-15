package com.kce.bean;
public class Customer {
    private int id;
    private String name;
    private double amount;
    private int age;
    //private int interest;

    public Customer(){

    }
    public Customer(int id, String name, double amount, int age) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.age = age;
        //this.interest = interest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + amount +
                ", age=" + age +
                '}';
    }
}