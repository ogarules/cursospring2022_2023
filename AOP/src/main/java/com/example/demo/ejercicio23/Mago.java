package com.example.demo.ejercicio23;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.util.Color;
import com.example.demo.util.IColorWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class Mago implements IAdivinador {

    @Autowired
    IColorWriter colorWriter;

    @Pointcut("execution(* com.example.demo.ejercicio23.IVoluntario.pensar*(String)) && args(pensamiento)")
    private void cuandoUnPerticipantePiensaEnAlgo(String pensamiento){}

    @Pointcut(value = "execution(* com.example.demo.ejercicio23.IVoluntario.getPensamiento(boolean)) && args(x)", argNames = "x")
    private void cuandoUnPerticipanteQuiereHacerTrampa(boolean hacerTrampa){}

    @Before("cuandoUnPerticipantePiensaEnAlgo(pensamiento)")
    @Override
    public void interceptarPensamiento(JoinPoint jp, String pensamiento){
        log.info(colorWriter.getColoredMessage(Color.YELLOW, "[Mago] El voluntario se prepara para pensar en algo.... y penso en : " + pensamiento));
    }

    @Around("cuandoUnPerticipanteQuiereHacerTrampa(hacerTrampa)")
    public Object hacerMagia(ProceedingJoinPoint pjp, boolean hacerTrampa) throws Throwable {
        if(hacerTrampa){
            return "Momento me quieres hacer trampa.....";
        }

        return pjp.proceed();
    }
}
