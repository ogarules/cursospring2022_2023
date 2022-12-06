package com.example.demo.ejercicio13;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiringTests {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass() {
        context = new ClassPathXmlApplicationContext("spring/ejercicio13/beans-type.xml");
    }

    @Test
    public void autowireTest() {
        log.info("Tsting autowiring by type...");

        Car car = context.getBean(Car.class);

        assertNotNull(car.getEngine());
    }
}
