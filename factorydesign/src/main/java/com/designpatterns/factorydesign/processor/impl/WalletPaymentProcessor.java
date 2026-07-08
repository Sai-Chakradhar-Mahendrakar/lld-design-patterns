package com.designpatterns.factorydesign.processor.impl;

import com.designpatterns.factorydesign.processor.PaymentProcessor;
import org.springframework.stereotype.Component;

@Component("wallet")
public class WalletPaymentProcessor implements PaymentProcessor {
    @Override
    public String processPayment(double amount) {
        return "Processing wallet payment of $" + amount;
    }
}
