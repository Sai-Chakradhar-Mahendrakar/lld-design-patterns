package com.vertex.chainofresponsibility.handler.impl;

import com.vertex.chainofresponsibility.dto.OrderRequest;
import com.vertex.chainofresponsibility.handler.OrderHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ValidationHandler implements OrderHandler {
    @Override
    public void handle(OrderRequest orderRequest) {
        System.out.println("Validating order...");

        if (orderRequest.getQuantity() <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }
    }
}
