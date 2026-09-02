package com.vertex.chainofresponsibility.handler;

import com.vertex.chainofresponsibility.dto.OrderRequest;

public interface OrderHandler {
    void handle(OrderRequest orderRequest);
}
