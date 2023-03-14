package com.example.demo.models;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private Integer quantity;
    private double price;
}
