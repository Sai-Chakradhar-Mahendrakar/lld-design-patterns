package com.designpatterns.factorydesign.controller;

import com.designpatterns.factorydesign.factory.PaymentProcessorFactory;
import com.designpatterns.factorydesign.processor.PaymentProcessor;
import com.designpatterns.factorydesign.request.PaymentRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentProcessorFactory factory;

    public PaymentController(PaymentProcessorFactory factory) {
        this.factory = factory;
    }

    @PostMapping("/{type}")
    public String pay(@PathVariable String type, @RequestBody PaymentRequest paymentRequest) {
        PaymentProcessor paymentProcessor =  factory.getPaymentProcessor(type);
        return paymentProcessor.processPayment(paymentRequest.getAmount());
    }
}
