package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.ejercicio22.IAudiencia;
import com.example.demo.ejercicio22.IJugador;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/ejercicio22/beans.xml" })
public class MatchNoAspectTests {

    @Value("#{jugadorBean}")
    private IJugador jugador;
    
    @Value("#{audienciaBean}")
    private IAudiencia audiencia;

    @Test
    public void traditionalTest(){
        log.info("Testing traditional execution...");

        audiencia.gritarOle();
        jugador.ejecutarPase();
        audiencia.gritarOle();

        log.info("-------------------");

        audiencia.gritarOle();
        jugador.ejecutarPase();
        audiencia.gritarOle();

        log.info("-------------------");

        audiencia.sePonedePie();

        try {
            jugador.cobrarPenal(false);
            audiencia.gritaGol();
        } catch (Throwable e) {
            log.error(e.getMessage());
            audiencia.abuchear();
            audiencia.abuchear();
        }

        audiencia.seSienta();

        log.info("-------------------");

        jugador.cometerFalta();
        audiencia.abuchear();

        log.info("-------------------");

        try {
            jugador.tirarAGol(false);
            audiencia.gritaGol();
            audiencia.gritaGol();
            audiencia.aplaudir();
            audiencia.aplaudir();
        } catch (Throwable e) {
            log.error(e.getMessage());
        }

        log.info("-------------------");

        jugador.esExpulsado();
        audiencia.abuchear();
            audiencia.abuchear();
            audiencia.aplaudir();
            audiencia.aplaudir();
    }
}
