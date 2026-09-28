package com.learning.observerdesign.observer;

import com.learning.observerdesign.event.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SmsObserver {
    @EventListener
    public void onOrderCreated(OrderCreatedEvent event) {
        System.out.println("Sending SMS to: " + event.order().customerPhone());
    }
}
