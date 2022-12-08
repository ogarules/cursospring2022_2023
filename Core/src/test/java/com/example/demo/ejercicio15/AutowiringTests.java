package com.example.demo.ejercicio15;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.ejercicio15.initmethod.Student;
import com.example.demo.ejercicio15.notrequired.Airplane;
import com.example.demo.ejercicio15.property.Reporter;
import com.example.demo.ejercicio15.required.Cameraman;
import com.example.demo.ejercicio15.setter.Journalist;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiringTests {
    
    @Test
    public void constructorTest() {
        log.info("Testinjg autowirgin by constructor...");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejercicio15/beans-required.xml");

        Cameraman cameraman = context.getBean(Cameraman.class);

        assertEquals("OGA", cameraman.getName());
    }

    @Test
    public void propertyTest() {
        log.info("Testinjg autowirgin by property...");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejercicio15/beans-property.xml");

        Reporter reporter = context.getBean(Reporter.class);

        assertEquals("Jordan Peterson", reporter.getName());
    }

    @Test
    public void notRequiredTest() {
        log.info("Testinjg autowirgin by property...");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejercicio15/beans-notrequired.xml");

        Airplane airplane = context.getBean(Airplane.class);

        assertEquals("airline2", airplane.getAirline().getName());
        assertNull(airplane.getAirplaneCode());
    }

    @Test
    public void initMethodTest() {
        log.info("Testinjg autowirgin by property...");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejercicio15/beans-initmethod.xml");

        Student student = context.getBean(Student.class);

        assertEquals("Oga", student.getName());

    }
    
    @Test
    public void setterTest() {
        log.info("Testinjg autowirgin by property...");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejercicio15/beans-setter.xml");

        Journalist journalist = context.getBean(Journalist.class);

        assertEquals("OGA", journalist.getName());
        
    }
}
