package com.example.demo.ejercicio23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.util.Color;
import com.example.demo.util.IColorWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Scope("prototype")
public class Voluntario implements IVoluntario {
    
    @Autowired
    IColorWriter colorWriter;

    private String pensamiento;

    @Override
    public void pensarEnAlgo(String pensamiento) {
        this.pensamiento = pensamiento;
        log.info(colorWriter.getColoredMessage(Color.MAGENTA, "[voluntario] piensa en " + pensamiento + "... no le digas a nadie..."));
    }

    @Override
    public void pensarEnOtraCosa(String otroPensamiento) {
        this.pensamiento = otroPensamiento;
        log.info(colorWriter.getColoredMessage(Color.MAGENTA, "[voluntario] piensa en otra cosa: " + pensamiento + "... no le digas a nadie..."));
        
    }

    @Override
    public String getPensamiento(boolean hacerTrampa) {
        return hacerTrampa ? "Un vaso medio vacio" : this.pensamiento;
    }

    
}
