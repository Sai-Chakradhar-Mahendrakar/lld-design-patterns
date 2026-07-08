package com.designpatterns.factorydesign.processor.impl;

import com.designpatterns.factorydesign.processor.PaymentProcessor;
import org.springframework.stereotype.Component;

@Component("card")
public class CreditPaymentProcessor implements PaymentProcessor {
    @Override
    public String processPayment(double amount) {
        return "Processing credit card payment of $" + amount;
    }
}
