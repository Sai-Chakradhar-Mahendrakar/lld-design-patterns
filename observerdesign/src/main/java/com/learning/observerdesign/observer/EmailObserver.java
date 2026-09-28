package com.learning.observerdesign.observer;

import com.learning.observerdesign.event.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailObserver {
    @EventListener
    public void onOrderCreated(OrderCreatedEvent event){
        System.out.println("Sending email to: " + event.order().customerEmail());
    }
}
