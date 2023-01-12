package com.example.demo.ejercicio22;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.util.Color;
import com.example.demo.util.IColorWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("audienciaBean")
public class Audiencia implements IAudiencia {
    
    @Autowired
    private IColorWriter colorWriter;
    
    public void print(String name){
        log.info(name);
    }

    public String getDatosAudiencia(){
        return "[audiencia] La audiencia ";
    }

    @Override
    public void aplaudir() {
        print(colorWriter.getColoredMessage(Color.BLUE, getDatosAudiencia() + " aplaude CLAP CLAP !!!!"));
        
    }

    @Override
    public void abuchear() {
        print(colorWriter.getColoredMessage(Color.RED, getDatosAudiencia() + " abuchea BUUUUU !!!!"));
        
    }

    @Override
    public void sePonedePie() {
        print(colorWriter.getColoredMessage(Color.YELLOW, getDatosAudiencia() + " se pone de pie !!!!"));
        
    }

    @Override
    public void seSienta() {
        print(colorWriter.getColoredMessage(Color.YELLOW, getDatosAudiencia() + " se sienta !!!!"));
        
    }

    @Override
    public void gritaGol() {
        print(colorWriter.getColoredMessage(Color.GREEN, getDatosAudiencia() + " grita GOOOOOOL !!!!"));
        
    }

    @Override
    public void gritarOle() {
        print(colorWriter.getColoredMessage(Color.MAGENTA, getDatosAudiencia() + " grita OLEEEE !!!!"));
        
    }

    @Override
    public Object sePonedeNervios(ProceedingJoinPoint pjp) throws Throwable {
        print(colorWriter.getColoredMessage(Color.YELLOW, getDatosAudiencia() + " se pone de nervios !!!!"));

        Object result = pjp.proceed();
        this.abuchear();
        this.abuchear();
        this.aplaudir();
        this.aplaudir();

        print(colorWriter.getColoredMessage(Color.GREEN, getDatosAudiencia() + " se deja de poner nerviosa !!!!"));

        return result;
    }
    
}
