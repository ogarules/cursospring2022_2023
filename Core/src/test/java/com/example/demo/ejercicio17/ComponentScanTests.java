package com.example.demo.ejercicio17;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.ejercicio17.IComponentClass;
import com.example.ejercicio17.IControllerClass;
import com.example.ejercicio17.IRepositoryClass;
import com.example.ejercicio17.IRestControllerClass;
import com.example.ejercicio17.IServiceClass;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComponentScanTests {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass() {
        context = new ClassPathXmlApplicationContext("spring/ejercicio17/beans.xml");
    }

    @Test
    public void componentScanTest() {
        log.info("Testing component scan ....");

        IComponentClass componentClass = context.getBean(IComponentClass.class);
        IControllerClass controllerClass = context.getBean(IControllerClass.class);
        IRepositoryClass repositoryClass = context.getBean(IRepositoryClass.class);
        IRestControllerClass restControllerClass = context.getBean(IRestControllerClass.class);
        IServiceClass serviceClass = context.getBean(IServiceClass.class);

        assertEquals("My component class", componentClass.getComponentClassName());
        assertEquals("My controller class", controllerClass.getControllerClassName());
        assertEquals("My repository class", repositoryClass.getRepositoryClassName());
        assertEquals("My rest controller class", restControllerClass.getRestControllerClassName());
        assertEquals("My service class", serviceClass.getServiceClassName());
    }
}
