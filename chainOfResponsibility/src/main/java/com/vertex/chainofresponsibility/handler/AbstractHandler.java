package com.vertex.chainofresponsibility.handler;

import com.vertex.chainofresponsibility.dto.OrderRequest;

public abstract class AbstractHandler {
    private AbstractHandler next;

    public AbstractHandler setNext(AbstractHandler next) {
        this.next = next;
        return next;
    }

    public void handle(OrderRequest orderRequest) {
        process(orderRequest);
        if (next != null) {
            next.handle(orderRequest);
        }
    }

    protected abstract void process(OrderRequest request);
}
