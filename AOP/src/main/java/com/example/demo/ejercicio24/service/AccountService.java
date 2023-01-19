package com.example.demo.ejercicio24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ejercicio24.dao.IAccountDAO;
import com.example.demo.ejercicio24.model.Account;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountService implements IAccountService {
    
    @Autowired
    private IAccountDAO accountDAO;

    @Override
    public List<Account> findByCustomerId(Long customerId) {
        log.info("Service getting accounts...");
        return accountDAO.findByCustomerId(customerId);
    }

    @Override
    public void updateBalance(Account aacount, Long amount) {
        log.info("Service updating balance...");
        accountDAO.updateBalance(aacount, amount);
        
    }

    @Override
    public void updateDescription(Account account) {
        log.info("Service updating description...");
        accountDAO.updateDescription(account);
    }

    

}
