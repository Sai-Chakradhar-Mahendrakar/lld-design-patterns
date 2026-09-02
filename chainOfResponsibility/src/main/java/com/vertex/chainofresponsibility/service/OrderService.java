package com.vertex.chainofresponsibility.service;

import com.vertex.chainofresponsibility.dto.OrderRequest;
import com.vertex.chainofresponsibility.handler.OrderHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final List<OrderHandler> handlers;

    public void process(OrderRequest request) {
        handlers.forEach(handler -> handler.handle(request));
        System.out.println("Order processed successfully");
    }
}
