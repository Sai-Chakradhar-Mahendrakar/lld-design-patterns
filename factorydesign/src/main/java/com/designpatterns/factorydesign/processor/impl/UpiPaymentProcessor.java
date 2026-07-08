package com.designpatterns.factorydesign.processor.impl;

import com.designpatterns.factorydesign.processor.PaymentProcessor;
import org.springframework.stereotype.Component;

@Component("upi")
public class UpiPaymentProcessor implements PaymentProcessor {
    @Override
    public String processPayment(double amount) {
        return "Processing UPI payment of $" + amount;
    }
}
