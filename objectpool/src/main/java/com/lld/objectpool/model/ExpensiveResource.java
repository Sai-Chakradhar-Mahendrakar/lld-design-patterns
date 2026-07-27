package com.lld.objectpool.model;

import java.util.UUID;

public class ExpensiveResource {
    private final String id;

    public ExpensiveResource() {
        this.id = UUID.randomUUID().toString();
        simulateExpensiveInit();
    }

    private void simulateExpensiveInit() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String process(String input) {
        return "Processed[" + id + "]: " + input;
    }

    public String getId() {
        return id;
    }
}
