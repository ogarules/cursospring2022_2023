package com.example.demo.ejercicio1;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;

import com.example.demo.ejercicio1.Aadvark;
import com.example.demo.ejercicio1.Animal;
import com.example.demo.ejercicio1.Bug;
import com.example.demo.ejercicio1.BugEater;
import com.example.demo.ejercicio1.LivingBeing;
import com.example.demo.ejercicio1.Water;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AadvarkTests {
    // private final Logger log = LoggerFactory.getLogger(VenusFlyTrap.class);
   
    @Test
    public void consumeTest() {
        log.info("Testing Aadvark consume methods...");

        Aadvark aadvark = new Aadvark();

        BugEater bugEater = aadvark;
        LivingBeing livingBeing = aadvark;
        Animal animal = aadvark;

        Assert.assertEquals("Aadvark consumed bug", bugEater.consume(new Bug()));
        Assert.assertEquals("Animal consumed water", livingBeing.consume(new Water()));
        
        Assert.assertEquals("Aadvark consumed bug", aadvark.consume(new Bug()));
        Assert.assertEquals("Animal consumed water", aadvark.consume(new Water()));
        
        Assert.assertSame(bugEater, livingBeing);
        Assert.assertSame(aadvark, animal);
    }
}
