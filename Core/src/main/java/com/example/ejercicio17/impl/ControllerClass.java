package com.example.ejercicio17.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.ejercicio17.IControllerClass;

import lombok.Data;

@Data
@Controller
public class ControllerClass implements IControllerClass {
    
    @Autowired
    private String controllerClassName;
}
