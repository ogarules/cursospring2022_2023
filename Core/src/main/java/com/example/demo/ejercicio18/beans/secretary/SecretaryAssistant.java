package com.example.demo.ejercicio18.beans.secretary;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Qualifier;

import com.example.demo.ejercicio18.SecretaryAssistantQualifier;
import com.example.demo.ejercicio18.beans.Employee;
import com.example.demo.ejercicio18.beans.Secretary;

@Named
@Singleton
@SecretaryAssistantQualifier
public class SecretaryAssistant extends Secretary {
    
    @Override
    @Inject
    @Qualifier("secretaryAssistantEmployee")
    public void setEmployee(Employee employee) {
        super.setEmployee(employee);
    }
}
