package com.example.demo.tarea3;

public class NumericalEng implements INumerical {

    private final String[] UNITS_en = { "", "one", "two", "three", "four", "five",
    "six", "seven", "eight", "nine" };

    private final String[] DOZENS_en = { "ten", "eleven", "twlve", "thirteen",
    "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
    "nineteen", "twenty", "thirty", "fourty", "fifty",
    "sixty", "seventy", "eighty", "ninety" };

    private final String[] HUNDREDS_en = { "", "one hundred", "two hundred",
    "three hundred", "four hundred", "five hundred", "six hundred",
        "seven hundred", "eight hundred", "nine hundred" };
    
    @Override
    public String getLanguage() {
        return "eng";
    }

    @Override
    public String[] getUnits() {
        return UNITS_en;
    }

    @Override
    public String[] getDozens() {
        return DOZENS_en;
    }

    @Override
    public String[] getHundreds() {
        return HUNDREDS_en;
    }

    @Override
    public String getZero() {
        return "zero";
    }

    @Override
    public String getOneHundred() {
        return "hundred";
    }

    @Override
    public String getAnd() {
        return "";
    }

    @Override
    public String getOneThousand() {
        return "thousend";
    }

    @Override
    public String getOneMillion() {
        return "million";
    }

    @Override
    public String getMillions() {
        return "millions";
    }
    

}
