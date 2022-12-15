package com.example.ejercicio17.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejercicio17.IComponentClass;
import com.example.ejercicio17.IServiceClass;

import lombok.Data;

@Data
@Service
public class ServiceClass implements IServiceClass {
    
    @Autowired
    private IComponentClass component;

    @Autowired
    private String serviceClassName;
}
