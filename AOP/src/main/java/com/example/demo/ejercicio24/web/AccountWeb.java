package com.example.demo.ejercicio24.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.ejercicio24.model.Account;
import com.example.demo.ejercicio24.service.IAccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AccountWeb implements IAccountWeb {
    
    @Autowired 
    IAccountService accountService;

    @Override
    public void showAccountsFromCustomerId(Long customerId) {
        log.info("Controller getting accounts");

        List<Account> accountList = accountService.findByCustomerId(customerId);

        accountList.stream().forEach(System.out::println);
    }

    @Override
    public void processFormUpdateBalance(Account account, Long amount) {
        log.info("Controller processing update balance...");
        accountService.updateBalance(account, amount);
        
    }

    @Override
    public void processFormUpdateDescription(Account account) {
        log.info("Controller processing update description...");
        accountService.updateDescription(account);
        
    }

    
}
