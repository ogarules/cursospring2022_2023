package com.example.demo.ejercicio29.models;

import java.util.List;

import lombok.Data;

@Data
public class Persons {
    
    private List<Person> persons;

    public Persons(List<Person> persons){
        this.persons = persons;
    }
}
