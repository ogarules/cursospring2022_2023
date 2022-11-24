package com.example.demo.ejercicio5;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScopeTests {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass() {
        context = new ClassPathXmlApplicationContext("spring/ejercicio5/beans.xml");
    }

    @Test
    public void SingletonScopeTest() {
        log.info("Testing scopes...");

        Persona persona = (Persona) context.getBean("personaSingletonBean");
        Persona persona2 = (Persona) context.getBean("personaSingletonBean");

        persona.setNombre("Oga");

        Assert.assertEquals(persona.getNombre(), persona2.getNombre());
    }
    
    @Test
    public void PrototypeScopeTest() {
        log.info("Testing scopes...");

        Persona persona = (Persona) context.getBean("personaPrototypeBean");
        Persona persona2 = (Persona) context.getBean("personaPrototypeBean");

        persona.setNombre("Oga");

        Assert.assertNotEquals(persona.getNombre(), persona2.getNombre());
    }
    
    @Test
    public void CustomScopeTest() {
        log.info("Testing scopes...");

        Persona persona = (Persona) context.getBean("personaCustomBean");
        Persona persona2 = (Persona) context.getBean("personaCustomBean");
        Persona persona3 = (Persona) context.getBean("personaCustomBean");
        Persona persona4 = (Persona) context.getBean("personaCustomBean");
        Persona persona5 = (Persona) context.getBean("personaCustomBean");
        Persona persona6 = (Persona) context.getBean("personaCustomBean");
        Persona persona7 = (Persona) context.getBean("personaCustomBean");

        persona.setNombre("Oga");

        Assert.assertEquals(persona.getNombre(), persona2.getNombre());
        Assert.assertEquals(persona.getNombre(), persona3.getNombre());
        Assert.assertEquals(persona.getNombre(), persona4.getNombre());
        Assert.assertEquals(persona.getNombre(), persona5.getNombre());
        Assert.assertNotEquals(persona.getNombre(), persona6.getNombre());
    }
}
