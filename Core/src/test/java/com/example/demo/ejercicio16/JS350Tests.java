package com.example.demo.ejercicio16;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JS350Tests {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass() {
        context = new ClassPathXmlApplicationContext("spring/ejercicio16/beans.xml");
    }

    @Test
    public void resourceTest() {
        log.info("Tsting resource and init and destroy...");

        Student student = context.getBean(Student.class);

        assertNotNull(student.getMathematics());
    }
}
