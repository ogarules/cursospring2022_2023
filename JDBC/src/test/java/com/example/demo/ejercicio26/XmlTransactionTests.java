package com.example.demo.ejercicio26;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.ejercicio26.domain.BusinessObject;
import com.example.demo.ejercicio26.service.ITransactionalService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ejercicio26/spring-jdbc.xml"})
@ActiveProfiles("h2-in-memory")
public class XmlTransactionTests {
    @Autowired
    ITransactionalService servce;

    @Test
    public void transactionalServiceTest(){
        log.info("Testing transactional configuration");

        BusinessObject bo = null;

        bo = servce.getBusinessObject(1L);

        log.info("Inserting business object");

        try{
            servce.insertBusinessObject(bo);
        }
        catch(Exception e){
            log.info("Insert error {}", e.getMessage());
        }

        log.info("Updating business object");
        
        try{
            servce.updateBusinessObject(bo);
        }
        catch(Exception e){
            log.info("Update error {}", e.getMessage());
        }

        log.info("Deleting business object...");

        servce.deleteBusinessObject(1L);
    }
}
