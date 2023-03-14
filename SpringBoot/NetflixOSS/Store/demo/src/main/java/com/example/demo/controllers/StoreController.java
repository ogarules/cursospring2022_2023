package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Order;
import com.example.demo.services.OrderService;

@RestController
@RequestMapping("store")
public class StoreController {
    
    @Autowired
    private OrderService service;

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable Integer id){
        return this.service.getOrer(id);
    }

    @PostMapping("/order")
    public Order addOrder(@RequestBody Order order){
        return this.service.addOrder(order);
    }
    
}
