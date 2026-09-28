package com.learning.observerdesign.service;

import com.learning.observerdesign.event.OrderCreatedEvent;
import com.learning.observerdesign.model.Order;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {
    private final ApplicationEventPublisher publisher;
    private final AtomicLong idGenerator = new AtomicLong();

    public OrderService(ApplicationEventPublisher publisher){
        this.publisher = publisher;
    }

    public Order createOrder(
            String email,
            String phone,
            BigDecimal amount
    ){
        Order order = new Order(idGenerator.incrementAndGet(), email, phone, amount);
        publisher.publishEvent(new OrderCreatedEvent(order));
        return order;
    }
}
