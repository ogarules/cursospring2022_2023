package com.example.demo.ejercicio25.parte2;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.ejercicio25.dao.ICustomerDAO;
import com.example.demo.ejercicio25.domain.Customer;
import com.example.demo.ejercicio25.domain.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/ejercicio25/spring-jdbc.xml" })
@ActiveProfiles("mysql")
public class CustomerDAOMySQLTests {
    @Autowired
    ICustomerDAO customerDAO;

    @Test
    public void customerDatoTest(){
        log.info("Testing customerdao ....");


        User user = new User();
        user.setPassword("1233");
        user.setUsername("oga1233");

        Customer customer = new Customer();
        customer.setLastName("gagaga");
        customer.setName("oggaa");
        customer.setUser(user);

        user.setCustomer(customer);
        customer.setUser(user);

        customerDAO.insert(customer);
        Customer cust = customerDAO.findById(1L);

        List<Customer> customers = customerDAO.findAll();

        assertFalse(customers.isEmpty());
    }
}
