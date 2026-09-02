package com.vertex.chainofresponsibility.handler.impl;

import com.vertex.chainofresponsibility.handler.OrderHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class PaymentHandler implements OrderHandler {
    @Override
    public void handle(com.vertex.chainofresponsibility.dto.OrderRequest orderRequest) {
        System.out.println("Processing payment for product: " + orderRequest.getProductId());

        // Simulate payment processing
        if (!orderRequest.isPaymentCompleted()) {
            throw new IllegalArgumentException("Payment not completed for product: " + orderRequest.getProductId());
        }
    }
}
