package com.example.demo.ejercicio24.dao;

import java.util.List;

import com.example.demo.ejercicio24.model.Account;

public interface IAccountDAO {
    List<Account> findByCustomerId(Long customerId);
    void updateBalance(Account aacount, Long amount);
    void updateDescription(Account account);
}
