package com.example.demo.ejercicioe;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class propertyEditorTests {
    private static ApplicationContext context;

    @BeforeClass
    public static void init(){
        context = new ClassPathXmlApplicationContext("spring/ejercicioe/beans.xml");
    }

    @Test
    public void popertyEditorTest(){
        log.info("Testing property editor...");

        Client client = context.getBean(Client.class);

        assertEquals("1111-2222-3333-4444", client.getCard().getRawCardNumber());

        CreditCardEditor editor = new CreditCardEditor();
        CreditCard creditCard = context.getBean(CreditCard.class);

        BeanWrapperImpl wrapper = new BeanWrapperImpl(creditCard);
        wrapper.registerCustomEditor(CreditCard.class, null, editor);
        editor.setAsText("1111-1111-1111-1111");
        ((CreditCard)editor.getValue()).setRawCardNumber("2222-2222-2222-2222");

        String finalCardNumber = editor.getAsText();

        assertEquals("2222-2222-2222-2222", finalCardNumber);

    }
}
