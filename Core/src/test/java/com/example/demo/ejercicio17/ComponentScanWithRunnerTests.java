package com.example.demo.ejercicio17;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.ejercicio17.IComponentClass;
import com.example.ejercicio17.IControllerClass;
import com.example.ejercicio17.IRepositoryClass;
import com.example.ejercicio17.IRestControllerClass;
import com.example.ejercicio17.IServiceClass;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/ejercicio17/beans.xml"})
public class ComponentScanWithRunnerTests {
    
    @Autowired
    IComponentClass componentClass;

    @Autowired
    IControllerClass controllerClass;

    @Autowired
    IRepositoryClass repositoryClass;

    @Autowired
    IRestControllerClass restControllerClass;

    @Autowired
    IServiceClass serviceClass;

    @Test
    public void componentScanTest() {
        log.info("Testing component scan with runner...");

        assertEquals("My component class", componentClass.getComponentClassName());
        assertEquals("My controller class", controllerClass.getControllerClassName());
        assertEquals("My repository class", repositoryClass.getRepositoryClassName());
        assertEquals("My rest controller class", restControllerClass.getRestControllerClassName());
        assertEquals("My service class", serviceClass.getServiceClassName());
    }
}
