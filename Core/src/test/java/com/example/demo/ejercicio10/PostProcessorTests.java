package com.example.demo.ejercicio10;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostProcessorTests {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass() {
        context = new ClassPathXmlApplicationContext("spring/ejercicio10/beans.xml");
    }

    @Test
    public void postProcessorTest() {
        log.info("Testing postprocessor..");

        IWorker worker = (IWorker) context.getBean("workerBean");

        Assert.assertEquals(WorkerFacade.class, worker.getClass());
        Assert.assertEquals("otro oga mas facade", worker.getName());
    }
}
