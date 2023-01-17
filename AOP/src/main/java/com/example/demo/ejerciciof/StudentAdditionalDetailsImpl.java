package com.example.demo.ejerciciof;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class StudentAdditionalDetailsImpl implements StudentAdditionalDetails {
    
    private String city;
    private String country;
    
    @Override
    public void showAdditionalDetails() {
        log.info("{}", city);
        log.info("{}", country);
    }
    
}
