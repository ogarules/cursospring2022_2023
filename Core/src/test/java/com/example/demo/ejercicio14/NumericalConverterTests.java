package com.example.demo.ejercicio14;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumericalConverterTests {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass() {
        context = new ClassPathXmlApplicationContext("spring/ejercicio14/beans.xml");
    }

    @Test
    public void converterTest() {
        log.info("Testing number to string conversion...");

        NumericalConverter converter = context.getBean(NumericalConverter.class);

        String convertedString = converter.convert("999999999,00", true);

        assertNotNull(converter);
        assertEquals("NOVECIENTOS NOVENTA Y NUEVE MILLONES NOVECIENTOS NOVENTA Y NUEVE MIL NOVECIENTOS NOVENTA Y NUEVE PESOS 00/100", convertedString);
    }
}
