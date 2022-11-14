package com.example.demo.ejercicio1;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;

import com.example.demo.ejercicio1.Bug;
import com.example.demo.ejercicio1.BugEater;
import com.example.demo.ejercicio1.LivingBeing;
import com.example.demo.ejercicio1.Plant;
import com.example.demo.ejercicio1.Sunlight;
import com.example.demo.ejercicio1.VenusFlyTrap;
import com.example.demo.ejercicio1.Water;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VenusFlyTrapTests {
    // private final Logger log = LoggerFactory.getLogger(VenusFlyTrap.class);
   
    @Test
    public void consumeTest() {
        log.info("Testing VenusFlyTrap consume methods...");

        VenusFlyTrap venusFlyTrap = new VenusFlyTrap();

        BugEater bugEater = venusFlyTrap;
        LivingBeing livingBeing = venusFlyTrap;
        Plant plant = venusFlyTrap;

        Assert.assertEquals("VenusFlyTrap consumed bug", bugEater.consume(new Bug()));
        Assert.assertEquals("Plant consuming water", livingBeing.consume(new Water()));
        Assert.assertEquals("Plant consuming water", plant.consume(new Water()));
        Assert.assertEquals("VenusFlyTrap consumed sunlight", plant.consume(new Sunlight()));

        Assert.assertEquals("VenusFlyTrap consumed bug", venusFlyTrap.consume(new Bug()));
        Assert.assertEquals("Plant consuming water", venusFlyTrap.consume(new Water()));
        Assert.assertEquals("Plant consuming water", venusFlyTrap.consume(new Water()));
        Assert.assertEquals("VenusFlyTrap consumed sunlight", venusFlyTrap.consume(new Sunlight()));

        Assert.assertSame(bugEater, livingBeing);
        Assert.assertSame(venusFlyTrap, plant);
    }
}
