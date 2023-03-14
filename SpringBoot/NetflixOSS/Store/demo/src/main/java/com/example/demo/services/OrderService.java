package com.example.demo.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Order;

@FeignClient(name="orders-service", fallback=OrdersFallback.class)
public interface OrderService {

    @RequestMapping("/orders/{id}")
    Order getOrer(@PathVariable Integer id);

    @PostMapping("/orders")
    Order addOrder(@RequestBody Order order);
    
}
