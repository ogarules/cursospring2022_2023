package com.example.demo.ejercicio18.beans.employees;

import javax.inject.Named;

import com.example.demo.ejercicio18.beans.Employee;

@Named("itDirectorEmployee")
public class EmployeeDirector extends Employee {
    public EmployeeDirector() {
        this.setName("Director");
        this.setRfc("GALO34");
    }
}
