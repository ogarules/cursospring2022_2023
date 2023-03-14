package com.example.demo.services;

import org.springframework.stereotype.Component;

import com.example.demo.models.Order;

@Component
public class OrdersFallback implements OrderService {

    @Override
    public Order addOrder(Order order) {
        Order orderDefault = new Order();
        orderDefault.setId(-1);

        return orderDefault;
    }

    @Override
    public Order getOrer(Integer id) {
        Order orderDefault = new Order();
        orderDefault.setId(-2);

        return orderDefault;
    }    
}
