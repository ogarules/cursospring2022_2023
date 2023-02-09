package com.example.demo.ejercicio27;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.ejercicio27.dao.ICustomerDAO;
import com.example.demo.ejercicio27.dao.IUserDAO;
import com.example.demo.ejercicio27.domain.Account;
import com.example.demo.ejercicio27.domain.Customer;
import com.example.demo.ejercicio27.domain.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ejercicio27/spring-orm.xml"})
@ActiveProfiles("h2-in-memory")
public class UserDAOTest {
    @Autowired
    IUserDAO userDAO;

    @Autowired
    ICustomerDAO customerDAO;

    @Test
    public void userDaoTest(){
        log.info("testing user and customer dao....");

        User user = new User();
        user.setUsername("oga");
        user.setPassword("1234");

        Customer customer = new Customer();
        customer.setLastName("oga");
        customer.setName("oga");
        customer.setUser(user);

        user.setCustomer(customer);

        userDAO.insert(user);

        User userDb = userDAO.findById(user.getId());

        Customer custDb = customerDAO.findById(1L);

        Account account = new Account();
        account.setAccountNumber("123");
        account.setBalance(new BigDecimal(100));
        account.setCreatedDate(new Date());

        custDb.getAccounts().add(account);

        customerDAO.update(custDb);

        Customer custdb2 = customerDAO.findById(1L);
        

        assertEquals(user.getId(), userDb.getId());
    }
    
}
