package com.example.demo.ejercicio1;

public class Aadvark extends Animal implements BugEater {

    @Override
    public String consume(Bug bug) {
        return "Aadvark consumed bug";
    }

    @Override
    String walk() {
        return "Aadvark walked";
    }
    
}
