package com.vertex.chainofresponsibility.handler.impl;

import com.vertex.chainofresponsibility.dto.OrderRequest;
import com.vertex.chainofresponsibility.handler.OrderHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class InventoryHandler implements OrderHandler {
    @Override
    public void handle(OrderRequest orderRequest) {
        System.out.println("Checking inventory for product: " + orderRequest.getProductId());

        // Simulate inventory check
        if (orderRequest.getQuantity() > 10) {
            throw new IllegalArgumentException("Insufficient inventory for product: " + orderRequest.getProductId());
        }
    }
}
