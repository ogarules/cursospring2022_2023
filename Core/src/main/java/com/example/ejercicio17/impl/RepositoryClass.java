package com.example.ejercicio17.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ejercicio17.IRepositoryClass;

import lombok.Data;

@Data
@Repository
public class RepositoryClass implements IRepositoryClass {
    
    @Autowired
    private String repositoryClassName;
}
