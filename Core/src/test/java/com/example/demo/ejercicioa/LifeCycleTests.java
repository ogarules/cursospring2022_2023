package com.example.demo.ejercicioa;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LifeCycleTests {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass() {
        context = new ClassPathXmlApplicationContext("spring/ejercicioa/beans.xml");
    }

    @Test
    public void LifeCycleTest() {
        log.info("Testing lifecycle ...");

        log.info("Starting context manually...");
        ((AbstractApplicationContext) context).start();

        log.info("Stoping context manually...");
        ((AbstractApplicationContext)context).stop();
    }
}
