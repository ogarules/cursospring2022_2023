package com.example.demo.ejercicio6;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InitDestroyTests {
    private static ApplicationContext context;
 
    @BeforeClass
    public static void beforeClass() {
        context = new ClassPathXmlApplicationContext("spring/ejercicio6/beans.xml");
    }

    @Test
    public void initDestroyTest() {
        log.info("Testing init and destroy methods...");

        DataBaseConnection conn = context.getBean("dbConnBean", DataBaseConnection.class);

        assertNotNull(conn);

        log.info("Closing context...");
        ((AbstractApplicationContext) context).close();

        log.info("Context closed....");
    }
}
