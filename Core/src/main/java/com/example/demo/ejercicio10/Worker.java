package com.example.demo.ejercicio10;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Worker implements IWorker {
    private String name;
    private int age;

    public Worker() {
        this.name = "El oga";
        this.age = 21;

        log.info("Constructor - Worker name {}", name);
        log.info("Constructor - Worker age {}", age);
    }

    @Override
    public void init() {
        log.info("Initializing worker.... ");
        log.info("init - Worker name {}", name);
        name = "Otro oga";
        log.info("init - Worker name {}", name);

    }
    
    @Override
    public void destroy() {
        log.info("Killing worker...");
    }

    @Override
    public void showInfo(){
        log.info("worker info - name: {} age {}", name, age);
    }
}
