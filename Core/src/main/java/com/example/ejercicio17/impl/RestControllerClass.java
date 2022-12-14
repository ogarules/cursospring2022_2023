package com.example.ejercicio17.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejercicio17.IRestControllerClass;
import com.example.ejercicio17.IServiceClass;

import lombok.Data;

@Data
@RestController
public class RestControllerClass implements IRestControllerClass {
    
    @Autowired
    IServiceClass service;

    @Autowired
    private String restControllerClassName;
}
