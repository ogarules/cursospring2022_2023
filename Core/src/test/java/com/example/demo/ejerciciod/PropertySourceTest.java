package com.example.demo.ejerciciod;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class PropertySourceTest {
    
    @Autowired
    ValuesClass valuesClass;

    @Autowired
    EnvironmentClass environmentClass;

    @Test
    public void propertySourceTest() {
        log.info("Testing property source...");

        assertEquals(valuesClass.getName(), environmentClass.getName());
        assertEquals(valuesClass.getAge(), environmentClass.getAge());
    }
}
