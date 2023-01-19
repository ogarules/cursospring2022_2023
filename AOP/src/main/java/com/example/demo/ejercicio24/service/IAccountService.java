package com.example.demo.ejercicio24.service;

import java.util.List;

import com.example.demo.ejercicio24.model.Account;

public interface IAccountService {
    List<Account> findByCustomerId(Long customerId);
    void updateBalance(Account aacount, Long amount);
    void updateDescription(Account account);
}
