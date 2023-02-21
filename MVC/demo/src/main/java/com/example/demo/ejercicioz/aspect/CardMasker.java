package com.example.demo.ejercicioz.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import com.example.demo.ejercicioz.domain.Card;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Configuration
public class CardMasker {
    
    @Around("execution(Iterable<com.example.demo.ejercicioz.domain.Card> com.example.demo.ejercicioz.services.*.*(..))")
    public Object maskCards(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result = joinPoint.proceed();

        log.info("Masking cards");

        Iterable<Card> cardItems = (Iterable<Card>)result;

        for(Card card : cardItems){
            log.info("Masking {} to {}", card.getCardNumber(), "XXXX-XXXX-XXXX-XXXX");
            card.setCardNumber("XXXX-XXXX-XXXX-XXXX");
        }

        return result;
    }

    @Around("execution(com.example.demo.ejercicioz.domain.Card com.example.demo.ejercicioz.services.*.*(..))")
    public Object maskCard(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result = joinPoint.proceed();

        if(result instanceof Card){
            Card cardItem = (Card)result;
            log.info("Masking {} to {}", cardItem.getCardNumber(), "XXXX-XXXX-XXXX-XXXX");
            cardItem.setCardNumber("XXXX-XXXX-XXXX-XXXX");
        }

        return result;
    }
}
