package com.example.demo.ejercicio9;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateTests {
    
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass() {
        context = new ClassPathXmlApplicationContext("spring/ejercicio9/beans.xml");
    }

    @Test
    public void templateTest() {
        log.info("Testing template inheritance...");

        DatabaseConnection dbConnParent = context.getBean("connectionParentBean", DatabaseConnection.class);
        DatabaseConnection dbConnChild = context.getBean("connectionChildBean", DatabaseConnection.class);

        assertEquals("localhost", dbConnParent.getDatabase());
        assertEquals("UATdb", dbConnChild.getDatabase());
        assertEquals(dbConnChild.getUser(), dbConnParent.getUser());
        assertEquals(dbConnChild.getPassword(), dbConnParent.getPassword());
    }
}
