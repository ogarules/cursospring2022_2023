package com.example.demo.ejercicio24.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.example.demo.ejercicio24.model.Account;
import com.example.demo.util.Color;
import com.example.demo.util.IColorWriter;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component("daoAccountLoggingAspect")
@Slf4j
public class DAOAccountLoggingAspect implements Ordered {
    
    private @Getter int order = 2;

    @Autowired
    private IColorWriter colorWriter;

    @Before("within(com.example.demo.ejercicio24.dao..*) and args(yy,..)")
    public void beforeDAOAccountMethod(JoinPoint jp, Account yy){
        
        Object[] args = jp.getArgs();

        log.info("{}", colorWriter.getColoredMessage(Color.RED, "Logging DAO Account Access: " + yy.getAccountNumber()));
    }

    @Before("within(com.example.demo.ejercicio24.dao..*) and args(bb,..)")
    public void beforeDAOAccountMethod(Long bb){
        
        log.info("{}", colorWriter.getColoredMessage(Color.RED, "Logging DAO Account Access customer id: " + bb));
    }
}
