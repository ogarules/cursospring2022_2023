package com.example.demo.ejercicio18;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.ejercicio18.beans.Corporation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/ejercicio18/beans.xml")
public class Jsr330AnnotationsTests {
    @Inject
    private Corporation corporation;

    @Test
    public void annotationsTest() {
        log.info("Testing jsr330 anotations..");

        assertNotNull(corporation);
    }
}
