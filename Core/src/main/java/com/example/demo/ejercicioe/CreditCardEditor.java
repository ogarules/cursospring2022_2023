package com.example.demo.ejercicioe;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

public class CreditCardEditor extends PropertyEditorSupport {
    
    @Override
    public String getAsText() {
        CreditCard creditCard = (CreditCard)getValue();
        return creditCard == null ? null : creditCard.getRawCardNumber();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(!StringUtils.hasText(text)) {
            setValue(null);
        }
        else {
            CreditCard creditCard = new CreditCard();
            creditCard.setRawCardNumber(text);

            String cardNo = text.replaceAll("-", "");

            if(cardNo.length() != 16){
                throw new IllegalArgumentException("Credit card should have 16 digits");
            }

            try {
                creditCard.setBankId( Integer.valueOf(cardNo.substring(0, 6)) );
                creditCard.setAccountNo( Integer.valueOf(
                  cardNo.substring(6, cardNo.length() - 1)) );
                creditCard.setCheckCode( Integer.valueOf(
                  cardNo.substring(cardNo.length() - 1)) );
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException(nfe);
            }

            setValue(creditCard);
        }
    }
}
