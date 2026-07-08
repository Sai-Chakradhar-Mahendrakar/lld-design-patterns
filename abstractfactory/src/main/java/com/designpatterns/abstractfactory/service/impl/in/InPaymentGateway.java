package com.designpatterns.abstractfactory.service.impl.in;

import com.designpatterns.abstractfactory.service.PaymentGateway;

public class InPaymentGateway implements PaymentGateway {
    @Override
    public double calculate(double amount) {
        System.out.printf("Charging ₹%.2f via IN gateway (Razorpay)%n", amount);
        return amount * 0.03;
    }
}
