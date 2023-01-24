package com.example.demo.ejercicio25.dao.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.example.demo.ejercicio25.domain.Customer;
import com.example.demo.ejercicio25.domain.User;

public class UserRowMapper implements RowMapper<User> {

    @Override
    @Nullable
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        user.setId(rs.getLong("USER_ID"));
        user.setUsername(rs.getString("USERNAME"));
        user.setPassword(rs.getString("PASSWORD"));

        Customer customer = new Customer();
        customer.setId(rs.getLong("CUSTOMER_ID"));
        customer.setLastName(rs.getString("LAST_NAME"));
        customer.setName(rs.getString("NAME"));

        user.setCustomer(customer);
        customer.setUser(user);

        return user;
    }
    
}
