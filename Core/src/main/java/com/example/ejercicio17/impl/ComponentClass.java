package com.example.ejercicio17.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.ejercicio17.IComponentClass;
import com.example.ejercicio17.IRepositoryClass;

import lombok.Data;

@Component
@Data
public class ComponentClass implements IComponentClass {
    
    @Autowired
    IRepositoryClass repository;

    @Autowired
    private String componentClassName;
}
