package com.example.demo.ejercicio21.methodReplacement;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunReplacer implements MethodReplacer {@Override
    public Object reimplement(Object arg0, Method arg1, Object[] arg2) throws Throwable {
        int milis = 200;

        SportsCar car = (SportsCar)arg0;
        log.info("Repalced : {} running at {}", car.getModel(), milis);

        return milis;
    }
    
}
