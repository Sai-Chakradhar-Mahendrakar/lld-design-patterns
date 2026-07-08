package com.designpatterns.abstractfactory.service.impl.eu;

import com.designpatterns.abstractfactory.service.PaymentGateway;

public class EuPaymentGateway implements PaymentGateway {
    @Override
    public double calculate(double amount) {
        System.out.printf("Charging €%.2f via EU gateway (PayPal)%n", amount);
        return amount * 0.025;
    }
}
