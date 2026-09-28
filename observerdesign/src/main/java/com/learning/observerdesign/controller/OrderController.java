package com.learning.observerdesign.controller;

import com.learning.observerdesign.model.Order;
import com.learning.observerdesign.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam BigDecimal amount
    ) {
        return orderService.createOrder(email, phone, amount);
    }
}
