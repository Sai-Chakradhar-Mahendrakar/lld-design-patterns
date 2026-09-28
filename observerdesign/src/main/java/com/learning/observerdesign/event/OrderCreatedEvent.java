package com.learning.observerdesign.event;

import com.learning.observerdesign.model.Order;

public record OrderCreatedEvent (
        Order order
){
}
