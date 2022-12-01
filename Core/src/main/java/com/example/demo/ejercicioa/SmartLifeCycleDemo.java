package com.example.demo.ejercicioa;

import org.springframework.context.SmartLifecycle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmartLifeCycleDemo implements SmartLifecycle {
    
    private boolean isRunning = false;

    @Override
    public void start() {
        log.info("Smart life cycle Starting");
        isRunning = true;
    }

    @Override
    public void stop() {
        log.info("Smart life cycle stoping....");
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        log.info("Checking if smart life cycle is running....");
        return isRunning;
    }
    
}
