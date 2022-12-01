package com.example.demo.ejercicio8;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactoryTests {
    
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass() {
        context = new ClassPathXmlApplicationContext("spring/ejercicio8/beans.xml");
    }

    @Test
    public void factoryMethodTest() {
        log.info("Testing factory method...");

        Student student = context.getBean("studentFactoryMethodBean", Student.class);

        Assert.assertEquals("Oscar Garcia", student.getSubject().getTeacher().getName());

    }

    @Test
    public void factoryClassTest() {
        log.info("]Testing factory class...");

        Student student = context.getBean("studentFactoryClassBean", Student.class);

        Assert.assertEquals("Oscar Garcia", student.getSubject().getTeacher().getName());
    }
}
