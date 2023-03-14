package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Order;
import com.example.demo.repositories.OrderRepository;

@RestController
@RequestMapping("orders")
public class OrderController {
    
    @Autowired
    private OrderRepository repository;

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Integer id){
        return this.repository.findById(id).orElse(null);
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order){
        return this.repository.save(order);
    }
}
