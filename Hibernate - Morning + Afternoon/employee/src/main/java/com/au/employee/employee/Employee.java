package com.au.employee.employee;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 2)
    private String firstName, lastName, designation, dob;
    private int age;
    private long salary;

    public Employee(){
    }

    public Employee(String firstName, String lastName, String designation, String dob, int age, long salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.designation = designation;
        this.dob = dob;
        this.age = age;
        this.salary = salary;
    }


    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }


    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getfirstName() {
        return firstName;
    }


    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
    public String getlastName() {
        return lastName;
    }

    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getDesignation() {
        return designation;
    }


    public void setDob(String dob) {
        this.dob = dob;
    }    
    public String getDob() {
        return dob;
    }


    public void setSalary(long salary) {
        this.salary = salary;
    }
    public long getSalary() {
        return salary;
    }


    @Override
    public String toString() {
        return "Employee {" +
                "id=" + id +
                ", age=" + age +
                ", fName='" + firstName + '\'' +
                ", lName='" + lastName + '\'' +
                ", designation='" + designation + '\'' +
                ", dob='" + dob + '\'' +
                ", salary=" + salary +
                " }";
    }
}