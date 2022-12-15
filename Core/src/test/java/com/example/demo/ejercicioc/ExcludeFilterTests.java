package com.example.demo.ejercicioc;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.ejercicioc.repositories.RepositoryA;
import com.example.demo.ejercicioc.services.ServiceA;
import com.example.demo.ejercicioc.services.other.ServiceB;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExcludeFilterTests {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass() {
        context = new ClassPathXmlApplicationContext("spring/ejercicioc/beans.xml");
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void excludeRepositoryFilterTest() {
        log.info("Testing exclusion of repository...");

        RepositoryA repositoryA = context.getBean(RepositoryA.class);

        Assert.fail();
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void excludeServiceFilterTest() {
        log.info("Testing exclusion of service...");

        ServiceA serviceA = context.getBean(ServiceA.class);

        Assert.fail();
    }

    @Test
    public void excludeServiceBFilterTest() {
        log.info("Testing exclusion of service...");

        ServiceB serviceB = context.getBean(ServiceB.class);

        assertNotNull(serviceB);
    }

}
