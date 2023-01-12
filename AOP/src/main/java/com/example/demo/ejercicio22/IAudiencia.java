package com.example.demo.ejercicio22;

import org.aspectj.lang.ProceedingJoinPoint;

public interface IAudiencia {
    public void aplaudir();
    public void abuchear();
    public void sePonedePie();
    public void seSienta();
    public void gritaGol();
    public void gritarOle();
    public Object sePonedeNervios(ProceedingJoinPoint pjp) throws Throwable;
}
