package com.example.demo.ejercicio1;

public abstract class Plant implements LivingBeing {

    abstract String consume(Sunlight sunlight);

    @Override
    public String consume(Water water) {
        return "Plant consuming water";
    }

    @Override
    public String grow() {
        return "Plant growing";
    }
    
}
