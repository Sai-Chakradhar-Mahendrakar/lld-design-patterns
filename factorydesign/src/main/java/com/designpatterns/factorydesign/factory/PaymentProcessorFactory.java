package com.designpatterns.factorydesign.factory;

import com.designpatterns.factorydesign.processor.PaymentProcessor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentProcessorFactory {
    private final Map<String, PaymentProcessor> paymentProcessorByType;

    public PaymentProcessorFactory(Map<String, PaymentProcessor> paymentProcessorByType) {
        this.paymentProcessorByType = paymentProcessorByType;
    }

    public PaymentProcessor getPaymentProcessor(String type) {
        return paymentProcessorByType.get(type);
    };
}
