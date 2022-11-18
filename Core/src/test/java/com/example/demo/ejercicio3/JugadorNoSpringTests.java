package com.example.demo.ejercicio3;

import org.junit.Assert;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JugadorNoSpringTests {
    
    @Test
    public void noSpringTest() {
        log.info("Testing traditional instantiation...");

        Evento evento = new Evento("La gran final");
        Torneo torneo = new Torneo("Super campeones", evento);
        Partido partido = new Partido("Newpi vs furuama");

        JugadorFutbol futbol = new JugadorFutbol();
        futbol.setNombre("Oliver atto");
        futbol.setPartido(partido);
        futbol.setTorneo(torneo);

        Assert.assertEquals("La gran final", futbol.getTorneo().getEvento().getNombre());
    }
}
