package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.ejercicio22.IJugador;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/ejercicio22/beans-aop.xml" })
public class MatchAspectTests {
    @Value("#{jugadorBean}")
    private IJugador jugador;

    @Test
    public void aspectsExecution(){
        log.info("Testing execution with aspects...");

        jugador.ejecutarPase();

        log.info("-------------------");

        jugador.ejecutarPase();

        log.info("-------------------");

        try {
            jugador.cobrarPenal(false);
        } catch (Throwable e) {
            log.error(e.getMessage());
        }

        log.info("-------------------");

        jugador.cometerFalta();

        log.info("-------------------");

        try {
            jugador.tirarAGol(false);
        } catch (Throwable e) {
            log.error(e.getMessage());
        }

        log.info("-------------------");

        try {
            jugador.tirarAGol(true);
        } catch (Throwable e) {
            log.error(e.getMessage());
        }

        log.info("-------------------");

        jugador.esExpulsado();
    }
}
