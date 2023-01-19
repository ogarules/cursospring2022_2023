package com.example.demo.ejercicio24;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.ejercicio24.model.Account;
import com.example.demo.ejercicio24.web.IAccountWeb;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class AspectsTests {
    
    @Autowired
    IAccountWeb controller;

    @Test
    public void aspectTest(){
        log.info("Testing aspects...");

        controller.showAccountsFromCustomerId(1L);
        
        controller.processFormUpdateBalance(Account.builder()
         .accountDescription("Account 1")
         .balance(new BigDecimal(100))
         .build(), 200L);

        controller.processFormUpdateDescription(Account.builder()
        .accountDescription("Account 1")
        .balance(new BigDecimal(100))
        .build());

    }
}
