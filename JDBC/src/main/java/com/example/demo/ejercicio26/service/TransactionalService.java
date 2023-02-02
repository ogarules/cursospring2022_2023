package com.example.demo.ejercicio26.service;

import org.springframework.stereotype.Component;

import com.example.demo.ejercicio26.domain.BusinessObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TransactionalService implements ITransactionalService {

    @Override
    public BusinessObject getBusinessObject(Long id) {
        log.info("Getting business object");
        return BusinessObject.builder().id(id).data("OGA").build();
    }

    @Override
    public void insertBusinessObject(BusinessObject businessObject) {
        log.info("inserting business object");
        throw new UnsupportedOperationException();
        
    }

    @Override
    public void updateBusinessObject(BusinessObject businessObject) {
        log.info("update business object");
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteBusinessObject(Long id) {
        log.info("Deleting business object");
        
    }
    
}
