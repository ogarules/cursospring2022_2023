package com.example.demo.ejercicio21.methodReplacement;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class SportsCar {
    private String model;

    public int run(){
        int milis = 120;

        log.info("{} running at {}", model, milis);

        return milis;
    }
}
