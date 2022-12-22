package com.example.demo.tarea3;

public class NumericalEsp implements INumerical {

    private final String[] UNITS = { "", "un", "dos", "tres", "cuatro", "cinco",
    "seis", "siete", "ocho", "nueve" };

    private final String[] DOZENS = { "diez", "once", "doce", "trece",
    "catorce", "quince", "dieciseis", "diecisiete", "dieciocho",
    "diecinueve", "veinte", "treinta", "cuarenta", "cincuenta",
    "sesenta", "setenta", "ochenta", "noventa" };

    private final String[] HUNDREDS = { "", "ciento", "doscientos",
    "trescientos", "cuatrocientos", "quinientos", "seiscientos",
    "setecientos", "ochocientos", "novecientos" };

    @Override
    public String getLanguage() {
        return "esp";
    }

    @Override
    public String[] getUnits() {
        return UNITS;
    }

    @Override
    public String[] getDozens() {
        return DOZENS;
    }

    @Override
    public String[] getHundreds() {
        return HUNDREDS;
    }

    @Override
    public String getZero() {
        return "cero";
    }

    @Override
    public String getOneHundred() {
        return "cien";
    }

    @Override
    public String getAnd() {
        return "y";
    }

    @Override
    public String getOneThousand() {
        return "mil";
    }

    @Override
    public String getOneMillion() {
        return "millon";
    }

    @Override
    public String getMillions() {
        return "millones";
    }
    
}
