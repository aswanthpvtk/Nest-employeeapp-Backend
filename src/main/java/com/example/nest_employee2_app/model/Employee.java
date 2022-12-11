package com.example.nest_employee2_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private int empid;
    private String name;
    private String designation;
    private  int salary;
    private String email;
    private String mob;
    private String uname;
    private String psw;
}
