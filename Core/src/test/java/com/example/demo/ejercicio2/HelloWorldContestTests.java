package com.example.demo.ejercicio2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloWorldContestTests {
    
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass() {
        var path = "spring/ejercicio2/beans.xml";

        context = new ClassPathXmlApplicationContext(path);
    }

    @Test
    public void helloWorldTest() {
        log.info("Testing hello world by app context...");

        var helloWorldBean = (HelloWorld) context.getBean("helloWorldProperties");        
        Assert.assertEquals("Hello world from properties", helloWorldBean.getMensaje());
    }
}
