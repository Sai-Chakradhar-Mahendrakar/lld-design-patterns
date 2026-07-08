package com.designpatterns.abstractfactory.service.impl.us;

import com.designpatterns.abstractfactory.service.PaymentGateway;

public class UsPaymentGateway implements PaymentGateway {
    @Override
    public double calculate(double amount) {
        System.out.printf("Charging $%.2f via US gateway (Stripe)%n", amount);
        return amount * 0.02;
    }
}
