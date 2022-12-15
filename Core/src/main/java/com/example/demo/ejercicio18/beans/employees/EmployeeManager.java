package com.example.demo.ejercicio18.beans.employees;

import javax.inject.Named;

import com.example.demo.ejercicio18.ManagerEmployeeQualifier;
import com.example.demo.ejercicio18.beans.Employee;

@Named
@ManagerEmployeeQualifier
public class EmployeeManager extends Employee {
    public EmployeeManager() {
        this.setName("Manager");
        this.setRfc("GALO124");
    }
}
