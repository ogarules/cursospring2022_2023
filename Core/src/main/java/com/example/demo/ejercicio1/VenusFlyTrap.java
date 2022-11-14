package com.example.demo.ejercicio1;

public class VenusFlyTrap extends Plant implements BugEater {

    @Override
    String consume(Sunlight sunlight) {
        return "VenusFlyTrap consumed sunlight";
    }

    @Override
    public String consume(Bug bug) {
        return "VenusFlyTrap consumed bug";
    }
    
}
